package com.mpcamargo.emuladornes.core.HWDevices.CPU.Stack;

import com.mpcamargo.emuladornes.core.Bus;

public class Stack {

    private Bus bus;

    private int pointerAddress = 0xFD;

    // Stack Base
    private int offsetMemory = 0x0100;

    public int pop () throws Exception {
        int value = bus.read(offsetMemory + pointerAddress);
        pointerAddress = (pointerAddress + 1 ) & 0xFF;

        return value;
    }

    public void push(int value) throws Exception {
        bus.write(offsetMemory + pointerAddress, value);
        pointerAddress = (pointerAddress - 1) & 0xFF;
    }

    public Stack (Bus bus) {
        this.bus = bus;
    }
}
