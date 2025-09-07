package com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Impl.Compare;

import com.mpcamargo.emuladornes.core.HWDevices.CPU.CPU;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.ExecutableInstruction;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Parameters;

public class CMP_ABSOLUTE_X implements ExecutableInstruction {

    @Override
    public void execute(CPU cpu, Parameters parameters) throws Exception {
        int programCounter = cpu.getProgramCounter();
        int addressLow = cpu.getBusHelper().read(programCounter++);
        int addressHigh = cpu.getBusHelper().read(programCounter++);

        int searchAddress = (addressHigh << 8) | addressLow;
        int valueRegisterX = cpu.getRegisterHelper().getValueRegisterX();
        int searchAddressPlusOffset = (searchAddress + valueRegisterX) & 0xFFFF;

        // Page Cross
        if ((searchAddressPlusOffset >> 8) != addressHigh) {
            cpu.addExtraCycle();
        }

        int data = cpu.getBusHelper().read(searchAddressPlusOffset);
        cpu.getRegisterHelper().doCompareAccumulator(data);
        cpu.setProgramCounter(programCounter);
    }
}
