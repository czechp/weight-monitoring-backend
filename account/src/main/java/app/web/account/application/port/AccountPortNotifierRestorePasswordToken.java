package app.web.account.application.port;

public interface AccountPortNotifierRestorePasswordToken {
    void sendRestorePasswordToken(String email, String token);
}
