package com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction;

import com.mpcamargo.emuladornes.core.HWDevices.CPU.CPU;

public interface ExecutableInstruction {

    void execute(CPU cpu, Parameters parameters) throws Exception;
}
