package com.mpcamargo.emuladornes.core.CPU;

import com.mpcamargo.emuladornes.core.Bus;
import com.mpcamargo.emuladornes.core.CPU.Decoder.Decoder;
import com.mpcamargo.emuladornes.core.CPU.Flag.Flag;
import com.mpcamargo.emuladornes.core.CPU.Instruction.ExecutableInstruction;
import com.mpcamargo.emuladornes.core.CPU.Instruction.Parameters;
import com.mpcamargo.emuladornes.core.CPU.Registers.A;
import com.mpcamargo.emuladornes.core.CPU.Registers.X;
import com.mpcamargo.emuladornes.core.CPU.Registers.Y;
import com.mpcamargo.emuladornes.core.CPU.Instruction.Instruction;
import com.mpcamargo.emuladornes.core.CPU.Stack.Stack;

public class CPU {

    private A register_a;

    private X register_x;

    private Y register_y;

    private int program_counter;
    private Stack stack;
    private int status;
    private int cyclesRemaining;

    private Bus bus;

    public CPU (Bus bus) {
        initializeStack();
        initializeFlag();
        initializeRegisters();
        connectToBus(bus);
    }

    private void connectToBus(Bus bus) {
        this.bus = bus;
    }

    private void initializeStack() {
        this.stack = new Stack(bus);
    }

    private void initializeFlag() {
        this.status = 0;
    }

    private void initializeRegisters() {
        register_a = new A(0x00);
        register_x = new X(0x00);
        register_y = new Y(0x00);

        program_counter = 0xFFFC;

        addFlag(Flag.UNUSED);
        addFlag(Flag.INTERRUPT);
    }

    public void incrementProgramCounter() {
        this.program_counter++;
    }

    public void clock() throws Exception {
        if (cyclesRemaining <= 0) {
            byte opCode = getOperationCode();
            Instruction instruction = Decoder.getInstruction(opCode);
            executeInstruction(instruction);
        }

        cyclesRemaining--;
    }

    private void addFlag(Flag flag) {
        this.status |=  (1 << flag.getLocation());
    }

    private void removeFlag(Flag flag) {
        this.status &= ~(1 << flag.getLocation());
    }

    public void reset() throws Exception {
        register_a.setValue((byte) 0x00);
        register_x.setValue((byte) 0x00);
        register_y.setValue((byte) 0x00);

        cyclesRemaining = 7;
    }

    private byte getOperationCode() throws Exception {
        cyclesRemaining++;
        byte data = bus.read(program_counter++);

        return (byte) (data & 0xFF);
    }

    private void executeInstruction(Instruction instruction) {

        Parameters parameters = instruction.getParameters();

        if (parameters.isIllegal()) {
            throw new IllegalArgumentException("Instruction is illegal!");
        }

        ExecutableInstruction executableInstruction = instruction.getExecutableInstruction();

        if (executableInstruction == null) {
            throw new IllegalArgumentException("Executable Instruction not implemented!!");
        }

        executableInstruction.execute(this, parameters);
    }
}
