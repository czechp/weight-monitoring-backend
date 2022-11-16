package app.web.account.application.service;

import app.web.account.application.dto.AccountCreateCmdDto;
import app.web.account.application.port.AccountPortFindByUsernameOrEmail;
import app.web.account.application.port.AccountPortNotifierCreate;
import app.web.account.application.port.AccountPortSave;
import app.web.account.application.useCase.AccountUseCaseCreate;
import app.web.account.domain.Account;
import app.web.exception.ConditionsNotFulFiledException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Function;

@Service
@AllArgsConstructor
class AccountUseCaseCreateImpl implements AccountUseCaseCreate {
    private final PasswordEncoder passwordEncoder;
    private final AccountPortFindByUsernameOrEmail accountPortFindByUsernameOrEmail;
    private final AccountPortNotifierCreate accountPortNotifierCreate;
    private final AccountPortSave accountPortSave;

    @Override
    @Transactional
    public Account createAccount(AccountCreateCmdDto accountCreateCmdDto) {
        Function<String, String> hashPasswordFunction = passwordEncoder::encode;
        accountPortFindByUsernameOrEmail.findAccountByUsernameOrEmail(accountCreateCmdDto.getUsername(), accountCreateCmdDto.getPassword())
                .ifPresent((r) -> {
                    throw new ConditionsNotFulFiledException("Account with such username or email already exists");
                });
        Account newAccount = Account.create(accountCreateCmdDto, hashPasswordFunction);
        accountPortSave.saveAccount(newAccount);
        accountPortNotifierCreate.notifyAboutNewAccount(newAccount.getEmail(), newAccount.getAccountConfiguration().getEnableToken());
        return newAccount;
    }
}
