package com.diversity3.common.exception;

import com.diversity3.common.Result;
import com.diversity3.common.enums.IStatusImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

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
    public <T> Result<T> baseHandler(BaseException e) {
        return Result.exception(e);
    }


    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public <T> Result<List<FieldErrorData>> validationHandler(BindException e) {
        List<FieldErrorData> list = new ArrayList<>();
        e.getBindingResult().getFieldErrors().forEach(d -> list.add(new FieldErrorData(d.getField(), d.getDefaultMessage())));
        return Result.exception(IStatusImpl.VALIDATED_ERROR, list);
    }

    @Data
    @AllArgsConstructor
    private static class FieldErrorData {
        private String fieldName;
        private String message;
    }

}
