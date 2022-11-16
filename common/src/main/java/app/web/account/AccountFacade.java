package app.web.account;

import app.web.account.dto.AccountFacadeDto;

import java.util.Optional;

public interface AccountFacade {
    Optional<AccountFacadeDto> findCurrentUserAccount();

    Optional<AccountFacadeDto> findAccountByUsername(String username);
}
