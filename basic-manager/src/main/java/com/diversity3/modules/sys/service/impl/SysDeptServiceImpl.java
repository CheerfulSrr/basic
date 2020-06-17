package com.diversity3.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.diversity3.common.base.impl.BaseServiceImpl;
import com.diversity3.common.utils.ConvertUtils;
import com.diversity3.modules.sys.dao.SysDeptDao;
import com.diversity3.modules.sys.dto.SysDeptDto;
import com.diversity3.modules.sys.entity.SysDeptEntity;
import com.diversity3.modules.sys.service.SysDeptService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 部门
 * </p>
 *
 * @author: Greekn
 * @version: 1.0
 * @date: Created in 2020-05-29 11:15:46
 * @package:  com.diversity3.sys.entity
 * @modified: Greekn
 * @description: 部门
 * @copyright: Copyright (c) 2020-05-29
 */
@Service
public class SysDeptServiceImpl extends BaseServiceImpl<SysDeptDao, SysDeptEntity, SysDeptDto> implements SysDeptService {

    @Override
    public LambdaQueryWrapper<SysDeptEntity> toQueryWrapper(Map<String, Object> params) {
        LambdaQueryWrapper<SysDeptEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(params.containsKey("name"), SysDeptEntity::getName, params.get("name"));
        return wrapper;
    }

    @Override
    public LambdaUpdateWrapper<SysDeptEntity> toUpdateWrapper(SysDeptEntity entity) {
        LambdaUpdateWrapper<SysDeptEntity> wrapper = Wrappers.lambdaUpdate();
        wrapper.eq(SysDeptEntity::getId, entity.getId());
        return wrapper;
    }

    @Override
    public List<SysDeptDto> toTarget(List<SysDeptEntity> source) {
        return ConvertUtils.sourceToTarget(source, SysDeptDto.class);
    }

    @Override
    public SysDeptDto toTarget(SysDeptEntity source) {
        return ConvertUtils.sourceToTarget(source, SysDeptDto.class);
    }


}