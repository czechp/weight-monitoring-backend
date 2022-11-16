package app.web.account.application.useCase;

import app.web.account.domain.Account;

public interface AccountUseCaseAdminActivation {
    Account accountAdminActivation(long id, boolean activation);
}
