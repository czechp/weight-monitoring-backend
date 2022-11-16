package app.web.application.useCase;

import app.web.application.port.crud.DosingDevicePortCRUD;
import app.web.domain.DosingDevice;
import app.web.domain.DosingDeviceFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@Transactional
@AllArgsConstructor
class DosingDeviceUseCaseCreateImpl implements DosingDeviceUseCaseCreate{
    private final DosingDevicePortCRUD portCRUD;

    @Override
    public List<DosingDevice> createDosingDevices(int amount, long moduleId, String lineName, boolean first) {
        List<DosingDevice> dosingDevices = IntStream.range(0, amount)
                .boxed()
                .map(n -> DosingDeviceFactory.createDosingDevice(moduleId, lineName, n + 1, first))
                .collect(Collectors.toList());

        dosingDevices.forEach(portCRUD::save);

        return dosingDevices;
    }
}
