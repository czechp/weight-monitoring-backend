package app.web.account.application.service;

import app.web.account.application.port.AccountPortFindByEnableToken;
import app.web.account.application.port.AccountPortSave;
import app.web.account.application.useCase.AccountUseCaseEmailConfirmation;
import app.web.account.domain.Account;
import app.web.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
class AccountUseCaseEmailConfirmationImpl implements AccountUseCaseEmailConfirmation {
    private final AccountPortFindByEnableToken accountPortFindByEnableToken;
    private final AccountPortSave accountPortSave;

    @Transactional
    @Override
    public Account accountEmailConfirmation(String token) {
        Account account = accountPortFindByEnableToken.findAccountByEnableToken(token)
                .orElseThrow(() -> new NotFoundException("Account with token: " + token + " does not exist"));
        account.confirmEmail(token);
        accountPortSave.saveAccount(account);
        return account;
    }
}
