package app.web.account.application.service;

import app.web.account.application.port.AccountPortFindByUsername;
import app.web.configuration.security.SecurityAuthenticator;
import app.web.configuration.security.dto.SecurityLoginQueryDto;
import app.web.exception.NotEnoughPrivilegesException;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SecurityAuthenticatorImpl implements SecurityAuthenticator {
    private final AuthenticationManager authenticationManager;
    private final AccountPortFindByUsername accountPortFindByUsername;

    @Override
    public SecurityLoginQueryDto authenticateAccount(String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        return accountPortFindByUsername.findAccountByUsername(username)
                .map(account -> new SecurityLoginQueryDto(account.getId(),
                        account.getUsername(),
                        account.getEmail(),
                        account.getAccountRole().toString()))
                .orElseThrow(() -> new NotEnoughPrivilegesException("There is no account with username: " + username));
    }
}
