package com.ingrowthly.mongo.extension.util;

import com.ingrowthly.mongo.extension.core.Func;
import com.ingrowthly.mongo.extension.exception.MongoExtensionException;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;

/**
 * @since 2022/11/28
 */
public final class LambdaUtil {

    private static final Map<String, String> CACHE_MAP = new ConcurrentHashMap<>();

    private LambdaUtil() {
    }

    /**
     * 获取字段名
     *
     * @param func 字段
     * @return 字段名
     */
    public static <T> String toColumn(Func<T, ?> func) {
        String column = CACHE_MAP.get(func.getClass().getName());
        if (column != null) {
            return column;
        }

        return CACHE_MAP.computeIfAbsent(func.getClass().getName(), key -> {
            Method method = ReflectionUtils.findMethod(func.getClass(), "writeReplace");
            method.setAccessible(true);
            SerializedLambda serializedLambda = (SerializedLambda)ReflectionUtils.invokeMethod(method, func);
            String implMethodName = serializedLambda.getImplMethodName();
            String property = methodToProperty(implMethodName);
            Field field = ReflectionUtils.findField(nameToClass(serializedLambda.getImplClass()), property);
            org.springframework.data.mongodb.core.mapping.Field annotation =
                field.getAnnotation(org.springframework.data.mongodb.core.mapping.Field.class);
            if (annotation != null) {
                return annotation.value();
            }
            return property;
        });
    }

    /**
     * 获取字段名
     *
     * @param name 字段名
     * @return 字段名
     */
    public static String methodToProperty(String name) {
        if (name.startsWith("is")) {
            name = name.substring(2);
        } else if (name.startsWith("get") || name.startsWith("set")) {
            name = name.substring(3);
        } else {
            throw new MongoExtensionException(
                "Error parsing property name '" + name + "'.  Didn't start with 'is', 'get' or 'set'.");
        }

        if (name.length() == 1 || (name.length() > 1 && !Character.isUpperCase(name.charAt(1)))) {
            name = name.substring(0, 1).toLowerCase(Locale.ENGLISH) + name.substring(1);
        }

        return name;
    }

    /**
     * 将 implClass 转换为 Class
     *
     * @param name implClass
     * @return Class
     */
    public static Class<?> nameToClass(String name) {
        try {
            String className = name.replace("/", ".");
            return ClassUtils.forName(className, null);
        } catch (ClassNotFoundException e) {
            throw new MongoExtensionException("Error parsing class name '" + name + "'.", e);
        }
    }

}
