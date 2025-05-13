package com.matrimonyproject.matrimony.customEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Gan {

    UNSPECIFIED("Unspecified", "अज्ञात"),
    DEV_GAN("Dev Gan", "देव गण"),
    MANUSHAY_GAN("Manushay Gan", "मनुष्य गण"),
    RAKSHAS_GAN("Rakshas Gan", "राक्षस गण");

    private final String marathiName;
    private final String englishName;
    public String getEnglishName() {
        return englishName;
    }
    public String getMarathiName() {
        return marathiName;
    }

}
