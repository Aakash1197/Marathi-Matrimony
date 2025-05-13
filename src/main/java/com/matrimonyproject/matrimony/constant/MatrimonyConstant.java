package com.matrimonyproject.matrimony.constant;

import org.springframework.stereotype.Component;

@Component
public class MatrimonyConstant {

    public static final String USER_REGISTRATION_SUCCESS = "Registration successful! Please save your username securely — you'll need it for future logins and enrollment. You can now sign in using the password you set during registration     :";
    public static final String USER_REGISTRATION_DTO_RECHECK ="Please check User Register Data";
    public static final String USER_ALREADY_REGISTERED_MESSAGE = "A user with this mobile number or email address is already registered. Please use a different one to continue.";
    public static final String INVALID_LAST_NAME_MESSAGE = "Last name is required and must contain only alphabetic characters.";
    public static final String INVALID_MOBILE_NUMBER_MESSAGE = "Mobile number is required and must contain at least 10 digits.";
    public static final String INVALID_USERNAME_LENGTH_MESSAGE = "Username must be between 12 and 50 characters long.";
    public static final String DUPLICATE_USER_CONTACT_MESSAGE = "The provided mobile number or email ID is already registered. Please try using different contact details.";
    public static final String INVALID_PAN_MESSAGE = "PAN must be a valid 10-character alphanumeric code (e.g., ABCDE1234F).";
    public static final String INVALID_PAN_LENGTH_MESSAGE = "PAN must be exactly 10 characters long.";
    public static final String PAN_REQUIRED_MESSAGE = "PAN number is required.";
    public static final String AADHAAR_REQUIRED_MESSAGE = "Aadhaar number is required.";
    public static final String AADHAAR_INVALID_MESSAGE = "Aadhaar number must be a valid 12-digit number starting with 2-9.";
    public static final String AADHAAR_INVALID_LENGTH_MESSAGE = "Aadhaar number must be exactly 12 digits.";

    // Passport number validation messages
    public static final String PASSPORT_NO_PATTERN_MESSAGE = "Passport number must start with a letter and be followed by 7 digits (e.g., A1234567).";
    public static final String PASSPORT_NO_SIZE_MESSAGE = "Passport number must be exactly 8 characters.";

    // Residence address validation message
    public static final String RESIDENCE_ADDRESS_SIZE_MESSAGE = "Residence address with city must not exceed 255 characters.";

    // Email validation messages
    public static final String EMAIL_INVALID_MESSAGE = "Please enter a valid email address.";
    public static final String EMAIL_SIZE_MESSAGE = "Email address must not exceed 100 characters.";
    public static final String EMAIL_REQUIRED_MESSAGE = "Email is required.";

    // Mobile number validation messages
    public static final String MOBILE_NO_PATTERN_MESSAGE = "Phone number must be between 6 to 15 digits and contain only numbers.";
    public static final String MOBILE_NO_SIZE_MESSAGE = "Mobile number must be exactly 10 digits.";
    public static final String MOBILE_NO_REQUIRED_MESSAGE = "Mobile is required.";

