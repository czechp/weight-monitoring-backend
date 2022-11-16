package app.web.account.application.useCase;

import app.web.account.adapter.persistence.AccountRole;
import app.web.account.domain.Account;

public interface AccountUseCaseAssignRole {
    Account accountAssignRole(long accountId, AccountRole newRole);
}
