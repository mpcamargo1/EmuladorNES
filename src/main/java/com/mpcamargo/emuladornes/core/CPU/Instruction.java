package com.mpcamargo.emuladornes.core.CPU;

import java.util.HashMap;
import java.util.Map;

public enum Instruction {

    // -------------------------------------------------------------------------------------------------------------- //
    BRK((byte) 0x00, AddressingMode.IMPLIED, 1, 7, ExtraCycleCondition.NONE),
    ORA_INDIRECT_X((byte) 0x01, AddressingMode.INDIRECT_X, 2, 6, ExtraCycleCondition.NONE),
    SLO_INDIRECT_X((byte) 0x03, AddressingMode.INDIRECT_X, 2, 8, ExtraCycleCondition.NONE, true),
    NOP_ZEROPAGE((byte) 0x04, AddressingMode.ZEROPAGE, 2, 3, ExtraCycleCondition.NONE, true),
    ORA_ZEROPAGE((byte) 0x05, AddressingMode.ZEROPAGE, 2, 3, ExtraCycleCondition.NONE),
    ASL_ZEROPAGE((byte) 0x06, AddressingMode.ZEROPAGE, 2, 5, ExtraCycleCondition.NONE),
    PHP((byte) 0x08, AddressingMode.IMPLIED, 1, 3, ExtraCycleCondition.NONE),
    ORA_IMMEDIATE((byte) 0x09, AddressingMode.IMMEDIATE, 2, 2, ExtraCycleCondition.NONE),
    ASL_ACCUMULATOR((byte) 0x0A, AddressingMode.ACCUMULATOR, 1, 2, ExtraCycleCondition.NONE),
    NOP_ABSOLUTE((byte) 0x0C, AddressingMode.ABSOLUTE, 3, 4, ExtraCycleCondition.NONE, true),
    ORA_ABSOLUTE((byte) 0x0D, AddressingMode.ABSOLUTE, 3, 4, ExtraCycleCondition.NONE),
    ASL_ABSOLUTE((byte) 0x0E, AddressingMode.ABSOLUTE, 3, 6, ExtraCycleCondition.NONE),

    // -------------------------------------------------------------------------------------------------------------- //
    BPL((byte) 0x10, AddressingMode.RELATIVE, 2, 2, ExtraCycleCondition.BranchOccursOn),
    ORA_INDIRECT_Y((byte) 0x11, AddressingMode.INDIRECT_Y, 2, 5, ExtraCycleCondition.PageBoundaryCrossed),
    NOP_ZEROPAGE_X((byte) 0x14, AddressingMode.ZEROPAGE_X, 2, 4, ExtraCycleCondition.NONE, true),
    ORA_ZEROPAGE_X((byte) 0x15, AddressingMode.ZEROPAGE_X, 2, 4, ExtraCycleCondition.NONE),
    ASL_ZEROPAGE_X((byte) 0x16, AddressingMode.ZEROPAGE_X, 2, 6, ExtraCycleCondition.NONE),
    CLC((byte) 0x18, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE),
    ORA_ABSOLUTE_Y((byte) 0x19, AddressingMode.ABSOLUTE_Y, 3, 4, ExtraCycleCondition.PageBoundaryCrossed),
    NOP_IMPLIED((byte) 0x1A, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE, true),
    NOP_ABSOLUTE_X((byte) 0x1C, AddressingMode.ABSOLUTE_X, 3, 4, ExtraCycleCondition.PageBoundaryCrossed, true),
    ORA_ABSOLUTE_X((byte) 0x1D, AddressingMode.ABSOLUTE_X, 3, 4, ExtraCycleCondition.PageBoundaryCrossed),
    ASL_ABSOLUTE_X((byte) 0x1E, AddressingMode.ABSOLUTE_X, 3, 7, ExtraCycleCondition.NONE),

    // -------------------------------------------------------------------------------------------------------------- //

