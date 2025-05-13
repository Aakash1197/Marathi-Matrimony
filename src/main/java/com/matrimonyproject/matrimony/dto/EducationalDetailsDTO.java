package com.matrimonyproject.matrimony.dto;

import com.matrimonyproject.matrimony.constant.MatrimonyConstant;
import com.matrimonyproject.matrimony.customEnum.EducationArea;
import com.matrimonyproject.matrimony.customEnum.OccupationType;
import com.matrimonyproject.matrimony.customEnum.validators.ValidEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class EducationalDetailsDTO {

    @Valid
    @ValidEnum(enumClass = EducationArea.class, message = MatrimonyConstant.INVALID_EDUCATION_AREA) // Reference constant
    private EducationArea educationArea;

    @NotBlank(message = MatrimonyConstant.EDUCATION_NAME_REQUIRED) // Reference constant
    @Size(max = 100, message = MatrimonyConstant.EDUCATION_NAME_SIZE)
    private String educationName;

    @Valid
    @ValidEnum(enumClass = OccupationType.class, message = MatrimonyConstant.INVALID_OCCUPATION_TYPE) // Reference constant
    private OccupationType occupationType;

    @NotBlank(message = MatrimonyConstant.OCCUPATION_DETAILS_REQUIRED) // Reference constant
    @Size(max = 255, message = MatrimonyConstant.OCCUPATION_DETAILS_SIZE)
    private String occupationDetails;

    @Min(value = 0, message = MatrimonyConstant.INCOME_PER_MONTH_MIN) // Reference constant
    private double incomePerMonth;

    @NotEmpty(message = MatrimonyConstant.EDUCATION_COUNTRY_REQUIRED) // Reference constant
    private List<@NotBlank(message = MatrimonyConstant.EDUCATION_COUNTRY_BLANK) String> educationCountry;

    @NotEmpty(message = MatrimonyConstant.EDUCATION_STATE_REQUIRED) // Reference constant
    private List<@NotBlank(message = MatrimonyConstant.EDUCATION_STATE_BLANK) String> educationState;

    @NotEmpty(message = MatrimonyConstant.EDUCATION_CITY_REQUIRED) // Reference constant
    private List<@NotBlank(message = MatrimonyConstant.EDUCATION_CITY_BLANK) String> educationCity;

}