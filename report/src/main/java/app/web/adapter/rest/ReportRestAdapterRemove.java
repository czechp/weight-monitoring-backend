package app.web.adapter.rest;

import app.web.application.useCase.ReportUseCaseRemove;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin("*")
@AllArgsConstructor
class ReportRestAdapterRemove {
    private final ReportUseCaseRemove useCaseRemove;

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Secured({"ROLE_ADMIN"})
    void removeReportById(@PathVariable(name = "id")long reportId){
        useCaseRemove.removeById(reportId);
    }
}
