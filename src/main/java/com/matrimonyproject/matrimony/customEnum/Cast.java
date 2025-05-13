package com.matrimonyproject.matrimony.customEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Cast {

    MARATHA("Maratha", "मराठा"),
    KULI("96_Kuli", "९६ कुली"),
    KUNBI("Kunbi", "कुणबी"),
    DESHMUKH_MARATHA("Deshmukh Maratha", "देशमुख मराठा"),
    KULI_MARATHA("96 Kuli Maratha", "९६ कुली मराठा"),
    TIRLE_KUNBI("Tirle Kunbi", "तिरळे कुणबी"),
    DOES_NOT_MATTER("Does not matter", "सर्व चालेल");

    private final String englishName;
    private final String marathiName;

}
