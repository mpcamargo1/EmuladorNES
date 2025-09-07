package com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Impl.Compare;

import com.mpcamargo.emuladornes.core.HWDevices.CPU.CPU;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.ExecutableInstruction;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Parameters;

public class CMP_INDIRECT_X implements ExecutableInstruction {
    @Override
    public void execute(CPU cpu, Parameters parameters) throws Exception {
        int programCounter = cpu.getProgramCounter();
        int baseAddress = cpu.getBusHelper().read(programCounter++);
        int valueRegisterX = cpu.getRegisterHelper().getValueRegisterX();
        int searchAddress = (baseAddress + valueRegisterX) & 0xFF;

        int addressLow = cpu.getBusHelper().read(searchAddress);
        int addressHigh = cpu.getBusHelper().read((searchAddress + 1) & 0xFF);

        int data = cpu.getBusHelper().read((addressHigh << 8) | addressLow);
        cpu.getRegisterHelper().doCompareAccumulator(data);

        cpu.setProgramCounter(programCounter);
    }
}
