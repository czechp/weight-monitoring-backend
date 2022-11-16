package app.web.account.application.service;

import app.web.account.application.port.AccountPortFindByEmail;
import app.web.account.application.port.AccountPortFindByNewPasswordToken;
import app.web.account.application.port.AccountPortNotifierRestorePasswordToken;
import app.web.account.application.port.AccountPortSave;
import app.web.account.application.useCase.AccountUseCaseRestorePassword;
import app.web.account.domain.Account;
import app.web.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Function;

@Service
@AllArgsConstructor
class AccountUseCaseRestorePasswordImpl implements AccountUseCaseRestorePassword {
    private final AccountPortFindByEmail accountPortFindByEmail;
    private final AccountPortFindByNewPasswordToken accountPortFindByNewPasswordToken;
    private final AccountPortSave accountPortSave;
    private final AccountPortNotifierRestorePasswordToken accountPortNotifierRestorePasswordToken;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public Account generateTokenToRestorePassword(String email) {
        Account account = accountPortFindByEmail.findAccountByEmail(email)
                .orElseThrow(() -> new NotFoundException("Account with such email: " + email + " does not exist"));
        String newPasswordToken = account.generateNewPasswordToken(email);
        accountPortSave.saveAccount(account);
        accountPortNotifierRestorePasswordToken.sendRestorePasswordToken(email, newPasswordToken);
        return account;
    }

    @Override
    public Account setNewPassword(String token, String newPassword) {
        final Function<String, String> passwordGenerator = passwordEncoder::encode;
        Account account = accountPortFindByNewPasswordToken.findAccountByNewPasswordToken(token)
                .orElseThrow(() -> new NotFoundException(
                        "Account with such new password token: " + token + " does not exist")
                );
        account.generateNewPassword(token, newPassword, passwordGenerator);
        accountPortSave.saveAccount(account);
        return account;
    }
}
