package com.matrimonyproject.matrimony.customEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MartialStatus {
    Unmarried_Boy("Unmarried Boy"),
    Unmarried_Girl("Unmarried Girl"),
    Divorcee_Boy("Divorcee Boy/Widower"),
    Divorcee_Girl("Divorcee Girl/Widow");
    private final String label;


    public String getLabel() {
        return label;
    }
}
