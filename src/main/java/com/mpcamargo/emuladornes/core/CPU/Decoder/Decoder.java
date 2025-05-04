package com.mpcamargo.emuladornes.core.CPU.Decoder;

import com.mpcamargo.emuladornes.core.CPU.Instruction;

import java.util.HashMap;
import java.util.Map;

public class Decoder {

    private static final Map<Byte, Instruction> opcodeMap = new HashMap<>();

    static {
        for (Instruction instruction : Instruction.values()) {
            opcodeMap.put(instruction.getCode(), instruction);
        }
    }

    public static Instruction getInstruction(byte opcode) {
        Instruction instruction = opcodeMap.get(opcode);

        if (instruction == null) {
            throw new IllegalArgumentException("Falha em encontrar o opcode");
        }

        return instruction;
    }

}
