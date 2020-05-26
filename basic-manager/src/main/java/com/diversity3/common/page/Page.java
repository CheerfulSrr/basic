package com.diversity3.common.page;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页工具类
 *
 * @author Greekn
 */
@Data
@ApiModel(value = "分页")
public class Page<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "总数")
    private Integer total;

    @ApiModelProperty(value = "当前页码")
    private Integer pageNo;

    @ApiModelProperty(value = "当前页显示数量")
    private Integer pageSize;

    @ApiModelProperty(value = "数据")
    private List<T> list;

    /**
     * 分页
     *
     * @param list  列表数据
     * @param total 总记录数
     */
    public Page(List<T> list, long total) {
        this.list = list;
        this.total = (int) total;
    }

    public Page(List<T> list, IPage<?> page) {
        this.list = list;
        this.pageNo = (int) page.getCurrent();
        this.total = (int) page.getTotal();
    }
}