    JSR((byte)0x20, AddressingMode.ABSOLUTE, 3, 6, ExtraCycleCondition.NONE),
    AND_IND_X((byte)0x21, AddressingMode.INDIRECT_X, 2, 6, ExtraCycleCondition.NONE),
    BIT_ZEROPAGE((byte)0x24, AddressingMode.ZEROPAGE, 2, 3, ExtraCycleCondition.NONE),
    AND_ZEROPAGE((byte)0x25, AddressingMode.ZEROPAGE, 2, 3, ExtraCycleCondition.NONE),
    ROL_ZEROPAGE((byte)0x26, AddressingMode.ZEROPAGE, 2, 5, ExtraCycleCondition.NONE),
    AND_IMMEDIATE((byte)0x29, AddressingMode.IMMEDIATE, 2, 2, ExtraCycleCondition.NONE),
    ROL_ACCUMULATOR((byte)0x2A, AddressingMode.ACCUMULATOR, 1, 2, ExtraCycleCondition.NONE),
    BIT_ABSOLUTE((byte)0x2C, AddressingMode.ABSOLUTE, 3, 4, ExtraCycleCondition.NONE),
    AND_ABSOLUTE((byte)0x2D, AddressingMode.ABSOLUTE, 3, 4, ExtraCycleCondition.NONE),
    ROL_ABSOLUTE((byte)0x2E, AddressingMode.ABSOLUTE, 3, 6, ExtraCycleCondition.NONE),

    // -------------------------------------------------------------------------------------------------------------- //

    BMI((byte) 0x30, AddressingMode.RELATIVE, 2, 2, ExtraCycleCondition.BranchOccursOn),
    AND_INDIRECT_Y((byte) 0x31, AddressingMode.INDIRECT_Y, 2, 5, ExtraCycleCondition.PageBoundaryCrossed),
    NOP_IMPLIED_1((byte) 0x32, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE, true),
    NOP_IMPLIED_2((byte) 0x3A, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE, true),
    NOP_ZEROPAGE_X_ILLEGAL((byte) 0x34, AddressingMode.ZEROPAGE_X, 2, 4, ExtraCycleCondition.NONE, true),
    AND_ZEROPAGE_X((byte) 0x35, AddressingMode.ZEROPAGE_X, 2, 4, ExtraCycleCondition.NONE),
    ROL_ZEROPAGE_X((byte) 0x36, AddressingMode.ZEROPAGE_X, 2, 6, ExtraCycleCondition.NONE),
    SEC((byte) 0x38, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE),
    AND_ABSOLUTE_Y((byte) 0x39, AddressingMode.ABSOLUTE_Y, 3, 4, ExtraCycleCondition.PageBoundaryCrossed),
    NOP_ABSOLUTE_X_1((byte) 0x3C, AddressingMode.ABSOLUTE_X, 3, 4, ExtraCycleCondition.PageBoundaryCrossed, true),
    AND_ABSOLUTE_X((byte) 0x3D, AddressingMode.ABSOLUTE_X, 3, 4, ExtraCycleCondition.PageBoundaryCrossed),
    ROL_ABSOLUTE_X((byte) 0x3E, AddressingMode.ABSOLUTE_X, 3, 7, ExtraCycleCondition.NONE),
    NOP_ABSOLUTE_X_ILLEGAL((byte) 0x3F, AddressingMode.ABSOLUTE_X, 3, 7, ExtraCycleCondition.NONE, true),

    // -------------------------------------------------------------------------------------------------------------- //

    RTI((byte) 0x40, AddressingMode.IMPLIED, 1, 6, ExtraCycleCondition.NONE),
    EOR_INDIRECT_X((byte) 0x41, AddressingMode.INDIRECT_X, 2, 6, ExtraCycleCondition.NONE),
    NOP_ZEROPAGE_1((byte) 0x44, AddressingMode.ZEROPAGE, 2, 3, ExtraCycleCondition.NONE, true),
    EOR_ZEROPAGE((byte) 0x45, AddressingMode.ZEROPAGE, 2, 3, ExtraCycleCondition.NONE),
    LSR_ZEROPAGE((byte) 0x46, AddressingMode.ZEROPAGE, 2, 5, ExtraCycleCondition.NONE),
    PHA((byte) 0x48, AddressingMode.IMPLIED, 1, 3, ExtraCycleCondition.NONE),
    EOR_IMMEDIATE((byte) 0x49, AddressingMode.IMMEDIATE, 2, 2, ExtraCycleCondition.NONE),
    LSR_ACCUMULATOR((byte) 0x4A, AddressingMode.ACCUMULATOR, 1, 2, ExtraCycleCondition.NONE),
    JMP_ABSOLUTE((byte) 0x4C, AddressingMode.ABSOLUTE, 3, 3, ExtraCycleCondition.NONE),
    EOR_ABSOLUTE((byte) 0x4D, AddressingMode.ABSOLUTE, 3, 4, ExtraCycleCondition.NONE),
    LSR_ABSOLUTE((byte) 0x4E, AddressingMode.ABSOLUTE, 3, 6, ExtraCycleCondition.NONE),

