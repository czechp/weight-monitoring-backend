package app.web.account.application.useCase;

import app.web.account.application.dto.AccountCreateCmdDto;
import app.web.account.domain.Account;

public interface AccountUseCaseCreate {
    Account createAccount(AccountCreateCmdDto accountCreateCmdDto);
}
