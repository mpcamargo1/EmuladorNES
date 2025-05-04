package com.mpcamargo.emuladornes.core.CPU.Registers;

public class A {
    private byte value;

    public void setValue(byte value){
        this.value = value;
    }

    public byte getValue() {
        return value;
    }

    public A (byte value) {
        this.value = value;
    }
}
