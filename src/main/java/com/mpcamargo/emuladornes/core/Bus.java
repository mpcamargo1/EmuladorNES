package com.mpcamargo.emuladornes.core;

import com.mpcamargo.emuladornes.constants.NESConstants;

public class Bus {

    private byte[] memory;

    public Bus() {
        memory = new byte[NESConstants.MAX_MEMORY];
    }

    public void write(int endereco, byte data) throws Exception {
        if (endereco >= 0  && endereco < memory.length) {
            memory[endereco] = data;
        }

        throw new Exception("Endereço fora do intervalo permitido!");
    }

    public byte read(int endereco) throws Exception {
        if (endereco >= 0  && endereco < memory.length) {
            return memory[endereco & 0xFFFF];
        }

        throw new Exception("Endereço fora do intervalo permitido!");
    }
}