    // -------------------------------------------------------------------------------------------------------------- //

    BVC((byte) 0x50, AddressingMode.RELATIVE, 2, 2, ExtraCycleCondition.BranchOccursOn),
    EOR_INDIRECT_Y((byte) 0x51, AddressingMode.INDIRECT_Y, 2, 5, ExtraCycleCondition.PageBoundaryCrossed),
    NOP_ZEROPAGE_X_1((byte) 0x54, AddressingMode.ZEROPAGE_X, 2, 4, ExtraCycleCondition.NONE, true),
    EOR_ZEROPAGE_X((byte) 0x55, AddressingMode.ZEROPAGE_X, 2, 4, ExtraCycleCondition.NONE),
    LSR_ZEROPAGE_X((byte) 0x56, AddressingMode.ZEROPAGE_X, 2, 6, ExtraCycleCondition.NONE),
    CLI((byte) 0x58, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE),
    EOR_ABSOLUTE_Y((byte) 0x59, AddressingMode.ABSOLUTE_Y, 3, 4, ExtraCycleCondition.PageBoundaryCrossed),
    NOP_IMPLIED_ILLEGAL((byte) 0x5A, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE, true),
    NOP_ABSOLUTE_X_ILLEGAL_2((byte) 0x5C, AddressingMode.ABSOLUTE_X, 3, 4, ExtraCycleCondition.PageBoundaryCrossed, true),
    EOR_ABSOLUTE_X((byte) 0x5D, AddressingMode.ABSOLUTE_X, 3, 4, ExtraCycleCondition.PageBoundaryCrossed),
    LSR_ABSOLUTE_X((byte) 0x5E, AddressingMode.ABSOLUTE_X, 3, 7, ExtraCycleCondition.NONE),

    // -------------------------------------------------------------------------------------------------------------- //

    RTS((byte) 0x60, AddressingMode.IMPLIED, 1, 6, ExtraCycleCondition.NONE),
    ADC_INDIRECT_X((byte) 0x61, AddressingMode.INDIRECT_X, 2, 6, ExtraCycleCondition.NONE),
    NOP_ZEROPAGE_ILLEGAL((byte) 0x64, AddressingMode.ZEROPAGE, 2, 3, ExtraCycleCondition.NONE, true),
    ADC_ZEROPAGE((byte) 0x65, AddressingMode.ZEROPAGE, 2, 3, ExtraCycleCondition.NONE),
    ROR_ZEROPAGE((byte) 0x66, AddressingMode.ZEROPAGE, 2, 5, ExtraCycleCondition.NONE),
    PLA((byte) 0x68, AddressingMode.IMPLIED, 1, 4, ExtraCycleCondition.NONE),
    ADC_IMMEDIATE((byte) 0x69, AddressingMode.IMMEDIATE, 2, 2, ExtraCycleCondition.NONE),
    ROR_ACCUMULATOR((byte) 0x6A, AddressingMode.ACCUMULATOR, 1, 2, ExtraCycleCondition.NONE),
    JMP_ABSOLUTE_INDIRECT((byte) 0x6C, AddressingMode.ABSOLUTE_INDIRECT, 3, 5, ExtraCycleCondition.NONE),
    ADC_ABSOLUTE((byte) 0x6D, AddressingMode.ABSOLUTE, 3, 4, ExtraCycleCondition.NONE),
    ROR_ABSOLUTE((byte) 0x6E, AddressingMode.ABSOLUTE, 3, 6, ExtraCycleCondition.NONE),

    // -------------------------------------------------------------------------------------------------------------- //

