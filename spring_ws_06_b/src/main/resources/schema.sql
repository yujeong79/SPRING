drop table if exists employee;
CREATE TABLE `employee` (
  `id` int NOT NULL primary key AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `position` varchar(30) DEFAULT NULL,
  `department` varchar(30) DEFAULT NULL
);

INSERT INTO `employee` (`id`, `name`, `position`, `department`) VALUES (1, '홍길동', '부장', '인사부');
INSERT INTO `employee` (`id`, `name`, `position`, `department`) VALUES (2, '이순신', '과장', '마케팅부');
INSERT INTO `employee` (`id`, `name`, `position`, `department`) VALUES (3, '김유신', '대리', '영업부');
INSERT INTO `employee` (`id`, `name`, `position`, `department`) VALUES (4, '신사임당', '사원', '기획부');
INSERT INTO `employee` (`id`, `name`, `position`, `department`) VALUES (5, '세종대왕', '부장', '재무부');
INSERT INTO `employee` (`id`, `name`, `position`, `department`) VALUES (6, '윤봉길', '과장', '인사부');
INSERT INTO `employee` (`id`, `name`, `position`, `department`) VALUES (7, '한석봉', '대리', '마케팅부');
INSERT INTO `employee` (`id`, `name`, `position`, `department`) VALUES (8, '대조영', '사원', '영업부');
INSERT INTO `employee` (`id`, `name`, `position`, `department`) VALUES (9, '장보고', '부장', '기획부');
INSERT INTO `employee` (`id`, `name`, `position`, `department`) VALUES (10, '강감찬', '과장', '재무부');