    // Landline number validation messages
    public static final String PHONE_NO_PATTERN_MESSAGE = "Landline number must start with valid STD code and be followed by 6 to 8 digits, optionally separated by space or hyphen.";
    public static final String PHONE_NO_SIZE_MESSAGE = "Phone number must not exceed 15 digits.";
    // Error messages for EducationalDetailsDTO
    public static final String INVALID_EDUCATION_AREA = "Invalid education area value.";
    public static final String EDUCATION_NAME_REQUIRED = "Education name is required.";
    public static final String EDUCATION_NAME_SIZE = "Education name must not exceed 100 characters.";
    public static final String INVALID_OCCUPATION_TYPE = "Invalid occupation type value.";
    public static final String OCCUPATION_DETAILS_REQUIRED = "Occupation details are required.";
    public static final String OCCUPATION_DETAILS_SIZE = "Occupation details must not exceed 255 characters.";
    public static final String INCOME_PER_MONTH_MIN = "Income per month must be greater than or equal to 0.";
    public static final String EDUCATION_COUNTRY_REQUIRED = "At least one education country is required.";
    public static final String EDUCATION_COUNTRY_BLANK = "Education country cannot be empty.";
    public static final String EDUCATION_STATE_REQUIRED = "At least one education state is required.";
    public static final String EDUCATION_STATE_BLANK = "Education state cannot be empty.";
    public static final String EDUCATION_CITY_REQUIRED = "At least one education city is required.";
    public static final String EDUCATION_CITY_BLANK = "Education city cannot be empty.";
    // Error messages for ExpectationDTO
    public static final String PREFERRED_CITIES_LIST_EMPTY = "Preferred cities list cannot be empty.";
    public static final String PREFERRED_CITY_BLANK = "Preferred city cannot be blank.";
    public static final String HAS_MANGAL_REQUIRED = "hasMangal field is required.";
    public static final String EXPECTED_CAST_LIST_NULL = "Expected cast list cannot be null.";
    public static final String INVALID_CAST_AREA = "Invalid cast area value.";
    public static final String MAX_AGE_DIFFERENCE_REQUIRED = "Maximum age difference must be specified.";
    public static final String INVALID_AGE_DIFFERENCE = "Invalid ageDifference area value.";
    public static final String EXPECTED_HEIGHT_REQUIRED = "Expected height must be specified.";
    public static final String INVALID_EXPECTED_HEIGHT = "Invalid Expected height area value.";
    public static final String EXPECTED_EDUCATION_AREA_LIST_NULL = "Expected education area list cannot be null.";
    public static final String EXPECTED_INVALID_EDUCATION_AREA = "Invalid Education area value.";
    public static final String EXPECTED_OCCUPATION_TYPE_LIST_NULL = "Expected occupation type list cannot be null.";
    public static final String EXPECTED_INVALID_OCCUPATION_TYPE = "Invalid Occupation Type value.";
    public static final String INCOME_PER_ANNUM_REQUIRED = "Income per annum must be provided.";
    public static final String INCOME_PER_ANNUM_MIN = "Income per annum must be 0 or more.";

    // Error messages for FamilyBackgroundDTO
    public static final String HAS_FATHER_REQUIRED = "Please specify if the father is present.";
    public static final String HAS_MOTHER_REQUIRED = "Please specify if the mother is present.";
    public static final String BROTHERS_COUNT_MIN = "Number of brothers cannot be less than 0.";
    public static final String BROTHERS_COUNT_MAX = "Number of brothers cannot be more than 10.";
    public static final String MARRIED_BROTHERS_COUNT_MIN = "Married brothers count cannot be less than 0.";
    public static final String MARRIED_BROTHERS_COUNT_MAX = "Married brothers count cannot be more than 10.";
    public static final String SISTERS_COUNT_MIN = "Sisters count cannot be less than 0.";
    public static final String SISTERS_COUNT_MAX = "Sisters count cannot be more than 10.";
    public static final String MARRIED_SISTERS_COUNT_MIN = "Married sisters count cannot be less than 0.";
    public static final String MARRIED_SISTERS_COUNT_MAX = "Married sisters count cannot be more than 10.";
    public static final String PARENTS_FULL_NAME_REQUIRED = "Parents' full name is required.";
    public static final String PARENTS_FULL_NAME_MAX = "Parents' full name must not exceed 100 characters.";
    public static final String PARENTS_OCCUPATION_REQUIRED = "Parents' occupation is required.";
    public static final String PARENTS_OCCUPATION_MAX = "Parents' occupation must not exceed 100 characters.";
    public static final String PARENTS_OCCUPATION_CITY_REQUIRED = "Parents' occupation city is required.";
    public static final String PARENTS_OCCUPATION_CITY_MAX = "Parents' occupation city must not exceed 100 characters.";
    public static final String PARENTS_RESIDENT_CITY_REQUIRED = "Parents' resident city is required.";
    public static final String PARENTS_RESIDENT_CITY_MAX = "Parents' resident city must not exceed 100 characters.";
    public static final String SURNAMES_OF_RELATIVES_NULL = "Surnames of relatives cannot be null.";
    public static final String SURNAMES_OF_RELATIVES_MIN = "At least one surname should be provided.";
    public static final String SURNAME_BLANK = "Surname cannot be blank.";
    public static final String SURNAME_MAX = "Each surname must not exceed 50 characters.";
    public static final String FAMILY_WEALTH_DETAILS_NULL = "Family wealth details cannot be null.";
    public static final String FAMILY_WEALTH_DETAILS_SIZE = "Please provide between 1 and 5 family wealth details.";
    public static final String FAMILY_WEALTH_BLANK = "Each family wealth entry must not be blank.";
    public static final String FAMILY_WEALTH_MAX = "Each family wealth entry must not exceed 100 characters.";
    public static final String MATERNAL_UNCLE_SURNAME_REQUIRED = "Maternal uncle's surname is required.";
    public static final String MATERNAL_UNCLE_SURNAME_SIZE = "Maternal uncle's surname must be between 2 and 50 characters.";
    public static final String MATERNAL_UNCLE_SURNAME_PLACE_REQUIRED = "Maternal uncle's surname place is required.";
    public static final String MATERNAL_UNCLE_SURNAME_PLACE_SIZE = "Place name must be between 2 and 100 characters.";
    public static final String NATIVE_CITY_LIST_NULL = "Native city list cannot be null.";
    public static final String NATIVE_CITY_LIST_SIZE = "Please provide between 1 and 5 native cities.";
    public static final String NATIVE_CITY_BLANK = "Each native city name must not be blank.";
    public static final String NATIVE_CITY_SIZE = "Each native city name must be between 2 and 100 characters.";
    public static final String NATIVE_TALUKA_LIST_NULL = "Native taluka list cannot be null.";
    public static final String NATIVE_TALUKA_LIST_SIZE = "Please provide between 1 and 5 native talukas.";
    public static final String NATIVE_TALUKA_BLANK = "Each native taluka name must not be blank.";
    public static final String NATIVE_TALUKA_SIZE = "Each native taluka name must be between 2 and 100 characters.";
    public static final String INTERCAST_MARRIAGE_CORE_FAMILY_REQUIRED = "Please specify whether there is any intercast marriage in the core family.";
    public static final String INTERCAST_MARRIAGE_CORE_FAMILY_CAST_MAX = "Cast name must not exceed 100 characters.";

