package com.diversity3.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.diversity3.common.base.impl.BaseServiceImpl;
import com.diversity3.common.utils.ConvertUtils;
import com.diversity3.modules.sys.dao.SysDictDao;
import com.diversity3.modules.sys.dto.SysDictDto;
import com.diversity3.modules.sys.entity.SysDictEntity;
import com.diversity3.modules.sys.service.SysDictService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 字典表
 * </p>
 *
 * @author: Greekn
 * @version: 1.0
 * @date: Created in 2020-05-29 11:15:45
 * @package:  com.diversity3.sys.entity
 * @modified: Greekn
 * @description: 字典表
 * @copyright: Copyright (c) 2020-05-29
 */
@Service
public class SysDictServiceImpl extends BaseServiceImpl<SysDictDao, SysDictEntity, SysDictDto> implements SysDictService {

    @Override
    public LambdaQueryWrapper<SysDictEntity> toQueryWrapper(Map<String, Object> params) {
        LambdaQueryWrapper<SysDictEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(params.containsKey("name"), SysDictEntity::getName, params.get("name"));
        return wrapper;
    }

    @Override
    public LambdaUpdateWrapper<SysDictEntity> toUpdateWrapper(SysDictEntity entity) {
        LambdaUpdateWrapper<SysDictEntity> wrapper = Wrappers.lambdaUpdate();
        wrapper.eq(SysDictEntity::getId, entity.getId());
        return wrapper;
    }

    @Override
    public List<SysDictDto> toTarget(List<SysDictEntity> source) {
        return ConvertUtils.sourceToTarget(source, SysDictDto.class);
    }

    @Override
    public SysDictDto toTarget(SysDictEntity source) {
        return ConvertUtils.sourceToTarget(source, SysDictDto.class);
    }


}