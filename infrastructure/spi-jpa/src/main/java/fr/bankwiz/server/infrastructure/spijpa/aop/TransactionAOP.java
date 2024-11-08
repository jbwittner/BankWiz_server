package fr.bankwiz.server.infrastructure.spijpa.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class TransactionAOP {

    private final PlatformTransactionManager platformTransactionManager;
    private final DefaultTransactionDefinition definition = new DefaultTransactionDefinition();

    public TransactionAOP(final PlatformTransactionManager platformTransactionManager) {
        this.platformTransactionManager = platformTransactionManager;
        definition.setIsolationLevel(TransactionDefinition.ISOLATION_REPEATABLE_READ);
        definition.setTimeout(10);
    }

    @Around("@within(fr.bankwiz.server.domain.annotation.DomainService)")
    public Object applyTransaction(final ProceedingJoinPoint pjp) throws Throwable {
        log.debug("Before method execution");

        final TransactionStatus status = platformTransactionManager.getTransaction(definition);
        try {
            final Object result = pjp.proceed();
            log.debug("After method execution");
            platformTransactionManager.commit(status);
            log.debug("Commit method execution");
            return result;
        } catch (final Exception e) {
            log.info("Rollback method execution");
            platformTransactionManager.rollback(status);
            throw e;
        }
    }
}