    // Error messages for HeroScopeDetailsDTO
    public static final String RASHI_NULL = "Rashi cannot be null.";
    public static final String INVALID_RASHI = "Invalid rashi area value.";
    public static final String NAKSHATRA_NULL = "Nakshatra cannot be null.";
    public static final String INVALID_NAKSHATRA = "Invalid Nakshatra value.";
    public static final String CHARAN_NULL = "Charan cannot be null.";
    public static final String INVALID_CHARAN = "Invalid Charan value.";
    public static final String NADI_NULL = "Nadi cannot be null.";
    public static final String INVALID_NADI = "Invalid nadi value.";
    public static final String GAN_NULL = "Gan cannot be empty.";
    public static final String INVALID_GAN = "Invalid Gan value.";
    public static final String MANGAL_NULL = "Mangal cannot be null.";
    public static final String INVALID_MANGAL = "Invalid mangal value.";
    public static final String BIRTH_TIME_REQUIRED = "Birth time is required.";
    public static final String BIRTH_STATE_REQUIRED = "Birth state(s) must be provided.";
    public static final String BIRTH_STATE_SIZE = "Please provide between 1 and 5 states of birth.";
    public static final String BIRTH_STATE_BLANK = "Each birth state must not be blank.";
    public static final String BIRTH_STATE_SIZE_LENGTH = "Each birth state must be between 2 and 100 characters.";
    public static final String BIRTH_CITY_REQUIRED = "Birth city(ies) must be provided.";
    public static final String BIRTH_CITY_SIZE = "Please provide between 1 and 5 cities of birth.";
    public static final String BIRTH_CITY_BLANK = "Each birth city must not be blank.";
    public static final String BIRTH_CITY_SIZE_LENGTH = "Each birth city must be between 2 and 100 characters.";
    public static final String IS_ABROAD_BORN_REQUIRED = "Please specify whether born abroad or not.";
    public static final String BIRTH_COUNTRY_REQUIRED = "Birth country(ies) must be provided.";
    public static final String BIRTH_COUNTRY_SIZE = "Please provide between 1 and 3 countries of birth.";
    public static final String BIRTH_COUNTRY_BLANK = "Each birth country must not be blank.";
    public static final String BIRTH_COUNTRY_SIZE_LENGTH = "Each birth country must be between 2 and 100 characters.";
    // Error messages for PersonalDetailsDTO
    public static final String FIRST_NAME_REQUIRED = "First name is required.";
    public static final String FIRST_NAME_SIZE = "First name must not exceed 50 characters.";
    public static final String MIDDLE_NAME_SIZE = "Middle name must not exceed 50 characters.";
    public static final String LAST_NAME_REQUIRED = "Last name is required.";
    public static final String LAST_NAME_SIZE = "Last name must not exceed 50 characters.";
    public static final String BIRTH_DATE_REQUIRED = "Birth date is required.";
    public static final String BIRTH_DATE_PAST = "Birth date must be in the past.";
    public static final String CAST_REQUIRED = "Cast cannot be null.";
    public static final String INVALID_CAST = "Invalid Cast value.";
    public static final String MARITAL_STATUS_REQUIRED = "Martial Status cannot be null.";
    public static final String INVALID_MARITAL_STATUS = "Invalid Martial Status value.";
    public static final String CHILD_COUNT_NEGATIVE = "Child count cannot be negative.";
    public static final String CHILD_COUNT_EXCEED = "Child count cannot exceed 10.";
    public static final String HEIGHT_REQUIRED = "Height is required.";
    public static final String HEIGHT_MIN = "Height must be at least 2.0 feet.";
    public static final String HEIGHT_MAX = "Height must not exceed 8.0 feet.";
    public static final String WEIGHT_REQUIRED = "Weight is required.";
    public static final String WEIGHT_MIN = "Weight must be at least 20 kg.";
    public static final String WEIGHT_MAX = "Weight must not exceed 200 kg.";
    public static final String BLOOD_GROUP_REQUIRED = "Blood Group cannot be null.";
    public static final String INVALID_BLOOD_GROUP = "Invalid Blood Group value.";
    public static final String COMPLEXION_REQUIRED = "Complexion cannot be null.";
    public static final String INVALID_COMPLEXION = "Invalid complexion value.";
    public static final String DISABILITY_SPECIFICATION_SIZE = "Specification for disability must not exceed 200 characters.";
    public static final String DIET_REQUIRED = "Diet cannot be null.";
    public static final String INVALID_DIET = "Invalid diet value.";
    public static final String PERSONALITY_SIZE = "Personality description must not exceed 250 characters.";
//Error messages for PhotosDTO
    public static final String PROFILE_ID_REQUIRED = "Profile ID is required.";
    public static final String PHOTO_URL_REQUIRED = "Photo URL or path is required.";
    public static final String PHOTO_PATH_SIZE = "Photo path must not exceed 255 characters.";
    // User login related constants
    public static final String USERNAME_BLANK_MESSAGE = "User name must not blank";
    public static final String USERNAME_FORMAT_MESSAGE = "Username must follow the correct format.";
    public static final String USERNAME_SIZE_MESSAGE = "Try logging in with the username that was generated during registration. The username must be between 12 and 50 characters long.";
    // Password related constants
    public static final String PASSWORD_BLANK_MESSAGE = "Password is required.";
    public static final String PASSWORD_FORMAT_MESSAGE = "Try logging in with the password you created during registration. The password must be between 8 and 20 characters long and include at least one letter, one number, and one special character.";

