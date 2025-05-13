package com.matrimonyproject.matrimony.customEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Rashi {
    MESH("Aries", "मेष"),
    VRISHABH("Taurus", "वृषभ"),
    MITHUN("Gemini", "मिथुन"),
    KARK("Cancer", "कर्क"),
    SINGH("Leo", "सिंह"),
    KANYA("Virgo", "कन्या"),
    TULA("Libra", "तुला"),
    VRISCHIK("Scorpio", "वृश्चिक"),
    DHANU("Sagittarius", "धनु"),
    MAKAR("Capricorn", "मकर"),
    KUMBH("Aquarius", "कुंभ"),
    MEEN("Pisces", "मीन");

    private final String englishName;
    private final String marathiName;


    public String getEnglishName() {
        return englishName;
    }

    public String getMarathiName() {
        return marathiName;
    }



}
