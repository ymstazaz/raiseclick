CREATE TABLE IF NOT EXISTS user (
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


