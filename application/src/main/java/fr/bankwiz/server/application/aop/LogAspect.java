package fr.bankwiz.server.application.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import fr.bankwiz.server.domain.service.UserDomainService;
import fr.bankwiz.server.infrastructure.apirest.controller.StatusController;
import fr.bankwiz.server.infrastructure.apirest.controller.UserController;
import fr.bankwiz.server.infrastructure.apirest.spi.Oauth2AuthenticationSpi;
import fr.bankwiz.server.infrastructure.spijpa.spi.database.JPAUserDomainSpi;

@Component
@Aspect
public class LogAspect {

    /* CONTROLLER */
    private final Logger statusControllerLog = LoggerFactory.getLogger(StatusController.class);
    private final Logger userControllerLog = LoggerFactory.getLogger(UserController.class);
    /* CONTROLLER */

    /* SERVICE */
    private final Logger userDomainServiceLog = LoggerFactory.getLogger(UserDomainService.class);
    /* SERVICE */

    /* SPI */
    private final Logger authenticationSpiLog = LoggerFactory.getLogger(Oauth2AuthenticationSpi.class);
    private final Logger userSpiLog = LoggerFactory.getLogger(JPAUserDomainSpi.class);
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

    /* CONTROLLER */

    /* SERVICE */
    @Around("within(fr.bankwiz.server.domain.service.UserDomainService)")
    public Object userDomainServiceAroundLog(final ProceedingJoinPoint joinPoint) throws Throwable {
        return aspectTools.aroundAdvice(joinPoint, userDomainServiceLog);
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

    /* SPI */

}
