package com.mpcamargo.emuladornes.core.HWDevices.CPU.Instruction;

public enum ExtraCycleCondition {
    NONE,
    PageBoundaryCrossed,
    BranchOccursOn;

    ExtraCycleCondition() {

    }
}
