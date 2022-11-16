package app.web.domain;

public class DosingDeviceLast extends DosingDevice {
    public DosingDeviceLast(long id, long version, ModuleInfo moduleInfo, int recordNumber, float totalMaterial, Measures measures) {
        super(id, version, moduleInfo, recordNumber, totalMaterial, measures);
    }

    public DosingDeviceLast(ModuleInfo moduleInfo, int recordNumber) {
        super(moduleInfo, recordNumber);
    }

    @Override
    ModuleType setModuleType() {
        return ModuleType.LAST;
    }
}
