package com.matrimonyproject.matrimony.customEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Charan {
    Unspecified(0),ONE(1),TWO(2),Three(3),Four(4);
    private final int value;
    public int getValue() {
        return value;
    }
}
