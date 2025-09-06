package com.mpcamargo.emuladornes.core.HWDevices.CPU.Stack;

import com.mpcamargo.emuladornes.core.Bus;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Helper.BusHelper;

public class Stack {

    private BusHelper busHelper;

    private int pointerAddress = 0xFD;

    // Stack Base
    private int offsetMemory = 0x0100;

    public int pop () throws Exception {
        int value = busHelper.read(offsetMemory + pointerAddress);
        pointerAddress = (pointerAddress + 1 ) & 0xFF;

        return value;
    }

    public void push(int value) throws Exception {
        busHelper.write(offsetMemory + pointerAddress, value);
        pointerAddress = (pointerAddress - 1) & 0xFF;
    }

    public void updateAddress(int value) {
        this.pointerAddress = value;
    }

    public Stack (BusHelper busHelper) {
        this.busHelper = busHelper;
    }
}
