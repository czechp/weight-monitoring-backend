package app.web.account.adapter.rest;


import app.web.account.application.useCase.AccountUseCaseRestorePassword;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/accounts/password-restore")
class AccountRestAdapterRestorePassword {
    private final AccountUseCaseRestorePassword accountUseCaseRestorePassword;

    @GetMapping("/token")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void generateTokenToRestorePassword(
            @RequestParam(name = "email") String email
    ) {
        accountUseCaseRestorePassword.generateTokenToRestorePassword(email);
    }

    @PatchMapping("/new-password")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void setNewPassword(
            @RequestParam(name = "token") String token,
            @RequestParam(name = "password") String newPassword
    ) {
        accountUseCaseRestorePassword.setNewPassword(token, newPassword);
    }
}
