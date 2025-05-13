package com.matrimonyproject.matrimony.customEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Complexion {

    FAIR("Fair", "गोरा"),
    GORA("Gora", "गोरा"),
    SAWALA("Sawala", "सावळा"),
    GAVAHL("Gavahl", "गव्हाळ"),
    NIMGORA("Nigora", "निम्मा गोरा"),
    BLACK("Black", "काळा"),
    GORA_SMART("Gora Smart", "गोरा स्मार्ट"),
    FAIR_SMART("Fair Smart", "गोरा देखणा"),
    GAVHAL_SMART("Gavhal Smart", "गव्हाळ स्मार्ट");

    private final String englishLabel;
    private final String marathiLabel;


    public String getMarathiLabel() {
        return this.marathiLabel;
    }
    public String getEnglishLabel() {
        return this.englishLabel;
    }

}
