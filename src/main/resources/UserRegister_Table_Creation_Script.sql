USE  MATRIMONY;
CREATE TABLE MATRIMONY.`user_register` (
    -- Identity
                                 `user_register_id` BIGINT NOT NULL AUTO_INCREMENT,
                                 PRIMARY KEY (`user_register_id`),

    -- Authentication / Account Status
                                 `username` VARCHAR(50) NOT NULL,
                                 `password` VARCHAR(255) NOT NULL,
                                 `account_non_locked` BIT(1) DEFAULT NULL,
                                 `failed_login_attempts` INT NOT NULL,
                                 `lock_time` VARCHAR(255) DEFAULT NULL,
                                 `password_expiration_date` VARCHAR(255) DEFAULT NULL,

    -- Contact Information
                                 `email` VARCHAR(255) NOT NULL,
                                 `mobile_number` VARCHAR(255) NOT NULL,

    -- Personal Information
                                 `first_name` VARCHAR(255) NOT NULL,
                                 `middle_name` VARCHAR(255) DEFAULT NULL,
                                 `last_name` VARCHAR(255) NOT NULL,
                                 `gender` VARCHAR(255) NOT NULL,

    -- Plan Details
                                 `plan` varchar(255) NOT NULL,,

    -- Audit Fields - Add
                                 `add_by_user` VARCHAR(255) DEFAULT NULL,
                                 `add_date` VARCHAR(255) DEFAULT NULL,
                                 `add_time` VARCHAR(255) DEFAULT NULL,

    -- Audit Fields - Modify
                                 `mdf_by_user` VARCHAR(255) DEFAULT NULL,
                                 `mdf_date` VARCHAR(255) DEFAULT NULL,
                                 `mdf_time` VARCHAR(255) DEFAULT NULL,

    -- Audit Fields - Delete
                                 `del_by_user` VARCHAR(255) DEFAULT NULL,
                                 `del_date` VARCHAR(255) DEFAULT NULL,
                                 `del_time` VARCHAR(255) DEFAULT NULL,
                                 `del_flg` INT DEFAULT NULL,

    -- Unique Constraints
                                 UNIQUE KEY `UK_EMAIL` (`email`),
                                 UNIQUE KEY `UK_MOBILE_NUMBER` (`mobile_number`)
) ENGINE=InnoDB
  AUTO_INCREMENT=4
  DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_0900_ai_ci;

-- Start auto-increment from 100000
ALTER TABLE user_register AUTO_INCREMENT = 100000;

COMMIT;
