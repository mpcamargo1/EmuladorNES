package com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction;

import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Impl.*;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Impl.Compare.*;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Impl.Decrement.DEX;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Impl.Decrement.DEY;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Impl.Flag.*;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Impl.Increment.INC_ABSOLUTE_X;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Impl.Increment.INX;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Impl.Increment.INY;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Impl.Jump.JMP_ABSOLUTE;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Impl.Jump.JMP_ABSOLUTE_INDIRECT;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction.Impl.Register.*;

public enum Instruction {

    // -------------------------------------------------------------------------------------------------------------- //
    BRK( 0x00, AddressingMode.IMPLIED, 1, 7, ExtraCycleCondition.NONE, new BRK()),
    ORA_INDIRECT_X( 0x01, AddressingMode.INDIRECT_X, 2, 6, ExtraCycleCondition.NONE),
    SLO_INDIRECT_X( 0x03, AddressingMode.INDIRECT_X, 2, 8, ExtraCycleCondition.NONE, true),
    NOP_ZEROPAGE( 0x04, AddressingMode.ZEROPAGE, 2, 3, ExtraCycleCondition.NONE, true),
    ORA_ZEROPAGE( 0x05, AddressingMode.ZEROPAGE, 2, 3, ExtraCycleCondition.NONE),
    ASL_ZEROPAGE( 0x06, AddressingMode.ZEROPAGE, 2, 5, ExtraCycleCondition.NONE),
    PHP( 0x08, AddressingMode.IMPLIED, 1, 3, ExtraCycleCondition.NONE),
    ORA_IMMEDIATE( 0x09, AddressingMode.IMMEDIATE, 2, 2, ExtraCycleCondition.NONE),
    ASL_ACCUMULATOR( 0x0A, AddressingMode.ACCUMULATOR, 1, 2, ExtraCycleCondition.NONE),
    NOP_ABSOLUTE( 0x0C, AddressingMode.ABSOLUTE, 3, 4, ExtraCycleCondition.NONE, true),
    ORA_ABSOLUTE( 0x0D, AddressingMode.ABSOLUTE, 3, 4, ExtraCycleCondition.NONE),
    ASL_ABSOLUTE( 0x0E, AddressingMode.ABSOLUTE, 3, 6, ExtraCycleCondition.NONE),

    // -------------------------------------------------------------------------------------------------------------- //
    BPL( 0x10, AddressingMode.RELATIVE, 2, 2, ExtraCycleCondition.BranchOccursOn),
    ORA_INDIRECT_Y( 0x11, AddressingMode.INDIRECT_Y, 2, 5, ExtraCycleCondition.PageBoundaryCrossed),
    NOP_ZEROPAGE_X( 0x14, AddressingMode.ZEROPAGE_X, 2, 4, ExtraCycleCondition.NONE, true),
    ORA_ZEROPAGE_X( 0x15, AddressingMode.ZEROPAGE_X, 2, 4, ExtraCycleCondition.NONE),
    ASL_ZEROPAGE_X( 0x16, AddressingMode.ZEROPAGE_X, 2, 6, ExtraCycleCondition.NONE),
    CLC( 0x18, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE, new CLC()),
    ORA_ABSOLUTE_Y( 0x19, AddressingMode.ABSOLUTE_Y, 3, 4, ExtraCycleCondition.PageBoundaryCrossed),
    NOP_IMPLIED( 0x1A, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE, true),
    NOP_ABSOLUTE_X( 0x1C, AddressingMode.ABSOLUTE_X, 3, 4, ExtraCycleCondition.PageBoundaryCrossed, true),
    ORA_ABSOLUTE_X( 0x1D, AddressingMode.ABSOLUTE_X, 3, 4, ExtraCycleCondition.PageBoundaryCrossed),
    ASL_ABSOLUTE_X( 0x1E, AddressingMode.ABSOLUTE_X, 3, 7, ExtraCycleCondition.NONE),

    // -------------------------------------------------------------------------------------------------------------- //

