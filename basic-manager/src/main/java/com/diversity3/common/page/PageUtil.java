package com.diversity3.common.page;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页
 *
 * @author Greekn
 */
@Data
@ApiModel(value = "分页")
public class PageUtil<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "总数")
    protected Integer pageTotal;
    @ApiModelProperty(value = "当前页码")
    protected Integer pageNo;
    @ApiModelProperty(value = "当前页显示数量")
    protected Integer pageSize;
    @ApiModelProperty(value = "数据")
    protected List<T> pageData;

    public PageUtil(Integer pageTotal, Integer pageNo, Integer pageSize, List<T> pageData) {
        this.pageTotal = pageTotal;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.pageData = pageData;
    }

    public PageUtil(IPage<?> page, List<T> pageData) {
        this.pageData = pageData;
        this.pageTotal = (int) page.getTotal();
        this.pageNo = (int) page.getCurrent();
        this.pageSize = (int) page.getSize();
    }
}
