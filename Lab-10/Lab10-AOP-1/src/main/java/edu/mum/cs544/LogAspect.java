package edu.mum.cs544;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Aspect
@Component
public class LogAspect {
    private static Logger logger = LogManager.getLogger(LogAspect.class);

    @After("execution(* edu.mum.cs544.EmailSender.sendEmail(String, String))")
    public void logAfter(JoinPoint joinpoint) {
        Object [] args=joinpoint.getArgs();
        logger.warn("Method = " + joinpoint.getSignature().getName()+" Address = "+(String)args[0]+"\n"+
                " Message = "+(String)args[1]+" Outgoing mail server =  "+joinpoint.getTarget());
    }
    @Around("execution(* edu.mum.cs544.CustomerDAO.save(..))")
    public Object invoke(ProceedingJoinPoint call ) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(call.getSignature().getName());
        Object retVal = call.proceed();
        sw.stop();
        long totaltime = sw.getLastTaskTimeMillis();
        // print the time to the console
        System.out.println("Time to execute save = "+totaltime+" ms");
        return retVal;
    }

}
