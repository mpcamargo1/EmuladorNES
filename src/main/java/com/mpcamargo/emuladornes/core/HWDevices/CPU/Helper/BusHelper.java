package com.mpcamargo.emuladornes.core.HWDevices.CPU.Helper;

import com.mpcamargo.emuladornes.core.Bus;

public class BusHelper {

    public Bus bus;

    public BusHelper() {
        this.bus = new Bus();
    }

    public void write(int address, int data) {
        bus.write(address, data);
    }

    public int read(int address) {
        return bus.read(address);
    }

    public int readMemoryVector(int addressLow) {
        return bus.readMemoryVector(addressLow);
    }
}
