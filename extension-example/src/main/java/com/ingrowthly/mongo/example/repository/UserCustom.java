package com.ingrowthly.mongo.example.repository;

import com.ingrowthly.mongo.example.model.User;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @since 2022/11/22
 */
public interface UserCustom {

    /**
     * 根据用户名（模糊）、性别、创建时间查询用户 条件都可能为空
     *
     * @param username        用户名
     * @param sex             性别 0 未知 1 男 2 女
     * @param startCreateTime 开始创建时间
     * @param endCreateTime   结束创建时间
     * @return 用户列表
     */
    List<User> searchUsers(String username, Integer sex, LocalDateTime startCreateTime, LocalDateTime endCreateTime);

    /**
     * 根据用户名（模糊）、性别、创建时间查询用户 条件都可能为空
     *
     * @param username        用户名
     * @param sex             性别 0 未知 1 男 2 女
     * @param startCreateTime 开始创建时间
     * @param endCreateTime   结束创建时间
     * @return 用户列表
     */
    List<User> lambdaSearch(String username, Integer sex, LocalDateTime startCreateTime, LocalDateTime endCreateTime);
}
