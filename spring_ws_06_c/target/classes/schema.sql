drop table if exists Board;
CREATE table Board (
  id int not null primary key auto_increment,
  title varchar(100) not null,
  content text not null,
  created datetime not null DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO Board (title, content) VALUES ('간단한 SSAFY 게시글', '간단한 내용입니다.');
INSERT INTO Board (title, content) VALUES ('알고리즘 스터디 모집', '알고리즘 스터디원 모집합니다.');
INSERT INTO Board (title, content) VALUES ('CS 스터디 모집', 'CS 스터디원 모집합니다.');