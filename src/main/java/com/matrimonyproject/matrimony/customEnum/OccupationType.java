package com.matrimonyproject.matrimony.customEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OccupationType {
    SELECT("Select", "निवडा"),
    GOVERNMENT("Government Job", "सरकारी नोकरी"),
    PRIVATE("Private Job", "खाजगी नोकरी"),
    BUSINESS("Business", "व्यवसाय"),
    SELF_EMPLOYED("Self Employed", "स्व-नियोजित"),
    FARMING("Farming", "शेती"),
    STUDENT("Student", "विद्यार्थी"),
    HOMEMAKER("Homemaker", "गृहिणी"),
    RETIRED("Retired", "निवृत्त"),
    ABROAD("Working Abroad", "परदेशात कार्यरत"),
    OTHER("Other", "इतर");

    @Getter
    private final String englishLabel;
    private final String marathiLabel;
    public String getLabel() {
        return this.marathiLabel;
    }

    public String getMarathiLabel() {
        return this.marathiLabel;
    }
    public String getEnglishLabel() {
        return this.englishLabel;
    }

}
