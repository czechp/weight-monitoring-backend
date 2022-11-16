package app.web.domain;

import lombok.AccessLevel;
import lombok.Getter;

public class DosingDeviceFirst extends DosingDevice {
    public DosingDeviceFirst(long id, long version, ModuleInfo moduleInfo, int recordNumber, float totalMaterial, Measures measures) {
        super(id, version, moduleInfo, recordNumber, totalMaterial, measures);
    }

    public DosingDeviceFirst(ModuleInfo moduleInfo, int recordNumber) {
        super(moduleInfo, recordNumber);
    }

    @Override
    ModuleType setModuleType() {
        return ModuleType.FIRST;
    }
}
