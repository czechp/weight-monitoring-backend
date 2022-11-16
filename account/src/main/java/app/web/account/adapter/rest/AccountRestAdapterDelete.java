package app.web.account.adapter.rest;


import app.web.account.application.useCase.AccountUseCaseDelete;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/accounts")
@CrossOrigin("*")
class AccountRestAdapterDelete {
    private final AccountUseCaseDelete accountUseCaseDelete;

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteAccount(@PathVariable(name = "id") long id) {
        accountUseCaseDelete.deleteAccountById(id);
    }
}
