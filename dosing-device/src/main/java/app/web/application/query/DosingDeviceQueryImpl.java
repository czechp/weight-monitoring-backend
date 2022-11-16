package app.web.application.query;

import app.web.application.dto.DosingDeviceQueryDto;
import app.web.application.port.DosingDeviceFirstPortQuery;
import app.web.application.port.DosingDeviceLastPortQuery;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
class DosingDeviceQueryImpl implements DosingDeviceQuery {
    private final DosingDeviceFirstPortQuery firstPortQuery;
    private final DosingDeviceLastPortQuery lastPortQuery;

    @Override
    public List<DosingDeviceQueryDto> findAllFirst(Pageable pageable) {
        return firstPortQuery.findAllFirst(pageable);
    }

    @Override
    public List<DosingDeviceQueryDto> findAllLast(Pageable pageable) {
        return lastPortQuery.finaAllLast(pageable);
    }

    @Override
    public List<DosingDeviceQueryDto> findByModuleIdFirst(long moduleId, Pageable pageable) {
        return firstPortQuery.findAllByModuleIdFirst(moduleId, pageable);
    }

    @Override
    public List<DosingDeviceQueryDto> findByModuleIdLast(long moduleId, Pageable pageable) {
        return lastPortQuery.findByModuleIdLast(moduleId, pageable);
    }
}
