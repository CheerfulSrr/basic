package com.diversity3.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.diversity3.common.base.impl.BaseServiceImpl;
import com.diversity3.common.utils.ConvertUtils;
import com.diversity3.modules.sys.dao.SysPermissionDao;
import com.diversity3.modules.sys.dto.SysPermissionDto;
import com.diversity3.modules.sys.entity.SysPermissionEntity;
import com.diversity3.modules.sys.service.SysPermissionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 权限
 * </p>
 *
 * @author: Greekn
 * @version: 1.0
 * @date: Created in 2020-05-29 11:15:46
 * @package:  com.diversity3.sys.entity
 * @modified: Greekn
 * @description: 权限
 * @copyright: Copyright (c) 2020-05-29
 */
@Service
public class SysPermissionServiceImpl extends BaseServiceImpl<SysPermissionDao, SysPermissionEntity, SysPermissionDto> implements SysPermissionService {

    @Override
    public LambdaQueryWrapper<SysPermissionEntity> toQueryWrapper(Map<String, Object> params) {
        LambdaQueryWrapper<SysPermissionEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(params.containsKey("name"), SysPermissionEntity::getName, params.get("name"));
        return wrapper;
    }

    @Override
    public LambdaUpdateWrapper<SysPermissionEntity> toUpdateWrapper(SysPermissionEntity entity) {
        LambdaUpdateWrapper<SysPermissionEntity> wrapper = Wrappers.lambdaUpdate();
        wrapper.eq(SysPermissionEntity::getId, entity.getId());
        return wrapper;
    }

    @Override
    public List<SysPermissionDto> toTarget(List<SysPermissionEntity> source) {
        return ConvertUtils.sourceToTarget(source, SysPermissionDto.class);
    }

    @Override
    public SysPermissionDto toTarget(SysPermissionEntity source) {
        return ConvertUtils.sourceToTarget(source, SysPermissionDto.class);
    }


}