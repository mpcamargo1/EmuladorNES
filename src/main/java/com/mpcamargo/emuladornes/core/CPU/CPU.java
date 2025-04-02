package com.mpcamargo.emuladornes.core.CPU;


import com.mpcamargo.emuladornes.core.Bus;

public class CPU {
    private int A; // Registrador acumulador
    private int X; // Registrador X
    private int Y; // Registrador Y
    private int pc; // Contador de Programa
    private int sp; // Ponteiro da pilha
    private Flag status;  // Registrador de Status
    private int cycles; // Contador de ciclos

    private Bus barramento; // Barramento

    public CPU (Bus barramento) {
        initializeRegisters();
        connectToBUs(barramento);
    }

    private void connectToBUs(Bus barramento) {
        this.barramento = barramento;
    }

    private void initializeRegisters() {
        A = X = Y = 0x00;
        pc = 0xFFFC;
        sp = 0xFD;
        status = Flag.NEGATIVE;
    }

    public void clock() throws Exception {
        if (cycles == 0) {
            byte dado = readMemory();
            executeInstruction();
        }

        cycles--;
    }

    public void reset() throws Exception {
        A = X = Y = 0x00;

        cycles = 7;
    }

    private byte readMemory() throws Exception {
        cycles++;
        byte data = barramento.lerMemoria(pc);
        pc++;
        return data;
    }

    private void executeInstruction() {

    }
}
