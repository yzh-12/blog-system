-- blog_system.user_info definition

CREATE TABLE user_info
(
    user_id      VARCHAR(32) NOT NULL PRIMARY KEY,
    user_name    VARCHAR(10) NOT NULL,
    nick_name    VARCHAR(32) NOT NULL,
    sex          tinyint     NOT NULL,
    phone_number VARCHAR(11)  DEFAULT NULL,
    email        VARCHAR(32)  DEFAULT NULL,
    avatar_url   VARCHAR(100) DEFAULT NULL,
    create_time  datetime    NOT NULL,
    update_time  datetime     DEFAULT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

INSERT INTO user_info (user_id, user_name, nick_name, sex, phone_number, email, avatar_url, create_time, update_time)
VALUES ('d2034abccc6315b0d30d88168bf4f9bc', 'zenghang', '杨过小龙女', 0, '15179930445', '1248371659@qq.com',
        'http://baidu.com', '2022-07-02 11:10:52', '2022-07-02 11:10:52'),
       ('dd66197dbc47d634e137cd0cd78ab553', 'zenghang', '杨过小龙女', 1, '15179930445', '1248371659@qq.com',
        'http://baidu.com', '2022-07-03 10:31:27', '2022-07-03 10:31:27');


-- blog_system.user_auths definition

CREATE TABLE user_auths
(
    user_auth_id  varchar(32) NOT NULL,
    user_id       varchar(32) NOT NULL,
    identity_type int         NOT NULL,
    identifier    varchar(32)                       DEFAULT NULL,
    credential    varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL,
    create_time   datetime    NOT NULL,
    update_time   datetime    NOT NULL,
    PRIMARY KEY (user_auth_id),
    KEY user_auths_FK (user_id),
    CONSTRAINT user_auths_FK FOREIGN KEY (user_id) REFERENCES user_info (user_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

INSERT INTO user_auths (user_auth_id, user_id, identity_type, identifier, credential, create_time,
                        update_time)
VALUES ('5c16cba6a8f34eb1f89756dbd8a8e496', 'dd66197dbc47d634e137cd0cd78ab553', 0, 'zenghang',
        '$2a$10$xETfzDq.fjJx2LaXULdCLOWiHY2Y.Imb.NDZll6lnLWWndPunlvJi', '2022-07-03 10:31:27', '2022-07-03 10:31:27');
