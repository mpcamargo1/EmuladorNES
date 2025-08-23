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

    private A registerA;

    private X registerX;

    private Y registerY;

    private int programCounter;
    private Stack stack;
    private int status;
    private int cyclesRemaining;

    private Bus bus;

    public CPU (Bus bus) {
        connectToBus(bus);
        initializeStack(bus);
        initializeFlag();
        initializeRegisters();
    }

    private void connectToBus(Bus bus) {
        this.bus = bus;
    }

    private void initializeStack(Bus bus) {
        this.stack = new Stack(bus);
    }

    private void initializeFlag() {
        this.status = 0;
    }

    private void initializeRegisters() {
        registerA = new A(0x00);
        registerX = new X(0x00);
        registerY = new Y(0x00);

        try {
            programCounter = readMemoryVector(0xFFFC);
        } catch (Exception ex) {
            System.exit(0);
        }

        addFlag(Flag.UNUSED);
        addFlag(Flag.INTERRUPT);
    }

    public void clock() throws Exception {
        if (cyclesRemaining <= 0) {
            byte opCode = getOperationCode();
            Instruction instruction = Decoder.getInstruction(opCode);
            executeInstruction(instruction);
        }

        cyclesRemaining--;
    }

    public void reset() throws Exception {
        registerA.setValue((byte) 0x00);
        registerX.setValue((byte) 0x00);
        registerY.setValue((byte) 0x00);

        cyclesRemaining = 7;
    }

    private byte getOperationCode() throws Exception {
        cyclesRemaining++;
        int data = bus.read(programCounter++);

        return (byte) (data & 0xFF);
    }

    private void executeInstruction(Instruction instruction) throws Exception {

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


    // -----------------------------------------------------------------//

    public int addFlag(Flag flag) {
        this.status |= (1 << flag.getLocation());
        return status;
    }

    public void removeFlag(Flag flag) {
        this.status &= ~(1 << flag.getLocation());
    }

    public void incrementAndGetProgramCounter() {
        this.programCounter++;
    }

    public void setProgramCounter(int programCounter) {
        this.programCounter = programCounter;
    }

    public void pushProgramCounter() throws Exception {
        int highByte = (this.programCounter >> 8) & 0xFF;
        int lowByte = this.programCounter & 0xFF;

        stack.push(highByte);
        stack.push(lowByte);
    }

    public void pushStatus(Flag flag) throws Exception {
        stack.push((byte) (1 << flag.getLocation()));
    }

    public int readMemoryVector(int addressLow) throws Exception {
        int low = bus.read(addressLow) & 0xFF;
        int high = bus.read(addressLow + 1) & 0xFF;

        return (high << 8) | low;
    }


}
