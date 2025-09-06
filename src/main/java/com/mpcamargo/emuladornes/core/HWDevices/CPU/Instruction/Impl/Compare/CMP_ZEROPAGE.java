package com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Impl.Compare;

import com.mpcamargo.emuladornes.core.HWDevices.CPU.CPU;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.ExecutableInstruction;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Parameters;

public class CMP_ZEROPAGE implements ExecutableInstruction {
    @Override
    public void execute(CPU cpu, Parameters parameters) throws Exception {
        int programCounter = cpu.getProgramCounter();
        int value = cpu.getBusHelper().read(programCounter++);
        cpu.setProgramCounter(programCounter);

        cpu.getRegisterHelper().compareRegisterA(value);
    }
}
