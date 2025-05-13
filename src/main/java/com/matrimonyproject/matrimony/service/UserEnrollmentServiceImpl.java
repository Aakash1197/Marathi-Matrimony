package com.matrimonyproject.matrimony.service;

import com.matrimonyproject.matrimony.constant.MatrimonyConstant;
import com.matrimonyproject.matrimony.controller.AuthController;
import com.matrimonyproject.matrimony.dto.UserEnrollmentDTO;
import com.matrimonyproject.matrimony.entity.UserEnrollment;
import com.matrimonyproject.matrimony.entity.UserRegister;
import com.matrimonyproject.matrimony.exception.APIException;
import com.matrimonyproject.matrimony.repository.UserEnrollmentRepository;
import com.matrimonyproject.matrimony.repository.SignupRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class UserEnrollmentServiceImpl implements UserEnrollmentSevice{
    private static final Logger logger = LoggerFactory.getLogger(UserEnrollmentServiceImpl.class);
    @Autowired
    private UserEnrollmentRepository userEnrollmentRepository;

    @Autowired
    private SignupRepository signupRepository;

    @Autowired
    private ModelMapper modelMapper ;

    @Transactional
    @Override
    public void savePersonalDetails(UserEnrollmentDTO userEnrollmentDTO,String userName) {
        // Validate userRegisterId (6 to 10 digits)
        if (String.valueOf(userName).length() <12 || String.valueOf(userName).length() > 50) {
            throw  new APIException(MatrimonyConstant.INVALID_USERNAME_LENGTH_MESSAGE);
        }
        logger.info("User email  :"+userEnrollmentDTO.getAddress().getEmail().toLowerCase());
        logger.info("User mobile :"+userEnrollmentDTO.getAddress().getMobileNo());
        logger.info("User name  :"+userName);
        Optional<UserRegister> registeredUser = signupRepository
                .findByUsernameAndMobileNoOrEmailId(userName,userEnrollmentDTO.getAddress().getMobileNo(),
                 userEnrollmentDTO.getAddress().getEmail().toLowerCase());
            logger.info("User already registerd check [******]   :"+registeredUser.stream().toList());
        if(registeredUser.isEmpty()){
           throw new APIException("User with username :"+userName+"  "+" already exists with the email"
                    +userEnrollmentDTO.getAddress().getEmail()+"and mobile number  :"+userEnrollmentDTO.getAddress().getMobileNo()+".Please verify the email and mobile.");
        }

            if (registeredUser.get().getUsername()!=null &&userEnrollmentDTO.getAddress() != null && userEnrollmentDTO.getExpectationDTO()!=null
                    && userEnrollmentDTO.getPhotosDTO() != null && userEnrollmentDTO.getEducationalDetailsDTO() != null
                    && userEnrollmentDTO.getPersonalDetailsDTO() != null && userEnrollmentDTO.getHeroScopeDetailsDTO() != null
                    && userEnrollmentDTO.getFamilyBackgroundDTO() != null) {
                boolean userExists = userEnrollmentRepository.findByMobileNoOrEmailId(
                        userEnrollmentDTO.getAddress().getMobileNo(),
                        userEnrollmentDTO.getAddress().getEmail().toLowerCase()
                ).isPresent();

                if (userExists) {
                    throw new APIException(MatrimonyConstant.DUPLICATE_USER_CONTACT_MESSAGE);
                }



            UserEnrollment user=UserEnrollment.convertDTOtoEntity(userEnrollmentDTO);
                setInsertionTimeStamp(userName, user);
                userEnrollmentRepository.save(user);
            }
            else {
                throw new APIException(MatrimonyConstant.USER_ENROLLMENT_FAILED_MESSAGE);
            }



    }


    private static void setInsertionTimeStamp(String  userName, UserEnrollment user) {
        user.setADD_TIME(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmmss")));
        user.setADD_DATE(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
        user.setADD_BY_USER(userName);
        user.setMDF_TIME(LocalDateTime.now().format(DateTimeFormatter.ofPattern("000000")));
        user.setMDF_DATE(LocalDate.now().format(DateTimeFormatter.ofPattern("00000000")));
        user.setMDF_BY_USER(null);
        user.setADD_TIME(LocalDateTime.now().format(DateTimeFormatter.ofPattern("000000")));
        user.setADD_DATE(LocalDate.now().format(DateTimeFormatter.ofPattern("00000000")));
        user.setADD_BY_USER(null);
        user.setDEL_FLG(0);
    }
    private static void setUpdateTimeStamp(String  userName, UserEnrollment user) {
        user.setADD_TIME("000000");
        user.setADD_DATE("00000000");
        user.setADD_BY_USER(null);
        user.setMDF_TIME(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmmss")));
        user.setMDF_DATE(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
        user.setMDF_BY_USER(userName);
        user.setDEL_TIME("000000");
        user.setDEL_DATE("00000000");
        user.setDEL_BY_USER(null);
        user.setDEL_FLG(0);
    }
    private static void setDeletionTimeStamp(String  userName, UserEnrollment user) {
        user.setADD_TIME("000000");
        user.setADD_DATE("00000000");
        user.setADD_BY_USER(null);
        user.setMDF_TIME("000000");
        user.setMDF_DATE("00000000");
        user.setMDF_BY_USER(null);
        user.setDEL_TIME(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmmss")));
        user.setDEL_DATE(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
        user.setDEL_BY_USER(userName);
        user.setDEL_FLG(0);
    }
}