    BVS((byte) 0x70, AddressingMode.RELATIVE, 2, 2, ExtraCycleCondition.BranchOccursOn),
    ADC_INDIRECT_Y((byte) 0x71, AddressingMode.INDIRECT_Y, 2, 5, ExtraCycleCondition.NONE),
    NOP_ZEROPAGE_X_NOEXTRACYCLE_ILLEGAL((byte) 0x74, AddressingMode.ZEROPAGE_X, 2, 4, ExtraCycleCondition.NONE, true),
    ADC_ZEROPAGE_X((byte) 0x75, AddressingMode.ZEROPAGE_X, 2, 4, ExtraCycleCondition.NONE),
    ROR_ZEROPAGE_X((byte) 0x76, AddressingMode.ZEROPAGE_X, 2, 6, ExtraCycleCondition.NONE),
    SEI((byte) 0x78, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE),
    ADC_ABSOLUTE_Y((byte) 0x79, AddressingMode.ABSOLUTE_Y, 3, 4, ExtraCycleCondition.NONE),
    NOP_IMPLIED_NOEXTRACYCLE_ILLEGAL((byte) 0x7A, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE, true),
    RRA_ABSOLUTE_Y_NOEXTRACYCLE_ILLEGAL((byte) 0x7B, AddressingMode.ABSOLUTE_Y, 3, 7, ExtraCycleCondition.NONE, true),
    NOP_ABSOLUTE_X_NOEXTRACYCLE_ILLEGAL((byte) 0x7C, AddressingMode.ABSOLUTE_X, 3, 4, ExtraCycleCondition.NONE, true),
    ADC_ABSOLUTE_X((byte) 0x7D, AddressingMode.ABSOLUTE_X, 3, 4, ExtraCycleCondition.NONE),
    ROR_ABSOLUTE_X((byte) 0x7E, AddressingMode.ABSOLUTE_X, 3, 7, ExtraCycleCondition.NONE),
    RRA_ABSOLUTE_X_1((byte) 0x7F, AddressingMode.ABSOLUTE_X, 3, 7, ExtraCycleCondition.NONE, true),

    // -------------------------------------------------------------------------------------------------------------- //

    NOP_IMMEDIATE_ILLEGAL((byte) 0x80, AddressingMode.IMMEDIATE, 2, 2, ExtraCycleCondition.NONE, true),
    STA_INDIRECT_X((byte) 0x81, AddressingMode.INDIRECT_X, 2, 6, ExtraCycleCondition.NONE),
    SAX_INDIRECT_X_ILLEGAL((byte) 0x83, AddressingMode.INDIRECT_X, 2, 6, ExtraCycleCondition.NONE, true),
    STY_ZEROPAGE((byte) 0x84, AddressingMode.ZEROPAGE, 2, 3, ExtraCycleCondition.NONE),
    STA_ZEROPAGE((byte) 0x85, AddressingMode.ZEROPAGE, 2, 3, ExtraCycleCondition.NONE),
    STX_ZEROPAGE((byte) 0x86, AddressingMode.ZEROPAGE, 2, 3, ExtraCycleCondition.NONE),
    SAX_ZEROPAGE_ILLEGAL((byte) 0x87, AddressingMode.ZEROPAGE, 2, 3, ExtraCycleCondition.NONE, true),
    DEY((byte) 0x88, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE),
    NOP_IMMEDIATE_NOEXTRACYCLE_ILLEGAL((byte) 0x89, AddressingMode.IMMEDIATE, 2, 2, ExtraCycleCondition.NONE, true),
    TXA((byte) 0x8A, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE),
    STY_ABSOLUTE((byte) 0x8C, AddressingMode.ABSOLUTE, 3, 4, ExtraCycleCondition.NONE),
    STA_ABSOLUTE((byte) 0x8D, AddressingMode.ABSOLUTE, 3, 4, ExtraCycleCondition.NONE),
    STX_ABSOLUTE((byte) 0x8E, AddressingMode.ABSOLUTE, 3, 4, ExtraCycleCondition.NONE),
    SAX_ABSOLUTE_1((byte) 0x8F, AddressingMode.ABSOLUTE, 3, 4, ExtraCycleCondition.NONE, true),

    // -------------------------------------------------------------------------------------------------------------- //

