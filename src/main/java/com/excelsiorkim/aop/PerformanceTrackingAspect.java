package com.excelsiorkim.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PerformanceTrackingAspect {

  private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

  @Around("execution(* com.excelsiorkim.aop.*.*(..))")
  public void findExecutionTime(ProceedingJoinPoint joinPoint)
    throws Throwable {
    long startTime = System.currentTimeMillis();
    joinPoint.proceed();
    long timeTaken = System.currentTimeMillis() - startTime;
    logger.info("Time Taken by {} is {}", joinPoint, timeTaken);
  }
}
