package edu.mum.cs544.bank.service.aop;

import edu.mum.cs544.bank.logging.ILogger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class StopWatchAdvice  {

    @Autowired
    private ILogger logger;

    @Around("execution(* edu.mum.cs544.bank.service..*(..))")
    public Object methodTimer(ProceedingJoinPoint call ) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(call.getSignature().getName());
        Object retVal = call.proceed();
        sw.stop();
        long totaltime = sw.getLastTaskTimeMillis();
        // print the time to the console
        System.out.println("Execution time of "+call.getSignature().getName()+" "+totaltime+" ms");
        return retVal;
    }

}

