package com.matrimonyproject.matrimony.controller;


import com.matrimonyproject.matrimony.constant.MatrimonyConstant;
import com.matrimonyproject.matrimony.dto.UserEnrollmentDTO;
import com.matrimonyproject.matrimony.service.UserEnrollmentSevice;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping("/matrimony-app/api/enrollment")
public class UserEnrollmentController {
    @Autowired
    private UserEnrollmentSevice userEnrollmentSevice;
    @PostMapping("/userEnrollment/{userName}")
 public ResponseEntity<String> userEnrollment(@Valid @RequestBody  UserEnrollmentDTO UserEnrollmentDTO,
                                              @PathVariable
                                              @NotBlank(message = MatrimonyConstant.USERNAME_BLANK_MESSAGE)
                                              @Pattern(regexp = "^[A-Za-z]{3,5}[@_$][0-9]{4}[0-9]{4}$",
                                              message =  MatrimonyConstant.USERNAME_FORMAT_MESSAGE)
                                              @Size( min=12, max=50,message = MatrimonyConstant.INVALID_USERNAME_LENGTH_MESSAGE)
                                              String userName) {

        userEnrollmentSevice.savePersonalDetails(UserEnrollmentDTO,userName);
        return new ResponseEntity<>(MatrimonyConstant.USER_ENROLLMENT_SUCCESSFUL_MESSAGE, HttpStatus.OK);
 }
}
