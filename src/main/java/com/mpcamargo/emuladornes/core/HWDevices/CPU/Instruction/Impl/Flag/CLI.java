package com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Impl.Flag;

import com.mpcamargo.emuladornes.core.HWDevices.CPU.CPU;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Flag.Flag;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.ExecutableInstruction;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Parameters;

public class CLI implements ExecutableInstruction {

    @Override
    public void execute(CPU cpu, Parameters parameters) throws Exception {
        cpu.removeFlag(Flag.INTERRUPT);
    }
}