    JSR(0x20, AddressingMode.ABSOLUTE, 3, 6, ExtraCycleCondition.NONE),
    AND_IND_X(0x21, AddressingMode.INDIRECT_X, 2, 6, ExtraCycleCondition.NONE),
    BIT_ZEROPAGE(0x24, AddressingMode.ZEROPAGE, 2, 3, ExtraCycleCondition.NONE),
    AND_ZEROPAGE(0x25, AddressingMode.ZEROPAGE, 2, 3, ExtraCycleCondition.NONE),
    ROL_ZEROPAGE(0x26, AddressingMode.ZEROPAGE, 2, 5, ExtraCycleCondition.NONE),
    AND_IMMEDIATE(0x29, AddressingMode.IMMEDIATE, 2, 2, ExtraCycleCondition.NONE),
    ROL_ACCUMULATOR(0x2A, AddressingMode.ACCUMULATOR, 1, 2, ExtraCycleCondition.NONE),
    BIT_ABSOLUTE(0x2C, AddressingMode.ABSOLUTE, 3, 4, ExtraCycleCondition.NONE),
    AND_ABSOLUTE(0x2D, AddressingMode.ABSOLUTE, 3, 4, ExtraCycleCondition.NONE),
    ROL_ABSOLUTE(0x2E, AddressingMode.ABSOLUTE, 3, 6, ExtraCycleCondition.NONE),

    // -------------------------------------------------------------------------------------------------------------- //

    BMI( 0x30, AddressingMode.RELATIVE, 2, 2, ExtraCycleCondition.BranchOccursOn),
    AND_INDIRECT_Y( 0x31, AddressingMode.INDIRECT_Y, 2, 5, ExtraCycleCondition.PageBoundaryCrossed),
    NOP_IMPLIED_1( 0x32, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE, true),
    NOP_IMPLIED_2( 0x3A, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE, true),
    NOP_ZEROPAGE_X_ILLEGAL( 0x34, AddressingMode.ZEROPAGE_X, 2, 4, ExtraCycleCondition.NONE, true),
    AND_ZEROPAGE_X( 0x35, AddressingMode.ZEROPAGE_X, 2, 4, ExtraCycleCondition.NONE),
    ROL_ZEROPAGE_X( 0x36, AddressingMode.ZEROPAGE_X, 2, 6, ExtraCycleCondition.NONE),
    SEC( 0x38, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE, new SEC()),
    AND_ABSOLUTE_Y( 0x39, AddressingMode.ABSOLUTE_Y, 3, 4, ExtraCycleCondition.PageBoundaryCrossed),
    NOP_ABSOLUTE_X_1( 0x3C, AddressingMode.ABSOLUTE_X, 3, 4, ExtraCycleCondition.PageBoundaryCrossed, true),
    AND_ABSOLUTE_X( 0x3D, AddressingMode.ABSOLUTE_X, 3, 4, ExtraCycleCondition.PageBoundaryCrossed),
    ROL_ABSOLUTE_X( 0x3E, AddressingMode.ABSOLUTE_X, 3, 7, ExtraCycleCondition.NONE),
    NOP_ABSOLUTE_X_ILLEGAL( 0x3F, AddressingMode.ABSOLUTE_X, 3, 7, ExtraCycleCondition.NONE, true),

    // -------------------------------------------------------------------------------------------------------------- //

    RTI( 0x40, AddressingMode.IMPLIED, 1, 6, ExtraCycleCondition.NONE),
    EOR_INDIRECT_X( 0x41, AddressingMode.INDIRECT_X, 2, 6, ExtraCycleCondition.NONE),
    NOP_ZEROPAGE_1( 0x44, AddressingMode.ZEROPAGE, 2, 3, ExtraCycleCondition.NONE, true),
    EOR_ZEROPAGE( 0x45, AddressingMode.ZEROPAGE, 2, 3, ExtraCycleCondition.NONE),
    LSR_ZEROPAGE( 0x46, AddressingMode.ZEROPAGE, 2, 5, ExtraCycleCondition.NONE),
    PHA( 0x48, AddressingMode.IMPLIED, 1, 3, ExtraCycleCondition.NONE),
    EOR_IMMEDIATE( 0x49, AddressingMode.IMMEDIATE, 2, 2, ExtraCycleCondition.NONE),
    LSR_ACCUMULATOR( 0x4A, AddressingMode.ACCUMULATOR, 1, 2, ExtraCycleCondition.NONE),
    JMP_ABSOLUTE( 0x4C, AddressingMode.ABSOLUTE, 3, 3, ExtraCycleCondition.NONE, new JMP_ABSOLUTE()),
    EOR_ABSOLUTE( 0x4D, AddressingMode.ABSOLUTE, 3, 4, ExtraCycleCondition.NONE),
    LSR_ABSOLUTE( 0x4E, AddressingMode.ABSOLUTE, 3, 6, ExtraCycleCondition.NONE),

