package app.web.configuration.security;

import app.web.configuration.security.dto.SecurityLoginQueryDto;

public interface SecurityAuthenticator {
    SecurityLoginQueryDto authenticateAccount(String username, String password);

}
