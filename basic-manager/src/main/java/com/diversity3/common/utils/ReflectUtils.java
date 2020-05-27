package com.diversity3.common.utils;

import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 反射utils
 *
 * @author Greekn
 * @version 0.1
 * @date 2020-05-27 15:32
 */
public class ReflectUtils {

    /**
     * 获得entity所有字段的name
     *
     * @param t   Class
     * @param <T> entity
     * @return List<String>
     */
    public static <T> List<String> getAllFieldsName(Class<T> t) {
        List<Field> fields = FieldUtils.getAllFieldsList(t);
        return fields.stream().map(Field::getName).collect(Collectors.toList());
    }

}
