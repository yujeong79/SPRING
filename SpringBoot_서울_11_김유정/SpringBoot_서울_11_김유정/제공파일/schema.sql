DROP DATABASE IF EXISTS spring_test;
CREATE DATABASE spring_test;
USE spring_test;

CREATE TABLE specialty (
    specialty_code INT PRIMARY KEY, -- 컬럼 specialty_code, int형 데이터 타입, 기본키
    specialty_name VARCHAR(100) NOT NULL  -- 컬럼 specialty_name, 문자열 데이터 타입, NULL 허용되지 않음
);

CREATE TABLE doctor (
    doctor_id INT PRIMARY KEY, -- 컬럼 doctor_id, int형 데이터 타입, 기본키
    name VARCHAR(100) NOT NULL, -- 컬럼 name, 문자열 데이터 타입, NULL 허용되지 않음
    age INT NOT NULL,  -- 컬럼 age, int형 데이터 타입, NULL 허용되지 않음
    specialty_code INT, -- 컬럼 specialty_code, int형 데이터 타입
    experience_years INT, -- 컬럼 experience_years, int형 데이터 타입
    FOREIGN KEY (specialty_code) REFERENCES specialty(specialty_code) -- specialty 테이블의 specialty_code를 참조해서 speicalty_code 외래키 등록
);

commit;

INSERT INTO specialty (specialty_code, specialty_name)
VALUES (1, '심장내과');

INSERT INTO doctor (doctor_id, name, age, specialty_code, experience_years)
VALUES (1, 'Dr.Yang', 45, 1, 20);


SELECT * FROM specialty;
SELECT * FROM doctor;