    // -------------------------------------------------------------------------------------------------------------- //

    BVC( 0x50, AddressingMode.RELATIVE, 2, 2, ExtraCycleCondition.BranchOccursOn),
    EOR_INDIRECT_Y( 0x51, AddressingMode.INDIRECT_Y, 2, 5, ExtraCycleCondition.PageBoundaryCrossed),
    NOP_ZEROPAGE_X_1( 0x54, AddressingMode.ZEROPAGE_X, 2, 4, ExtraCycleCondition.NONE, true),
    EOR_ZEROPAGE_X( 0x55, AddressingMode.ZEROPAGE_X, 2, 4, ExtraCycleCondition.NONE),
    LSR_ZEROPAGE_X( 0x56, AddressingMode.ZEROPAGE_X, 2, 6, ExtraCycleCondition.NONE),
    CLI( 0x58, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE, new CLI()),
    EOR_ABSOLUTE_Y( 0x59, AddressingMode.ABSOLUTE_Y, 3, 4, ExtraCycleCondition.PageBoundaryCrossed),
    NOP_IMPLIED_ILLEGAL( 0x5A, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE, true),
    NOP_ABSOLUTE_X_ILLEGAL_2( 0x5C, AddressingMode.ABSOLUTE_X, 3, 4, ExtraCycleCondition.PageBoundaryCrossed, true),
    EOR_ABSOLUTE_X( 0x5D, AddressingMode.ABSOLUTE_X, 3, 4, ExtraCycleCondition.PageBoundaryCrossed),
    LSR_ABSOLUTE_X( 0x5E, AddressingMode.ABSOLUTE_X, 3, 7, ExtraCycleCondition.NONE),

    // -------------------------------------------------------------------------------------------------------------- //

    RTS( 0x60, AddressingMode.IMPLIED, 1, 6, ExtraCycleCondition.NONE),
    ADC_INDIRECT_X( 0x61, AddressingMode.INDIRECT_X, 2, 6, ExtraCycleCondition.NONE),
    NOP_ZEROPAGE_ILLEGAL( 0x64, AddressingMode.ZEROPAGE, 2, 3, ExtraCycleCondition.NONE, true),
    ADC_ZEROPAGE( 0x65, AddressingMode.ZEROPAGE, 2, 3, ExtraCycleCondition.NONE),
    ROR_ZEROPAGE( 0x66, AddressingMode.ZEROPAGE, 2, 5, ExtraCycleCondition.NONE),
    PLA( 0x68, AddressingMode.IMPLIED, 1, 4, ExtraCycleCondition.NONE),
    ADC_IMMEDIATE( 0x69, AddressingMode.IMMEDIATE, 2, 2, ExtraCycleCondition.NONE),
    ROR_ACCUMULATOR( 0x6A, AddressingMode.ACCUMULATOR, 1, 2, ExtraCycleCondition.NONE),
    JMP_ABSOLUTE_INDIRECT( 0x6C, AddressingMode.ABSOLUTE_INDIRECT, 3, 5, ExtraCycleCondition.NONE, new JMP_ABSOLUTE_INDIRECT()),
    ADC_ABSOLUTE( 0x6D, AddressingMode.ABSOLUTE, 3, 4, ExtraCycleCondition.NONE),
    ROR_ABSOLUTE( 0x6E, AddressingMode.ABSOLUTE, 3, 6, ExtraCycleCondition.NONE),

    // -------------------------------------------------------------------------------------------------------------- //

