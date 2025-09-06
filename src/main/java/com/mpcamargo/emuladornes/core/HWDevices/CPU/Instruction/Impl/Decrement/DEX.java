package com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Impl.Decrement;

import com.mpcamargo.emuladornes.core.HWDevices.CPU.CPU;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Flag.Flag;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.ExecutableInstruction;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Parameters;

public class DEX implements ExecutableInstruction {
    @Override
    public void execute(CPU cpu, Parameters parameters) throws Exception {
        int value = cpu.getRegisterHelper().getValueRegisterX();
        value = (value - 1) + 0xFF;
        cpu.getRegisterHelper().updateX(value);

        cpu.getFlagHelper().removeFlag(Flag.ZERO);
        cpu.getFlagHelper().removeFlag(Flag.NEGATIVE);

        if (value == 0) {
            cpu.getFlagHelper().addFlag(Flag.ZERO);
        }

        final int mask7bit = 0x80; // 1000 0000;

        if ((value & mask7bit) != 0) {
            cpu.getFlagHelper().addFlag(Flag.NEGATIVE);
        }
    }
}
