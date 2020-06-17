package com.diversity3.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.diversity3.common.base.impl.BaseServiceImpl;
import com.diversity3.common.utils.ConvertUtils;
import com.diversity3.modules.sys.dao.SysRoleDao;
import com.diversity3.modules.sys.dto.SysRoleDto;
import com.diversity3.modules.sys.entity.SysRoleEntity;
import com.diversity3.modules.sys.service.SysRoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author: Greekn
 * @version: 1.0
 * @date: Created in 2020-05-29 11:15:46
 * @package:  com.diversity3.sys.entity
 * @modified: Greekn
 * @description: 角色
 * @copyright: Copyright (c) 2020-05-29
 */
@Service
public class SysRoleServiceImpl extends BaseServiceImpl<SysRoleDao, SysRoleEntity, SysRoleDto> implements SysRoleService {

    @Override
    public LambdaQueryWrapper<SysRoleEntity> toQueryWrapper(Map<String, Object> params) {
        LambdaQueryWrapper<SysRoleEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(params.containsKey("name"), SysRoleEntity::getName, params.get("name"));
        return wrapper;
    }

    @Override
    public LambdaUpdateWrapper<SysRoleEntity> toUpdateWrapper(SysRoleEntity entity) {
        LambdaUpdateWrapper<SysRoleEntity> wrapper = Wrappers.lambdaUpdate();
        wrapper.eq(SysRoleEntity::getId, entity.getId());
        return wrapper;
    }

    @Override
    public List<SysRoleDto> toTarget(List<SysRoleEntity> source) {
        return ConvertUtils.sourceToTarget(source, SysRoleDto.class);
    }

    @Override
    public SysRoleDto toTarget(SysRoleEntity source) {
        return ConvertUtils.sourceToTarget(source, SysRoleDto.class);
    }


}