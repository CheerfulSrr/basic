package com.diversity3.common.base;

import com.baomidou.mybatisplus.extension.service.IService;
import com.diversity3.common.page.PageUtil;

import java.util.List;
import java.util.Map;

/**
 * @author Greekn
 * @version 0.1
 * @date 2020-05-26 23:15
 */
public interface BaseService<T, E> extends IService<T> {

    PageUtil<E> page(Map<String, Object> map);

    boolean update(T entity);

    List<T> list(Map<String, Object> map);

}
