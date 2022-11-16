package app.web.account.adapter.persistence;

import app.web.account.application.port.*;
import app.web.account.domain.Account;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
class AccountPersistenceAdapter implements
        AccountPortDelete,
        AccountPortFindById,
        AccountPortFindByUsername,
        AccountPortFindByUsernameOrEmail,
        AccountPortSave,
        AccountPortFindByEnableToken,
        AccountPortFindByEmail,
        AccountPortFindByNewPasswordToken,
        AccountPortFindAll {
    private final AccountJpaRepository accountJpaRepository;

    @Override
    public void deleteAccount(Account account) {
        accountJpaRepository.delete(AccountEntityMapper.toEntity(account));
    }

    @Override
    public Optional<Account> findAccountById(long id) {
        return accountJpaRepository.findById(id)
                .map(AccountEntityMapper::toDomain);
    }

    @Override
    public Optional<Account> findAccountByUsername(String username) {
        return accountJpaRepository.findByUsername(username)
                .map(AccountEntityMapper::toDomain);
    }

    @Override
    public Optional<Account> findAccountByUsernameOrEmail(String username, String email) {
        return accountJpaRepository.findByUsernameOrEmail(username, email)
                .map(AccountEntityMapper::toDomain);
    }

    @Override
    public Account saveAccount(Account account) {
        AccountEntity accountEntity = AccountEntityMapper.toEntity(account);
        return AccountEntityMapper.toDomain(accountJpaRepository.save(accountEntity));
    }

    @Override
    public Optional<Account> findAccountByEnableToken(String enableToken) {
        return accountJpaRepository.findByAccountConfigurationEmbEnableToken(enableToken)
                .map(AccountEntityMapper::toDomain);
    }

    @Override
    public Optional<Account> findAccountByEmail(String email) {
        return accountJpaRepository.findByEmail(email)
                .map(AccountEntityMapper::toDomain);
    }

    @Override
    public Optional<Account> findAccountByNewPasswordToken(String newPasswordToken) {
        return accountJpaRepository.findByAccountConfigurationEmbNewPasswordToken(newPasswordToken)
                .map(AccountEntityMapper::toDomain);
    }

    @Override
    public List<Account> findAllAccounts() {
        return accountJpaRepository.findAll()
                .stream()
                .map(AccountEntityMapper::toDomain)
                .collect(Collectors.toList());
    }
}
