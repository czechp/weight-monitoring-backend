package app.web.account.application.port;

import app.web.account.domain.Account;

import java.util.Optional;

public interface AccountPortFindByUsernameOrEmail {
    Optional<Account> findAccountByUsernameOrEmail(String username, String email);
}
