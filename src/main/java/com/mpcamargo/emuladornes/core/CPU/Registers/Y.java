package com.mpcamargo.emuladornes.core.CPU.Registers;

public class Y {
    private byte value;

    public Y(byte value) {
        this.value = value;
    }

    public void setValue(byte value) {
        this.value = value;
    }

    public byte getValue() {
        return value;
    }
}
