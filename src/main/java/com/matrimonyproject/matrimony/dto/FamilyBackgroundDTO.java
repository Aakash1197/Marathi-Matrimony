package com.matrimonyproject.matrimony.dto;

import com.matrimonyproject.matrimony.constant.MatrimonyConstant;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FamilyBackgroundDTO {

    @NotNull(message = MatrimonyConstant.HAS_FATHER_REQUIRED) // Reference constant
    private Boolean hasFather;

    @NotNull(message = MatrimonyConstant.HAS_MOTHER_REQUIRED) // Reference constant
    private Boolean hasMother;

    @Min(value = 0, message = MatrimonyConstant.BROTHERS_COUNT_MIN) // Reference constant
    @Max(value = 10, message = MatrimonyConstant.BROTHERS_COUNT_MAX) // Reference constant
    private int brothersCount;

    @Min(value = 0, message = MatrimonyConstant.MARRIED_BROTHERS_COUNT_MIN) // Reference constant
    @Max(value = 10, message = MatrimonyConstant.MARRIED_BROTHERS_COUNT_MAX) // Reference constant
    private int marriedBrothersCount;

    @Min(value = 0, message = MatrimonyConstant.SISTERS_COUNT_MIN) // Reference constant
    @Max(value = 10, message = MatrimonyConstant.SISTERS_COUNT_MAX) // Reference constant
    private int sistersCount;

    @Min(value = 0, message = MatrimonyConstant.MARRIED_SISTERS_COUNT_MIN) // Reference constant
    @Max(value = 10, message = MatrimonyConstant.MARRIED_SISTERS_COUNT_MAX) // Reference constant
    private int marriedSistersCount;

    @NotBlank(message = MatrimonyConstant.PARENTS_FULL_NAME_REQUIRED) // Reference constant
    @Size(max = 100, message = MatrimonyConstant.PARENTS_FULL_NAME_MAX) // Reference constant
    private String parentsFullName;

    @NotBlank(message = MatrimonyConstant.PARENTS_OCCUPATION_REQUIRED) // Reference constant
    @Size(max = 100, message = MatrimonyConstant.PARENTS_OCCUPATION_MAX) // Reference constant
    private String parentsOccupation;

    @NotBlank(message = MatrimonyConstant.PARENTS_OCCUPATION_CITY_REQUIRED) // Reference constant
    @Size(max = 100, message = MatrimonyConstant.PARENTS_OCCUPATION_CITY_MAX) // Reference constant
    private String parentsOccupationCity;

    @NotBlank(message = MatrimonyConstant.PARENTS_RESIDENT_CITY_REQUIRED) // Reference constant
    @Size(max = 100, message = MatrimonyConstant.PARENTS_RESIDENT_CITY_MAX) // Reference constant
    private String parentsResidentCity;

    @NotNull(message = MatrimonyConstant.SURNAMES_OF_RELATIVES_NULL) // Reference constant
    @Size(min = 1, message = MatrimonyConstant.SURNAMES_OF_RELATIVES_MIN) // Reference constant
    private List<@NotBlank(message = MatrimonyConstant.SURNAME_BLANK) @Size(max = 50, message = MatrimonyConstant.SURNAME_MAX) String> surnameOfRelatives;

    @NotNull(message = MatrimonyConstant.FAMILY_WEALTH_DETAILS_NULL) // Reference constant
    @Size(min = 1, max = 5, message = MatrimonyConstant.FAMILY_WEALTH_DETAILS_SIZE) // Reference constant
    private List<@NotBlank(message = MatrimonyConstant.FAMILY_WEALTH_BLANK) @Size(max = 100, message = MatrimonyConstant.FAMILY_WEALTH_MAX) String> family_Wealth;

    @NotBlank(message = MatrimonyConstant.MATERNAL_UNCLE_SURNAME_REQUIRED) // Reference constant
    @Size(min = 2, max = 50, message = MatrimonyConstant.MATERNAL_UNCLE_SURNAME_SIZE) // Reference constant
    private String maternalUncleSurname;

    @NotBlank(message = MatrimonyConstant.MATERNAL_UNCLE_SURNAME_PLACE_REQUIRED) // Reference constant
    @Size(min = 2, max = 100, message = MatrimonyConstant.MATERNAL_UNCLE_SURNAME_PLACE_SIZE) // Reference constant
    private String maternalUncleSurnamePlace;

    @NotNull(message = MatrimonyConstant.NATIVE_CITY_LIST_NULL) // Reference constant
    @Size(min = 1, max = 5, message = MatrimonyConstant.NATIVE_CITY_LIST_SIZE) // Reference constant
    private List<@NotBlank(message = MatrimonyConstant.NATIVE_CITY_BLANK) @Size(min = 2, max = 100, message = MatrimonyConstant.NATIVE_CITY_SIZE) String> nativeCity;

    @NotNull(message = MatrimonyConstant.NATIVE_TALUKA_LIST_NULL) // Reference constant
    @Size(min = 1, max = 5, message = MatrimonyConstant.NATIVE_TALUKA_LIST_SIZE) // Reference constant
    private List<@NotBlank(message = MatrimonyConstant.NATIVE_TALUKA_BLANK) @Size(min = 2, max = 100, message = MatrimonyConstant.NATIVE_TALUKA_SIZE) String> nativeTaluka;

    @NotNull(message = MatrimonyConstant.INTERCAST_MARRIAGE_CORE_FAMILY_REQUIRED) // Reference constant
    private Boolean AnyIntercastMarriageInCoreFamily;

    @Size(max = 100, message = MatrimonyConstant.INTERCAST_MARRIAGE_CORE_FAMILY_CAST_MAX) // Reference constant
    private String IntercastMarriageInCorefamilyCast; //if yes

}
