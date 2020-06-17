package com.diversity3.modules.sys.dao;

import com.diversity3.common.base.BaseDao;
import com.diversity3.modules.sys.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author: Greekn
 * @version: 1.0
 * @date: Created in 2020-05-29 11:15:46
 * @package:  com.diversity3.sys.entity
 * @modified: Greekn
 * @description: 用户
 * @copyright: Copyright (c) 2020-05-29
 */
@Mapper
public interface SysUserDao extends BaseDao<SysUserEntity> {
	
}