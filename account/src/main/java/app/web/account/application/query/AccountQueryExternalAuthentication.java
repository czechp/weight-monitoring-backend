package app.web.account.application.query;

import app.web.account.application.dto.AccountUserDetailsDto;

public interface AccountQueryExternalAuthentication {
    AccountUserDetailsDto authenticateCurrentUser();
}
