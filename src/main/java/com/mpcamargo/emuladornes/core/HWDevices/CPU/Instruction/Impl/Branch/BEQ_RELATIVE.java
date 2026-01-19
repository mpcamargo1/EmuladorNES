package com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Impl.Branch;

import com.mpcamargo.emuladornes.core.HWDevices.CPU.CPU;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Flag.Flag;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.ExecutableInstruction;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Parameters;

public class BEQ_RELATIVE implements ExecutableInstruction {
    @Override
    public void execute(CPU cpu, Parameters parameters) throws Exception {
        int programCounter = cpu.getProgramCounter();
        // Cast to byte [-128, 127] - Offset is signed.
        byte offset = (byte) cpu.getBusHelper().read(programCounter);
        cpu.setProgramCounter(++programCounter);

        boolean isActive = cpu.getFlagHelper().getFlag(Flag.ZERO);

        if (!isActive) {
            return;
        }

        cpu.setProgramCounter(programCounter + offset);
    }
}
