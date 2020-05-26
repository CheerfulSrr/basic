package com.diversity3.modules.test.dto;

import javax.validation.constraints.NotNull;

/**
 * @author Greekn
 * @version 0.1
 * @date 2020-05-26 23:27
 */
public class TestDto {

    @NotNull(message = "not null!!!!")
    private Integer id;
    private String name;

}