    public static final String FIRST_NAME_BLANK_MESSAGE = "First name is required.";
    public static final String FIRST_NAME_SIZE_MESSAGE = "Full name must be between 2 and 100 characters.";

    public static final String LAST_NAME_BLANK_MESSAGE = "Last name is required.";
    public static final String LAST_NAME_SIZE_MESSAGE = "Full name must be between 2 and 100 characters.";

    public static final String GENDER_BLANK_MESSAGE = "Gender is required.";
    public static final String GENDER_PATTERN_MESSAGE = "Gender must be Male, Female, or Other.";

    public static final String EMAIL_PATTERN_MESSAGE = "Email must be a valid Gmail address.";

    public static final String MOBILE_NUMBER_BLANK_MESSAGE = "Mobile is required.";
    public static final String MOBILE_NUMBER_PATTERN_MESSAGE = "Phone number must be between 6 to 15 digits and contain only numbers.";
    public static final String MOBILE_NUMBER_SIZE_MESSAGE = "Mobile number must be exactly 10 digits.";


    public static final String PASSWORD_PATTERN_MESSAGE = "Try logging in with the password you created during registration. The password must be between 8 and 20 characters long and include at least one letter, one number, and one special character.";

    public static final String PLANS_BLANK_MESSAGE = "Plans cannot be null.";
    public static final String INVALID_PLAN_MESSAGE = "Invalid plan value.";
    public static final String LOGOUT = "You have been signed out!!.";

    public static final String USER_ENROLLMENT_SUCCESSFUL_MESSAGE = "Your profile has been successfully updated! You can now log in using your username and registered password";
    public static final String USER_ENROLLMENT_FAILED_MESSAGE = "Invalid input data detected. It seems some required fields are missing, have incorrect values, or the data format is incorrect. Please review your input and ensure it meets the required format and includes all necessary information before submitting again.";
}

