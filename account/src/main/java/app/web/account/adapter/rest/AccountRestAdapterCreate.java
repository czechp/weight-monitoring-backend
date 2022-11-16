package app.web.account.adapter.rest;

import app.web.account.application.dto.AccountCreateCmdDto;
import app.web.account.application.useCase.AccountUseCaseCreate;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api/accounts")
@Validated
@CrossOrigin("*")
class AccountRestAdapterCreate {
    private final AccountUseCaseCreate accountUseCaseCreate;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    String createAccount(@RequestBody @Valid AccountCreateCmdDto accountCreateCmdDto) {
        final var createdAccount = accountUseCaseCreate.createAccount(accountCreateCmdDto);
        return createdAccount.getAccountConfiguration().getEnableToken();
    }


}
