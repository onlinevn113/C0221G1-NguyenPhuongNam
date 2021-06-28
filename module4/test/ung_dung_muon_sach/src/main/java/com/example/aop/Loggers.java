package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component
@Aspect
public class Loggers {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @AfterReturning("execution(* com.example.controller.BookController.*(..))")
    public void log(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
//        System.err.println(String.format("[CMS] co loi xay ra: %s.%s%s: %s", className, method, args));

        logger.error("ten phuong thuc :"+method);
        logger.error("cac tham so  :"+args);
    }
}