package com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Impl.Compare;

import com.mpcamargo.emuladornes.core.HWDevices.CPU.CPU;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.ExecutableInstruction;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Parameters;

public class CMP_INDIRECT_Y implements ExecutableInstruction {
    @Override
    public void execute(CPU cpu, Parameters parameters) throws Exception {
        int programCounter = cpu.getProgramCounter();

        int pointerAddress = cpu.getBusHelper().read(programCounter++);

        int addressLow = cpu.getBusHelper().read(pointerAddress);
        int addressHigh = cpu.getBusHelper().read((pointerAddress + 1) & 0xFF);

        int baseAddress = (addressHigh << 8) | addressLow;
        int valueRegisterY = cpu.getRegisterHelper().getValueRegisterY();

        int baseAddressPlusOffset = (baseAddress + valueRegisterY) & 0xFFFF;

        // Page cross
        if ((baseAddressPlusOffset >> 8) != addressHigh) {
            cpu.addExtraCycle();
        }

        int data = cpu.getBusHelper().read(baseAddressPlusOffset);

        cpu.getRegisterHelper().doCompareAccumulator(data);
        cpu.setProgramCounter(programCounter);
    }
}
