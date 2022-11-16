package app.web.account.application.service;

import app.web.account.adapter.persistence.AccountRole;
import app.web.account.application.port.AccountPortDelete;
import app.web.account.application.port.AccountPortEmitDeleteEvent;
import app.web.account.application.port.AccountPortFindById;
import app.web.account.application.port.AccountPortFindByUsername;
import app.web.account.application.useCase.AccountUseCaseDelete;
import app.web.account.domain.Account;
import app.web.configuration.security.SecurityCurrentUser;
import app.web.exception.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountUseCaseDeleteImplTest {
    @Mock
    AccountPortFindById accountPortFindById;
    @Mock
    AccountPortFindByUsername accountPortFindByUsername;
    @Mock
    AccountPortEmitDeleteEvent accountPortEmitDeleteEvent;
    @Mock
    AccountPortDelete accountPortDelete;
    @Mock
    SecurityCurrentUser securityCurrentUser;


    AccountUseCaseDelete accountUseCaseDelete;

    @BeforeEach
    void init() {
        this.accountUseCaseDelete = new AccountUseCaseDeleteImpl(
                accountPortFindById,
                accountPortDelete,
                accountPortFindByUsername,
                accountPortEmitDeleteEvent,
                securityCurrentUser);
    }

    @Test
    void deleteAccountByOwner() {
        //given
        final long id = 1L;
        final Account accountToDelete = Account
                .builder()
                .withUsername("user")
                .build();
        final String currentLoggedUser = "user";
        //when
        when(accountPortFindById.findAccountById(anyLong())).thenReturn(Optional.of(accountToDelete));
        when(securityCurrentUser.getCurrentUser()).thenReturn(currentLoggedUser);
        accountUseCaseDelete.deleteAccountById(id);
        //then
        verify(accountPortDelete, times(1)).deleteAccount(accountToDelete);
        verify(securityCurrentUser, times(1)).getCurrentUser();
    }


    @Test
    void deleteAccountByAdmin() {
        final long id = 1L;
        final Account accountToDelete = Account
                .builder()
                .withUsername("user")
                .build();
        final String currentLoggedUser = "user123";
        final Account currentUserIsAdmin = Account.builder()
                .withAccountRole(AccountRole.ADMIN)
                .build();
        //when
        when(accountPortFindById.findAccountById(anyLong())).thenReturn(Optional.of(accountToDelete));
        when(securityCurrentUser.getCurrentUser()).thenReturn(currentLoggedUser);
        when(accountPortFindByUsername.findAccountByUsername(anyString())).thenReturn(Optional.of(currentUserIsAdmin));
        accountUseCaseDelete.deleteAccountById(id);
        //then
        verify(accountPortDelete, times(1)).deleteAccount(accountToDelete);
        verify(securityCurrentUser, times(1)).getCurrentUser();
    }

    @Test
    void deleteAccountNotExists() {
        //given
        final long id = 1L;
        //when
        when(accountPortFindById.findAccountById(anyLong())).thenReturn(Optional.empty());
        //then
        assertThrows(NotFoundException.class, () -> accountUseCaseDelete.deleteAccountById(id));
    }

    @Configuration
    @ComponentScan("app.web.pczportfolio.pczbuildingautomation.account.application")
    static class TestConfiguration {

    }
}