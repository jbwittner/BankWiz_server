package fr.bankwiz.server.application.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import fr.bankwiz.server.domain.service.BankAccountDomainService;
import fr.bankwiz.server.domain.service.CurrencyDomainService;
import fr.bankwiz.server.domain.service.UserDomainService;
import fr.bankwiz.server.infrastructure.apirest.controller.BankAccountController;
import fr.bankwiz.server.infrastructure.apirest.controller.CurrencyController;
import fr.bankwiz.server.infrastructure.apirest.controller.StatusController;
import fr.bankwiz.server.infrastructure.apirest.controller.UserController;
import fr.bankwiz.server.infrastructure.apirest.spi.Oauth2AuthenticationSpi;
import fr.bankwiz.server.infrastructure.spijpa.spi.database.JPABankAccountDomainSpi;
import fr.bankwiz.server.infrastructure.spijpa.spi.database.JPACurrencyDomainSpi;
import fr.bankwiz.server.infrastructure.spijpa.spi.database.JPAUserDomainSpi;

@Component
@Aspect
public class LogAspect {

    /* CONTROLLER */
    private final Logger statusControllerLog = LoggerFactory.getLogger(StatusController.class);
    private final Logger userControllerLog = LoggerFactory.getLogger(UserController.class);
    private final Logger bankAccountControllerLog = LoggerFactory.getLogger(BankAccountController.class);
    private final Logger currencyControllerLog = LoggerFactory.getLogger(CurrencyController.class);
    /* CONTROLLER */

    /* SERVICE */
    private final Logger userDomainServiceLog = LoggerFactory.getLogger(UserDomainService.class);
    private final Logger bankAccountServiceLog = LoggerFactory.getLogger(BankAccountDomainService.class);
    private final Logger currencyServiceLog = LoggerFactory.getLogger(CurrencyDomainService.class);
    /* SERVICE */

    /* SPI */
    private final Logger authenticationSpiLog = LoggerFactory.getLogger(Oauth2AuthenticationSpi.class);
    private final Logger userSpiLog = LoggerFactory.getLogger(JPAUserDomainSpi.class);
    private final Logger bankAccountSpiLog = LoggerFactory.getLogger(JPABankAccountDomainSpi.class);
    private final Logger currencySpiLog = LoggerFactory.getLogger(JPACurrencyDomainSpi.class);
    /* SPI */

    private final AspectTools aspectTools = new AspectTools();

    /* CONTROLLER */
    @Around("within(fr.bankwiz.server.infrastructure.apirest.controller.impl.StatusControllerImpl)")
    public Object statusControllerAroundLog(final ProceedingJoinPoint joinPoint) throws Throwable {
        return aspectTools.aroundAdvice(joinPoint, statusControllerLog);
    }

    @Around("within(fr.bankwiz.server.infrastructure.apirest.controller.impl.UserControllerImpl)")
    public Object userControllerAroundLog(final ProceedingJoinPoint joinPoint) throws Throwable {
        return aspectTools.aroundAdvice(joinPoint, userControllerLog);
    }

    @Around("within(fr.bankwiz.server.infrastructure.apirest.controller.impl.BankAccountControllerImpl)")
    public Object bankAccountControllerAroundLog(final ProceedingJoinPoint joinPoint) throws Throwable {
        return aspectTools.aroundAdvice(joinPoint, bankAccountControllerLog);
    }

    @Around("within(fr.bankwiz.server.infrastructure.apirest.controller.impl.CurrencyControllerImpl)")
    public Object currencyControllerAroundLog(final ProceedingJoinPoint joinPoint) throws Throwable {
        return aspectTools.aroundAdvice(joinPoint, currencyControllerLog);
    }

    /* CONTROLLER */

    /* SERVICE */
    @Around("within(fr.bankwiz.server.domain.service.UserDomainService)")
    public Object userDomainServiceAroundLog(final ProceedingJoinPoint joinPoint) throws Throwable {
        return aspectTools.aroundAdvice(joinPoint, userDomainServiceLog);
    }

    @Around("within(fr.bankwiz.server.domain.service.BankAccountDomainService)")
    public Object bankAccountDomainServiceAroundLog(final ProceedingJoinPoint joinPoint) throws Throwable {
        return aspectTools.aroundAdvice(joinPoint, bankAccountServiceLog);
    }

    @Around("within(fr.bankwiz.server.domain.service.CurrencyDomainService)")
    public Object currencyDomainServiceAroundLog(final ProceedingJoinPoint joinPoint) throws Throwable {
        return aspectTools.aroundAdvice(joinPoint, currencyServiceLog);
    }

    /* SERVICE */

    /* SPI */
    @Around("within(fr.bankwiz.server.infrastructure.apirest.spi.Oauth2AuthenticationSpi)")
    public Object authenticationSpiAroundLog(final ProceedingJoinPoint joinPoint) throws Throwable {
        return aspectTools.aroundAdvice(joinPoint, authenticationSpiLog);
    }

    @Around("within(fr.bankwiz.server.infrastructure.spijpa.spi.database.JPAUserDomainSpi)")
    public Object userSpiAroundLog(final ProceedingJoinPoint joinPoint) throws Throwable {
        return aspectTools.aroundAdvice(joinPoint, userSpiLog);
    }

    @Around("within(fr.bankwiz.server.infrastructure.spijpa.spi.database.JPABankAccountDomainSpi)")
    public Object bankAccountSpiAroundLog(final ProceedingJoinPoint joinPoint) throws Throwable {
        return aspectTools.aroundAdvice(joinPoint, bankAccountSpiLog);
    }

    @Around("within(fr.bankwiz.server.infrastructure.spijpa.spi.database.JPACurrencyDomainSpi)")
    public Object currencySpiAroundLog(final ProceedingJoinPoint joinPoint) throws Throwable {
        return aspectTools.aroundAdvice(joinPoint, currencySpiLog);
    }

    /* SPI */

}
