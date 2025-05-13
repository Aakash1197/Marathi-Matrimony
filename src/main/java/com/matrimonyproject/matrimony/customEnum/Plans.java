package com.matrimonyproject.matrimony.customEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Plans {
    FREE("Free"),
    BASIC("Basic"),
    PREMIUM("Premium"),
    ADMIN("Admin");

    private final String planName;
}
