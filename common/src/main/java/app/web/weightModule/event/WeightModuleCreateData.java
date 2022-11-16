package app.web.weightModule.event;

public interface WeightModuleCreateData {

    long getModuleId();

    String getLineName();

    boolean isFirst();

    int getDosingDeviceAmount();
}
