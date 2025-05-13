package com.matrimonyproject.matrimony.service;

import com.matrimonyproject.matrimony.dto.UserEnrollmentDTO;

public interface UserEnrollmentSevice {
    void savePersonalDetails(UserEnrollmentDTO userEnrollmentDTO,String userName);
}
