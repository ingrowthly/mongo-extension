package com.ingrowthly.mongo.example.repository;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.RandomUtil;
import com.ingrowthly.mongo.example.model.User;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepositoryTest {

    @Autowired private UserRepository userRepository;
    private String username;

    @Test
    void saveAll() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setUsername(String.valueOf(RandomUtil.randomChinese()) + RandomUtil.randomChinese());
            user.setSex(RandomUtil.randomInt(0, 3));
            user.setCreateTime(LocalDateTime.now());
            user.setUpdateTime(LocalDateTime.now());
            users.add(user);
        }
        // 随机获取一个用户名
        username = users.get(RandomUtil.randomInt(0, 100)).getUsername();
        Assertions.assertDoesNotThrow(() -> userRepository.saveAll(users));
    }

    @Test
    void searchUsers() {
        List<User> users =
            userRepository.searchUsers(username, 1, LocalDateTime.now().minusDays(1), LocalDateTime.now());
        Assertions.assertNotNull(users);
        Assertions.assertTrue(CollUtil.isNotEmpty(users));
    }

    @Test
    void lambdaSearch() {
        List<User> users =
            userRepository.lambdaSearch(username, 1, LocalDateTime.now().minusDays(100), LocalDateTime.now());
        Assertions.assertNotNull(users);
        Assertions.assertTrue(CollUtil.isNotEmpty(users));
    }
}
