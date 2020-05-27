package com.diversity3.common.enums;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Greekn
 * @version 0.1
 * @date 2020-05-27 10:16
 */
public interface Constants {

    //====分页===

    /**
     * 当前页码
     */
    String PAGE_NO = "pageNo";

    /**
     * 当前页数量
     */
    String PAGE_SIZE = "pageSize";

    /**
     * 排序字段
     */
    String ORDER_BY_FIELD = "orderByField";

    /**
     * 排序方式
     */
    String ORDER = "order";

    /**
     * 分页数据集合
     */
    Set<String> PAGE_LIST = new HashSet<>(Arrays.asList(PAGE_NO, PAGE_SIZE, ORDER_BY_FIELD, ORDER));

    //===排序===

    /**
     * 升序
     */
    String ASC = "asc";
    /**
     * 降序
     */
    String DESC = "desc";

    //===响应===

    /**
     * 响应码
     */
    String CODE = "code";

    /**
     * 响应信息
     */
    String MSG = "msg";

    /**
     * 响应数据
     */
    String DATA = "data";

    //===entity===

    /**
     * 用户id
     */
    String ID = "id";

    /**
     * 创建时间
     */
    String CREATE_TIME = "create_time";

    /**
     * 更新时间
     */
    String UPDATE_TIME = "update_time";
}
