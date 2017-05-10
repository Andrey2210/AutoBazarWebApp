package by.autobazar.util;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class LogAspect {
    private static Logger log = Logger.getRootLogger();

    @Pointcut("execution(* by.autobazar.dao.daoImp.*.*(..))")
    public void dabMethodsPointcut() {
    }

    @Around("dabMethodsPointcut()")
    public void aroundDao(ProceedingJoinPoint joinPoint) {
        try {
            log.info("Starting method " + joinPoint.getSignature().getName());
            Object result = joinPoint.proceed();
            log.info("Successfully completed " + joinPoint.getSignature().getName() + " with result " + result);
        } catch (Throwable throwable) {
            log.error("Error in " + joinPoint.getSignature().getName() + throwable.getMessage());
        }
    }
}