    BVS( 0x70, AddressingMode.RELATIVE, 2, 2, ExtraCycleCondition.BranchOccursOn),
    ADC_INDIRECT_Y( 0x71, AddressingMode.INDIRECT_Y, 2, 5, ExtraCycleCondition.NONE),
    NOP_ZEROPAGE_X_NOEXTRACYCLE_ILLEGAL( 0x74, AddressingMode.ZEROPAGE_X, 2, 4, ExtraCycleCondition.NONE, true),
    ADC_ZEROPAGE_X( 0x75, AddressingMode.ZEROPAGE_X, 2, 4, ExtraCycleCondition.NONE),
    ROR_ZEROPAGE_X( 0x76, AddressingMode.ZEROPAGE_X, 2, 6, ExtraCycleCondition.NONE),
    SEI( 0x78, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE, new SEI()),
    ADC_ABSOLUTE_Y( 0x79, AddressingMode.ABSOLUTE_Y, 3, 4, ExtraCycleCondition.NONE),
    NOP_IMPLIED_NOEXTRACYCLE_ILLEGAL( 0x7A, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE, true),
    RRA_ABSOLUTE_Y_NOEXTRACYCLE_ILLEGAL( 0x7B, AddressingMode.ABSOLUTE_Y, 3, 7, ExtraCycleCondition.NONE, true),
    NOP_ABSOLUTE_X_NOEXTRACYCLE_ILLEGAL( 0x7C, AddressingMode.ABSOLUTE_X, 3, 4, ExtraCycleCondition.NONE, true),
    ADC_ABSOLUTE_X( 0x7D, AddressingMode.ABSOLUTE_X, 3, 4, ExtraCycleCondition.NONE),
    ROR_ABSOLUTE_X( 0x7E, AddressingMode.ABSOLUTE_X, 3, 7, ExtraCycleCondition.NONE),
    RRA_ABSOLUTE_X_1( 0x7F, AddressingMode.ABSOLUTE_X, 3, 7, ExtraCycleCondition.NONE, true),

    // -------------------------------------------------------------------------------------------------------------- //

    NOP_IMMEDIATE_ILLEGAL( 0x80, AddressingMode.IMMEDIATE, 2, 2, ExtraCycleCondition.NONE, true),
    STA_INDIRECT_X( 0x81, AddressingMode.INDIRECT_X, 2, 6, ExtraCycleCondition.NONE),
    SAX_INDIRECT_X_ILLEGAL( 0x83, AddressingMode.INDIRECT_X, 2, 6, ExtraCycleCondition.NONE, true),
    STY_ZEROPAGE( 0x84, AddressingMode.ZEROPAGE, 2, 3, ExtraCycleCondition.NONE),
    STA_ZEROPAGE( 0x85, AddressingMode.ZEROPAGE, 2, 3, ExtraCycleCondition.NONE),
    STX_ZEROPAGE( 0x86, AddressingMode.ZEROPAGE, 2, 3, ExtraCycleCondition.NONE),
    SAX_ZEROPAGE_ILLEGAL( 0x87, AddressingMode.ZEROPAGE, 2, 3, ExtraCycleCondition.NONE, true),
    DEY( 0x88, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE, new DEY()),
    NOP_IMMEDIATE_NOEXTRACYCLE_ILLEGAL( 0x89, AddressingMode.IMMEDIATE, 2, 2, ExtraCycleCondition.NONE, true),
    TXA( 0x8A, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE, new TXA()),
    STY_ABSOLUTE( 0x8C, AddressingMode.ABSOLUTE, 3, 4, ExtraCycleCondition.NONE),
    STA_ABSOLUTE( 0x8D, AddressingMode.ABSOLUTE, 3, 4, ExtraCycleCondition.NONE),
    STX_ABSOLUTE( 0x8E, AddressingMode.ABSOLUTE, 3, 4, ExtraCycleCondition.NONE),
    SAX_ABSOLUTE_1( 0x8F, AddressingMode.ABSOLUTE, 3, 4, ExtraCycleCondition.NONE, true),

    // -------------------------------------------------------------------------------------------------------------- //

