package app.web.account.application.port;

import app.web.account.domain.Account;

import java.util.Optional;

public interface AccountPortFindByUsername {
    Optional<Account> findAccountByUsername(String username);
}
