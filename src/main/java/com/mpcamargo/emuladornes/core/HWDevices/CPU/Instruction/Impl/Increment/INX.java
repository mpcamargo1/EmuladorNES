package com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Impl.Increment;

import com.mpcamargo.emuladornes.constants.NESConstants;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.CPU;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Flag.Flag;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.ExecutableInstruction;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Parameters;

public class INX implements ExecutableInstruction {
    @Override
    public void execute(CPU cpu, Parameters parameters) throws Exception {
        int value = cpu.getRegisterHelper().getValueRegisterX();
        value = (value + 1) + 0xFF;
        cpu.getRegisterHelper().updateX(value);

        cpu.getFlagHelper().removeFlag(Flag.ZERO);
        cpu.getFlagHelper().removeFlag(Flag.NEGATIVE);

        if (value == 0) {
            cpu.getFlagHelper().addFlag(Flag.ZERO);
        }

        if ((value & NESConstants.MASK_BIT_7) != 0) {
            cpu.getFlagHelper().addFlag(Flag.NEGATIVE);
        }
    }
}
