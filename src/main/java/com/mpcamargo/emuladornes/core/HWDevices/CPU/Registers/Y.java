package com.mpcamargo.emuladornes.core.HWDevices.CPU.Registers;

public class Y {
    private int value;

    public Y(int value) {
        this.value = value;
    }

    public void setValue(byte value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
