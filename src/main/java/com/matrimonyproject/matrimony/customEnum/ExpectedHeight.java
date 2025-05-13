package com.matrimonyproject.matrimony.customEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ExpectedHeight {
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7);
    private final int value;
    public double toDouble() {
        return (double) value;
    }

}
