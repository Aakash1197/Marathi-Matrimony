package com.matrimonyproject.matrimony.customEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Diet {
    N_A("N/A"),Vegetarian("Vegetarian"),Non_Vegetarian("Non Vegetarian");
    private final String label;

    public String getLabel() {
        return label;
    }
}