    BCC( 0x90, AddressingMode.RELATIVE, 2, 2, ExtraCycleCondition.BranchOccursOn),
    STA_INDIRECT_Y( 0x91, AddressingMode.INDIRECT_Y, 2, 6, ExtraCycleCondition.NONE),
    JAM_ILLEGAL( 0x92, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE, true),
    STY_ZEROPAGE_X( 0x94, AddressingMode.ZEROPAGE_X, 2, 4, ExtraCycleCondition.NONE),
    STA_ZEROPAGE_X( 0x95, AddressingMode.ZEROPAGE_X, 2, 4, ExtraCycleCondition.NONE),
    STX_ZEROPAGE_Y( 0x96, AddressingMode.ZEROPAGE_Y, 2, 4, ExtraCycleCondition.NONE),
    SAX_ZEROPAGE_Y_ILLEGAL( 0x97, AddressingMode.ZEROPAGE_Y, 2, 4, ExtraCycleCondition.NONE, true),
    TYA( 0x98, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE, new TYA()),
    STA_ABSOLUTE_Y( 0x99, AddressingMode.ABSOLUTE_Y, 3, 5, ExtraCycleCondition.NONE),
    TXS( 0x9A, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE, new TXS()),
    STA_ABSOLUTE_X( 0x9D, AddressingMode.ABSOLUTE_X, 3, 5, ExtraCycleCondition.NONE),

    // -------------------------------------------------------------------------------------------------------------- //

    LDY_IMMEDIATE( 0xA0, AddressingMode.IMMEDIATE, 2, 2, ExtraCycleCondition.NONE),
    LDA_INDIRECT_X( 0xA1, AddressingMode.INDIRECT_X, 2, 6, ExtraCycleCondition.NONE),
    LDX_IMMEDIATE( 0xA2, AddressingMode.IMMEDIATE, 2, 2, ExtraCycleCondition.NONE),
    LAX_INDIRECT_X_ILLEGAL( 0xA3, AddressingMode.INDIRECT_X, 2, 6, ExtraCycleCondition.NONE, true),
    LDY_ZEROPAGE( 0xA4, AddressingMode.ZEROPAGE, 2, 3, ExtraCycleCondition.NONE),
    LDA_ZEROPAGE( 0xA5, AddressingMode.ZEROPAGE, 2, 3, ExtraCycleCondition.NONE),
    LDX_ZEROPAGE( 0xA6, AddressingMode.ZEROPAGE, 2, 3, ExtraCycleCondition.NONE),
    LAX_ZEROPAGE_ILLEGAL( 0xA7, AddressingMode.ZEROPAGE, 2, 3, ExtraCycleCondition.NONE, true),
    TAY( 0xA8, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE, new TAY()),
    LDA_IMMEDIATE( 0xA9, AddressingMode.IMMEDIATE, 2, 2, ExtraCycleCondition.NONE),
    TAX( 0xAA, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE, new TAX()),
    LDY_ABSOLUTE( 0xAC, AddressingMode.ABSOLUTE, 3, 4, ExtraCycleCondition.NONE),
    LDA_ABSOLUTE( 0xAD, AddressingMode.ABSOLUTE, 3, 4, ExtraCycleCondition.NONE),
    LDX_ABSOLUTE( 0xAE, AddressingMode.ABSOLUTE, 3, 4, ExtraCycleCondition.NONE),
    LAX_ABSOLUTE_ILLEGAL( 0xAF, AddressingMode.ABSOLUTE, 3, 4, ExtraCycleCondition.NONE, true),

    // -------------------------------------------------------------------------------------------------------------- //

