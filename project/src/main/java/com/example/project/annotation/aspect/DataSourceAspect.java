package com.example.project.annotation.aspect;

import com.example.project.annotation.DataSourceType;
import com.example.project.common.DataSourceContextHolder;
import com.example.project.common.DataSourceEnum;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class DataSourceAspect {

    @Pointcut("execution(* com.example.project..*(..)) && " +
            "@annotation(com.example.project.annotation.DataSourceType)")
    public void dataSourcePointcut() {
    }

    @Around("dataSourcePointcut()")
    public Object doAround(ProceedingJoinPoint pjp) {
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();
        DataSourceType type = method.getAnnotation(DataSourceType.class);
        DataSourceEnum sourceEnum = type.value();

        if (sourceEnum == DataSourceEnum.DS1) {
            DataSourceContextHolder.setDataSourceType(DataSourceEnum.DS1);
        } else if (sourceEnum == DataSourceEnum.DS2) {
            DataSourceContextHolder.setDataSourceType(DataSourceEnum.DS2);
        }

        Object result = null;
        try {
            result = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            DataSourceContextHolder.resetDataSourceType();
        }

        return result;
    }
}
