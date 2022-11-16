package app.web.account.application.port;

import app.web.account.domain.Account;

import java.util.Optional;

public interface AccountPortFindByNewPasswordToken {
    Optional<Account> findAccountByNewPasswordToken(String newPasswordToken);
}
