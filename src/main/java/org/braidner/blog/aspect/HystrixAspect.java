package org.braidner.blog.aspect;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author Braidner
 */
@Aspect
@Component
public class HystrixAspect {

    @Around("within(org.braidner.blog.service..*)")
    public Object hystrixServiceMonitor(final ProceedingJoinPoint aJoinPoint) throws Throwable {
        HystrixCommand theCommand = getHystrixCommand(aJoinPoint);
        return theCommand.execute();
    }

    @Around("within(org.braidner.blog.controller..*)")
    public Object hystrixControllerMonitor(final ProceedingJoinPoint aJoinPoint) throws Throwable {
        HystrixCommand theCommand = getHystrixCommand(aJoinPoint);
        return theCommand.execute();
    }

    private HystrixCommand getHystrixCommand(final ProceedingJoinPoint aJoinPoint) {
        String serviceName = aJoinPoint.getSignature().getDeclaringType().getSimpleName();
        String theShortName = aJoinPoint.getSignature().toShortString();
        HystrixCommand.Setter theSetter =
                HystrixCommand.Setter.
                        withGroupKey(HystrixCommandGroupKey.Factory.asKey(serviceName))
                        .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                                .withExecutionTimeoutEnabled(false));
        theSetter = theSetter.andCommandKey(HystrixCommandKey.Factory.asKey(theShortName));
        return new HystrixCommand(theSetter) {
            @Override
            protected Object run() throws Exception {
                try {
                    return aJoinPoint.proceed();
                } catch (Exception e) {
                    throw e;
                } catch (Throwable e) {
                    throw new Exception(e);
                }
            }
        };
    }
}
