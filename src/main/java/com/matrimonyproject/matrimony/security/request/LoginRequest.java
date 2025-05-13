package com.matrimonyproject.matrimony.security.request;

import com.matrimonyproject.matrimony.constant.MatrimonyConstant;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    @NotBlank(message = MatrimonyConstant.USERNAME_BLANK_MESSAGE)
    @Pattern(regexp = "^[a-zA-Z]{1,5}[_$@]{1}[0-9]{4}[0-9]{4}$", message = MatrimonyConstant.USERNAME_FORMAT_MESSAGE)
    @Size( min=12, max=50,message = MatrimonyConstant.USERNAME_SIZE_MESSAGE)
    private String userName;


    @NotBlank(message = MatrimonyConstant.PASSWORD_BLANK_MESSAGE)
    @Pattern(
            regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@#$%^&+=!])[A-Za-z\\d@#$%^&+=!]{8,20}$",
            message = MatrimonyConstant.PASSWORD_FORMAT_MESSAGE
    )
    private String password;
}
