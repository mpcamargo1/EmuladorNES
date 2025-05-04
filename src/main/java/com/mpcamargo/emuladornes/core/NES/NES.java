package com.mpcamargo.emuladornes.core.NES;

import com.mpcamargo.emuladornes.core.Bus;
import com.mpcamargo.emuladornes.core.CPU.CPU;
import com.mpcamargo.emuladornes.core.PPU.PPU;

public class NES {

    private CPU cpu;

    private PPU ppu;

    private Bus bus;

    public NES() {
        bus = new Bus();

        ppu = new PPU();
        cpu = new CPU(bus);
    }

    public void step() throws Exception {
        cpu.clock();
    }

}
