-- `blog-system`.QRTZ_CALENDARS definition

CREATE TABLE `QRTZ_CALENDARS` (
                                  `SCHED_NAME` varchar(120) NOT NULL,
                                  `CALENDAR_NAME` varchar(190) NOT NULL,
                                  `CALENDAR` blob NOT NULL,
                                  PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- `blog-system`.QRTZ_FIRED_TRIGGERS definition

CREATE TABLE `QRTZ_FIRED_TRIGGERS` (
                                       `SCHED_NAME` varchar(120) NOT NULL,
                                       `ENTRY_ID` varchar(95) NOT NULL,
                                       `TRIGGER_NAME` varchar(190) NOT NULL,
                                       `TRIGGER_GROUP` varchar(190) NOT NULL,
                                       `INSTANCE_NAME` varchar(190) NOT NULL,
                                       `FIRED_TIME` bigint(13) NOT NULL,
                                       `SCHED_TIME` bigint(13) NOT NULL,
                                       `PRIORITY` int(11) NOT NULL,
                                       `STATE` varchar(16) NOT NULL,
                                       `JOB_NAME` varchar(190) DEFAULT NULL,
                                       `JOB_GROUP` varchar(190) DEFAULT NULL,
                                       `IS_NONCONCURRENT` varchar(1) DEFAULT NULL,
                                       `REQUESTS_RECOVERY` varchar(1) DEFAULT NULL,
                                       PRIMARY KEY (`SCHED_NAME`,`ENTRY_ID`),
                                       KEY `IDX_QRTZ_FT_TRIG_INST_NAME` (`SCHED_NAME`,`INSTANCE_NAME`),
                                       KEY `IDX_QRTZ_FT_INST_JOB_REQ_RCVRY` (`SCHED_NAME`,`INSTANCE_NAME`,`REQUESTS_RECOVERY`),
                                       KEY `IDX_QRTZ_FT_J_G` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
                                       KEY `IDX_QRTZ_FT_JG` (`SCHED_NAME`,`JOB_GROUP`),
                                       KEY `IDX_QRTZ_FT_T_G` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
                                       KEY `IDX_QRTZ_FT_TG` (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- `blog-system`.QRTZ_JOB_DETAILS definition

CREATE TABLE `QRTZ_JOB_DETAILS` (
                                    `SCHED_NAME` varchar(120) NOT NULL,
                                    `JOB_NAME` varchar(190) NOT NULL,
                                    `JOB_GROUP` varchar(190) NOT NULL,
                                    `DESCRIPTION` varchar(250) DEFAULT NULL,
                                    `JOB_CLASS_NAME` varchar(250) NOT NULL,
                                    `IS_DURABLE` varchar(1) NOT NULL,
                                    `IS_NONCONCURRENT` varchar(1) NOT NULL,
                                    `IS_UPDATE_DATA` varchar(1) NOT NULL,
                                    `REQUESTS_RECOVERY` varchar(1) NOT NULL,
                                    `JOB_DATA` blob,
                                    PRIMARY KEY (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
                                    KEY `IDX_QRTZ_J_REQ_RECOVERY` (`SCHED_NAME`,`REQUESTS_RECOVERY`),
                                    KEY `IDX_QRTZ_J_GRP` (`SCHED_NAME`,`JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- `blog-system`.QRTZ_LOCKS definition

CREATE TABLE `QRTZ_LOCKS` (
                              `SCHED_NAME` varchar(120) NOT NULL,
                              `LOCK_NAME` varchar(40) NOT NULL,
                              PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- `blog-system`.QRTZ_PAUSED_TRIGGER_GRPS definition

CREATE TABLE `QRTZ_PAUSED_TRIGGER_GRPS` (
                                            `SCHED_NAME` varchar(120) NOT NULL,
                                            `TRIGGER_GROUP` varchar(190) NOT NULL,
                                            PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- `blog-system`.QRTZ_SCHEDULER_STATE definition

CREATE TABLE `QRTZ_SCHEDULER_STATE` (
                                        `SCHED_NAME` varchar(120) NOT NULL,
                                        `INSTANCE_NAME` varchar(190) NOT NULL,
                                        `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
                                        `CHECKIN_INTERVAL` bigint(13) NOT NULL,
                                        PRIMARY KEY (`SCHED_NAME`,`INSTANCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- `blog-system`.article definition

CREATE TABLE `article` (
                           `article_id` varchar(32) NOT NULL,
                           `class_id` varchar(32) NOT NULL,
                           `user_id` varchar(32) NOT NULL,
                           `title` varchar(32) NOT NULL,
                           `summary` varchar(255) DEFAULT NULL,
                           `poll_count` int(11) NOT NULL DEFAULT '0',
                           `comment_count` int(11) NOT NULL DEFAULT '0',
                           `read_count` int(11) NOT NULL DEFAULT '0',
                           `is_essence` smallint(1) NOT NULL DEFAULT '0' COMMENT '0默认不是精华\r\n',
                           PRIMARY KEY (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- `blog-system`.article_classification definition

CREATE TABLE `article_classification` (
                                          `article_classification_id` varchar(32) NOT NULL,
                                          `classification_name` varchar(32) NOT NULL,
                                          `create_time` datetime NOT NULL,
                                          `update_time` datetime NOT NULL,
                                          PRIMARY KEY (`article_classification_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- `blog-system`.article_detail definition

CREATE TABLE `article_detail` (
                                  `article_detail_id` varchar(32) NOT NULL,
                                  `article_id` varchar(32) NOT NULL,
                                  `content` text,
                                  `create_time` datetime NOT NULL,
                                  `update_time` datetime NOT NULL,
                                  PRIMARY KEY (`article_detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- `blog-system`.article_poll definition

CREATE TABLE `article_poll` (
                                `article_poll_id` varchar(32) NOT NULL,
                                `create_time` datetime NOT NULL,
                                `article_id` varchar(32) NOT NULL,
                                `user_id` varchar(32) DEFAULT NULL,
                                `is_positive` smallint(6) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- `blog-system`.comment definition

CREATE TABLE `comment` (
                           `comment_id` varchar(32) NOT NULL,
                           `comment_time` datetime NOT NULL,
                           `comment_content` varchar(100) DEFAULT NULL,
                           `user_id` varchar(32) NOT NULL COMMENT '评论人用户ID',
                           `article_id` varchar(32) NOT NULL,
                           `father_comment_id` varchar(32) NOT NULL,
                           PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- `blog-system`.comment_poll definition

CREATE TABLE `comment_poll` (
                                `comment_poll_id` varchar(32) NOT NULL,
                                `create_time` datetime NOT NULL COMMENT '点赞时间',
                                `comment_id` varchar(32) DEFAULT NULL,
                                `user_id` varchar(32) NOT NULL,
                                `is_positive` smallint(6) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- `blog-system`.message_send definition

CREATE TABLE `message_send` (
                                `message_send_id` varchar(32) NOT NULL,
                                `nick_name` varchar(32) NOT NULL,
                                `send_type` smallint(6) NOT NULL COMMENT '0短信发送 1邮件发送',
                                `destination` varchar(32) NOT NULL,
                                `template_id` varchar(32) NOT NULL,
                                `is_send` smallint(6) NOT NULL,
                                `create_time` datetime NOT NULL,
                                `update_time` datetime NOT NULL,
                                PRIMARY KEY (`message_send_id`),
                                KEY `message_send_is_send_IDX` (`is_send`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- `blog-system`.permission definition

CREATE TABLE `permission` (
                              `permission_id` varchar(32) NOT NULL,
                              `permission_name` varchar(32) CHARACTER SET utf8 NOT NULL,
                              `create_time` datetime NOT NULL,
                              `update_time` datetime NOT NULL,
                              PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- `blog-system`.`role` definition

CREATE TABLE `role` (
                        `role_id` varchar(32) NOT NULL,
                        `role_name` varchar(32) CHARACTER SET utf8 NOT NULL,
                        `create_time` datetime NOT NULL,
                        `update_time` datetime NOT NULL,
                        `status` smallint(6) DEFAULT NULL,
                        PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- `blog-system`.role_permission definition

CREATE TABLE `role_permission` (
                                   `role_id` varchar(32) NOT NULL,
                                   `permission_id` varchar(32) NOT NULL,
                                   `create_time` datetime NOT NULL,
                                   `update_time` datetime NOT NULL
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
                             `update_time` datetime NOT NULL,
                             `expiration_time` date NOT NULL COMMENT '角色过期时间 '
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- `blog-system`.QRTZ_TRIGGERS definition

CREATE TABLE `QRTZ_TRIGGERS` (
                                 `SCHED_NAME` varchar(120) NOT NULL,
                                 `TRIGGER_NAME` varchar(190) NOT NULL,
                                 `TRIGGER_GROUP` varchar(190) NOT NULL,
                                 `JOB_NAME` varchar(190) NOT NULL,
                                 `JOB_GROUP` varchar(190) NOT NULL,
                                 `DESCRIPTION` varchar(250) DEFAULT NULL,
                                 `NEXT_FIRE_TIME` bigint(13) DEFAULT NULL,
                                 `PREV_FIRE_TIME` bigint(13) DEFAULT NULL,
                                 `PRIORITY` int(11) DEFAULT NULL,
                                 `TRIGGER_STATE` varchar(16) NOT NULL,
                                 `TRIGGER_TYPE` varchar(8) NOT NULL,
                                 `START_TIME` bigint(13) NOT NULL,
                                 `END_TIME` bigint(13) DEFAULT NULL,
                                 `CALENDAR_NAME` varchar(190) DEFAULT NULL,
                                 `MISFIRE_INSTR` smallint(2) DEFAULT NULL,
                                 `JOB_DATA` blob,
                                 PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
                                 KEY `IDX_QRTZ_T_J` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
                                 KEY `IDX_QRTZ_T_JG` (`SCHED_NAME`,`JOB_GROUP`),
                                 KEY `IDX_QRTZ_T_C` (`SCHED_NAME`,`CALENDAR_NAME`),
                                 KEY `IDX_QRTZ_T_G` (`SCHED_NAME`,`TRIGGER_GROUP`),
                                 KEY `IDX_QRTZ_T_STATE` (`SCHED_NAME`,`TRIGGER_STATE`),
                                 KEY `IDX_QRTZ_T_N_STATE` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
                                 KEY `IDX_QRTZ_T_N_G_STATE` (`SCHED_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
                                 KEY `IDX_QRTZ_T_NEXT_FIRE_TIME` (`SCHED_NAME`,`NEXT_FIRE_TIME`),
                                 KEY `IDX_QRTZ_T_NFT_ST` (`SCHED_NAME`,`TRIGGER_STATE`,`NEXT_FIRE_TIME`),
                                 KEY `IDX_QRTZ_T_NFT_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`),
                                 KEY `IDX_QRTZ_T_NFT_ST_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_STATE`),
                                 KEY `IDX_QRTZ_T_NFT_ST_MISFIRE_GRP` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
                                 CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `QRTZ_JOB_DETAILS` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`)
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


-- `blog-system`.QRTZ_BLOB_TRIGGERS definition

CREATE TABLE `QRTZ_BLOB_TRIGGERS` (
                                      `SCHED_NAME` varchar(120) NOT NULL,
                                      `TRIGGER_NAME` varchar(190) NOT NULL,
                                      `TRIGGER_GROUP` varchar(190) NOT NULL,
                                      `BLOB_DATA` blob,
                                      PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
                                      KEY `SCHED_NAME` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
                                      CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `QRTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- `blog-system`.QRTZ_CRON_TRIGGERS definition

CREATE TABLE `QRTZ_CRON_TRIGGERS` (
                                      `SCHED_NAME` varchar(120) NOT NULL,
                                      `TRIGGER_NAME` varchar(190) NOT NULL,
                                      `TRIGGER_GROUP` varchar(190) NOT NULL,
                                      `CRON_EXPRESSION` varchar(120) NOT NULL,
                                      `TIME_ZONE_ID` varchar(80) DEFAULT NULL,
                                      PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
                                      CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `QRTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- `blog-system`.QRTZ_SIMPLE_TRIGGERS definition

CREATE TABLE `QRTZ_SIMPLE_TRIGGERS` (
                                        `SCHED_NAME` varchar(120) NOT NULL,
                                        `TRIGGER_NAME` varchar(190) NOT NULL,
                                        `TRIGGER_GROUP` varchar(190) NOT NULL,
                                        `REPEAT_COUNT` bigint(7) NOT NULL,
                                        `REPEAT_INTERVAL` bigint(12) NOT NULL,
                                        `TIMES_TRIGGERED` bigint(10) NOT NULL,
                                        PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
                                        CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `QRTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- `blog-system`.QRTZ_SIMPROP_TRIGGERS definition

CREATE TABLE `QRTZ_SIMPROP_TRIGGERS` (
                                         `SCHED_NAME` varchar(120) NOT NULL,
                                         `TRIGGER_NAME` varchar(190) NOT NULL,
                                         `TRIGGER_GROUP` varchar(190) NOT NULL,
                                         `STR_PROP_1` varchar(512) DEFAULT NULL,
                                         `STR_PROP_2` varchar(512) DEFAULT NULL,
                                         `STR_PROP_3` varchar(512) DEFAULT NULL,
                                         `INT_PROP_1` int(11) DEFAULT NULL,
                                         `INT_PROP_2` int(11) DEFAULT NULL,
                                         `LONG_PROP_1` bigint(20) DEFAULT NULL,
                                         `LONG_PROP_2` bigint(20) DEFAULT NULL,
                                         `DEC_PROP_1` decimal(13,4) DEFAULT NULL,
                                         `DEC_PROP_2` decimal(13,4) DEFAULT NULL,
                                         `BOOL_PROP_1` varchar(1) DEFAULT NULL,
                                         `BOOL_PROP_2` varchar(1) DEFAULT NULL,
                                         PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
                                         CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `QRTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;