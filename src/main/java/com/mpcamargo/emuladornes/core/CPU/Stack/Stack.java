package com.mpcamargo.emuladornes.core.CPU.Stack;

import com.mpcamargo.emuladornes.core.Bus;

public class Stack {

    private Bus bus;

    private int pointerAddress = 0xFD;

    // Stack Base
    private int offsetMemory = 0x0100;

    public int pop () throws Exception {

        if (pointerAddress == (byte) 0xFF) {
            throw new IllegalStateException("Pointer Address equals 0xFF");
        }

        int addressMemoryUnsigned = (pointerAddress & 0xFF);

        int value = bus.read(offsetMemory + addressMemoryUnsigned);
        pointerAddress++;

        return value;
    }

    public void push(int value) throws Exception {

        if (pointerAddress == (byte) 0x00) {
            throw new IllegalStateException("Pointer Address equals 0x00");
        }

        int addressMemoryUnsigned = (pointerAddress & 0xFF);

        bus.write(offsetMemory + addressMemoryUnsigned, value);
        pointerAddress--;
    }

    public Stack (Bus bus) {
        this.bus = bus;
    }
}
