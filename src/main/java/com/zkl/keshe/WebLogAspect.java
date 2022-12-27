package com.zkl.keshe;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 请求日志切面
 *
 * @author BailuGansan
 * @email 1195137943@qq.com
 */

@Aspect
@Component
public class WebLogAspect {

    public static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    @Pointcut("execution( * com..controller.*.*(..))")
    public void logPointCut() {
    }

    @Before("logPointCut()")
    public void before(JoinPoint joinPoint) {
        // 从 servlet 上下文中获取 request 容器中的属性
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest req = attributes.getRequest();

//        logger.info("客户端地址: " + req.getRemoteHost() + ":" + req.getRemotePort());
        logger.info("请求地址: " + req.getRequestURL().toString());
        logger.info("请求方法: " + req.getMethod());
        logger.info("控制器方法: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("参数: " + Arrays.toString(joinPoint.getArgs()));
    }

//    @After("logPointCut()")
//    public void after(JoinPoint joinPoint){
//
//    }

    @AfterReturning(returning = "ret", pointcut = "logPointCut()")
    public void returning(Object ret) {
        // 返回值太大时打印物理存储地址
        logger.debug("返回值: " + ret);
    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        logger.info("耗时: " + (System.currentTimeMillis() - startTime) + "ms");
        return result;
    }
}
