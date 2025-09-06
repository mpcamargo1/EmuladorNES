package com.mpcamargo.emuladornes.core.HWDevices.CPU.Helper;

import com.mpcamargo.emuladornes.core.HWDevices.CPU.Flag.Flag;

public class FlagHelper {

    private int status;

    public FlagHelper (int status) {
        this.status = status;
    }

    public void addFlag(Flag flag) {
        int shift = (1 << flag.getLocation());
        status = status | shift;
    }

    public void removeFlag(Flag flag) {
        int shift = ~(1 << flag.getLocation());
        status = status & shift;
    }

    public int getStatus() {
        return status;
    }
}
