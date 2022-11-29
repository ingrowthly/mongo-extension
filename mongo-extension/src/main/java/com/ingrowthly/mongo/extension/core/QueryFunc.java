package com.ingrowthly.mongo.extension.core;

import java.io.Serializable;
import java.util.Collection;

/**
 * @since 2022/11/28
 */
public interface QueryFunc<T, R> extends Serializable {

    default T isNull(R column) {
        return isNull(true, column);
    }

    /**
     * 字段 IS NULL
     *
     * @param condition 执行条件
     * @param column    字段
     * @return children
     */
    T isNull(boolean condition, R column);

    default T exists(R column) {
        return exists(true, column);
    }

    /**
     * 字段 EXISTS
     *
     * @param condition 执行条件
     * @param column    字段
     * @return children
     */
    T exists(boolean condition, R column);

    default T in(R column, Collection<?> coll) {
        return in(true, column, coll);
    }

    /**
     * 字段 IN (value1, value2, ...)
     *
     * @param condition 执行条件
     * @param column    字段
     * @param coll      集合
     * @return children
     */
    T in(boolean condition, R column, Collection<?> coll);

    default T nin(R column, Collection<?> coll) {
        return nin(true, column, coll);
    }

    /**
     * 字段 NOT IN (value1, value2, ...)
     *
     * @param condition 执行条件
     * @param column    字段
     * @param coll      集合
     * @return children
     */
    T nin(boolean condition, R column, Collection<?> coll);

    default T regex(R column, String regex) {
        return regex(true, column, regex);
    }

    /**
     * 字段 REGEX
     *
     * @param condition 执行条件
     * @param column    字段
     * @param regex     正则表达式
     * @return children
     */
    T regex(boolean condition, R column, String regex);

    default T is(R column, Object value) {
        return is(true, column, value);
    }

    /**
     * 字段 IS
     *
     * @param condition 执行条件
     * @param column    字段
     * @param value     值
     * @return children
     */
    T is(boolean condition, R column, Object value);

    default T ne(R column, Object value) {
        return ne(true, column, value);
    }

    /**
     * 字段 NOT IS
     *
     * @param condition 执行条件
     * @param column    字段
     * @param value     值
     * @return children
     */
    T ne(boolean condition, R column, Object value);

    default T gt(R column, Object value) {
        return gt(true, column, value);
    }

    /**
     * 字段 >
     *
     * @param condition 执行条件
     * @param column    字段
     * @param value     值
     * @return children
     */
    T gt(boolean condition, R column, Object value);

    default T gte(R column, Object value) {
        return gte(true, column, value);
    }

    /**
     * 字段 >=
     *
     * @param condition 执行条件
     * @param column    字段
     * @param value     值
     * @return children
     */
    T gte(boolean condition, R column, Object value);

    default T lt(R column, Object value) {
        return lt(true, column, value);
    }

    /**
     * 字段 <
     *
     * @param condition 执行条件
     * @param column    字段
     * @param value     值
     * @return children
     */
    T lt(boolean condition, R column, Object value);

    default T lte(R column, Object value) {
        return lte(true, column, value);
    }

    /**
     * 字段 <=
     *
     * @param condition 执行条件
     * @param column    字段
     * @param value     值
     * @return children
     */
    T lte(boolean condition, R column, Object value);

    default T between(R column, Object value1, Object value2) {
        return between(true, column, value1, value2);
    }

    /**
     * 字段 BETWEEN value1 AND value2
     *
     * @param condition 执行条件
     * @param column    字段
     * @param value1    值1
     * @param value2    值2
     * @return children
     */
    T between(boolean condition, R column, Object value1, Object value2);

}
