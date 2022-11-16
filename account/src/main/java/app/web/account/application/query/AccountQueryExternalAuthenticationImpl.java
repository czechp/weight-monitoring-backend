package app.web.account.application.query;

import app.web.account.application.dto.AccountUserDetailsDto;
import app.web.account.application.port.AccountPortQuery;
import app.web.configuration.security.SecurityCurrentUser;
import app.web.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class AccountQueryExternalAuthenticationImpl implements AccountQueryExternalAuthentication {
    private final AccountPortQuery accountPortQuery;
    private final SecurityCurrentUser securityCurrentUser;

    @Override
    public AccountUserDetailsDto authenticateCurrentUser() {
        final var currentUser = securityCurrentUser.getCurrentUser();
        return accountPortQuery.findAccountByUsername(currentUser)
                .orElseThrow(() -> new NotFoundException("Account with username: " + currentUser + " does not exist"));
    }

}
