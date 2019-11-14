CREATE TABLE USER_INFO
(
    email            VARCHAR2(30)    NOT NULL, 
    password         VARCHAR2(20)    NOT NULL, 
    first_name       VARCHAR2(10)    NOT NULL, 
    last_name        VARCHAR2(10)    NOT NULL, 
    creation_date    DATE            NOT NULL, 
    update_date      DATE            NULL, 
    CONSTRAINT USER_INFO_PK PRIMARY KEY (email)
)
/

COMMENT ON TABLE USER_INFO IS 'USER_INFO'
/

COMMENT ON COLUMN USER_INFO.email IS '이메일주소'
/

COMMENT ON COLUMN USER_INFO.password IS '비밀번호'
/

COMMENT ON COLUMN USER_INFO.first_name IS '성'
/

COMMENT ON COLUMN USER_INFO.last_name IS '이름'
/

COMMENT ON COLUMN USER_INFO.creation_date IS '생성일시'
/

COMMENT ON COLUMN USER_INFO.update_date IS '변경일시'
/

INSERT INTO USER_INFO (email, password, first_name, last_name, creation_date, update_date) VALUES ('e1@naver.com', 'pw1', '강', '감찬', sysdate, null);
INSERT INTO USER_INFO (email, password, first_name, last_name, creation_date, update_date) VALUES ('e2@naver.com', 'pw2', '최', '고', sysdate, null);
INSERT INTO USER_INFO (email, password, first_name, last_name, creation_date, update_date) VALUES ('e3@naver.com', 'pw3', '유', '령', sysdate, null);
INSERT INTO USER_INFO (email, password, first_name, last_name, creation_date, update_date) VALUES ('e4@naver.com', 'pw4', '이', '빨', sysdate, null);
INSERT INTO USER_INFO (email, password, first_name, last_name, creation_date, update_date) VALUES ('e5@naver.com', 'pw5', '고', '릴라', sysdate, null);
INSERT INTO USER_INFO (email, password, first_name, last_name, creation_date, update_date) VALUES ('e6@naver.com', 'pw6', '김', '밥', sysdate, null);
INSERT INTO USER_INFO (email, password, first_name, last_name, creation_date, update_date) VALUES ('e7@naver.com', 'pw7', '강', '강수월래', sysdate, null);
INSERT INTO USER_INFO (email, password, first_name, last_name, creation_date, update_date) VALUES ('e8@naver.com', 'pw8', '강', '남', sysdate, null);
INSERT INTO USER_INFO (email, password, first_name, last_name, creation_date, update_date) VALUES ('e9@naver.com', 'pw9', '강', '북', sysdate, null);
INSERT INTO USER_INFO (email, password, first_name, last_name, creation_date, update_date) VALUES ('e10@naver.com','pw10','강', '동', sysdate, null);

commit;
