package com.mpcamargo.emuladornes.core.HWDevices.CPU.Helper;

import com.mpcamargo.emuladornes.constants.NESConstants;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Flag.Flag;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Registers.A;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Registers.Register;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Registers.X;
import com.mpcamargo.emuladornes.core.HWDevices.CPU.Registers.Y;
import com.mpcamargo.emuladornes.core.NES.NES;

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

    public void updateX(int value) {
        X.setValue(value & 0xFF);
    }

    public void updateY(int value) {
        Y.setValue(value & 0xFF);
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

        if ((value & NESConstants.MASK_BIT_7) != 0) {
            flagHelper.addFlag(Flag.NEGATIVE);
        }

    }

    public void reset() {
        A.setValue((byte) 0x00);
        X.setValue((byte) 0x00);
        Y.setValue((byte) 0x00);
    }

    public int getValueRegisterA() {
        return this.A.getValue();
    }

    public int getValueRegisterX() {
        return this.X.getValue();
    }

    public int getValueRegisterY() {
        return this.Y.getValue();
    }

    public void doCompareAccumulator(int data) {

        flagHelper.removeFlag(Flag.ZERO);
        flagHelper.removeFlag(Flag.NEGATIVE);
        flagHelper.removeFlag(Flag.CARRY);

        int valueRegisterA = getValueRegisterA();

        if (data == valueRegisterA) {
            flagHelper.addFlag(Flag.ZERO);
        }

        if (((valueRegisterA - data) & NESConstants.MASK_BIT_7) != 0) {
            flagHelper.addFlag(Flag.NEGATIVE);
        }

        if (valueRegisterA >= data) {
            flagHelper.addFlag(Flag.CARRY);
        }
    }

}