    BCS( 0xB0, AddressingMode.RELATIVE, 2, 2, ExtraCycleCondition.BranchOccursOn),
    LDA_INDIRECT_Y( 0xB1, AddressingMode.INDIRECT_Y, 2, 5, ExtraCycleCondition.PageBoundaryCrossed),
    LAX_INDIRECT_Y_ILLEGAL( 0xB3, AddressingMode.INDIRECT_Y, 2, 5, ExtraCycleCondition.PageBoundaryCrossed, true),
    LDY_ZEROPAGE_X( 0xB4, AddressingMode.ZEROPAGE_X, 2, 4, ExtraCycleCondition.NONE),
    LDA_ZEROPAGE_X( 0xB5, AddressingMode.ZEROPAGE_X, 2, 4, ExtraCycleCondition.NONE),
    LDX_ZEROPAGE_Y( 0xB6, AddressingMode.ZEROPAGE_Y, 2, 4, ExtraCycleCondition.NONE),
    LAX_ZEROPAGE_Y_ILLEGAL( 0xB7, AddressingMode.ZEROPAGE_Y, 2, 4, ExtraCycleCondition.NONE, true),
    CLV( 0xB8, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE, new CLV()),
    LDA_ABSOLUTE_Y( 0xB9, AddressingMode.ABSOLUTE_Y, 3, 4, ExtraCycleCondition.PageBoundaryCrossed),
    TSX( 0xBA, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE, new TSX()),
    LDY_ABSOLUTE_X( 0xBC, AddressingMode.ABSOLUTE_X, 3, 4, ExtraCycleCondition.PageBoundaryCrossed),
    LDA_ABSOLUTE_X( 0xBD, AddressingMode.ABSOLUTE_X, 3, 4, ExtraCycleCondition.PageBoundaryCrossed),
    LDX_ABSOLUTE_Y( 0xBE, AddressingMode.ABSOLUTE_Y, 3, 4, ExtraCycleCondition.PageBoundaryCrossed),
    LAX_ABSOLUTE_Y_ILLEGAL( 0xBF, AddressingMode.ABSOLUTE_Y, 3, 4, ExtraCycleCondition.PageBoundaryCrossed, true),

    // -------------------------------------------------------------------------------------------------------------- //

    CPY_IMMEDIATE( 0xC0, AddressingMode.IMMEDIATE, 2, 2, ExtraCycleCondition.NONE),
    CMP_INDIRECT_X( 0xC1, AddressingMode.INDIRECT_X, 2, 6, ExtraCycleCondition.NONE, new CMP_INDIRECT_X()),
    CPY_ZEROPAGE( 0xC4, AddressingMode.ZEROPAGE, 2, 3, ExtraCycleCondition.NONE),
    CMP_ZEROPAGE( 0xC5, AddressingMode.ZEROPAGE, 2, 2, ExtraCycleCondition.NONE, new CMP_ZEROPAGE()),
    DEC_ZEROPAGE( 0xC6, AddressingMode.ZEROPAGE, 2, 5, ExtraCycleCondition.NONE),
    DCP_ZEROPAGE_ILLEGAL( 0xC7, AddressingMode.ZEROPAGE, 2, 5, ExtraCycleCondition.NONE, true),
    INY( 0xC8, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE, new INY()),
    CMP_IMMEDIATE( 0xC9, AddressingMode.IMMEDIATE, 2, 2, ExtraCycleCondition.NONE, new CMP_IMEDIATE()),
    DEX( 0xCA, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE, new DEX()),
    DCP_INDIRECT_X_ILLEGAL( 0xC3, AddressingMode.INDIRECT_X, 2, 8, ExtraCycleCondition.NONE, true),
    CPY_ABSOLUTE( 0xCC, AddressingMode.ABSOLUTE, 3, 4, ExtraCycleCondition.NONE),
    CMP_ABSOLUTE( 0xCD, AddressingMode.ABSOLUTE, 3, 4, ExtraCycleCondition.NONE, new CMP_ABSOLUTE()),
    DEC_ABSOLUTE( 0xCE, AddressingMode.ABSOLUTE, 3, 6, ExtraCycleCondition.NONE),
    DCP_ABSOLUTE_ILLEGAL( 0xCF, AddressingMode.ABSOLUTE, 3, 6, ExtraCycleCondition.NONE, true),

    // -------------------------------------------------------------------------------------------------------------- //

