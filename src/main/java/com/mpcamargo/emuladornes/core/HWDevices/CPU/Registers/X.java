package com.mpcamargo.emuladornes.core.HWDevices.CPU.Registers;

public class X {
    private int value;

    public X(int value) {
        this.value = value;
    }

    public void setValue(byte value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
