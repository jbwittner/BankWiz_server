package fr.bankwiz.server.application.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;

public class AspectTools {

    public Object aroundAdvice(final ProceedingJoinPoint joinPoint, final Logger logger) throws Throwable {
        final String methodName = joinPoint.getSignature().getName();
        final String declaringTypeSimpleName =
                joinPoint.getSignature().getDeclaringType().getSimpleName();

        final String informationCall = declaringTypeSimpleName + "::" + methodName;

        logger.info("Entering [{}]", informationCall);

        if (logger.isDebugEnabled()) {
            final String args = Arrays.toString(joinPoint.getArgs());
            logger.debug("Entering [{}] with arguments {}", informationCall, args);
        }

        final long start = System.currentTimeMillis();
        final Object proceed = joinPoint.proceed();
        final long executionTime = System.currentTimeMillis() - start;

        logger.info("Exiting [{}] executed in {} ms", informationCall, executionTime);

        return proceed;
    }
}
