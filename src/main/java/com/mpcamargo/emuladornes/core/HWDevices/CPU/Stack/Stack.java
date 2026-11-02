package com.mpcamargo.emuladornes.core.HWDevices.CPU.Stack;

import com.mpcamargo.emuladornes.core.Bus;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Helper.BusHelper;

public class Stack {

    private BusHelper busHelper;

    private int pointerAddress = 0xFD;

    // Stack Base
    private int offsetMemory = 0x0100;

    public int pop () {
        pointerAddress = (pointerAddress + 1 ) & 0xFF;
        int value = busHelper.read(offsetMemory + pointerAddress);

        return value;
    }

    public void push(int value)  {
        busHelper.write(offsetMemory + pointerAddress, value);
        pointerAddress = (pointerAddress - 1) & 0xFF;
    }

    public void push16(int value) {
        push((value >> 8)); // Parte alta
        push(value);  // Parte baixa
    }

    public int pop16() {
        int parteBaixa = pop(); // Parte alta
        int parteAlta = pop();  // Parte baixa
        return (parteAlta << 8) | parteBaixa;
    }

    public void updateAddress(int value) {
        this.pointerAddress = value;
    }

    public int getPointerAddress() {
        return this.pointerAddress;
    }

    public Stack (BusHelper busHelper) {
        this.busHelper = busHelper;
    }
}
