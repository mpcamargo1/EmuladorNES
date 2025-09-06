package com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Impl.Compare;

import com.mpcamargo.emuladornes.core.HWDevices.CPU.CPU;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.ExecutableInstruction;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Parameters;

public class CMP_ZEROPAGE_X implements ExecutableInstruction {
    @Override
    public void execute(CPU cpu, Parameters parameters) throws Exception {
        int programCounter = cpu.getProgramCounter();
        int addressZeroPage = cpu.getBusHelper().read(programCounter++);
        int valueRegisterX = cpu.getRegisterHelper().getValueRegisterX();
        int finalAddress = (addressZeroPage + valueRegisterX) & 0xFF;
        int data = cpu.getBusHelper().read(finalAddress);
        cpu.getRegisterHelper().doCompareAccumulator(data);
        cpu.setProgramCounter(programCounter);
    }
}
