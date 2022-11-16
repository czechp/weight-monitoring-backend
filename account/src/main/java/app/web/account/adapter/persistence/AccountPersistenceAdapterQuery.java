package app.web.account.adapter.persistence;

import app.web.account.application.dto.AccountQueryDto;
import app.web.account.application.dto.AccountUserDetailsDto;
import app.web.account.application.port.AccountPortQuery;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
class AccountPersistenceAdapterQuery implements AccountPortQuery {
    private final AccountJpaRepository accountJpaRepository;

    @Override
    public Optional<AccountQueryDto> findAccountByIdQuery(long accountId) {
        return accountJpaRepository.findByIdQuery(accountId);
    }

    @Override
    public List<AccountQueryDto> findAllAccountQuery(Pageable pageable) {
        return accountJpaRepository.findAllQuery(pageable);
    }

    @Override
    public Optional<AccountUserDetailsDto> findAccountByUsername(String username) {
        return accountJpaRepository.findByUsernameUserDetailsQuery(username);
    }
}
