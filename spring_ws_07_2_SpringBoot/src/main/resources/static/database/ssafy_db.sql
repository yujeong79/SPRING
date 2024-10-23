CREATE DATABASE IF NOT EXISTS ssafy_db;

USE ssafy_db;

CREATE TABLE `movies` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `title` VARCHAR(100) NOT NULL,
    `director` VARCHAR(100) NOT NULL,
    `genre` VARCHAR(100),
    `content` VARCHAR(100),
    `running_time` INT,
    `img` VARCHAR(100),
    `org_img` VARCHAR(100)
);

CREATE TABLE `users` (
	`id` VARCHAR(100) PRIMARY KEY,
    `password` VARCHAR(100) NOT NULL,
    `name` VARCHAR(100) NOT NULL,
	`img` VARCHAR(100),
    `org_img` VARCHAR(100)
);

INSERT INTO `users` (`id`, `password`, `name`)
VALUES ("ssafy", "1234", "김싸피"),
		("admin", "1234", "관리자");
        
INSERT INTO `movies` (`id`, `title`, `director`, `genre`, `content`, `running_time`)
VALUES (0, "해리포터와 마법사의 돌", "크리스 콜럼버스", "판타지", "해리포터 첫번째 시리즈", 152),
	(0, "해리포터와 비밀의 방", "크리스 콜럼버스", "판타지", "해리포터 두번째 시리즈", 161);
        
commit;

SELECT * FROM `users`;
SELECT * FROM `movies`;