    BCC((byte) 0x90, AddressingMode.RELATIVE, 2, 2, ExtraCycleCondition.BranchOccursOn),
    STA_INDIRECT_Y((byte) 0x91, AddressingMode.INDIRECT_Y, 2, 6, ExtraCycleCondition.NONE),
    JAM_ILLEGAL((byte) 0x92, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE, true),
    STY_ZEROPAGE_X((byte) 0x94, AddressingMode.ZEROPAGE_X, 2, 4, ExtraCycleCondition.NONE),
    STA_ZEROPAGE_X((byte) 0x95, AddressingMode.ZEROPAGE_X, 2, 4, ExtraCycleCondition.NONE),
    STX_ZEROPAGE_Y((byte) 0x96, AddressingMode.ZEROPAGE_Y, 2, 4, ExtraCycleCondition.NONE),
    SAX_ZEROPAGE_Y_ILLEGAL((byte) 0x97, AddressingMode.ZEROPAGE_Y, 2, 4, ExtraCycleCondition.NONE, true),
    TYA((byte) 0x98, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE),
    STA_ABSOLUTE_Y((byte) 0x99, AddressingMode.ABSOLUTE_Y, 3, 5, ExtraCycleCondition.NONE),
    TXS((byte) 0x9A, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE),
    STA_ABSOLUTE_X((byte) 0x9D, AddressingMode.ABSOLUTE_X, 3, 5, ExtraCycleCondition.NONE),

    // -------------------------------------------------------------------------------------------------------------- //

    LDY_IMMEDIATE((byte) 0xA0, AddressingMode.IMMEDIATE, 2, 2, ExtraCycleCondition.NONE),
    LDA_INDIRECT_X((byte) 0xA1, AddressingMode.INDIRECT_X, 2, 6, ExtraCycleCondition.NONE),
    LDX_IMMEDIATE((byte) 0xA2, AddressingMode.IMMEDIATE, 2, 2, ExtraCycleCondition.NONE),
    LAX_INDIRECT_X_ILLEGAL((byte) 0xA3, AddressingMode.INDIRECT_X, 2, 6, ExtraCycleCondition.NONE, true),
    LDY_ZEROPAGE((byte) 0xA4, AddressingMode.ZEROPAGE, 2, 3, ExtraCycleCondition.NONE),
    LDA_ZEROPAGE((byte) 0xA5, AddressingMode.ZEROPAGE, 2, 3, ExtraCycleCondition.NONE),
    LDX_ZEROPAGE((byte) 0xA6, AddressingMode.ZEROPAGE, 2, 3, ExtraCycleCondition.NONE),
    LAX_ZEROPAGE_ILLEGAL((byte) 0xA7, AddressingMode.ZEROPAGE, 2, 3, ExtraCycleCondition.NONE, true),
    TAY((byte) 0xA8, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE),
    LDA_IMMEDIATE((byte) 0xA9, AddressingMode.IMMEDIATE, 2, 2, ExtraCycleCondition.NONE),
    TAX((byte) 0xAA, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE),
    LDY_ABSOLUTE((byte) 0xAC, AddressingMode.ABSOLUTE, 3, 4, ExtraCycleCondition.NONE),
    LDA_ABSOLUTE((byte) 0xAD, AddressingMode.ABSOLUTE, 3, 4, ExtraCycleCondition.NONE),
    LDX_ABSOLUTE((byte) 0xAE, AddressingMode.ABSOLUTE, 3, 4, ExtraCycleCondition.NONE),
    LAX_ABSOLUTE_ILLEGAL((byte) 0xAF, AddressingMode.ABSOLUTE, 3, 4, ExtraCycleCondition.NONE, true),

    // -------------------------------------------------------------------------------------------------------------- //

