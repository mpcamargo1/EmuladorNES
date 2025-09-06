package com.mpcamargo.emuladornes.core.HWDevices.CPU.Helper;

import com.mpcamargo.emuladornes.core.Bus;

public class BusHelper {

    public Bus bus;

    public BusHelper() {
        this.bus = new Bus();
    }

    public void write(int address, int data) throws Exception {
        bus.write(address, data);
    }

    public int read(int address) throws Exception {
        return bus.read(address);
    }

    public int readMemoryVector(int addressLow) throws Exception {
        return bus.readMemoryVector(addressLow);
    }
}
