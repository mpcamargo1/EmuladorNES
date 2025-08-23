package com.mpcamargo.emuladornes.core.CPU.Stack;

import com.mpcamargo.emuladornes.core.Bus;

public class Stack {

    private Bus bus;

    private byte addressMemory = (byte) 0xFD;

    // Stack Base
    private int offsetMemory = 0x0100;

    public byte pop () throws Exception {

        if (addressMemory == (byte) 0xFF) {
            throw new IllegalStateException("Address memory equals 0xFF");
        }

        int addressMemoryUnsigned = (addressMemory & 0xFF);

        byte value = bus.read(offsetMemory + addressMemoryUnsigned);
        addressMemory++;

        return value;
    }

    public void push(byte value) throws Exception {

        if (addressMemory == (byte) 0x00) {
            throw new IllegalStateException("Address memory equals 0x00");
        }

        int addressMemoryUnsigned = (addressMemory & 0xFF);

        bus.write(offsetMemory + addressMemoryUnsigned, value);
        addressMemory--;
    }

    public Stack (Bus bus) {
        this.bus = bus;
    }
}
