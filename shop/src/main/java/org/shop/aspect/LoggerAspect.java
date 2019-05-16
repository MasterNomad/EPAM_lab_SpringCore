package org.shop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggerAspect {

    private final static Logger logger = LoggerFactory.getLogger(LoggerAspect.class);

    @Pointcut("execution(public * org.shop.api.impl.ProposalServiceImpl.*(..))")
    public void callAtApiPublic() {
    }

    @Before("callAtApiPublic()")
    public void loggingBeforeMethod(JoinPoint joinPoint) {
        logger.info("Method: {} was called with args: {}",
                joinPoint.getSignature().getName(),
                joinPoint.getArgs());
    }

    @After("callAtApiPublic()")
    public void loggingAfterMethod(JoinPoint joinPoint) {
        logger.info("Method: {} return: {}",
                joinPoint.getSignature().getName(),
                joinPoint.);
    }

}
