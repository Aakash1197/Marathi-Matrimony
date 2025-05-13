package com.matrimonyproject.matrimony.customEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Nakshatra {

    UNSPECIFIED("Unspecified", "अज्ञात"),
    ASHWINI("Ashwini", "अश्विनी"),
    BHARANI("Bharani", "भारणी"),
    KRITTIKA("Krittika", "कृतिका"),
    ROHINI("Rohini", "रोहिणी"),
    MRIGASHIRSHA("Mrigashirsha", "मृगशिरा"),
    ARDRA("Ardra", "आर्द्रा"),
    PUNARVASU("Punarvasu", "पुनर्वसु"),
    PUSHYA("Pushya", "पुष्य"),
    ASHLESHA("Ashlesha", "अश्लेषा"),
    MAGHA("Magha", "मघा"),
    PURVA_PHALGUNI("Purva Phalguni", "पूर्व फाल्गुनी"),
    UTTARA_PHALGUNI("Uttara Phalguni", "उत्तर फाल्गुनी"),
    HASTA("Hasta", "हस्त"),
    CHITRA("Chitra", "चित्रा"),
    SWATI("Swati", "स्वाती"),
    VISHAKHA("Vishakha", "विशाखा"),
    ANURADHA("Anuradha", "अनुराधा"),
    JYESHTHA("Jyeshtha", "ज्येष्ठा"),
    MOOLA("Moola", "मूल"),
    PURVA_ASHADHA("Purva Ashadha", "पूर्व अशाढा"),
    UTTARA_ASHADHA("Uttara Ashadha", "उत्तर अशाढा"),
    SHRAVANA("Shravana", "श्रवण"),
    DHANISHTA("Dhanishta", "धनिष्ठा"),
    SHATABHISHA("Shatabhisha", "शतभिषा"),
    PURVA_BHADRAPADA("Purva Bhadrapada", "पूर्व भाद्रपद"),
    UTTARA_BHADRAPADA("Uttara Bhadrapada", "उत्तर भाद्रपद"),
    REVATI("Revati", "रेवती");

    private final String englishLabel;
    private final String marathiLabel;


    public String getMarathiLabel() {
        return this.marathiLabel;
    }
    public String getEnglishLabel() {
        return this.englishLabel;
    }

}