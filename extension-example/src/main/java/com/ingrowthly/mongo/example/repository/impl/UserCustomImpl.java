package com.ingrowthly.mongo.example.repository.impl;

import cn.hutool.core.util.StrUtil;
import com.ingrowthly.mongo.example.model.User;
import com.ingrowthly.mongo.example.repository.UserCustom;
import com.ingrowthly.mongo.extension.util.WrapUtil;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * @since 2022/11/22
 */
@RequiredArgsConstructor
public class UserCustomImpl implements UserCustom {

    private final MongoTemplate mongoTemplate;

    @Override
    public List<User> searchUsers(String username, Integer sex, LocalDateTime startCreateTime,
        LocalDateTime endCreateTime) {
        Query query = new Query();
        if (StrUtil.isNotBlank(username)) {
            query.addCriteria(Criteria.where("username").regex(username));
        }
        if (sex != null) {
            query.addCriteria(Criteria.where("sex").is(sex));
        }
        if (startCreateTime != null && endCreateTime != null) {
            query.addCriteria(Criteria.where("createTime").gte(startCreateTime).lte(endCreateTime));
        } else if (startCreateTime != null) {
            query.addCriteria(Criteria.where("createTime").gte(startCreateTime));
        } else if (endCreateTime != null) {
            query.addCriteria(Criteria.where("createTime").lte(endCreateTime));
        }
        return mongoTemplate.find(query, User.class);
    }

    @Override
    public List<User> lambdaSearch(String username, Integer sex, LocalDateTime startCreateTime,
        LocalDateTime endCreateTime) {
        Query query = WrapUtil.<User>lambdaQuery().regex(StrUtil.isNotBlank(username), User::getUsername, username)
            .is(sex != null, User::getSex, sex).between(User::getCreateTime, startCreateTime, endCreateTime).getQuery();
        return mongoTemplate.find(query, User.class);
    }
}
