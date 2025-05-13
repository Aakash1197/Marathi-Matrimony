package com.matrimonyproject.matrimony.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.matrimonyproject.matrimony.customEnum.Mangal;
import com.matrimonyproject.matrimony.customEnum.Plans;
import com.matrimonyproject.matrimony.customEnum.validators.ValidEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
/*

@Data
@AllArgsConstructor
public class UserRegisterDTO {
    @NotBlank(message = "User name must not blank")
    @Size( min=12, max=50,message = "Try logging in with the username that was generated during registration. The username must be between 12 and 50 characters long.")
    private String username;
    @NotBlank(message = "first name is required.")
    @Size(min = 2, max = 100, message = "Full name must be between 2 and 100 characters.")
    private String firstName;
    private String middleName;
    @NotBlank(message = "first name is required.")
    @Size(min = 2, max = 100, message = "Full name must be between 2 and 100 characters.")
    private String lastName;

    @NotBlank(message = "Gender is required.")
    @Pattern(regexp = "^(?i)(male|female|other)$", message = "Gender must be Male, Female, or Other.")
    private String gender;

    @Email(message = "Email should be valid.")
    @Pattern(
            regexp = "^[a-zA-Z0-9](?!.*\\.\\.)([a-zA-Z0-9._%+-]{4,28}[a-zA-Z0-9])?@gmail\\.com$",
            message = "Email must be a valid Gmail address."
    )
    private String email;

    @Pattern(regexp = "^(\\+91[\\s]?)?[6-9][0-9]{9}$", message = "Phone number must be between 6 to 15 digits and contain only numbers.")
    @Size(min = 10, max = 10, message = "Mobile number must be exactly 10 digits.")
    @NotBlank(message = "Mobile is required.")
    private String mobileNumber;

*/
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
*//*

    @JsonIgnore
    @NotBlank(message = "Password is required.")
    @Pattern(
            regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@#$%^&+=!])[A-Za-z\\d@#$%^&+=!]{8,20}$",
            message = "Try logging in with the password you created during registration. The password must be between 8 and 20 characters long and include at least one letter, one number, and one special character"
    )
    private String password;
    @Valid
    @NotNull(message = " plans cannot be null.")
    @ValidEnum(enumClass = Plans.class, message = "Invalid plan value.")
    private Plans plans;


}
*/
