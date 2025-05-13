use matrimony;


CREATE TABLE `user_enrollment` (
    -- Primary Key
                                   `user_enrollment_id` BIGINT NOT NULL AUTO_INCREMENT,

    -- Personal Details
                                   `first_name` VARCHAR(50) NOT NULL,
                                   `last_name` VARCHAR(50) NOT NULL,
                                   `middle_name` VARCHAR(50) DEFAULT NULL,
                                   `birth_date` DATE NOT NULL,
                                   `birth_time` DATETIME(6) DEFAULT NULL,
                                   `height` DOUBLE NOT NULL,
                                   `weight` BIGINT NOT NULL,
                                   `complexion` VARCHAR(15) NOT NULL,
                                   `personality` VARCHAR(255) NOT NULL,
                                   `blood_group` VARCHAR(3) NOT NULL,

    -- Contact Details
                                   `mobile_no` VARCHAR(15) DEFAULT NULL,
                                   `mobile_no2` VARCHAR(15) DEFAULT NULL,
                                   `phone_no` VARCHAR(15) DEFAULT NULL,
                                   `phone_no2` VARCHAR(15) DEFAULT NULL,
                                   `email` VARCHAR(100) DEFAULT NULL,

    -- Family & Background Info
                                   `has_father` BIT(1) DEFAULT NULL,
                                   `has_mother` BIT(1) DEFAULT NULL,
                                   `brothers_count` INT DEFAULT NULL,
                                   `married_brothers_count` INT DEFAULT NULL,
                                   `sisters_count` INT DEFAULT NULL,
                                   `married_sisters_count` INT DEFAULT NULL,
                                   `parents_full_name` VARCHAR(255) DEFAULT NULL,
                                   `parents_occupation` VARCHAR(100) DEFAULT NULL,
                                   `parents_occupation_city` VARCHAR(100) DEFAULT NULL,
                                   `parents_resident_city` VARCHAR(100) DEFAULT NULL,

    -- Birth & Native Info
                                   `is_abroad_born` BIT(1) DEFAULT NULL,
                                   `born_citi` VARCHAR(50) DEFAULT NULL,
                                   `born_state` VARCHAR(20) DEFAULT NULL,
                                   `born_country` VARCHAR(50) DEFAULT NULL,
                                   `native_city` VARCHAR(100) DEFAULT NULL,
                                   `native_taluka` VARCHAR(100) DEFAULT NULL,

    -- Education Info
                                   `education_name` VARCHAR(100) DEFAULT NULL,
                                   `education_area` VARCHAR(50) DEFAULT NULL,
                                   `education_city` VARCHAR(50) DEFAULT NULL,
                                   `education_state` VARCHAR(20) DEFAULT NULL,
                                   `education_country` VARCHAR(50) DEFAULT NULL,

    -- Expected Partner Info
                                   `expected_height` DOUBLE DEFAULT NULL,
                                   `expected_cast` VARCHAR(50) DEFAULT NULL,
                                   `expected_education_area` VARCHAR(100) DEFAULT NULL,
                                   `expected_occupation_type` VARCHAR(100) DEFAULT NULL,
                                   `max_age_difference` INT DEFAULT NULL,
                                   `preferred_cities` VARCHAR(255) DEFAULT NULL,

    -- Occupation & Finance
                                   `occupation_type` VARCHAR(50) DEFAULT NULL,
                                   `occupation_details` VARCHAR(255) DEFAULT NULL,
                                   `income_per_month` DOUBLE NOT NULL,
                                   `income_per_annum` BIGINT DEFAULT NULL,
                                   `family_wealth` VARCHAR(50) DEFAULT NULL,

    -- Astrological Info
                                   `mangal` VARCHAR(10) DEFAULT NULL,
                                   `has_mangal` BIT(1) DEFAULT NULL,
                                   `nadi` VARCHAR(10) DEFAULT NULL,
                                   `gan` VARCHAR(15) DEFAULT NULL,
                                   `rashi` VARCHAR(15) DEFAULT NULL,
                                   `nakshatra` VARCHAR(20) DEFAULT NULL,
                                   `charan` VARCHAR(10) DEFAULT NULL,
                                   `pan` VARCHAR(10) DEFAULT NULL,

    -- Marriage Details
                                   `martial_status` VARCHAR(30) NOT NULL,
                                   `divorcee` BIT(1) NOT NULL,
                                   `child` INT DEFAULT NULL,

    -- Physical Attributes
                                   `physical_disablities` BIT(1) NOT NULL,
                                   `spectacles` BIT(1) DEFAULT NULL,
                                   `lens` BIT(1) DEFAULT NULL,

    -- Documents
                                   `aadhaar_id` VARCHAR(12) DEFAULT NULL,
                                   `passport_no` VARCHAR(20) DEFAULT NULL,
                                   `image_url` VARCHAR(255) DEFAULT NULL,

    -- Relatives & Surnames
                                   `surname_of_relatives` VARCHAR(100) DEFAULT NULL,
                                   `maternal_uncle_surname` VARCHAR(50) DEFAULT NULL,
                                   `maternal_uncle_surname_place` VARCHAR(100) DEFAULT NULL,

    -- Intercast Info
                                   `any_intercast_marriage_in_core_family` BIT(1) DEFAULT NULL,
                                   `intercast_marriage_in_corefamily_cast` VARCHAR(100) DEFAULT NULL,
                                   `if_yes_please_specify` VARCHAR(255) DEFAULT NULL,

    -- Address Info
                                   `residence_address_with_city` VARCHAR(255) DEFAULT NULL,

    -- Cast Info
                                   `sub_cast` VARCHAR(50) NOT NULL,
                                   `diet` VARCHAR(15) NOT NULL,

    -- Audit Fields
                                   `add_time` VARCHAR(255) DEFAULT NULL,
                                   `add_date` VARCHAR(255) DEFAULT NULL,
                                   `add_by_user` VARCHAR(255) DEFAULT NULL,
                                   `mdf_time` VARCHAR(255) DEFAULT NULL,
                                   `mdf_date` VARCHAR(255) DEFAULT NULL,
                                   `mdf_by_user` VARCHAR(255) DEFAULT NULL,
                                   `del_time` VARCHAR(255) DEFAULT NULL,
                                   `del_date` VARCHAR(255) DEFAULT NULL,
                                   `del_by_user` VARCHAR(255) DEFAULT NULL,
                                   `del_flg` INT DEFAULT NULL,

    -- Foreign Keys
                                   `user_register_id` BIGINT NOT NULL,

    -- Constraints
                                   PRIMARY KEY (`user_enrollment_id`),
                                   UNIQUE KEY `UK_user_register_id` (`user_register_id`),
                                   UNIQUE KEY `UK_user_enrollment_mobile_no` (`mobile_no`),
                                   UNIQUE KEY `UK_user_enrollment_email` (`email`),
                                   CONSTRAINT `FK_USER_REGISTER_ID`
                                       FOREIGN KEY (`user_register_id`) REFERENCES `user_register` (`user_register_id`)
) ENGINE=InnoDB
  DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_0900_ai_ci;

COMMIT;