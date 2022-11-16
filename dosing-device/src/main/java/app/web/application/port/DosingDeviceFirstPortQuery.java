package app.web.application.port;

import app.web.application.dto.DosingDeviceQueryDto;
import app.web.domain.DosingDevice;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DosingDeviceFirstPortQuery {
    List<DosingDeviceQueryDto> findAllFirst(Pageable pageable);
    List<DosingDeviceQueryDto> findAllByModuleIdFirst(long moduleId, Pageable pageable);

}
