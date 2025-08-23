package com.mpcamargo.emuladornes.core.CPU.Instruction;

public class Parameters {

    private final AddressingMode addressingMode;

    private final int length;

    private final int cycle;

    private final ExtraCycleCondition extraCycleCondition;

    private final boolean isIllegal;

    public Parameters(AddressingMode addressingMode, int length, int cycle, ExtraCycleCondition extraCycleCondition) {
        this.addressingMode = addressingMode;
        this.length = length;
        this.cycle = cycle;
        this.extraCycleCondition = extraCycleCondition;
        this.isIllegal = false;
    }

    public Parameters(AddressingMode addressingMode, int length, int cycle, ExtraCycleCondition extraCycleCondition,
                      boolean isIllegal) {
        this.addressingMode = addressingMode;
        this.length = length;
        this.cycle = cycle;
        this.extraCycleCondition = extraCycleCondition;
        this.isIllegal = isIllegal;
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
