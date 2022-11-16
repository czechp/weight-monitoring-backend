package app.web.account.application.port;

import app.web.account.domain.Account;

public interface AccountPortDelete {
    void deleteAccount(Account account);
}
