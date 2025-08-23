package com.mpcamargo.emuladornes.core.CPU.Flag;

public enum Flag {
    CARRY(0),
    ZERO(1),
    INTERRUPT(2),
    DECIMAL(3),
    BREAK(4),
    UNUSED(5),
    OVERFLOW(6),
    NEGATIVE(7);

    private final int location;

    Flag(int location) {
        this.location = location;
    }

    public int getLocation() {
        return location;
    }
}
