package com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Impl.Increment;

import com.mpcamargo.emuladornes.core.HWDevices.CPU.CPU;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Flag.Flag;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.ExecutableInstruction;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Parameters;

public class INC_ABSOLUTE_X implements ExecutableInstruction {
    @Override
    public void execute(CPU cpu, Parameters parameters) throws Exception {
        int programCounter = cpu.getProgramCounter();
        int addressLow = cpu.getBusHelper().read(programCounter++);
        int addressHigh = cpu.getBusHelper().read(programCounter++);

        int baseAddress = (addressHigh << 8) | addressLow;
        int valueRegisterX = cpu.getRegisterHelper().getValueRegisterX();
        int baseAddressPlusX = baseAddress + valueRegisterX;
        int data = (cpu.getBusHelper().read(baseAddressPlusX) + 1) & 0xFF;
        cpu.getBusHelper().write(baseAddressPlusX, data);

        cpu.getFlagHelper().removeFlag(Flag.ZERO);
        cpu.getFlagHelper().removeFlag(Flag.NEGATIVE);

        if (data == 0) {
            cpu.getFlagHelper().addFlag(Flag.ZERO);
        }

        final int mask7bit = 0x80; // 1000 0000;

        if ((data & mask7bit) != 0) {
            cpu.getFlagHelper().addFlag(Flag.NEGATIVE);
        }

        cpu.setProgramCounter(programCounter);
    }
}
