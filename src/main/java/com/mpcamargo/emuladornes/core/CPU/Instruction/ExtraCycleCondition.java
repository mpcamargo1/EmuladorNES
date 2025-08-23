package com.mpcamargo.emuladornes.core.CPU.Instruction;

public enum ExtraCycleCondition {
    NONE,
    PageBoundaryCrossed,
    BranchOccursOn;

    ExtraCycleCondition() {

    }
}
