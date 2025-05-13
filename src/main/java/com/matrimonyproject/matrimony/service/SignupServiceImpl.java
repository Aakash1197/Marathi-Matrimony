package com.matrimonyproject.matrimony.service;

import com.matrimonyproject.matrimony.constant.MatrimonyConstant;
import com.matrimonyproject.matrimony.customEnum.AppRole;

import com.matrimonyproject.matrimony.entity.Role;
import com.matrimonyproject.matrimony.entity.UserRegister;
import com.matrimonyproject.matrimony.exception.APIException;
import com.matrimonyproject.matrimony.repository.RoleRepository;
import com.matrimonyproject.matrimony.repository.SignupRepository;
import com.matrimonyproject.matrimony.security.jwt.AuthEntryPointJwt;
import com.matrimonyproject.matrimony.security.request.SignupRequest;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class SignupServiceImpl implements SignupService {
    private static final Logger logger = LoggerFactory.getLogger(SignupServiceImpl.class);
    @Autowired
    private SignupRepository signupRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public String registerNewUser(SignupRequest signupRequest) {
        UserRegister savedUserRegisterDetails;
        if(signupRequest==null){
            throw new APIException(MatrimonyConstant.USER_REGISTRATION_DTO_RECHECK);
        }
        else{
            //logger.info("User already existance check [******]   :"+signupRepository.findByMobileNoOrEmailId(signupRequest.getMobileNumber(),signupRequest.getEmail()).stream().toList());
            boolean userAlreadyExistOrNot=signupRepository.findByMobileNoOrEmailId(signupRequest.getMobileNumber(),signupRequest.getEmail()).isPresent();

                if(userAlreadyExistOrNot){
                    throw new APIException(MatrimonyConstant.USER_ALREADY_REGISTERED_MESSAGE);
                }
                String userName=generateUniqueUsername(signupRequest.getLastName(),signupRequest.getMobileNumber());
            signupRequest.setUsername( userName);

           UserRegister userRegister = modelMapper.map(signupRequest, UserRegister.class);
           userRegister.setPlans(signupRequest.getPlans().getPlanName());
            userRoleSelectBaseOnPlan(userRegister);
            userRegister.setPassword(bCryptPasswordEncoder.encode(signupRequest.getPassword()));
          /*  Boolean Representation for account AccountNonLocked
            true: The account is not locked (user can log in).

            false: The account is locked (user cannot log in).*/
            userRegister.setAccountNonLocked(true);
            userRegister.setFailedLoginAttempts(0);
            userRegister.setLockTime(null);
              String passwordExpirationDate=LocalDateTime.now().plusDays(90).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
            userRegister.setPasswordExpirationDate(passwordExpirationDate);
            setInsertionTimeStamp(userName,userRegister);
             savedUserRegisterDetails= signupRepository.save(userRegister);

        }
        return MatrimonyConstant.USER_REGISTRATION_SUCCESS+"   "+savedUserRegisterDetails.getUsername();
    }

    private void userRoleSelectBaseOnPlan( UserRegister userRegister) {
      /*  FREE,
                BASIC,
                PREMIUM,
                ADMIN;*/
        switch (userRegister.getPlans()) {
            case "Basic":
                System.out.println("Basic Plan: Limited access, no contact viewing.");
                // Add logic for free plan
                Set<Role> roles = new HashSet<>();
                roleRepository.findByRoleName(AppRole.ROLE_USER.getRoleName()).ifPresentOrElse(roles::add,
                        () -> roles.add(roleRepository.save(new Role(AppRole.ROLE_USER,userRegister.getUsername()))) );
                userRegister.setRoles(roles);
                break;

            case "Premium":
                System.out.println("Premium Plan: Full access with contact viewing and messaging.");
                // Add logic for premium plan
                Set<Role> premiumUsers = new HashSet<>();

                roleRepository.findByRoleName(AppRole.ROLE_PREMIUM_USER.getRoleName()).ifPresentOrElse(premiumUsers::add,
                        () -> premiumUsers.add(roleRepository.save(new Role(AppRole.ROLE_PREMIUM_USER,userRegister.getUsername()))) );

                userRegister.setRoles(premiumUsers);

                break;

            case "Admin":
                System.out.println("Admin Plan: Full access for role and user configuration.");
                // Add logic for premium plan
                Set<Role> adminUsers = new HashSet<>();

                roleRepository.findByRoleName(AppRole.ROLE_ADMIN.getRoleName()).ifPresentOrElse(adminUsers::add,
                        () -> adminUsers.add(roleRepository.save(new Role(AppRole.ROLE_ADMIN,userRegister.getUsername()))) );

                userRegister.setRoles(adminUsers);

                break;

            default:
                System.out.println("Invalid plan selected.");
                Set<Role> guests = new HashSet<>();

                roleRepository.findByRoleName(AppRole.ROLE_GUEST.getRoleName()).ifPresentOrElse(guests::add,
                        () -> guests.add(roleRepository.save(new Role(AppRole.ROLE_GUEST,userRegister.getUsername()))) );

                userRegister.setRoles(guests);
                break;
        }


    }

    private static void setInsertionTimeStamp(String userName, UserRegister user) {
        user.setADD_TIME(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmmss")));
        user.setADD_DATE(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
        user.setADD_BY_USER(userName);
        user.setMDF_TIME(LocalDateTime.now().format(DateTimeFormatter.ofPattern("000000")));
        user.setMDF_DATE(LocalDate.now().format(DateTimeFormatter.ofPattern("00000000")));
        user.setMDF_BY_USER(null);
        user.setDEL_TIME(LocalDateTime.now().format(DateTimeFormatter.ofPattern("000000")));
        user.setDEL_DATE(LocalDate.now().format(DateTimeFormatter.ofPattern("00000000")));
        user.setDEL_BY_USER(null);
        user.setDEL_FLG(0);
    }
    private static void setUpdateTimeStamp(String userName, UserRegister user) {
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
    private static void setDeletionTimeStamp(String userName, UserRegister user) {
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

    // Method to generate and check username
    public String generateUniqueUsername(String lastName, String mobileNumber)  {

        // Step 1: Validate input fields
        if (isInvalidName(lastName)) {
            throw new APIException(MatrimonyConstant.INVALID_LAST_NAME_MESSAGE);
        }

        if (isInvalidMobile(mobileNumber)) {
            throw new APIException(MatrimonyConstant.INVALID_MOBILE_NUMBER_MESSAGE);
        }

        // Step 2: Generate username
        String username = createUsername(lastName, mobileNumber);

        // Step 3: Check if username already exists
        while (signupRepository.existsByUsername(username)) {
            // Regenerate if the username exists
            username = createUsername(lastName, mobileNumber);
        }

        // Step 4: Return the generated unique username
        return username;
    }
    // Validate Last Name (Only alphabetic characters, and not blank)
    private boolean isInvalidName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            return true;
        }
        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");  // Only letters (no spaces, numbers, or special chars)
        Matcher matcher = pattern.matcher(lastName);
        return !matcher.matches();
    }

    // Validate Mobile Number (Must be numeric and at least 10 digits)
    private boolean isInvalidMobile(String mobileNumber) {
        if (mobileNumber == null || mobileNumber.trim().isEmpty()) {
            return true;
        }
        return !mobileNumber.matches("^(\\+91[\\s]?)?[6-9][0-9]{9}$"); // Mobile number must be numeric and at least 10 digits
    }

    // Generate Username based on the strategy
    private String createUsername(String lastName, String mobileNumber) {
        // Get the first 5 characters of the last name (if available)
        String firstNamePart = lastName.length() >= 5 ? lastName.substring(0, 5) : lastName;

        // Get the last 4 digits of the mobile number
        String last4MobileDigits = mobileNumber.length() >= 4 ? mobileNumber.substring(mobileNumber.length() - 4) : mobileNumber;

        // Generate a random 4-digit number
        String randomDigits = String.format("%04d", new Random().nextInt(10000));  // Ensures a 4-digit number

        // Choose a random special character
        String specialChar = chooseRandomSpecialCharacter();

        // Combine all parts: Last Name Part + Special Char + Last 4 Digits of Mobile + Random Number
        return firstNamePart + specialChar + last4MobileDigits + randomDigits;
    }

    // Randomly pick a special character from the allowed set
    private String chooseRandomSpecialCharacter() {
        String[] specialChars = {"@", "_", "$"};
        SecureRandom random = new SecureRandom();
        return specialChars[random.nextInt(specialChars.length)];
    }
}


