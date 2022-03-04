package ru.denisov.restWithAngularJs.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
    @Around("execution(* ru.denisov.restWithAngularJs.controllers.*.*(..))")
    public Object controllersLogging(ProceedingJoinPoint proceedingJoinPoint) {
        long start = System.currentTimeMillis();
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable t) {
            logger.error("Can't executed " + proceedingJoinPoint.getSignature().getName());
            return null;
        }

        long end = System.currentTimeMillis();
        logger.info(String.format("executed request for: %s in %d milliseconds",
                proceedingJoinPoint.getSignature().toShortString(), (end - start)));
        return result;
    }
}
