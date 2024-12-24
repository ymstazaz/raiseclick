--ENUMは一旦VARCHARになってる。落ち着いたら修正
CREATE TABLE IF NOT EXISTS users (
 id          BIGINT AUTO_INCREMENT PRIMARY KEY,
 name        VARCHAR(50) NOT NULL,
 address     VARCHAR(100) NOT NULL UNIQUE,
 password    VARCHAR(255) NOT NULL,
 prefecture  VARCHAR(50) NOT NULL,
 city        VARCHAR(50) NOT NULL,
 gender      ENUM('男','女','秘密') NOT NULL,
 age         ENUM('10代', '20代', '30代', '40代', '50代', '60代以上') NOT NULL
);

CREATE TABLE IF NOT EXISTS spot(
 id BIGINT AUTO_INCREMENT PRIMARY KEY,
 spot_name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS review(
 id            BIGINT AUTO_INCREMENT PRIMARY KEY,
 image_path    VARCHAR(255),
 situation     VARCHAR(50) NOT NULL,
 review_age    ENUM('10代', '20代', '30代', '40代', '50代', '60代以上') NOT NULL,
 review_gender ENUM('男','女','秘密') NOT NULL,
 free_comment  TEXT,
 spot_id       BIGINT NOT NULL,
 user_id       BIGINT,
 created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 FOREIGN KEY (spot_id) REFERENCES spot(id),
 FOREIGN KEY (user_id) REFERENCES user(id)
 );

CREATE TABLE IF NOT EXISTS purpose(
id            BIGINT AUTO_INCREMENT PRIMARY KEY,
purpose_name  VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS review_purpose(
 id            BIGINT AUTO_INCREMENT PRIMARY KEY,
 review_id     BIGINT NOT NULL,
 purpose_id    BIGINT NOT NULL,
 nth_purpose   INT,
 satisfaction  INT,
 FOREIGN KEY (review_id) REFERENCES review(id) ON DELETE CASCADE,
 FOREIGN KEY (purpose_id) REFERENCES purpose(id) ON DELETE CASCADE
 );

 CREATE TABLE IF NOT EXISTS diary(
 id             BIGINT AUTO_INCREMENT PRIMARY KEY,
 review_id      BIGINT NOT NULL,
 users_id       BIGINT NOT NULL,
 Transportation VARCHAR(50) NOT NULL,
 cost           INT,
 full_cost      INT,
 frequency      INT NOT NULL,
 FOREIGN KEY (review_id) REFERENCES review(id) ON DELETE CASCADE,
 FOREIGN KEY (users_id) REFERENCES users(id) ON DELETE CASCADE
 );

