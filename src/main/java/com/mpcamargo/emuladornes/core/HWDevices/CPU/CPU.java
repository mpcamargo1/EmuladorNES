package com.mpcamargo.emuladornes.core.HWDevices.CPU;

import com.mpcamargo.emuladornes.core.Bus;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Decoder.Decoder;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Flag.Flag;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.ExecutableInstruction;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Parameters;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Registers.A;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Registers.Register;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Registers.X;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Registers.Y;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Instruction;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Stack.Stack;
import com.mpcamargo.emuladornes.core.HWDevices.Clockable.Clockable;

public class CPU implements Clockable {

    private A A;
    private X B;
    private Y C;
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
        A = new A(0x00);
        B = new X(0x00);
        C = new Y(0x00);

        try {
            programCounter = readMemoryVector(0xFFFC);
        } catch (Exception ex) {
            System.exit(0);
        }

        addFlag(Flag.UNUSED);
        addFlag(Flag.INTERRUPT);
    }

    @Override
    public void clock() throws Exception {
        if (cyclesRemaining == 0) {
            int opCode = getOperationCode();
            Instruction instruction = Decoder.getInstruction(opCode);
            executeInstruction(instruction);

            cyclesRemaining = instruction.getParameters().getCycle();
        }

        cyclesRemaining--;
    }

    public void reset() throws Exception {
        A.setValue((byte) 0x00);
        B.setValue((byte) 0x00);
        C.setValue((byte) 0x00);

        cyclesRemaining = 7;
    }

    private int getOperationCode() throws Exception {
        cyclesRemaining++;
        int data = bus.read(programCounter++);

        return (data & 0xFF);
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


    // --------------------------------------------------------------------------------------------------------------//

    public void addFlag(Flag flag) {
        this.status |= (1 << flag.getLocation());
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
        stack.push(1 << flag.getLocation());
    }

    public int readMemoryVector(int addressLow) throws Exception {
        int low = bus.read(addressLow) & 0xFF;
        int high = bus.read(addressLow + 1) & 0xFF;

        return (high << 8) | low;
    }

    public void transferRegister(Register origin, Register destination) {
        int value = origin.getValue();

        destination.setValue(value);

        if (value == 0) {
            addFlag(Flag.ZERO);
            return;
        }

        if (value < 0) {
            addFlag(Flag.NEGATIVE);
        }

    }

    // --------------------------------------------------------------------------------------------------------------//

}
