package com.ingrowthly.mongo.extension.util;

import com.ingrowthly.mongo.extension.model.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LambdaUtilTest {

    @Test
    void toColumn() {
        String name = LambdaUtil.toColumn(Foo::getCode);
        Assertions.assertEquals("coding", name);

        String flag = LambdaUtil.toColumn(Foo::getFlag);
        Assertions.assertEquals("flag", flag);
    }

    @Test
    void nameToClass() {
        String name = "com/ingrowthly/mongo/extension/model/Foo";
        Class<?> clazz = LambdaUtil.nameToClass(name);
        Assertions.assertTrue(clazz.isAssignableFrom(Foo.class));
    }
}