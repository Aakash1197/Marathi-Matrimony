package com.matrimonyproject.matrimony.dto;

import com.matrimonyproject.matrimony.constant.MatrimonyConstant;
import com.matrimonyproject.matrimony.customEnum.*;
import com.matrimonyproject.matrimony.customEnum.validators.ValidEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
public class ExpectationDTO {

        @NotEmpty(message = MatrimonyConstant.PREFERRED_CITIES_LIST_EMPTY) // Reference constant
        private List<@NotBlank(message = MatrimonyConstant.PREFERRED_CITY_BLANK) String> preferredCities;

        @NotNull(message = MatrimonyConstant.HAS_MANGAL_REQUIRED) // Reference constant
        private Boolean hasMangal;

        @Valid
        @NotNull(message = MatrimonyConstant.EXPECTED_CAST_LIST_NULL) // Reference constant
        @ValidEnum(enumClass = Cast.class, message = MatrimonyConstant.INVALID_CAST_AREA) // Reference constant
        private List<Cast> expectedCast;

        @Valid
        @NotNull(message = MatrimonyConstant.MAX_AGE_DIFFERENCE_REQUIRED) // Reference constant
        @ValidEnum(enumClass = AgeDifference.class, message = MatrimonyConstant.INVALID_AGE_DIFFERENCE) // Reference constant
        private AgeDifference maxAgeDifference;

        @Valid
        @NotNull(message = MatrimonyConstant.EXPECTED_HEIGHT_REQUIRED) // Reference constant
        @ValidEnum(enumClass = ExpectedHeight.class, message = MatrimonyConstant.INVALID_EXPECTED_HEIGHT) // Reference constant
        private ExpectedHeight expectedHeight;

        @Valid
        @NotNull(message = MatrimonyConstant.EXPECTED_EDUCATION_AREA_LIST_NULL) // Reference constant
        @ValidEnum(enumClass = EducationArea.class, message = MatrimonyConstant.EXPECTED_INVALID_EDUCATION_AREA) // Reference constant
        private List<EducationArea> expectedEducationArea;

        @Valid
        @NotNull(message = MatrimonyConstant.EXPECTED_OCCUPATION_TYPE_LIST_NULL) // Reference constant
        @ValidEnum(enumClass = OccupationType.class, message = MatrimonyConstant.EXPECTED_INVALID_OCCUPATION_TYPE) // Reference constant
        private List<OccupationType> expectedOccupationType;

        @NotNull(message = MatrimonyConstant.INCOME_PER_ANNUM_REQUIRED) // Reference constant
        @Min(value = 0, message = MatrimonyConstant.INCOME_PER_ANNUM_MIN) // Reference constant
        private Long incomePerAnnum;

        private boolean divorcee;




}
