package app.web.adapter.rest;

import app.web.application.dto.DosingDeviceQueryDto;
import app.web.application.query.DosingDeviceQuery;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dosing-devices")
@CrossOrigin("*")
@AllArgsConstructor
class DosingDeviceRestAdapterQuery {
    private final DosingDeviceQuery dosingDeviceQuery;

    @GetMapping("/first")
    List<DosingDeviceQueryDto> findAllFirst(Pageable pageable) {
        return dosingDeviceQuery.findAllFirst(pageable);
    }


    @GetMapping("/last")
    List<DosingDeviceQueryDto> findAllLast(Pageable pageable) {
        return dosingDeviceQuery.findAllLast(pageable);
    }

    @GetMapping("/module-first/{id}")
    List<DosingDeviceQueryDto> findByModuleIdFirst(@PathVariable(name = "id") long moduleId, Pageable pageable) {
        return dosingDeviceQuery.findByModuleIdFirst(moduleId, pageable);
    }

    @GetMapping("/module-last/{id}")
    List<DosingDeviceQueryDto> findByModuleIdLast(@PathVariable(name = "id") long moduleId, Pageable pageable) {
        return dosingDeviceQuery.findByModuleIdLast(moduleId, pageable);
    }

}
