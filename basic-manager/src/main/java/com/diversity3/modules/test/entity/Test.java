package com.diversity3.modules.test.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.diversity3.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Greekn
 * @version 0.1
 * @date 2020-05-26 16:04
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("demo")
public class Test extends BaseEntity {

    @TableId
    private Integer id;
    private String name;

}
