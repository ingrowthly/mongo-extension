package com.ingrowthly.mongo.extension.core;

import java.io.Serializable;
import java.util.function.Function;

@FunctionalInterface
public interface Func<T, R> extends Function<T, R>, Serializable {
}
