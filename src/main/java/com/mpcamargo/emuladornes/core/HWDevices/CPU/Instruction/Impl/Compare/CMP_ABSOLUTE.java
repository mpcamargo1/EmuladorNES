package com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Impl.Compare;

import com.mpcamargo.emuladornes.core.HWDevices.CPU.CPU;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Flag.Flag;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Helper.FlagHelper;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Helper.RegisterHelper;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.ExecutableInstruction;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Parameters;

public class CMP_ABSOLUTE implements ExecutableInstruction {
    @Override
    public void execute(CPU cpu, Parameters parameters) throws Exception {
        int programCounter = cpu.getProgramCounter();
        int addressLow = cpu.getBusHelper().read(programCounter++);
        int addressHigh = cpu.getBusHelper().read(programCounter++);
        int data = cpu.getBusHelper().read((addressHigh << 8) | addressLow);
        cpu.getRegisterHelper().doCompareAccumulator(data);
        cpu.setProgramCounter(programCounter);
    }
}
