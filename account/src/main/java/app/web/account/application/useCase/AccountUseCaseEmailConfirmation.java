package app.web.account.application.useCase;

import app.web.account.domain.Account;

public interface AccountUseCaseEmailConfirmation {
    Account accountEmailConfirmation(String token);
}
