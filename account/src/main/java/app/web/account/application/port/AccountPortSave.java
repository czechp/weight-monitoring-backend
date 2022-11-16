package app.web.account.application.port;

import app.web.account.domain.Account;

public interface AccountPortSave {
    Account saveAccount(Account account);
}
