package fr.bankwiz.server.application.spi;

import fr.bankwiz.server.domain.model.data.CurrencyDomain;
import fr.bankwiz.server.domain.spi.CurrencyDomainSpi;
import org.springframework.stereotype.Component;

import javax.money.CurrencyQuery;
import javax.money.CurrencyUnit;
import javax.money.Monetary;
import java.util.*;

@Component
public class CurrencyDomainSpiImpl implements CurrencyDomainSpi {

    @Override
    public List<CurrencyDomain> findAll() {
        List<Currency> currencies = CurrencyDomainSpiImpl.getAllCurrencies();
        return currencies.stream().map(CurrencyDomainSpiImpl::convertCurrency).toList();
    }


    @Override
    public Optional<CurrencyDomain> findByIsoCode(String isoCode) {
        try {
            final Currency currency = Currency.getInstance(isoCode);
            final CurrencyDomain currencyDomain = CurrencyDomainSpiImpl.convertCurrency(currency);
            return Optional.of(currencyDomain);
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
    }

    public static CurrencyDomain convertCurrency(Currency currency){
        return new CurrencyDomain(currency.getCurrencyCode(), currency.getDisplayName(), currency.getSymbol(), currency.getDefaultFractionDigits());
    }

    public static List<Currency> getAllCurrencies()
    {
        List<Currency> toret = new ArrayList<>();
        Locale[] locs = Locale.getAvailableLocales();

        for(Locale loc : locs) {
            try {
                Currency currency = Currency.getInstance( loc );

                if ( currency != null ) {
                    toret.add( currency );
                }
            } catch(Exception exc)
            {
                throw new RuntimeException(exc);
                // Locale not found
            }
        }

        return toret;
    }


}
