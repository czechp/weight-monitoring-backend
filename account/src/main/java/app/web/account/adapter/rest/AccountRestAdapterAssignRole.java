package app.web.account.adapter.rest;

import app.web.account.adapter.persistence.AccountRole;
import app.web.account.application.useCase.AccountUseCaseAssignRole;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/api/accounts/role")
@CrossOrigin("*")
class AccountRestAdapterAssignRole {
    private final AccountUseCaseAssignRole accountUseCaseAssignRole;

    @Secured({"ROLE_ADMIN"})
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void accountAssignRole(@PathVariable(name = "id") long accountId,
                           @RequestParam(name = "role") AccountRole newRole) {
        accountUseCaseAssignRole.accountAssignRole(accountId, newRole);
    }
}
