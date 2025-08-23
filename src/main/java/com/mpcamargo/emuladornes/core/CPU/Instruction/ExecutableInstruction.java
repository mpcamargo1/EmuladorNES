package com.mpcamargo.emuladornes.core.CPU.Instruction;

import com.mpcamargo.emuladornes.core.CPU.CPU;

public interface ExecutableInstruction {

    void execute(CPU cpu, Parameters parameters) throws Exception;
}
