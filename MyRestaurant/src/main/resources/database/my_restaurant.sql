CREATE DATABASE IF NOT EXISTS `my_restaurant`;

USE `my_restaurant`;

CREATE TABLE IF NOT EXISTS `category` (
	`code` INT PRIMARY KEY,
    `name` VARCHAR(100) NOT NULL
);

-- category 데이터 삽입
INSERT INTO `category` (`code`, `name`) 
VALUES
(100, '한식'),
(200, '일식'),
(300, '양식'),
(400, '중식'),
(500, '카페');

CREATE TABLE IF NOT EXISTS `restaurant` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL,
    `location` VARCHAR(100) NOT NULL,
    `category_code` INT NOT NULL,
    `signature_menu` VARCHAR(100) NULL,
    `phone_number` VARCHAR(100) NULL,
    `img` VARCHAR(100) NULL,
    FOREIGN KEY (`category_code`) REFERENCES `category`(`code`)
);

-- restaurant 데이터 삽입
INSERT INTO `restaurant` (`name`, `location`, `category_code`, `signature_menu`, `phone_number`) 
VALUES
('청화월', '수원시 영통구', 400, '마라우육면', '031-203-7807'),
('장터밥상', '수원시 영통구', 100, '제육볶음', '031-203-4846'),
('썬프란시스코마켓', '수원시 영통구', 300, '썬프란시스코마켓 피자와 매운딸기소스', '031-548-0388'),
('쏘울피', '수원시 영통구', 300, '꽃페퍼로니피자', '0507-1338-4131'),
('이루카', '수원시 영통구', 200, '초밥', '010-2243-5078'),
('노팅힐', '수원시 팔달구', 500, '무화과 얼그레이 케이크', '0504-0813-6407'),
('존앤진피자펍', '수원시 팔달구', 300, '꽈뜨로 피자', '010-7514-5189'),
('벽돌해피푸드 압구정점', '서울 강남구', 400, '마라샹궈', '02-514-0200'),
('꽁티드툴레아 도산점', '서울 강남구', 300, '브런치', '070-8846-8490'),
('홍라드', '수원시 팔달구', 500, '전남친 토스트', '010-9141-3736');

CREATE TABLE IF NOT EXISTS `user` (
	`id` VARCHAR(100) PRIMARY KEY,
    `password` VARCHAR(100) NOT NULL,
    `name` VARCHAR(100) NOT NULL,
    `img` VARCHAR(100) NULL
);

-- user 데이터 삽입
INSERT INTO `user` (`id`, `password`, `name`)
VALUES ('hellokitty', '1234', '헬로키티');

commit;

SELECT * FROM `restaurant`;

