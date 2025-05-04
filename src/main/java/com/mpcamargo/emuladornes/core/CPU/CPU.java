package com.mpcamargo.emuladornes.core.CPU;

import com.mpcamargo.emuladornes.core.Bus;
import com.mpcamargo.emuladornes.core.CPU.Decoder.Decoder;
import com.mpcamargo.emuladornes.core.CPU.Registers.A;
import com.mpcamargo.emuladornes.core.CPU.Registers.X;
import com.mpcamargo.emuladornes.core.CPU.Registers.Y;

public class CPU {

    private A register_a;

    private X register_x;

    private Y register_y;

    private int program_counter;
    private int stack_pointer;
    private byte status;  // Flag de Status
    private int cycles; // Contador de ciclos

    private Bus bus; // Barramento

    public CPU (Bus bus) {
        initializeRegisters();
        connectToBus(bus);
    }

    private void connectToBus(Bus barramento) {
        this.bus = barramento;
    }

    private void initializeRegisters() {
        register_a = new A((byte) 0x00);
        register_x = new X((byte) 0x00);
        register_y = new Y((byte) 0x00);
        program_counter = 0xFFFC;
        stack_pointer = 0xFD;
        status = 7;
    }

    public void clock() throws Exception {
        if (cycles <= 0) {
            byte opCode = getOperationCode();
            Instruction instruction = Decoder.getInstruction(opCode);
            executeInstruction(instruction);
        }

        cycles--;
    }

    public void reset() throws Exception {
        register_a.setValue((byte) 0x00);
        register_x.setValue((byte) 0x00);
        register_y.setValue((byte) 0x00);

        cycles = 7;
    }

    private byte getOperationCode() throws Exception {
        cycles++;
        byte data = bus.read(program_counter++);

        return (byte) (data & 0xFF);
    }

    private void executeInstruction(Instruction instruction) {
        if (instruction.isIllegal()) {
            throw new IllegalArgumentException("Instruction is illegal");
        }

    }
}
