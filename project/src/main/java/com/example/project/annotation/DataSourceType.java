package com.example.project.annotation;

import com.example.project.common.DataSourceEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.MODULE})
public @interface DataSourceType {
    DataSourceEnum value() default DataSourceEnum.DS1;
}
