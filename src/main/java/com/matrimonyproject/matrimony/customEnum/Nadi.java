package com.matrimonyproject.matrimony.customEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
@Getter
public enum Nadi {

    UNSPECIFIED("Unspecified", "अज्ञात"),
    ADHYA("Adhya", "आद्य"),
    MADHYA("Madhya", "मध्य"),
    ANTYA("Antya", "अंत्य");

    private final String englishLabel;
    private final String marathiLabel;


    public String getMarathiLabel() {
        return this.marathiLabel;
    }
    public String getEnglishLabel() {
        return this.englishLabel;
    }
}