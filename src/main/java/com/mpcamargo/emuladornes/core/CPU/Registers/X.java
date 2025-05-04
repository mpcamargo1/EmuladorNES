package com.mpcamargo.emuladornes.core.CPU.Registers;

public class X {
    private byte value;

    public X(byte value) {
        this.value = value;
    }

    public void setValue(byte value){
        this.value = value;
    }

    public byte getValue() {
        return value;
    }
}
