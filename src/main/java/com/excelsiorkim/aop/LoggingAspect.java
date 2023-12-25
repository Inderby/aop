package com.excelsiorkim.aop;

import ch.qos.logback.classic.Logger;
import org.aspectj.lang.JoinPoint;
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
}
