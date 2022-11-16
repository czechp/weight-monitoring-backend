package app.web.account.application.useCase;

import app.web.account.domain.Account;

public interface AccountUseCaseRestorePassword {
    Account generateTokenToRestorePassword(String email);

    Account setNewPassword(String token, String newPassword);
}
