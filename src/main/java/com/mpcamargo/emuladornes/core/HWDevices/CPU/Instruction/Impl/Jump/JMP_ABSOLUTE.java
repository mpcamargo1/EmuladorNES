package com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Impl.Jump;

import com.mpcamargo.emuladornes.core.HWDevices.CPU.CPU;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.ExecutableInstruction;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Parameters;

public class JMP_ABSOLUTE implements ExecutableInstruction {
    @Override
    public void execute(CPU cpu, Parameters parameters) throws Exception {
        int programCounter = cpu.getProgramCounter();
        int addressLow = cpu.getBusHelper().read(programCounter++);
        int addressHigh = cpu.getBusHelper().read(programCounter);

        int finalAddress = (addressHigh << 8) | addressLow;

        cpu.setProgramCounter(finalAddress);
    }
}
