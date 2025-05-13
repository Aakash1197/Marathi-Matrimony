package com.matrimonyproject.matrimony.dto;


import com.matrimonyproject.matrimony.constant.MatrimonyConstant;
import com.matrimonyproject.matrimony.customEnum.*;
import com.matrimonyproject.matrimony.customEnum.validators.ValidEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PersonalDetailsDTO {
    @NotBlank(message = MatrimonyConstant.FIRST_NAME_REQUIRED) // Reference constant
    @Size(max = 50, message = MatrimonyConstant.FIRST_NAME_SIZE) // Reference constant
    private String FirstName;

    @Size(max = 50, message = MatrimonyConstant.MIDDLE_NAME_SIZE) // Reference constant
    private String MiddleName;

    @NotBlank(message = MatrimonyConstant.LAST_NAME_REQUIRED) // Reference constant
    @Size(max = 50, message = MatrimonyConstant.LAST_NAME_SIZE) // Reference constant
    private String LastName;

    @NotNull(message = MatrimonyConstant.BIRTH_DATE_REQUIRED) // Reference constant
    @Past(message = MatrimonyConstant.BIRTH_DATE_PAST) // Reference constant
    private LocalDate birthDate;

    @Valid
    @NotNull(message = MatrimonyConstant.CAST_REQUIRED) // Reference constant
    @ValidEnum(enumClass = Cast.class, message = MatrimonyConstant.INVALID_CAST) // Reference constant
    private Cast subCast;

    @Valid
    @NotNull(message = MatrimonyConstant.MARITAL_STATUS_REQUIRED) // Reference constant
    @ValidEnum(enumClass = MartialStatus.class, message = MatrimonyConstant.INVALID_MARITAL_STATUS) // Reference constant
    private MartialStatus martialStatus;

    @Min(value = 0, message = MatrimonyConstant.CHILD_COUNT_NEGATIVE) // Reference constant
    @Max(value = 10, message = MatrimonyConstant.CHILD_COUNT_EXCEED) // Reference constant
    private int child;

    @NotNull(message = MatrimonyConstant.HEIGHT_REQUIRED) // Reference constant
    @DecimalMin(value = "2.0", message = MatrimonyConstant.HEIGHT_MIN) // Reference constant
    @DecimalMax(value = "8.0", message = MatrimonyConstant.HEIGHT_MAX) // Reference constant
    private Double height;

    @NotNull(message = MatrimonyConstant.WEIGHT_REQUIRED) // Reference constant
    @Min(value = 20, message = MatrimonyConstant.WEIGHT_MIN) // Reference constant
    @Max(value = 200, message = MatrimonyConstant.WEIGHT_MAX) // Reference constant
    private Long weight;

    @Valid
    @NotNull(message = MatrimonyConstant.BLOOD_GROUP_REQUIRED) // Reference constant
    @ValidEnum(enumClass = BloodGroup.class, message = MatrimonyConstant.INVALID_BLOOD_GROUP) // Reference constant
    private BloodGroup bloodGroup;

    @Valid
    @NotNull(message = MatrimonyConstant.COMPLEXION_REQUIRED) // Reference constant
    @ValidEnum(enumClass = Complexion.class, message = MatrimonyConstant.INVALID_COMPLEXION) // Reference constant
    private Complexion complexion;

    private boolean isPhysicalDisablities;

    @Size(max = 200, message = MatrimonyConstant.DISABILITY_SPECIFICATION_SIZE) // Reference constant
    private String if_Yes_Please_Specify;

    @Valid
    @NotNull(message = MatrimonyConstant.DIET_REQUIRED) // Reference constant
    @ValidEnum(enumClass = Diet.class, message = MatrimonyConstant.INVALID_DIET) // Reference constant
    private Diet diet;

    private Boolean Spectacles;

    private Boolean lens;

    @Size(max = 250, message = MatrimonyConstant.PERSONALITY_SIZE) // Reference constant
    private String personality;


}
