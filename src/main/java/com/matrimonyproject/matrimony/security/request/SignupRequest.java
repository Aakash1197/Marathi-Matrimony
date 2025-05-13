package com.matrimonyproject.matrimony.security.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.matrimonyproject.matrimony.constant.MatrimonyConstant;
import com.matrimonyproject.matrimony.customEnum.Plans;
import com.matrimonyproject.matrimony.customEnum.validators.ValidEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;


@Data
@AllArgsConstructor
public class SignupRequest {
    @JsonIgnore
/*  @NotBlank(message = "User name must not blank")
    @Size( min=12, max=50,message = "Try logging in with the username that was generated during registration. The username must be between 12 and 50 characters long.")*/
    private String username;
    @NotBlank(message = MatrimonyConstant.FIRST_NAME_BLANK_MESSAGE)
    @Size(min = 2, max = 100, message = MatrimonyConstant.FIRST_NAME_SIZE_MESSAGE)
    private String firstName;
    private String middleName;

    @NotBlank(message = MatrimonyConstant.LAST_NAME_BLANK_MESSAGE)
    @Size(min = 2, max = 100, message = MatrimonyConstant.LAST_NAME_SIZE_MESSAGE)
    private String lastName;

    @NotBlank(message = MatrimonyConstant.GENDER_BLANK_MESSAGE)
    @Pattern(regexp = "^(?i)(male|female|other)$", message = MatrimonyConstant.GENDER_PATTERN_MESSAGE)
    private String gender;

    @Email(message =MatrimonyConstant.EMAIL_INVALID_MESSAGE)
    @Pattern(
            regexp = "^[a-zA-Z0-9](?!.*\\.\\.)([a-zA-Z0-9._%+-]{4,28}[a-zA-Z0-9])?@gmail\\.com$",
            message = MatrimonyConstant.EMAIL_PATTERN_MESSAGE
    )
    private String email;

    @Pattern(regexp = "^(\\+91[\\s]?)?[6-9][0-9]{9}$", message = MatrimonyConstant.MOBILE_NUMBER_PATTERN_MESSAGE)
    @Size(min = 10, max = 10, message = MatrimonyConstant.MOBILE_NUMBER_SIZE_MESSAGE)
    @NotBlank(message = MatrimonyConstant.MOBILE_NUMBER_BLANK_MESSAGE)
    private String mobileNumber;

    /*✅ Recommended Password Validation Rules
     Rule	Description	Regex Support
    ✅ Minimum length	At least 8 characters	✔️
                ✅ Maximum length	Up to 20–30 characters	✔️
                ✅ Letters required	At least one lowercase or uppercase letter	✔️
                ✅ Numbers required	At least one digit (0–9)	✔️
                ✅ Special character	At least one symbol like @#$%^&*	✔️
                ✅ No spaces	Disallow whitespace	✔️
                ❌ Not common password	Avoid "password", "123456", etc.	🔁 (custom logic)
                ✅ This allows:
                Pass@123
                Hello2024!
                A1@strongpass

                ❌ This blocks:
                password → no number or special char
                12345678 → no letters
                abc@ → too short
                thisisaverylongpassword! → too long
    */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(message = MatrimonyConstant.PASSWORD_BLANK_MESSAGE)
    @Getter
    @Pattern(
            regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@#$%^&+=!])[A-Za-z\\d@#$%^&+=!]{8,20}$",
            message = MatrimonyConstant.PASSWORD_PATTERN_MESSAGE
    )
    private String password;
    @Valid
    @NotNull(message = MatrimonyConstant.PLANS_BLANK_MESSAGE)
    @ValidEnum(enumClass = Plans.class, message = MatrimonyConstant.INVALID_PLAN_MESSAGE)
    private Plans plans;


}

