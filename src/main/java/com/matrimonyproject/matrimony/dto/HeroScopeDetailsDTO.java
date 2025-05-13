package com.matrimonyproject.matrimony.dto;

import com.matrimonyproject.matrimony.constant.MatrimonyConstant;
import com.matrimonyproject.matrimony.customEnum.*;
import com.matrimonyproject.matrimony.customEnum.validators.ValidEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class HeroScopeDetailsDTO {

    @Valid
    @NotNull(message = MatrimonyConstant.RASHI_NULL) // Reference constant
    @ValidEnum(enumClass = Rashi.class, message = MatrimonyConstant.INVALID_RASHI) // Reference constant
    private List<Rashi> rashi;

    @Valid
    @NotNull(message = MatrimonyConstant.NAKSHATRA_NULL) // Reference constant
    @ValidEnum(enumClass = Nakshatra.class, message = MatrimonyConstant.INVALID_NAKSHATRA) // Reference constant
    private List<Nakshatra> nakshatra;

    @Valid
    @NotNull(message = MatrimonyConstant.CHARAN_NULL) // Reference constant
    @ValidEnum(enumClass = Charan.class, message = MatrimonyConstant.INVALID_CHARAN) // Reference constant
    private List<Charan> charan;

    @Valid
    @NotNull(message = MatrimonyConstant.NADI_NULL) // Reference constant
    @ValidEnum(enumClass = Nadi.class, message = MatrimonyConstant.INVALID_NADI) // Reference constant
    private List<Nadi> nadi;

    @Valid
    @NotNull(message = MatrimonyConstant.GAN_NULL) // Reference constant
    @ValidEnum(enumClass = Gan.class, message = MatrimonyConstant.INVALID_GAN) // Reference constant
    private List<Gan> gan;

    @Valid
    @NotNull(message = MatrimonyConstant.MANGAL_NULL) // Reference constant
    @ValidEnum(enumClass = Mangal.class, message = MatrimonyConstant.INVALID_MANGAL) // Reference constant
    private List<Mangal> mangal;

    @NotNull(message = MatrimonyConstant.BIRTH_TIME_REQUIRED) // Reference constant
    private LocalDateTime Birth_Time;

    @NotNull(message = MatrimonyConstant.BIRTH_STATE_REQUIRED) // Reference constant
    @Size(min = 1, max = 5, message = MatrimonyConstant.BIRTH_STATE_SIZE) // Reference constant
    private List<@NotBlank(message = MatrimonyConstant.BIRTH_STATE_BLANK) @Size(min = 2, max = 100, message = MatrimonyConstant.BIRTH_STATE_SIZE_LENGTH) String> BornState;

    @NotNull(message = MatrimonyConstant.BIRTH_CITY_REQUIRED) // Reference constant
    @Size(min = 1, max = 5, message = MatrimonyConstant.BIRTH_CITY_SIZE) // Reference constant
    private List<@NotBlank(message = MatrimonyConstant.BIRTH_CITY_BLANK) @Size(min = 2, max = 100, message = MatrimonyConstant.BIRTH_CITY_SIZE_LENGTH) String> BornCiti;

    @NotNull(message = MatrimonyConstant.IS_ABROAD_BORN_REQUIRED) // Reference constant
    private Boolean isAbroadBorn;

    @NotNull(message = MatrimonyConstant.BIRTH_COUNTRY_REQUIRED) // Reference constant
    @Size(min = 1, max = 3, message = MatrimonyConstant.BIRTH_COUNTRY_SIZE) // Reference constant
    private List<@NotBlank(message = MatrimonyConstant.BIRTH_COUNTRY_BLANK) @Size(min = 2, max = 100, message = MatrimonyConstant.BIRTH_COUNTRY_SIZE_LENGTH) String> BornCountry;

}