    BCS((byte) 0xB0, AddressingMode.RELATIVE, 2, 2, ExtraCycleCondition.BranchOccursOn),
    LDA_INDIRECT_Y((byte) 0xB1, AddressingMode.INDIRECT_Y, 2, 5, ExtraCycleCondition.PageBoundaryCrossed),
    LAX_INDIRECT_Y_ILLEGAL((byte) 0xB3, AddressingMode.INDIRECT_Y, 2, 5, ExtraCycleCondition.PageBoundaryCrossed, true),
    LDY_ZEROPAGE_X((byte) 0xB4, AddressingMode.ZEROPAGE_X, 2, 4, ExtraCycleCondition.NONE),
    LDA_ZEROPAGE_X((byte) 0xB5, AddressingMode.ZEROPAGE_X, 2, 4, ExtraCycleCondition.NONE),
    LDX_ZEROPAGE_Y((byte) 0xB6, AddressingMode.ZEROPAGE_Y, 2, 4, ExtraCycleCondition.NONE),
    LAX_ZEROPAGE_Y_ILLEGAL((byte) 0xB7, AddressingMode.ZEROPAGE_Y, 2, 4, ExtraCycleCondition.NONE, true),
    CLV((byte) 0xB8, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE),
    LDA_ABSOLUTE_Y((byte) 0xB9, AddressingMode.ABSOLUTE_Y, 3, 4, ExtraCycleCondition.PageBoundaryCrossed),
    TSX((byte) 0xBA, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE),
    LDY_ABSOLUTE_X((byte) 0xBC, AddressingMode.ABSOLUTE_X, 3, 4, ExtraCycleCondition.PageBoundaryCrossed),
    LDA_ABSOLUTE_X((byte) 0xBD, AddressingMode.ABSOLUTE_X, 3, 4, ExtraCycleCondition.PageBoundaryCrossed),
    LDX_ABSOLUTE_Y((byte) 0xBE, AddressingMode.ABSOLUTE_Y, 3, 4, ExtraCycleCondition.PageBoundaryCrossed),
    LAX_ABSOLUTE_Y_ILLEGAL((byte) 0xBF, AddressingMode.ABSOLUTE_Y, 3, 4, ExtraCycleCondition.PageBoundaryCrossed, true),

    // -------------------------------------------------------------------------------------------------------------- //

    CPY_IMMEDIATE((byte) 0xC0, AddressingMode.IMMEDIATE, 2, 2, ExtraCycleCondition.NONE),
    CMP_INDIRECT_X((byte) 0xC1, AddressingMode.INDIRECT_X, 2, 6, ExtraCycleCondition.NONE),
    CPY_ZEROPAGE((byte) 0xC4, AddressingMode.ZEROPAGE, 2, 3, ExtraCycleCondition.NONE),
    CMP_ZEROPAGE((byte) 0xC5, AddressingMode.ZEROPAGE, 2, 2, ExtraCycleCondition.NONE),
    DEC_ZEROPAGE((byte) 0xC6, AddressingMode.ZEROPAGE, 2, 5, ExtraCycleCondition.NONE),
    DCP_ZEROPAGE_ILLEGAL((byte) 0xC7, AddressingMode.ZEROPAGE, 2, 5, ExtraCycleCondition.NONE, true),
    INY((byte) 0xC8, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE),
    CMP_IMMEDIATE((byte) 0xC9, AddressingMode.IMMEDIATE, 2, 2, ExtraCycleCondition.NONE),
    DEX((byte) 0xCA, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE),
    DCP_INDIRECT_X_ILLEGAL((byte) 0xC3, AddressingMode.INDIRECT_X, 2, 8, ExtraCycleCondition.NONE, true),
    CPY_ABSOLUTE((byte) 0xCC, AddressingMode.ABSOLUTE, 3, 4, ExtraCycleCondition.NONE),
    CMP_ABSOLUTE((byte) 0xCD, AddressingMode.ABSOLUTE, 3, 4, ExtraCycleCondition.NONE),
    DEC_ABSOLUTE((byte) 0xCE, AddressingMode.ABSOLUTE, 3, 6, ExtraCycleCondition.NONE),
    DCP_ABSOLUTE_ILLEGAL((byte) 0xCF, AddressingMode.ABSOLUTE, 3, 6, ExtraCycleCondition.NONE, true),

    // -------------------------------------------------------------------------------------------------------------- //

