package com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Impl.Jump;

import com.mpcamargo.emuladornes.core.HWDevices.CPU.CPU;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.ExecutableInstruction;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Parameters;

public class JMP_ABSOLUTE_INDIRECT implements ExecutableInstruction {
    @Override
    public void execute(CPU cpu, Parameters parameters) throws Exception {
        int programCounter = cpu.getProgramCounter();
        int addressLow = cpu.getBusHelper().read(programCounter++);
        int addressHigh = cpu.getBusHelper().read(programCounter);
        int searchAddress = (addressHigh << 8) | addressLow;
        addressLow = cpu.getBusHelper().read(searchAddress);

        // Implementing the hardware bug 6502
        if ((searchAddress & 0x00FF) == 0x00FF) {
            searchAddress &= 0xFF00;
        } else {
            searchAddress++;
        }

        addressHigh = cpu.getBusHelper().read(searchAddress);
        int finalAddress = (addressHigh << 8) | addressLow;
        cpu.setProgramCounter(finalAddress);
    }
}
