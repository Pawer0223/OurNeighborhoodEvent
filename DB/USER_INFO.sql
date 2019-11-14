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

COMMENT ON COLUMN USER_INFO.email IS '�̸����ּ�'
/

COMMENT ON COLUMN USER_INFO.password IS '��й�ȣ'
/

COMMENT ON COLUMN USER_INFO.first_name IS '��'
/

COMMENT ON COLUMN USER_INFO.last_name IS '�̸�'
/

COMMENT ON COLUMN USER_INFO.creation_date IS '�����Ͻ�'
/

COMMENT ON COLUMN USER_INFO.update_date IS '�����Ͻ�'
/

INSERT INTO USER_INFO (email, password, first_name, last_name, creation_date, update_date) VALUES ('e1@naver.com', 'pw1', '��', '����', sysdate, null);
INSERT INTO USER_INFO (email, password, first_name, last_name, creation_date, update_date) VALUES ('e2@naver.com', 'pw2', '��', '��', sysdate, null);
INSERT INTO USER_INFO (email, password, first_name, last_name, creation_date, update_date) VALUES ('e3@naver.com', 'pw3', '��', '��', sysdate, null);
INSERT INTO USER_INFO (email, password, first_name, last_name, creation_date, update_date) VALUES ('e4@naver.com', 'pw4', '��', '��', sysdate, null);
INSERT INTO USER_INFO (email, password, first_name, last_name, creation_date, update_date) VALUES ('e5@naver.com', 'pw5', '��', '����', sysdate, null);
INSERT INTO USER_INFO (email, password, first_name, last_name, creation_date, update_date) VALUES ('e6@naver.com', 'pw6', '��', '��', sysdate, null);
INSERT INTO USER_INFO (email, password, first_name, last_name, creation_date, update_date) VALUES ('e7@naver.com', 'pw7', '��', '��������', sysdate, null);
INSERT INTO USER_INFO (email, password, first_name, last_name, creation_date, update_date) VALUES ('e8@naver.com', 'pw8', '��', '��', sysdate, null);
INSERT INTO USER_INFO (email, password, first_name, last_name, creation_date, update_date) VALUES ('e9@naver.com', 'pw9', '��', '��', sysdate, null);
INSERT INTO USER_INFO (email, password, first_name, last_name, creation_date, update_date) VALUES ('e10@naver.com','pw10','��', '��', sysdate, null);

commit;
