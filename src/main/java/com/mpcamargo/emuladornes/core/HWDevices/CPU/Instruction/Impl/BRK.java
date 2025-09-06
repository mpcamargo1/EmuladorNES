package com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Impl;

import com.mpcamargo.emuladornes.core.HWDevices.CPU.CPU;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Flag.Flag;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.ExecutableInstruction;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Parameters;

public class BRK implements ExecutableInstruction {

    @Override
    public void execute(CPU cpu, Parameters parameters) throws Exception {
        cpu.getStackHelper().push(cpu.getProgramCounter());

        cpu.getStackHelper().pushStatus(Flag.BREAK);

        cpu.getFlagHelper().addFlag(Flag.INTERRUPT);

        int newProgramCounter = cpu.getBusHelper().readMemoryVector(0xFFFE);
        cpu.setProgramCounter(newProgramCounter);
    }
}
