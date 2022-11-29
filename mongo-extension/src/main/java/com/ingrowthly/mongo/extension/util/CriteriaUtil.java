package com.ingrowthly.mongo.extension.util;

import org.springframework.data.mongodb.core.query.Criteria;

/**
 * Criteria 工具类
 *
 * @since 2022/11/22
 */
public final class CriteriaUtil {

    private CriteriaUtil() {
    }

    /**
     * 空条件
     *
     * @return 空条件
     */
    public static Criteria empty() {
        return new Criteria();
    }

    /**
     * 是否为空条件
     *
     * @param criteria 条件
     * @return 是否为空条件
     */
    public static boolean isTrivial(Criteria criteria) {
        return criteria.equals(new Criteria());
    }

}
