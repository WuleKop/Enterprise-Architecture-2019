package edu.mum.cs544.bank.service.aop;

import edu.mum.cs544.bank.logging.ILogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class JMSLogAdvice {

    @Autowired
    private ILogger logger;

    @Before("execution(* edu.mum.cs544.bank.jms.JMSSender.sendJMSMessage(String))")
    public void logJMSMessage(JoinPoint joinpoint) {
        Object [] args=joinpoint.getArgs();
        logger.log("Method = " + joinpoint.getSignature().getName()+" Message = "+(String)args[0]);
    }

}