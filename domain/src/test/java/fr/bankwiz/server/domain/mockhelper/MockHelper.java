package fr.bankwiz.server.domain.mockhelper;

import org.mockito.Mockito;

import lombok.Getter;

@Getter
public class MockHelper<T> {

    protected final T mock;

    protected MockHelper(final Class<T> mockClass) {
        this.mock = Mockito.mock(mockClass);
    }

    public void resetMock() {
        Mockito.reset(this.mock);
    }
}
