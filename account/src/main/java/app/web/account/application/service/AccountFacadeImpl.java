package app.web.account.application.service;

import app.web.account.AccountFacade;
import app.web.account.application.port.AccountPortFindByUsername;
import app.web.account.domain.Account;
import app.web.account.dto.AccountFacadeDto;
import app.web.configuration.security.SecurityCurrentUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
class AccountFacadeImpl implements AccountFacade {
    private AccountPortFindByUsername accountPortFindByUsername;
    private SecurityCurrentUser securityCurrentUser;


    @Override
    public Optional<AccountFacadeDto> findCurrentUserAccount() {
        String currentUser = securityCurrentUser.getCurrentUser();
        return accountPortFindByUsername.findAccountByUsername(currentUser)
                .map(this::toDto);
    }


    @Override
    public Optional<AccountFacadeDto> findAccountByUsername(String username) {
        return accountPortFindByUsername.findAccountByUsername(username)
                .map(this::toDto);
    }

    private AccountFacadeDto toFacadeDto(Account account) {
        return new AccountFacadeDto(account.getId(), account.getUsername(), account.getAccountRole().toString());
    }


    private AccountFacadeDto toDto(Account account) {
        return new AccountFacadeDto(
                account.getId(),
                account.getUsername(),
                account.getAccountRole().toString()
        );
    }
}
