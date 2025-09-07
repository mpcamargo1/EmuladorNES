package com.mpcamargo.emuladornes.core.HWDevices.CPU;

import com.mpcamargo.emuladornes.core.HWDevices.CPU.Decoder.Decoder;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Flag.Flag;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Helper.BusHelper;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Helper.FlagHelper;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Helper.RegisterHelper;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Helper.StackHelper;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.ExecutableInstruction;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Parameters;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Instruction;
import com.mpcamargo.emuladornes.core.HWDevices.Clockable.Clockable;

public class CPU implements Clockable {

    private int programCounter;
    private int cyclesRemaining;
    private BusHelper busHelper;
    private RegisterHelper registerHelper;
    private StackHelper stackHelper;
    private FlagHelper flagHelper;

    public int getProgramCounter() {
        return programCounter;
    }

    public void setProgramCounter(int programCounter) {
        this.programCounter = programCounter;
    }

    public CPU () {
        initializeBus();
        initializeStack(busHelper);
        initializeFlag();
        initializeRegisters();
    }

    private void initializeBus() {
        this.busHelper = new BusHelper();
    }

    private void initializeStack(BusHelper busHelper) {
        this.stackHelper = new StackHelper(busHelper);
    }

    private void initializeFlag() {
        this.flagHelper = new FlagHelper(0);
    }

    private void initializeRegisters() {
        this.registerHelper = new RegisterHelper(flagHelper, stackHelper);
        programCounter = busHelper.readMemoryVector(0xFFFC);

        getFlagHelper().addFlag(Flag.UNUSED);
        getFlagHelper().addFlag(Flag.INTERRUPT);
    }

    @Override
    public void clock() throws Exception {
        if (cyclesRemaining == 0) {
            int opCode = getOperationCode();
            Instruction instruction = Decoder.getInstruction(opCode);
            cyclesRemaining = instruction.getParameters().getCycle();
            executeInstruction(instruction);
        }

        cyclesRemaining--;
    }

    public void reset() {
        registerHelper.reset();
        cyclesRemaining = 7;
    }

    private int getOperationCode() {
        cyclesRemaining++;
        int data = busHelper.read(programCounter++);

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

    public void addExtraCycle() {
        this.cyclesRemaining++;
    }

    public RegisterHelper getRegisterHelper() {
        return this.registerHelper;
    }

    public FlagHelper getFlagHelper() {
        return this.flagHelper;
    }

    public StackHelper getStackHelper() {
        return this.stackHelper;
    }

    public BusHelper getBusHelper() {
        return this.busHelper;
    }


}
