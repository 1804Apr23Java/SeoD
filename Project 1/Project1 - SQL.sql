
--TABLES
-------------------------------------------------------------------------------
CREATE TABLE USERS(
USER_ID NUMBER PRIMARY KEY, 
USERNAME VARCHAR(20)UNIQUE NOT NULL, 
PASSWORD VARCHAR(20) UNIQUE,
FIRST_NAME VARCHAR(20), 
LAST_NAME VARCHAR(20), 
EMAIL VARCHAR(20),
SUPER_USER NUMBER
);

CREATE TABLE REIMBURSE(
REIMBURSE_ID NUMBER PRIMARY KEY,
USER_ID NUMBER,
EXPENSES NUMBER,
PENDING_STATE NUMBER, --0 FOR REVIEWING, 1 FOR REJECTED, 2 FOR RESOLVED
MANAGER_VIEW VARCHAR(20) --IF 1 OR 2, LOOK WHO CHANGED IT
)

CREATE TABLE REIMBURSE_IMAGE(
REIMBURSE_IMAGE_ID NUMBER PRIMARY KEY,
USER_ID NUMBER,
PHOTO BLOB
)

ALTER TABLE REIMBURSE MODIFY PENDING_STATE DEFAULT 0 NOT NULL;

ALTER TABLE USERS MODIFY SUPER_USER DEFAULT 0 NOT NULL;


--SEQUENCES AND TRIGGERS FOR PRIMARY KEYS
-------------------------------------------------------------------------------
CREATE SEQUENCE SQ_UNIQUE_USER_ID
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE SQ_UNIQUE_REIMBURSE_ID
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER TR_BEFORE_INSERT_USER
BEFORE INSERT ON USER
FOR EACH ROW
BEGIN
    SELECT SQ_UNIQUE_USER_ID.NEXTVAL INTO :NEW.USER_ID FROM DUAL;
END;

CREATE OR REPLACE TRIGGER TR_BEFORE_INSERT_REIMBURSE
BEFORE INSERT ON REIMBURSE
FOR EACH ROW
BEGIN
    SELECT SQ_UNIQUE_REIMBURSE_ID.NEXTVAL INTO :NEW.REIMBURSE_ID FROM DUAL;
END;



--PROCEDURES FOR JDBC METHODS
-------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE PROC_CHANGE_REIMBURSE_STATE(INPUT_ID NUMBER, MANAGER VARCHAR, NEW_STATE NUMBER)
IS
BEGIN
    UPDATE REIMBURSE
    SET PENDING_STATE = NEW_STATE, MANAGER_VIEW = MANAGER
    WHERE REIMBURSE_ID = INPUT_ID;
END;

CREATE OR REPLACE PROCEDURE PROC_CHANGE_PASSWORD(CHECK_USERNAME VARCHAR, NEW_PASSWORD VARCHAR)
IS
BEGIN
    UPDATE USERS
    SET PASSWORD = NEW_PASSWORD
    WHERE USERNAME = CHECK_USERNAME;
END;

CREATE OR REPLACE PROCEDURE PROC_CHANGE_USER_INFO(NAME1 VARCHAR, NAME2 VARCHAR, NAME3 VARCHAR, NEW_EMAIL VARCHAR)
IS
BEGIN
    UPDATE USERS
    SET FIRST_NAME = NAME2, LAST_NAME = NAME3, EMAIL = NEW_EMAIL
    WHERE USERNAME = NAME1;
END;



