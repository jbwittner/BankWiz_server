package fr.bankwiz.server.domain.mockhelper;

import java.util.Optional;

import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import fr.bankwiz.server.domain.spi.BaseDomainSpi;

public class MockBaseDomainSpiHelper<T extends BaseDomainSpi<E, I>, E, I> extends MockHelper<T> {

    public MockBaseDomainSpiHelper(final Class<T> mockClass) {
        super(mockClass);
    }

    public void mockSave() {
        final Answer<E> returnArgumentAnswer = invocation -> {
            final Object[] args = invocation.getArguments();
            return (E) args[0];
        };

        Mockito.doAnswer(returnArgumentAnswer).when(this.mock).save(Mockito.any());
    }

    public void verifySave(final E domainData) {
        Mockito.verify(this.mock, Mockito.times(1)).save(domainData);
    }

    public void mockFindById(final I id, final E entity) {
        Mockito.when(this.mock.findById(id)).thenReturn(Optional.of(entity));
    }
}
