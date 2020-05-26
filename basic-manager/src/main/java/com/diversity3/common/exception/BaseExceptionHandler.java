package com.diversity3.common.exception;

import com.diversity3.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 *
 * @author Greekn
 * @version 0.1
 * @date 2020-05-26 10:44
 */
@ControllerAdvice
@Slf4j
public class BaseExceptionHandler {

    @ExceptionHandler(value = BaseException.class)
    @ResponseBody
    public <T> Result<T> handler(BaseException e) {
        return Result.exception(e);
    }

}
