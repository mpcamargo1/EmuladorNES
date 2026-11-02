package com.mpcamargo.emuladornes.core.HWDevices.CPU.Helper;

import com.mpcamargo.emuladornes.core.HWDevices.CPU.Stack.Stack;

public class StackHelper {

    private Stack stack;

    public StackHelper(BusHelper busHelper) {
        this.stack = new Stack(busHelper);
    }

    public void updateAddressStack(int value) {
        stack.updateAddress(value);
    }

    public void push(int value) {
        stack.push(value);
    }

    public void push16(int value) {
        stack.push16(value);
    }
    
    public int getPointerAddressStack() {
        return stack.getPointerAddress();
    }

}
