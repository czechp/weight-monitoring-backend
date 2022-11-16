package app.web.account.adapter.rest;


import app.web.account.application.useCase.AccountUseCaseEmailConfirmation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/accounts/email-confirmation")
@CrossOrigin("*")
class AccountRestAdapterEmailConfirmation {
    private final AccountUseCaseEmailConfirmation accountUseCaseEmailConfirmation;

    @PatchMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void accountEmailConfirmation(
            @RequestParam(name = "token") String token
    ) {
        accountUseCaseEmailConfirmation.accountEmailConfirmation(token);
    }
}
