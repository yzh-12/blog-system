-- `blog-system`.`role` definition

CREATE TABLE `role` (
                        `role_id` varchar(32) NOT NULL,
                        `role_name` varchar(32) NOT NULL,
                        `create_time` datetime NOT NULL,
                        `update_time` datetime NOT NULL,
                        `status` smallint(6) DEFAULT NULL,
                        PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- `blog-system`.user_info definition

CREATE TABLE `user_info` (
                             `user_id` varchar(32) NOT NULL,
                             `user_name` varchar(10) NOT NULL,
                             `nick_name` varchar(32) NOT NULL,
                             `sex` tinyint(4) NOT NULL,
                             `phone_number` varchar(11) DEFAULT NULL,
                             `email` varchar(32) DEFAULT NULL,
                             `avatar_url` varchar(100) DEFAULT NULL,
                             `create_time` datetime NOT NULL,
                             `update_time` datetime DEFAULT NULL,
                             PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- `blog-system`.user_role definition

CREATE TABLE `user_role` (
                             `user_id` varchar(32) NOT NULL,
                             `role_id` varchar(32) NOT NULL,
                             `create_time` datetime NOT NULL,
                             `update_time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- `blog-system`.permission definition

CREATE TABLE `permission` (
                              `permission_id` varchar(32) NOT NULL,
                              `permission_name` varchar(32) CHARACTER SET utf8 NOT NULL,
                              `create_time` datetime NOT NULL,
                              `update_time` datetime NOT NULL,
                              PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- `blog-system`.role_permission definition

CREATE TABLE `role_permission` (
                                   `role_id` varchar(32) NOT NULL,
                                   `permission_id` varchar(32) NOT NULL,
                                   `create_time` datetime NOT NULL,
                                   `update_time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- `blog-system`.user_auths definition

CREATE TABLE `user_auths` (
                              `user_auth_id` varchar(32) NOT NULL,
                              `user_id` varchar(32) NOT NULL,
                              `identity_type` int(11) NOT NULL,
                              `identifier` varchar(32) DEFAULT NULL,
                              `credential` varchar(64) DEFAULT NULL,
                              `create_time` datetime NOT NULL,
                              `update_time` datetime NOT NULL,
                              PRIMARY KEY (`user_auth_id`),
                              KEY `user_auths_FK` (`user_id`),
                              CONSTRAINT `user_auths_FK` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
