package com.matrimonyproject.matrimony.customEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Mangal {

    YES("Yes", "हो"),
    NO("No", "नाही"),
    SAUMYA("Saumya", "सौम्य"),
    NIRDOSH("Nirdosh", "निर्दोष"),
    NOT_KNOWN("Not Known", "माहित नाही");

    private final String englishLabel;
    private final String marathiLabel;


    public String getMarathiLabel() {
        return this.marathiLabel;
    }
    public String getEnglishLabel() {
        return this.englishLabel;
    }
}
