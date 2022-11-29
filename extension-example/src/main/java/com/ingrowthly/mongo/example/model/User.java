package com.ingrowthly.mongo.example.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @since 2022/11/22
 */
@Getter
@Setter
@Document(collection = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 8654676752773622380L;

    /**
     * id
     */
    @Id @Field("_id") private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 生日
     */
    private LocalDateTime birthday;

    /**
     * 性别 0 未知 1 男 2 女
     */
    private Integer sex;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
