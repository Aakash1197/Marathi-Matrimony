package com.matrimonyproject.matrimony.dto;

import com.matrimonyproject.matrimony.constant.MatrimonyConstant;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    @Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}", message = MatrimonyConstant.INVALID_PAN_MESSAGE)
    @Size(max = 10, message = MatrimonyConstant.INVALID_PAN_LENGTH_MESSAGE)
    @NotBlank(message = MatrimonyConstant.PAN_REQUIRED_MESSAGE)
    private String pan;
    @NotBlank(message = MatrimonyConstant.AADHAAR_REQUIRED_MESSAGE)
    @Pattern(regexp = "^[2-9][0-9]{11}$", message = MatrimonyConstant.AADHAAR_INVALID_MESSAGE)
    @Size(min = 12, max = 12, message = MatrimonyConstant.AADHAAR_INVALID_LENGTH_MESSAGE)
    private String aadhaarId;

    @Pattern(regexp = "^[A-PR-WYa-pr-wy][0-9]{7}$", message = MatrimonyConstant.PASSPORT_NO_PATTERN_MESSAGE)
    @Size(min = 8, max = 8, message = MatrimonyConstant.PASSPORT_NO_SIZE_MESSAGE)
    private String  passportNo;
    @Size(max = 255, message = MatrimonyConstant.RESIDENCE_ADDRESS_SIZE_MESSAGE)
    private String  ResidenceAddressWithCity;
    @Email(message = MatrimonyConstant.EMAIL_INVALID_MESSAGE)
    @Size(max = 100, message = MatrimonyConstant.EMAIL_SIZE_MESSAGE)
    @NotBlank(message = MatrimonyConstant.EMAIL_REQUIRED_MESSAGE)
    private String  email;

    @Pattern(regexp = "^(\\+91[\\s]?)?[6-9][0-9]{9}$", message = MatrimonyConstant.MOBILE_NO_PATTERN_MESSAGE)
    @Size(min = 10, max = 10, message = MatrimonyConstant.MOBILE_NO_SIZE_MESSAGE)
    @NotBlank(message = MatrimonyConstant.MOBILE_NO_REQUIRED_MESSAGE)
    private String  mobileNo;
    @Pattern(regexp = "^(\\+91[\\s]?)?[6-9][0-9]{9}$", message = MatrimonyConstant.MOBILE_NO_PATTERN_MESSAGE)
    @Size(min = 10, max = 10, message = MatrimonyConstant.MOBILE_NO_SIZE_MESSAGE)
    private String  mobileNo2;
    @Pattern(
            regexp = "^0[1-9][0-9]{1,4}([\\s-]?[0-9]{6,8})$",
            message = MatrimonyConstant.PHONE_NO_PATTERN_MESSAGE
    )
    @Size(max = 15, message = MatrimonyConstant.PHONE_NO_SIZE_MESSAGE)
    private String  phoneNo;
    @Pattern(
            regexp = "^$|^0[1-9][0-9]{1,4}([\\s-]?[0-9]{6,8})$",
            message = MatrimonyConstant.PHONE_NO_PATTERN_MESSAGE
    )
    private String phoneNo2;

}
