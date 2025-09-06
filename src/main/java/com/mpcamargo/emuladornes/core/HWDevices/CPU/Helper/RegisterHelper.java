package com.mpcamargo.emuladornes.core.HWDevices.CPU.Helper;

import com.mpcamargo.emuladornes.core.HWDevices.CPU.Flag.Flag;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Registers.A;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Registers.Register;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Registers.X;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Registers.Y;

public class RegisterHelper {

    private A A;
    private X X;
    private Y Y;

    private FlagHelper flagHelper;
    private StackHelper stackHelper;

    public RegisterHelper (FlagHelper flagHelper, StackHelper stackHelper) {
        this.flagHelper = flagHelper;
        this.stackHelper = stackHelper;

        this.A = new A(0x00);
        this.X = new X(0x00);
        this.Y = new Y(0x00);
    }

    public void transferRegisterAToX() {
        transferRegister(this.A, this.X);
    }

    public void transferRegisterAToY() {
        transferRegister(this.A, this.Y);
    }

    public void transferRegisterXToA() {
        transferRegister(this.X, this.A);
    }

    public void transferRegisterYToA() {
        transferRegister(this.Y, this.A);
    }

    public void transferRegisterXToStackPointer() {
        stackHelper.updateAddressStack(X.getValue());
    }

    public void transferStackPointerToX() {
        int pointerAddress = stackHelper.getPointerAddressStack();
        X.setValue(pointerAddress);
    }

    public void incrementX() {
        X.setValue(X.getValue() + 1);
    }

    public void incrementY(){
        Y.setValue(Y.getValue() + 1);
    }

    public void decrementX() {
        X.setValue(X.getValue() - 1);
    }

    public void decrementY() {
        Y.setValue(T.getValue() - 1);
    }

    private void transferRegister(Register origin, Register destination) {
        int value = origin.getValue();

        destination.setValue(value);

        flagHelper.removeFlag(Flag.ZERO);
        flagHelper.removeFlag(Flag.NEGATIVE);

        if (value == 0) {
            flagHelper.addFlag(Flag.ZERO);
            return;
        }

        if (value < 0) {
            flagHelper.addFlag(Flag.NEGATIVE);
        }

    }

    public void reset() {
        A.setValue((byte) 0x00);
        X.setValue((byte) 0x00);
        Y.setValue((byte) 0x00);
    }

}