    BNE_RELATIVE((byte) 0xD0, AddressingMode.RELATIVE, 2, 2, ExtraCycleCondition.BranchOccursOn),
    CMP_INDIRECT_Y((byte) 0xD1, AddressingMode.INDIRECT_Y, 2, 5, ExtraCycleCondition.PageBoundaryCrossed),
    DCP_INDIRECT_Y_ILLEGAL((byte) 0xD3, AddressingMode.INDIRECT_Y, 2, 8, ExtraCycleCondition.NONE, true),
    NOP_ZEROPAGE_X_ILLEGAL_2((byte) 0xD4, AddressingMode.ZEROPAGE_X, 2, 4, ExtraCycleCondition.NONE, true),
    CMP_ZEROPAGE_X((byte) 0xD5, AddressingMode.ZEROPAGE_X, 2, 4, ExtraCycleCondition.NONE),
    DEC_ZEROPAGE_X((byte) 0xD6, AddressingMode.ZEROPAGE_X, 2, 6, ExtraCycleCondition.NONE),
    DCP_ZEROPAGE_X_ILLEGAL((byte) 0xD7, AddressingMode.ZEROPAGE_X, 2, 6, ExtraCycleCondition.NONE, true),
    CLD((byte) 0xD8, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE),
    CMP_ABSOLUTE_Y((byte) 0xD9, AddressingMode.ABSOLUTE_Y, 3, 4, ExtraCycleCondition.PageBoundaryCrossed),
    NOP_IMPLIED_ILLEGAL_2((byte) 0xDA, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE, true),
    DCP_ABSOLUTE_Y_ILLEGAL((byte) 0xDB, AddressingMode.ABSOLUTE_Y, 3, 7, ExtraCycleCondition.NONE, true),
    NOP_ABSOLUTE_X_ILLEGAL_3((byte) 0xDC, AddressingMode.ABSOLUTE_X, 3, 4, ExtraCycleCondition.PageBoundaryCrossed, true),
    CMP_ABSOLUTE_X((byte) 0xDD, AddressingMode.ABSOLUTE_X, 3, 4, ExtraCycleCondition.PageBoundaryCrossed),
    DEC_ABSOLUTE_X((byte) 0xDE, AddressingMode.ABSOLUTE_X, 3, 7, ExtraCycleCondition.NONE),
    DCP_ABSOLUTE_X_ILLEGAL((byte) 0xDF, AddressingMode.ABSOLUTE_X, 3, 7, ExtraCycleCondition.NONE, true),

    // -------------------------------------------------------------------------------------------------------------- //

    CPX_IMMEDIATE((byte) 0xE0, AddressingMode.IMMEDIATE, 2, 2, ExtraCycleCondition.NONE),
    SBC_INDIRECT_X((byte) 0xE1, AddressingMode.INDIRECT_X, 2, 6, ExtraCycleCondition.NONE),
    ISB_INDIRECT_X_ILLEGAL((byte) 0xE3, AddressingMode.INDIRECT_X, 2, 8, ExtraCycleCondition.NONE, true),
    CPX_ZEROPAGE((byte) 0xE4, AddressingMode.ZEROPAGE, 2, 3, ExtraCycleCondition.NONE),
    SBC_ZEROPAGE((byte) 0xE5, AddressingMode.ZEROPAGE, 2, 3, ExtraCycleCondition.NONE),
    INC_ZEROPAGE((byte) 0xE6, AddressingMode.ZEROPAGE, 2, 5, ExtraCycleCondition.NONE),
    ISB_ZEROPAGE_ILLEGAL((byte) 0xE7, AddressingMode.ZEROPAGE, 2, 5, ExtraCycleCondition.NONE, true),
    INX((byte) 0xE8, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE),
    SBC_IMMEDIATE((byte) 0xE9, AddressingMode.IMMEDIATE, 2, 2, ExtraCycleCondition.NONE),
    NOP((byte) 0xEA, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE),
    SBC_IMMEDIATE_ILLEGAL((byte) 0xEB, AddressingMode.IMMEDIATE, 2, 2, ExtraCycleCondition.NONE, true),
    CPX_ABSOLUTE((byte) 0xEC, AddressingMode.ABSOLUTE, 3, 4, ExtraCycleCondition.NONE),
    SBC_ABSOLUTE((byte) 0xED, AddressingMode.ABSOLUTE, 3, 4, ExtraCycleCondition.NONE),
    INC_ABSOLUTE((byte) 0xEE, AddressingMode.ABSOLUTE, 3, 6, ExtraCycleCondition.NONE),
    ISB_ABSOLUTE_ILLEGAL((byte) 0xEF, AddressingMode.ABSOLUTE, 3, 6, ExtraCycleCondition.NONE, true),

