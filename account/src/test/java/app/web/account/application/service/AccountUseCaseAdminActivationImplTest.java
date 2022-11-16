package app.web.account.application.service;

import app.web.account.application.port.AccountPortFindById;
import app.web.account.application.port.AccountPortSave;
import app.web.account.application.useCase.AccountUseCaseAdminActivation;
import app.web.account.domain.Account;
import app.web.account.domain.AccountConfiguration;
import app.web.exception.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountUseCaseAdminActivationImplTest {
    @Mock
    AccountPortFindById accountPortFindById;
    @Mock
    AccountPortSave accountPortSave;

    AccountUseCaseAdminActivation accountUseCaseAdminActivation;

    @BeforeEach
    void init() {
        this.accountUseCaseAdminActivation = new AccountUseCaseAdminActivationImpl(accountPortFindById, accountPortSave);
    }

    @Test
    void accountAdminActivationTest() {
        //given
        final long id = 1L;
        final boolean activation = true;
        final Account fetchedAccount = Account.builder()
                .withAccountConfiguration(
                        AccountConfiguration.builder()
                                .withAdminActivation(false)
                                .build()
                )
                .build();
        //when
        when(accountPortFindById.findAccountById(anyLong())).thenReturn(Optional.of(fetchedAccount));
        Account activatedAccount = accountUseCaseAdminActivation.accountAdminActivation(id, activation);
        //then
        assertEquals(activation, activatedAccount.getAccountConfiguration().isAdminActivation());
        verify(accountPortSave, times(1)).saveAccount(fetchedAccount);
    }


    @Test
    void accountAdminActivationAccountNotFoundTest() {
        //given
        final long id = 1L;
        final boolean activation = true;
        //when
        when(accountPortFindById.findAccountById(anyLong())).thenReturn(Optional.empty());
        //then
        assertThrows(NotFoundException.class, () -> accountUseCaseAdminActivation.accountAdminActivation(id, activation));
    }
}