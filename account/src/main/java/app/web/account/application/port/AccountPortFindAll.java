package app.web.account.application.port;

import app.web.account.domain.Account;

import java.util.List;

public interface AccountPortFindAll {
    List<Account> findAllAccounts();
}