    // -------------------------------------------------------------------------------------------------------------- //

    EQ_RELATIVE((byte) 0xF0, AddressingMode.RELATIVE, 2, 2, ExtraCycleCondition.BranchOccursOn),
    SBC_INDIRECT_Y((byte) 0xF1, AddressingMode.INDIRECT_Y, 2, 5, ExtraCycleCondition.PageBoundaryCrossed),
    ISB_INDIRECT_Y_ILLEGAL((byte) 0xF3, AddressingMode.INDIRECT_Y, 2, 8, ExtraCycleCondition.NONE, true),
    NOP_ZEROPAGE_X_ILLEGAL_3((byte) 0xF4, AddressingMode.ZEROPAGE_X, 2, 4, ExtraCycleCondition.NONE, true),
    SBC_ZEROPAGE_X((byte) 0xF5, AddressingMode.ZEROPAGE_X, 2, 4, ExtraCycleCondition.NONE),
    INC_ZEROPAGE_X((byte) 0xF6, AddressingMode.ZEROPAGE_X, 2, 6, ExtraCycleCondition.NONE),
    ISB_ZEROPAGE_X_ILLEGAL((byte) 0xF7, AddressingMode.ZEROPAGE_X, 2, 6, ExtraCycleCondition.NONE, true),
    SED_IMPLIED((byte) 0xF8, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE),
    SBC_ABSOLUTE_Y((byte) 0xF9, AddressingMode.ABSOLUTE_Y, 3, 4, ExtraCycleCondition.PageBoundaryCrossed),
    NOP_IMPLIED_ILLEGAL_4((byte) 0xFA, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE, true),
    ISB_ABSOLUTE_Y_ILLEGAL((byte) 0xFB, AddressingMode.ABSOLUTE_Y, 3, 7, ExtraCycleCondition.NONE, true),
    NOP_ABSOLUTE_X_ILLEGAL_4((byte) 0xFC, AddressingMode.ABSOLUTE_X, 3, 4, ExtraCycleCondition.PageBoundaryCrossed, true),
    SBC_ABSOLUTE_X((byte) 0xFD, AddressingMode.ABSOLUTE_X, 3, 4, ExtraCycleCondition.PageBoundaryCrossed),
    INC_ABSOLUTE_X((byte) 0xFE, AddressingMode.ABSOLUTE_X, 3, 7, ExtraCycleCondition.NONE),
    ISB_ABSOLUTE_X_ILLEGAL((byte) 0xFF, AddressingMode.ABSOLUTE_X, 3, 7, ExtraCycleCondition.NONE, true);

    // -------------------------------------------------------------------------------------------------------------- //

    private final byte code;

    private final AddressingMode addressingMode;

    private final int length;

    private final int cycle;

    private final ExtraCycleCondition extraCycleCondition;

    private final boolean isIllegal;


    Instruction (byte code, AddressingMode addressingMode, int length, int cycles,
                 ExtraCycleCondition extraCycleCondition) {
        this.code = code;
        this.addressingMode = addressingMode;
        this.length = length;
        this.cycle = cycles;
        this.extraCycleCondition = extraCycleCondition;
        this.isIllegal = false;
    }

    Instruction (byte code, AddressingMode addressingMode, int length, int cycles,
                 ExtraCycleCondition extraCycleCondition, boolean isIllegal) {
        this.code = code;
        this.addressingMode = addressingMode;
        this.length = length;
        this.cycle = cycles;
        this.extraCycleCondition = extraCycleCondition;
        this.isIllegal = isIllegal;
    }

    public byte getCode() {
        return code;
    }

    public AddressingMode getAddressingMode() {
        return addressingMode;
    }

    public int getLength() {
        return length;
    }

    public int getCycle() {
        return cycle;
    }

    public ExtraCycleCondition getExtraCycleCondition() {
        return extraCycleCondition;
    }

    public boolean isIllegal() {
        return isIllegal;
    }
}
