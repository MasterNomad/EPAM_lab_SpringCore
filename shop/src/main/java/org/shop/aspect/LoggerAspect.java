package org.shop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggerAspect {

    private final static Logger logger = LoggerFactory.getLogger(LoggerAspect.class);

    @Pointcut("execution(public * org.shop.repository.map..*(..))")
    public void callAtApiPublic() {
    }

    @Around("callAtApiPublic()")
    public Object loggingMethod(ProceedingJoinPoint joinPoint) {
        logger.info("Method: {}.{} was called with args: {}",
                joinPoint.getTarget().getClass().getSimpleName(),
                joinPoint.getSignature().getName(),
                joinPoint.getArgs());
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        logger.info("Method: {}.{} return: {}",
                joinPoint.getTarget().getClass().getSimpleName(),
                joinPoint.getSignature().getName(),
                result);
        return result;
    }


}
