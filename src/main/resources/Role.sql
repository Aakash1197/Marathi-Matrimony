USE MATRIMONY;

CREATE TABLE `roles` (
                         `role_id` bigint NOT NULL AUTO_INCREMENT,
                         `role_name` varchar(20) DEFAULT NULL,
                         `add_time` varchar(255) DEFAULT NULL,
                         `add_date` varchar(255) DEFAULT NULL,
                         `add_by_user` bigint DEFAULT NULL,
                         `mdf_time` varchar(255) DEFAULT NULL,
                         `mdf_date` varchar(255) DEFAULT NULL,
                         `mdf_by_user` bigint DEFAULT NULL,
                         `del_time` varchar(255) DEFAULT NULL,
                         `del_date` varchar(255) DEFAULT NULL,
                         `del_by_user` bigint DEFAULT NULL,
                         `del_flg` int DEFAULT NULL,
                         PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


COMMIT ;