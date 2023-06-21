package com.wi.pb.forum.aspect;

import com.wi.pb.forum.utils.SecurityUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class AspectLogger {
    private long afterMethodInvocation;
    private long beforeMethodInvocation;
    private static final Logger logger = LoggerFactory.getLogger(AspectLogger.class.getName());
    private Method method;

    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    public void loggerAspectPointcut(){}

    @Before("loggerAspectPointcut()")
    public void before(JoinPoint joinPoint){

        method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        beforeMethodInvocation = System.currentTimeMillis();

        logger.info(" METHOD " + method.getName() + " STARTED");
        String username = SecurityUtil.getCurrentUserNameOrEmptyString();
        if (!username.equals("anonymousUser")){
            logger.info("-- Login: " + username);
        }
        logger.info("-- Args:");

        for(int i = 0; i < joinPoint.getArgs().length; i++){
            String argName = ((MethodSignature) joinPoint.getSignature()).getParameterNames()[i];
            if(joinPoint.getArgs()[i]!=null) {
                String argValue = joinPoint.getArgs()[i].toString();
                logger.info("---- " + argName + ": " + argValue);
            }
        }
    }

    @After("loggerAspectPointcut()")
    public void after(JoinPoint joinPoint){
        method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        afterMethodInvocation = System.currentTimeMillis();
        long methodExecutionTime = afterMethodInvocation - beforeMethodInvocation;
        logger.info("METHOD " + method.getName() + " ENDED. TIME: " + methodExecutionTime + " ms\n");
    }
}

