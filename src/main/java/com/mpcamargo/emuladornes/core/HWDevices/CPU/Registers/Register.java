package com.mpcamargo.emuladornes.core.HWDevices.CPU.Registers;

public abstract class Register {
    private int value;

    public void setValue(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
