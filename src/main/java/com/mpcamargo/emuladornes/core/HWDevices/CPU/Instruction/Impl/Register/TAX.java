package com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Impl.Register;

import com.mpcamargo.emuladornes.core.HWDevices.CPU.CPU;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.ExecutableInstruction;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Parameters;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Registers.A;

public class TAX implements ExecutableInstruction {
    @Override
    public void execute(CPU cpu, Parameters parameters) throws Exception {
        cpu.transferRegister(cpu.getA(), cpu.getX());
    }
}
