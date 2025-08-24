package com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Impl;

import com.mpcamargo.emuladornes.core.HWDevices.CPU.CPU;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Flag.Flag;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.ExecutableInstruction;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Parameters;

public class BRK implements ExecutableInstruction {

    @Override
    public void execute(CPU cpu, Parameters parameters) throws Exception {
        cpu.incrementAndGetProgramCounter();
        cpu.pushProgramCounter();

        cpu.pushStatus(Flag.BREAK);
        cpu.addFlag(Flag.INTERRUPT);

        int newProgramCounter = cpu.readMemoryVector(0xFFFE);
        cpu.setProgramCounter(newProgramCounter);
    }
}
