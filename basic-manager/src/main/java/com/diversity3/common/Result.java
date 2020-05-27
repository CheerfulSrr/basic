package com.diversity3.common;

import com.diversity3.common.enums.IStatus;
import com.diversity3.common.enums.IStatusImpl;
import com.diversity3.common.exception.BaseException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 通用响应结果
 *
 * @author Greekn
 * @version 0.1
 * @date 2020-05-26 09:54
 */
@Data
@ApiModel(value = "通用响应结果")
public class Result<T> implements Serializable {

    @ApiModelProperty(name = "响应数据")
    private T data;
    @ApiModelProperty(name = "状态码")
    private Integer code;
    @ApiModelProperty(name = "简述")
    private String msg;

    public Result(T data, Integer code, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public Result(ResultBuilder<T> builder) {
        this.data = builder.data;
        this.code = builder.code;
        this.msg = builder.msg;
    }

    public static <T> Result<T> ok() {
        return new ResultBuilder<T>().status(IStatusImpl.SUCCESS).build();
    }

    public static <T> Result<T> ok(T data) {
        return new ResultBuilder<T>().status(IStatusImpl.SUCCESS).data(data).build();
    }

    public static <T> Result<T> of(Integer code, String msg, T data) {
        return new ResultBuilder<T>(code).msg(msg).data(data).build();
    }

    public static <T> Result<T> of(T data) {
        return new ResultBuilder<T>().data(data).build();
    }

    public static <T> ResultBuilder<T> status(IStatus status){
        return new ResultBuilder<T>().status(status);
    }

    public static <T> Result<T> exception(BaseException e) {
        return new ResultBuilder<T>().exception(e).build();
    }

    public static <T> Result<T> exception(IStatus status, T data) {
        return (Result<T>) status(status).data(data).build();
    }


    public static class ResultBuilder<T> {
        private Integer code;
        private T data;
        private String msg;

        public ResultBuilder() {
            this.code = IStatusImpl.SUCCESS.getCode();
            this.msg = IStatusImpl.SUCCESS.getMessage();
        }

        public ResultBuilder(Integer code) {
            this.code = code;
        }

        public ResultBuilder<T> data(T data) {
            this.data = data;
            return this;
        }

        public ResultBuilder<T> msg(String msg) {
            this.msg = msg;
            return this;
        }

        public ResultBuilder<T> status(IStatus status) {
            this.code = status.getCode();
            this.msg = status.getMessage();
            return this;
        }

        public ResultBuilder<T> exception(BaseException e) {
            this.code = e.getCode();
            this.msg = e.getLocalizedMessage();
            return this;
        }

        public Result<T> build() {
            return new Result<T>(this);
        }

    }


}
