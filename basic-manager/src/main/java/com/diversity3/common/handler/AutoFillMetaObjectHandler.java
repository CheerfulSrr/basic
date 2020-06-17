package com.diversity3.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * <p>
 * mybatis plus 字段自动填充
 * </p>
 *
 * @author cheer
 * @version 0.1
 * @date 2020-05-29 09:24
 * @package: com.diversity3.common.handler
 * @modified: cheer
 * @description:
 * @copyright: Copyright (c) 2020
 */
@Component
public class AutoFillMetaObjectHandler implements MetaObjectHandler {

    private final static String CREATOR = "creator";
    private final static String UPDATER = "updater";
    private final static String CREATE_TIME = "createTime";
    private final static String UPDATE_TIME = "updateTime";
    private final static String DEPT_ID = "deptId";

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, CREATE_TIME, LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, UPDATE_TIME, LocalDateTime.class, LocalDateTime.now());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, UPDATE_TIME, LocalDateTime.class, LocalDateTime.now());
    }
}
