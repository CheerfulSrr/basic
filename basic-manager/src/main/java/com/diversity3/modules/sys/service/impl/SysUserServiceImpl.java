package com.diversity3.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.diversity3.common.base.impl.BaseServiceImpl;
import com.diversity3.common.utils.ConvertUtils;
import com.diversity3.modules.sys.dao.SysUserDao;
import com.diversity3.modules.sys.dto.SysUserDto;
import com.diversity3.modules.sys.entity.SysUserEntity;
import com.diversity3.modules.sys.service.SysUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author: Greekn
 * @version: 1.0
 * @date: Created in 2020-05-29 11:15:46
 * @package: com.diversity3.sys.entity
 * @modified: Greekn
 * @description: 用户
 * @copyright: Copyright (c) 2020-05-29
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUserDao, SysUserEntity, SysUserDto> implements SysUserService {

    @Override
    public LambdaQueryWrapper<SysUserEntity> toQueryWrapper(Map<String, Object> params) {
        LambdaQueryWrapper<SysUserEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(params.containsKey("userName"), SysUserEntity::getUserName, params.get("userName"));
        return wrapper;
    }

    @Override
    public LambdaUpdateWrapper<SysUserEntity> toUpdateWrapper(SysUserEntity entity) {
        LambdaUpdateWrapper<SysUserEntity> wrapper = Wrappers.lambdaUpdate();
        wrapper.eq(SysUserEntity::getId, entity.getId());
        return wrapper;
    }

    @Override
    public List<SysUserDto> toTarget(List<SysUserEntity> source) {
        return ConvertUtils.sourceToTarget(source, SysUserDto.class);
    }

    @Override
    public SysUserDto toTarget(SysUserEntity source) {
        return ConvertUtils.sourceToTarget(source, SysUserDto.class);
    }


}