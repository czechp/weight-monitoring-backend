package app.web.adapter.persistence;

import app.web.application.dto.DosingDeviceDtoFactory;
import app.web.application.dto.DosingDeviceQueryDto;
import app.web.application.port.DosingDeviceFirstPortQuery;
import app.web.application.port.DosingDeviceLastPortQuery;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
class DosingQueryDevicePersistenceAdapterQueryQuery implements DosingDeviceLastPortQuery, DosingDeviceFirstPortQuery {
    private final DosingDeviceFirstRepository firstRepository;
    private final DosingDeviceLastRepository lastRepository;

    @Override
    public List<DosingDeviceQueryDto> findAllFirst(Pageable pageable) {
        return firstRepository.findAll(pageable)
                .stream()
                .map(DosingDeviceDtoFactory::toQueryDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<DosingDeviceQueryDto> finaAllLast(Pageable pageable) {
        return lastRepository.findAll(pageable)
                .stream()
                .map(DosingDeviceDtoFactory::toQueryDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<DosingDeviceQueryDto> findAllByModuleIdFirst(long moduleId, Pageable pageable) {
        return firstRepository.findByFirstModuleEntity_Id(moduleId, pageable)
                .stream()
                .map(DosingDeviceDtoFactory::toQueryDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<DosingDeviceQueryDto> findByModuleIdLast(long moduleId, Pageable pageable) {
        return lastRepository.findByLastModuleEntity_Id(moduleId, pageable)
                .stream()
                .map(DosingDeviceDtoFactory::toQueryDto)
                .collect(Collectors.toList());
    }
}
