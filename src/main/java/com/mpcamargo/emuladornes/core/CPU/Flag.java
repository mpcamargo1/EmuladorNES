package com.mpcamargo.emuladornes.core.CPU;

public enum Flag {
    CARRY((byte) 0x0),
    ZERO((byte) 0x1),
    INTERRUPT((byte) 0x2),
    DECIMAL((byte) 0x3),
    BREAK((byte) 0x4),
    UNUSED((byte) 0x5),
    OVERFLOW((byte) 0x6),
    NEGATIVE((byte) 0x7);

    private final byte bit;

    Flag(byte bit) {
        this.bit = bit;
    }

    public int getBit() {
        return bit;
    }
}
