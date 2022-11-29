package com.ingrowthly.mongo.extension.util;

import com.ingrowthly.mongo.extension.core.LambdaQuery;

/**
 * @since 2022/11/28
 */
public final class WrapUtil {

    private WrapUtil() {
    }

    public static <T> LambdaQuery<T> lambdaQuery() {
        return new LambdaQuery<>();
    }
}
