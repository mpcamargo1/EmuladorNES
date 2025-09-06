package com.mpcamargo.emuladornes.core.HWDevices.CPU.Helper;

import com.mpcamargo.emuladornes.core.HWDevices.CPU.Flag.Flag;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Stack.Stack;

public class StackHelper {

    private Stack stack;

    public StackHelper(BusHelper busHelper) {
        this.stack = new Stack(busHelper);
    }

    public void updateAddressStack(int value) {
        stack.updateAddress(value);
    }

    public void pushStatus(Flag flag) throws Exception {
        stack.push(1 << flag.getLocation());
    }

    public void push(int value) throws Exception {
        stack.push(value);
    }

}
