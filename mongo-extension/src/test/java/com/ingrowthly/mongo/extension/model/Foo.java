package com.ingrowthly.mongo.extension.model;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @since 2022/11/29
 */
@Getter
@Setter
public class Foo implements Serializable {

    private static final long serialVersionUID = -8170492406836686013L;

    private String name;

    @Field("coding") private String code;

    private Boolean flag;

    private Bar bar;
}
