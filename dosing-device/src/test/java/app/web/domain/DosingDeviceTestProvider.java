package app.web.domain;

public class DosingDeviceTestProvider {
    public static DosingDevice getDomain(int recordNumber) {
        return new DosingDeviceFirst(0L, 0L, new ModuleInfo(0l, ""), recordNumber, 0, new Measures());
    }
}
