package com.mpcamargo.emuladornes.core;

import com.mpcamargo.emuladornes.constants.NESConstants;

public class Bus {

    private int[] memory;

    public Bus() {
        memory = new int[NESConstants.MAX_MEMORY];
    }

    public void write(int address, int data) throws Exception {
        if (address >= 0  && address < memory.length) {
            memory[address] = data;
            return;
        }

        throw new Exception("Address out of range!");
    }

    public int read(int address) throws Exception {
        if (address >= 0  && address < memory.length) {
            return memory[address & 0xFFFF];
        }

        throw new Exception("Address out of range!");
    }
}
