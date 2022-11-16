package app.web.domain;

import app.web.dosingDevice.dto.DosingDeviceUpdateData;
import lombok.AccessLevel;
import lombok.Getter;

@Getter(AccessLevel.PACKAGE)
public abstract class DosingDevice {
    protected long id;
    protected long version;
    protected ModuleInfo moduleInfo;
    protected ModuleType moduleType;
    protected int recordNumber;
    protected float totalMaterial;
    protected Measures measures = new Measures();

    DosingDevice(long id, long version, ModuleInfo moduleInfo, int recordNumber, float totalMaterial, Measures measures) {
        this.id = id;
        this.version = version;
        this.recordNumber = recordNumber;
        this.totalMaterial = totalMaterial;
        this.measures = measures;
        this.moduleInfo = moduleInfo;
        this.moduleType = setModuleType();
    }

    DosingDevice(ModuleInfo moduleInfo, int recordNumber ){
        this.moduleInfo = moduleInfo;
        this.recordNumber = recordNumber;
        this.moduleType = setModuleType();
    }

    abstract ModuleType setModuleType();

    public DosingDevice updateData(DosingDeviceUpdateData data) {
        this.measures = new Measures(
                data.getLastMeasure(),
                data.getAmountBelowMeasures(),
                data.getAmountCorrectMeasures(),
                data.getAmountAboveMeasures(),
                data.getAverageMeasure(),
                data.getCorrectMeasuresPercent()
        );
        this.totalMaterial = data.getTotalMaterial();
        return this;
    }

    public int getRecordNumber(){
        return this.recordNumber;
    }
}
