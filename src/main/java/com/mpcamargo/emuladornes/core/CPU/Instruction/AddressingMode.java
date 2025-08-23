package com.mpcamargo.emuladornes.core.CPU.Instruction;

public enum AddressingMode {
    IMPLIED,
    ABSOLUTE,
    ABSOLUTE_X,
    ABSOLUTE_Y,
    ZEROPAGE,
    ZEROPAGE_X,
    ZEROPAGE_Y,
    RELATIVE,
    ACCUMULATOR,
    ABSOLUTE_INDIRECT,
    INDIRECT_X,
    INDIRECT_Y,
    IMMEDIATE,
}