package app.web.account.application.port;

import app.web.account.domain.Account;

public interface AccountPortEmitDeleteEvent {
    void emitAccountDeleteEvent(Account account);
}
