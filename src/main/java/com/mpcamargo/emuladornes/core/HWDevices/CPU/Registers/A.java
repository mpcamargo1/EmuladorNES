package com.mpcamargo.emuladornes.core.HWDevices.CPU.Registers;

public class A {
    private int value;

    public void setValue(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public A (int value) {
        this.value = value;
    }
}