    BNE_RELATIVE( 0xD0, AddressingMode.RELATIVE, 2, 2, ExtraCycleCondition.BranchOccursOn),
    CMP_INDIRECT_Y( 0xD1, AddressingMode.INDIRECT_Y, 2, 5, ExtraCycleCondition.PageBoundaryCrossed, new CMP_INDIRECT_Y()),
    DCP_INDIRECT_Y_ILLEGAL( 0xD3, AddressingMode.INDIRECT_Y, 2, 8, ExtraCycleCondition.NONE, true),
    NOP_ZEROPAGE_X_ILLEGAL_2( 0xD4, AddressingMode.ZEROPAGE_X, 2, 4, ExtraCycleCondition.NONE, true),
    CMP_ZEROPAGE_X( 0xD5, AddressingMode.ZEROPAGE_X, 2, 4, ExtraCycleCondition.NONE, new CMP_ZEROPAGE_X()),
    DEC_ZEROPAGE_X( 0xD6, AddressingMode.ZEROPAGE_X, 2, 6, ExtraCycleCondition.NONE),
    DCP_ZEROPAGE_X_ILLEGAL( 0xD7, AddressingMode.ZEROPAGE_X, 2, 6, ExtraCycleCondition.NONE, true),
    CLD( 0xD8, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE, new CLD()),
    CMP_ABSOLUTE_Y( 0xD9, AddressingMode.ABSOLUTE_Y, 3, 4, ExtraCycleCondition.PageBoundaryCrossed, new CMP_ABSOLUTE_Y()),
    NOP_IMPLIED_ILLEGAL_2( 0xDA, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE, true),
    DCP_ABSOLUTE_Y_ILLEGAL( 0xDB, AddressingMode.ABSOLUTE_Y, 3, 7, ExtraCycleCondition.NONE, true),
    NOP_ABSOLUTE_X_ILLEGAL_3( 0xDC, AddressingMode.ABSOLUTE_X, 3, 4, ExtraCycleCondition.PageBoundaryCrossed, true),
    CMP_ABSOLUTE_X( 0xDD, AddressingMode.ABSOLUTE_X, 3, 4, ExtraCycleCondition.PageBoundaryCrossed, new CMP_ABSOLUTE_X()),
    DEC_ABSOLUTE_X( 0xDE, AddressingMode.ABSOLUTE_X, 3, 7, ExtraCycleCondition.NONE),
    DCP_ABSOLUTE_X_ILLEGAL( 0xDF, AddressingMode.ABSOLUTE_X, 3, 7, ExtraCycleCondition.NONE, true),

    // -------------------------------------------------------------------------------------------------------------- //

    CPX_IMMEDIATE( 0xE0, AddressingMode.IMMEDIATE, 2, 2, ExtraCycleCondition.NONE),
    SBC_INDIRECT_X( 0xE1, AddressingMode.INDIRECT_X, 2, 6, ExtraCycleCondition.NONE),
    ISB_INDIRECT_X_ILLEGAL( 0xE3, AddressingMode.INDIRECT_X, 2, 8, ExtraCycleCondition.NONE, true),
    CPX_ZEROPAGE( 0xE4, AddressingMode.ZEROPAGE, 2, 3, ExtraCycleCondition.NONE),
    SBC_ZEROPAGE( 0xE5, AddressingMode.ZEROPAGE, 2, 3, ExtraCycleCondition.NONE),
    INC_ZEROPAGE( 0xE6, AddressingMode.ZEROPAGE, 2, 5, ExtraCycleCondition.NONE),
    ISB_ZEROPAGE_ILLEGAL( 0xE7, AddressingMode.ZEROPAGE, 2, 5, ExtraCycleCondition.NONE, true),
    INX( 0xE8, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE, new INX()),
    SBC_IMMEDIATE( 0xE9, AddressingMode.IMMEDIATE, 2, 2, ExtraCycleCondition.NONE),
    NOP( 0xEA, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE, new NOP()),
    SBC_IMMEDIATE_ILLEGAL( 0xEB, AddressingMode.IMMEDIATE, 2, 2, ExtraCycleCondition.NONE, true),
    CPX_ABSOLUTE( 0xEC, AddressingMode.ABSOLUTE, 3, 4, ExtraCycleCondition.NONE),
    SBC_ABSOLUTE( 0xED, AddressingMode.ABSOLUTE, 3, 4, ExtraCycleCondition.NONE),
    INC_ABSOLUTE( 0xEE, AddressingMode.ABSOLUTE, 3, 6, ExtraCycleCondition.NONE),
    ISB_ABSOLUTE_ILLEGAL( 0xEF, AddressingMode.ABSOLUTE, 3, 6, ExtraCycleCondition.NONE, true),

