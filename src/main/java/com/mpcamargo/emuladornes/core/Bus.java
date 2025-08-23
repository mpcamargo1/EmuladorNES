package com.mpcamargo.emuladornes.core;

import com.mpcamargo.emuladornes.constants.NESConstants;

public class Bus {

    private byte[] memory;

    public Bus() {
        memory = new byte[NESConstants.MAX_MEMORY];
    }

    public void write(int address, byte data) throws Exception {
        if (address >= 0  && address < memory.length) {
            memory[address] = data;
        }

        throw new Exception("Address out of range!");
    }

    public byte read(int address) throws Exception {
        if (address >= 0  && address < memory.length) {
            return memory[address & 0xFFFF];
        }

        throw new Exception("Address out of range!");
    }
}
