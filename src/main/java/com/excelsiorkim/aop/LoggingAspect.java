package com.excelsiorkim.aop;

import ch.qos.logback.classic.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {

  private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

  @Before("execution(* com.excelsiorkim.aop.*.*(..))")
  public void logMethod(JoinPoint joinPoint) {
    logger.info(
      "Before Aspect - Method called - {}",
      joinPoint.getSignature().getName()
    );
  }

  @After("execution(* com.excelsiorkim.aop.*.*(..))")
  public void logMethodAfter(JoinPoint joinPoint) {
    logger.info(
      "After Aspect - Method called - {}",
      joinPoint.getSignature().getName()
    );
  }

  @AfterThrowing(
    value = "execution(* com.excelsiorkim.aop.*.*(..))",
    throwing = "exception"
  )
  public void logMethodAfterThrowing(JoinPoint joinPoint, Exception exception) {
    logger.info(
      "After Throwing Aspect - Method called - {} - Exception - {}",
      joinPoint.getSignature().getName(),
      exception
    );
  }

  @AfterReturning(
    value = "execution(* com.excelsiorkim.aop.*.*(..))",
    returning = "result"
  )
  public void logMethodAfterReturning(JoinPoint joinPoint, Object result) {
    logger.info(
      "After Returning Aspect - Method called - {} - Result - {}",
      joinPoint.getSignature().getName(),
      result
    );
  }
}
