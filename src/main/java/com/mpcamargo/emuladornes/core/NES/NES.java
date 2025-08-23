package com.mpcamargo.emuladornes.core.NES;

import com.mpcamargo.emuladornes.core.Bus;
import com.mpcamargo.emuladornes.core.CPU.CPU;
import com.mpcamargo.emuladornes.core.PPU.PPU;

public class NES {

    private CPU cpu;

    private PPU ppu;

    public NES() {
        ppu = new PPU();
        cpu = new CPU(new Bus());
    }

    public void step() throws Exception {
        cpu.clock();
    }

}
