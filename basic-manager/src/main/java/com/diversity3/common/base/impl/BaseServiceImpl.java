package com.diversity3.common.base.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.diversity3.common.base.BaseDao;
import com.diversity3.common.base.BaseService;
import com.diversity3.common.enums.Constants;
import com.diversity3.common.page.PageUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * 通用service-impl
 *
 * @author Greekn
 * @version 0.1
 * @date 2020-05-27 11:03
 */
public abstract class BaseServiceImpl<D extends BaseDao<T>, T> extends ServiceImpl<D, T> implements BaseService<T> {

    @Override
    public PageUtil<T> page(Map<String, Object> params) {
        IPage<T> page = baseMapper.selectPage(
                toPage(params, Constants.CREATE_TIME, true),
                toQueryWrapper(params)
        );
        List<T> result = toTarget(page.getRecords());
        return toPageUtil(page, result);
    }

    @Override
    public boolean update(T entity) {
        return SqlHelper.retBool(baseMapper.update(
                entity,
                toUpdateWrapper(entity)
        ));
    }

    @Override
    public List<T> list(Map<String, Object> params) {
        return baseMapper.selectList(toQueryWrapper(params));
    }

    /**
     * 分页及排序
     *
     * @param params              参数
     * @param defaultOrderByField 默认排序字段
     * @param asc                 是否正序
     * @return IPage<T>
     */
    protected IPage<T> toPage(Map<String, Object> params, String defaultOrderByField, boolean asc) {

        int pageNo = 1;
        int pageSize = 20;

        if (params.get(Constants.PAGE_NO) != null) {
            pageNo = Integer.parseInt((String) params.get(Constants.PAGE_NO));
        }
        if (params.get(Constants.PAGE_NO) != null) {
            pageSize = Integer.parseInt((String) params.get(Constants.PAGE_SIZE));
        }

        Page<T> page = new Page<>(pageNo, pageSize);

        String orderByField = (String) params.get(Constants.ORDER_BY_FIELD);
        String order = (String) params.get(Constants.ORDER);

        if (StringUtils.isNotEmpty(orderByField) && StringUtils.isNotEmpty(order)) {
            if (Constants.ASC.equalsIgnoreCase(order)) {
                return page.addOrder(OrderItem.asc(orderByField));
            } else {
                return page.addOrder(OrderItem.desc(orderByField));
            }
        } else {
            if (asc) {
                page.addOrder(OrderItem.asc(defaultOrderByField));
            } else {
                page.addOrder(OrderItem.desc(defaultOrderByField));
            }
        }
        return page;
    }


    private PageUtil<T> toPageUtil(IPage<T> page, List<T> result) {
        return new PageUtil<T>(page, result);
    }

    /**
     * 获得LambdaQueryWrapper
     * 需子类重写
     *
     * @param params 参数
     * @return LambdaQueryWrapper<T>
     */
    public abstract LambdaQueryWrapper<T> toQueryWrapper(Map<String, Object> params);

    /**
     * 获得LambdaUpdateWrapper
     * 需子类重写
     *
     * @param entity entity
     * @return LambdaUpdateWrapper<T>
     */
    public abstract LambdaUpdateWrapper<T> toUpdateWrapper(T entity);

    /**
     * 查询结果转换为实体类
     *
     * @param source List<T>
     * @return List<entity>
     */
    public abstract List<T> toTarget(List<T> source);

    /**
     * 查询结果转换为实体类
     *
     * @param source T
     * @return entity
     */
    public abstract T toTarget(T source);

}
