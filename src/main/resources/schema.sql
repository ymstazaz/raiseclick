CREATE TABLE IF NOT EXISTS users (
 id          INT AUTO_INCREMENT PRIMARY KEY,
 name        VARCHAR(50) NOT NULL,
 address     VARCHAR(100) NOT NULL UNIQUE,
 password    VARCHAR(255) NOT NULL,
 prefecture  VARCHAR(50) NOT NULL,
 city        VARCHAR(50) NOT NULL,
 gender      ENUM('男','女','秘密') NOT NULL,
 age         ENUM('10代', '20代', '30代', '40代', '50代', '60代以上') NOT NULL
);