package com.mpcamargo.emuladornes.core;

import com.mpcamargo.emuladornes.constantes.CPUConstants;
import com.mpcamargo.emuladornes.core.CPU.CPU;

public class Bus {

    private CPU cpu;

    private PPU ppu;
    private byte[] memory;

    public Bus() {
        memory = new byte[CPUConstants.TAMANHO_MEMORIA];
        cpu = new CPU(this);
    }

    public void escreverMemoria(int endereco, byte data) throws Exception {
        if (endereco >= 0  && endereco < memory.length) {
            memory[endereco] = data;
        }

        throw new Exception("Endereço fora do intervalo permitido!");
    }

    public byte lerMemoria(int endereco) throws Exception {
        if (endereco >= 0  && endereco < memory.length) {
            return memory[endereco & 0xFFFF];
        }

        throw new Exception("Endereço fora do intervalo permitido!");
    }
}
