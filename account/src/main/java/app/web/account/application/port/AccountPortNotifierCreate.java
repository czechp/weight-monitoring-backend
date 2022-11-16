package app.web.account.application.port;

public interface AccountPortNotifierCreate {
    void notifyAboutNewAccount(String email, String token);
}
