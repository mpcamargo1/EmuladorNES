package com.mpcamargo.emuladornes.core;

import com.mpcamargo.emuladornes.constants.NESConstants;

public class Bus {
    private int[] memory;
    private int limitPhysicalRAM = 0x07FF;
    private int block0 = 0x0000;
    private int block1 = 0x0800;
    private int block2 = 0x1000;
    private int block3 = 0x1800;

    public Bus() {
        memory = new int[NESConstants.MAX_MEMORY];
    }

    public void write(int address, int data) {
        address &= 0xFFFF;
        data &= 0xFF;

        // Mirroring
        if (address >= block0 && address <= block3) {
            int baseAddress = address & limitPhysicalRAM;

            memory[block0 | baseAddress] = data;
            memory[block1 | baseAddress] = data;
            memory[block2 | baseAddress] = data;
            memory[block3 | baseAddress] = data;

            return;
        }

        memory[address] = data;
    }

    public int read(int address) {
        return memory[address & 0xFFFF] & 0xFF;
    }

    public int readMemoryVector(int addressLow) {
        int low = read(addressLow) & 0xFF;
        int high = read(addressLow + 1) & 0xFF;

        return (high << 8) | low;
    }
}
