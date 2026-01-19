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

    public boolean getFlag(Flag flag) {
        int mask = (1 << flag.getLocation());
        int result = (mask & status) >> flag.getLocation();

        return result == 1;
    }
}
