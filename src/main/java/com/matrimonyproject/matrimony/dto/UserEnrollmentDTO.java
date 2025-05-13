package com.matrimonyproject.matrimony.dto;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Setter
@Getter

public class UserEnrollmentDTO {
//    @JsonProperty("AddressDTO")
    @Valid
    private AddressDTO address;
//    @JsonProperty("PersonalDetailsDTO")
    @Valid
    private PersonalDetailsDTO personalDetailsDTO;
//    @JsonProperty("EducationalDetailsDTO")
    @Valid
    private EducationalDetailsDTO educationalDetailsDTO;
//    @JsonProperty("ExpectationDTO")
    @Valid
    private ExpectationDTO expectationDTO;
//    @JsonProperty("FamilyBackgroundDTO")
    @Valid
    private FamilyBackgroundDTO familyBackgroundDTO;
//    @JsonProperty("HeroScopeDetailsDTO")
    @Valid
    private HeroScopeDetailsDTO heroScopeDetailsDTO;
//    @JsonProperty("PhotosDTO")
    @Valid
    private PhotosDTO  photosDTO;
}
