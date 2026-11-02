package com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Impl;

import com.mpcamargo.emuladornes.core.HWDevices.CPU.CPU;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Flag.Flag;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.ExecutableInstruction;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Parameters;

public class BRK implements ExecutableInstruction {

    @Override
    public void execute(CPU cpu, Parameters parameters) throws Exception {
        // Contador de programa aponta para o parâmetro da instrução BRK
        // Deve incrementar o contador para empilhar a próxima instrução
        cpu.getStackHelper().push16(cpu.getProgramCounter() + 1);

        // 0x30 = 0110000 -> Bit 4 (BREAK) e 5 (UNUSED) ficam ativos
        int status = cpu.getFlagHelper().getStatus() | 0x30;
        cpu.getStackHelper().push(status);

        cpu.getFlagHelper().addFlag(Flag.INTERRUPT);

        int newProgramCounter = cpu.getBusHelper().readMemoryVector(0xFFFE);
        cpu.setProgramCounter(newProgramCounter);
    }
}
