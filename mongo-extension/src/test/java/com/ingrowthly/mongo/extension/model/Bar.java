package com.ingrowthly.mongo.extension.model;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * @since 2022/11/29
 */
@Getter
@Setter
public class Bar implements Serializable {

    private static final long serialVersionUID = 3147407960452136028L;

    private String name;

    private String code;

    private Boolean flag;

}
