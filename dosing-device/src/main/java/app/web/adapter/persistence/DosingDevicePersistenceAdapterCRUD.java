package app.web.adapter.persistence;

import app.web.application.port.crud.DosingDevicePortCRUD;
import app.web.domain.DosingDevice;
import app.web.domain.DosingDeviceFactory;
import app.web.domain.DosingDeviceFirst;
import app.web.domain.DosingDeviceLast;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
class DosingDevicePersistenceAdapterCRUD implements DosingDevicePortCRUD {
    private final DosingDeviceFirstRepository firstRepository;
    private final DosingDeviceLastRepository lastRepository;


    @Override
    public DosingDevice save(DosingDevice dosingDevice) {
        return dosingDevice instanceof DosingDeviceFirst
                ? saveFirstDosingDevice((DosingDeviceFirst) dosingDevice)
                : saveLastDosingDevice((DosingDeviceLast) dosingDevice);
    }

    private DosingDevice saveLastDosingDevice(DosingDeviceLast dosingDevice) {
        DosingDeviceLastEntity entity = DosingDeviceFactory.toEntity(dosingDevice);
        return DosingDeviceFactory.toDomain(lastRepository.save(entity));
    }

    private DosingDevice saveFirstDosingDevice(DosingDeviceFirst dosingDevice) {
        DosingDeviceFirstEntity entity = DosingDeviceFactory.toEntity(dosingDevice);
        return DosingDeviceFactory.toDomain(firstRepository.save(entity));
    }

    @Override
    public List<DosingDevice> findByModuleId(long moduleId, boolean firstModule) {
        PageRequest pagination = PageRequest.of(0, Integer.MAX_VALUE, Sort.by("recordNumber"));
        return firstModule ? findFirstDosingDevicesByModuleId(moduleId, pagination) : findLastDosingDevicesByModuleId(moduleId, pagination);
    }

    private List<DosingDevice> findLastDosingDevicesByModuleId(long moduleId, PageRequest pagination) {
        return lastRepository.findByLastModuleEntity_Id(moduleId, pagination)
                .stream()
                .map(DosingDeviceFactory::toDomain)
                .collect(Collectors.toList());
    }

    private List<DosingDevice> findFirstDosingDevicesByModuleId(long moduleId, PageRequest pagination) {
        return firstRepository.findByFirstModuleEntity_Id(moduleId, pagination)
                .stream()
                .map(DosingDeviceFactory::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<DosingDevice> findByLineName(String lineName, boolean isFirst) {
        return  isFirst ? findFirstDosingDeviceByLineName(lineName) : findLastDosingDevicesByLineName(lineName);
    }

    private List<DosingDevice> findLastDosingDevicesByLineName(String lineName) {
        return lastRepository.findByLineName(lineName)
                .stream()
                .map(DosingDeviceFactory::toDomain)
                .collect(Collectors.toList());

    }

    private List<DosingDevice> findFirstDosingDeviceByLineName(String lineName) {
        return firstRepository.findByLineName(lineName)
                .stream()
                .map(DosingDeviceFactory::toDomain)
                .collect(Collectors.toList());
    }
}
