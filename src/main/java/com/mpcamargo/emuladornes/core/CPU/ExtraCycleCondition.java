package com.mpcamargo.emuladornes.core.CPU;

public enum ExtraCycleCondition {
    NONE,
    PageBoundaryCrossed,
    BranchOccursOn;

    ExtraCycleCondition() {

    }
}