    // -------------------------------------------------------------------------------------------------------------- //

    EQ_RELATIVE( 0xF0, AddressingMode.RELATIVE, 2, 2, ExtraCycleCondition.BranchOccursOn),
    SBC_INDIRECT_Y( 0xF1, AddressingMode.INDIRECT_Y, 2, 5, ExtraCycleCondition.PageBoundaryCrossed),
    ISB_INDIRECT_Y_ILLEGAL( 0xF3, AddressingMode.INDIRECT_Y, 2, 8, ExtraCycleCondition.NONE, true),
    NOP_ZEROPAGE_X_ILLEGAL_3( 0xF4, AddressingMode.ZEROPAGE_X, 2, 4, ExtraCycleCondition.NONE, true),
    SBC_ZEROPAGE_X( 0xF5, AddressingMode.ZEROPAGE_X, 2, 4, ExtraCycleCondition.NONE),
    INC_ZEROPAGE_X( 0xF6, AddressingMode.ZEROPAGE_X, 2, 6, ExtraCycleCondition.NONE),
    ISB_ZEROPAGE_X_ILLEGAL( 0xF7, AddressingMode.ZEROPAGE_X, 2, 6, ExtraCycleCondition.NONE, true),
    SED_IMPLIED( 0xF8, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE, new SED()),
    SBC_ABSOLUTE_Y( 0xF9, AddressingMode.ABSOLUTE_Y, 3, 4, ExtraCycleCondition.PageBoundaryCrossed),
    NOP_IMPLIED_ILLEGAL_4( 0xFA, AddressingMode.IMPLIED, 1, 2, ExtraCycleCondition.NONE, true),
    ISB_ABSOLUTE_Y_ILLEGAL( 0xFB, AddressingMode.ABSOLUTE_Y, 3, 7, ExtraCycleCondition.NONE, true),
    NOP_ABSOLUTE_X_ILLEGAL_4( 0xFC, AddressingMode.ABSOLUTE_X, 3, 4, ExtraCycleCondition.PageBoundaryCrossed, true),
    SBC_ABSOLUTE_X( 0xFD, AddressingMode.ABSOLUTE_X, 3, 4, ExtraCycleCondition.PageBoundaryCrossed),
    INC_ABSOLUTE_X( 0xFE, AddressingMode.ABSOLUTE_X, 3, 7, ExtraCycleCondition.NONE, new INC_ABSOLUTE_X()),
    ISB_ABSOLUTE_X_ILLEGAL( 0xFF, AddressingMode.ABSOLUTE_X, 3, 7, ExtraCycleCondition.NONE, true);

    // -------------------------------------------------------------------------------------------------------------- //

    private final int code;

    private final Parameters parameters;

    private final ExecutableInstruction executableInstruction;

    Instruction (int code, AddressingMode addressingMode, int length, int cycles,
                 ExtraCycleCondition extraCycleCondition) {
        this.code = code;
        this.parameters = new Parameters(addressingMode, length, cycles, extraCycleCondition);
        this.executableInstruction = null;
    }

    Instruction (int code, AddressingMode addressingMode, int length, int cycles,
                 ExtraCycleCondition extraCycleCondition, boolean isIllegal) {
        this.code = code;
        this.parameters = new Parameters(addressingMode, length, cycles, extraCycleCondition, isIllegal);
        this.executableInstruction = null;
    }

    Instruction (int code, AddressingMode addressingMode, int length, int cycles,
                 ExtraCycleCondition extraCycleCondition,  ExecutableInstruction executableInstruction) {
        this.code = code;
        this.parameters = new Parameters(addressingMode, length, cycles, extraCycleCondition);
        this.executableInstruction = executableInstruction;
    }

    public int getCode() {
        return code;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public ExecutableInstruction getExecutableInstruction() {
        return executableInstruction;
    }
}
