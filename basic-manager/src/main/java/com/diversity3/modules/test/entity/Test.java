package com.diversity3.modules.test.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Greekn
 * @version 0.1
 * @date 2020-05-26 16:04
 */
@Data
@TableName("demo")
public class Test {

    @TableId
    private Integer id;
    private String name;

}
