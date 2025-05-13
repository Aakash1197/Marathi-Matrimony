use matrimony;

CREATE TABLE `user_role` (
                             `role_id` bigint NOT NULL,
                             `user_register_id` bigint NOT NULL,
                             PRIMARY KEY (`role_id`,`user_register_id`),
                             KEY `FK_user_register_id` (`user_register_id`),
                             CONSTRAINT `FK_user_role_user_register_id` FOREIGN KEY (`user_register_id`) REFERENCES `user_register` (`user_register_id`),
                             CONSTRAINT `FK_user_role_role_id` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

COMMIT;
