# Spring Data Mongo Extension

本项目提供了一些对 Spring Data Mongo 的扩展。

This project provides a set of extensions to the Spring Data MongoDB project.

1. 链式调用 lambda 式 (Chainable lambda style)
2. 支持不为空才生效的条件设置 (Supports conditional operations)

## 使用

添加依赖 (Add dependency)

```xml
<dependency>
    <groupId>com.ingrowthly.mongo</groupId>
    <artifactId>mongo-extension</artifactId>
    <version>${version}</version>
</dependency>
```

书写查询 (Coding)

```java
public List<User> lambdaSearch(String username, Integer sex, LocalDateTime startCreateTime,
    LocalDateTime endCreateTime) {
    Query query = WrapUtil.<User>lambdaQuery().regex(StrUtil.isNotBlank(username), User::getUsername, username)
    .is(sex != null, User::getSex, sex).between(User::getCreateTime, startCreateTime, endCreateTime).getQuery();
    return mongoTemplate.find(query, User.class);
    }
```

## 路线图 (Roadmap)

- [ ] 支持更多的条件操作
- [ ] 支持更新操作
- [ ] 支持嵌套对象

## 参考

1. [mybatis-plus](https://github.com/baomidou/mybatis-plus)
2. [hutool](https://github.com/dromara/hutool)