-- 2.1.1 Select all records from the Employee table.
SELECT * FROM EMPLOYEE;


-- 2.1.2 Select all records from the Employee table where last name is King.
SELECT * FROM EMPLOYEE
WHERE LASTNAME = 'King';


-- 2.1.3 Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;


-- 2.2.1 Select all albums in Album table and sort result set in descending order by title.
SELECT TITLE FROM ALBUM
ORDER BY TITLE DESC;


-- 2.2.2 Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME FROM CUSTOMER
ORDER BY FIRSTNAME ASC;


-- 2.3.1 Insert two new records into Genre table 
INSERT INTO GENRE (GENREID, NAME)
VALUES (26, 'Suicide Pop');

INSERT INTO GENRE (GENREID, NAME)
VALUES (27, 'Anything Goes');


-- 2.3.2 Insert two new records into Employee table
-- Possible Null Values: Postco
INSERT INTO EMPLOYEE 
VALUES (200, 'Jesse3', 'Adams3', 'CTO', 7, '18-APR-20', '01-DEC-03', '66664 New Waver','San Jose', 'CA', 'USA', 'TPP 8x8', '+1 (410) 444-5555', '+1 (777) 777-7477', 'jesse.adam@whereami.com');

INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, PHONE, FAX, EMAIL)
VALUES(20, 'Owens', 'Gale', 'CPO', TO_DATE('19-APR-21 00:00:00', 'dd-mmm-yy hh24:mi:ss'), TO_DATE('02-MAR-18 00:00:00', 'dd-mmm-yy hh24:mi:ss'), '66667 New Waver','San Jose', 'CA', 'USA', '+1 (410) 444-5556', '+2 (777) 777-7777', 'owens.gales@whereami.com');


-- 2.3.3 Insert two new records into Customer table
-- Possible Null values: Company State, postal code,fax,
INSERT INTO CUSTOMER
VALUES(95, 'Eric', 'McEric', 'Eida Corp', '5518 Street', 'Somewhere', 'Texas', 'USA', '44121', '300-xxx-55xx', '+55 555 5555', 'eric.mceric@gmail.com', 3);

INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, ADDRESS, CITY, COUNTRY, PHONE, EMAIL, SUPPORTREPID)
VALUES(96, 'Songoon', 'Park', 'xxx Street', 'Gangnam', 'S. Korea', '+82 17 5582 8422', 'park.songoon@gmail.com', 2);


-- 2.4.1 Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';


-- 2.4.2 Update name of artist in the Artist table �Creedence Clearwater Revival� to �CCR�	
UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';


-- 2.5.1 Select all invoices with a billing address like �T%� 
SELECT * FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';

-- 2.6.1 Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 50;

-- 2.6.2 Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM EMPLOYEE
WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04';

-- 2.7.1 Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
DELETE FROM INVOICELINE
WHERE INVOICEID IN ( SELECT INVOICEID FROM INVOICE
                     WHERE CUSTOMERID IN ( SELECT CUSTOMERID FROM CUSTOMER
                                           WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter'));

DELETE FROM INVOICE
WHERE CUSTOMERID IN ( SELECT CUSTOMERID FROM CUSTOMER
                      WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter');
                    

DELETE FROM CUSTOMER
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';


-- 3.1.1 Create a function that returns the current time.
CREATE OR REPLACE FUNCTION CURRENT_TIME
RETURN VARCHAR
IS Z VARCHAR(100);
BEGIN
SELECT CURRENT_TIMESTAMP
INTO Z
FROM DUAL;
RETURN Z;
END;

DECLARE
A VARCHAR(100);
BEGIN
A := CURRENT_TIME();
DBMS_OUTPUT.PUT_LINE(A);
END;

-- 3.1.2 Create a function that returns the length of name in MEDIATYPE table
CREATE OR REPLACE FUNCTION NAMELENGTH(INPUT VARCHAR)
RETURN NUMBER
IS LENGTHOFNAME NUMBER;
BEGIN
    LENGTHOFNAME := LENGTH(INPUT);
    RETURN LENGTHOFNAME;
END;

DECLARE
TRACK_SIZE NUMBER;
LOOKUPID NUMBER := 3;
TRACKNAME VARCHAR(50);
BEGIN
    SELECT NAME INTO TRACKNAME FROM MEDIATYPE WHERE MEDIATYPEID = LOOKUPID ;
    DBMS_OUTPUT.PUT_LINE('Media Name Length: ' || NAMELENGTH(TRACKNAME));
END;

--Finished


-- 3.2.1 Create a function that returns the average total of all invoices 
CREATE OR REPLACE FUNCTION INVOICE_AVERAGE_TOTAL
RETURN NUMBER 
IS AVERAGE NUMBER;
BEGIN 
   SELECT AVG(TOTAL) INTO AVERAGE
   FROM INVOICE;
   RETURN AVERAGE; 
   --DBMS_OUTPUT.PUT_LINE('AVERAGE: ' || AVERAGE);
END; 

DECLARE
A NUMBER;
BEGIN
A := INVOICE_AVERAGE_TOTAL();
DBMS_OUTPUT.PUT_LINE('Average of Invoice Totals: ' ||A);
END;
--FINISHED


-- 3.2.2 Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION MOST_EXPENSIVE_TRACK
RETURN NUMBER
IS RICH_TRACK NUMBER;
BEGIN
    SELECT MAX(UNITPRICE) INTO RICH_TRACK
    FROM TRACK;
    RETURN RICH_TRACK;
END;

DECLARE
POSTTRACK VARCHAR(100);
BEGIN

    
    SELECT NAME INTO POSTTRACK FROM (
        SELECT NAME FROM TRACK WHERE UNITPRICE = MOST_EXPENSIVE_TRACK ORDER BY DBMS_RANDOM.VALUE)
    WHERE ROWNUM = 1;
    DBMS_OUTPUT.PUT_LINE('Most Expensive Track: ' || POSTTRACK || '    Price: ' || MOST_EXPENSIVE_TRACK);
END;


-- 3.3.1 Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION AVERAGE_INVOICELINE_PRICE
RETURN NUMBER
IS AVERAGE_PRICE NUMBER;
BEGIN
    SELECT AVG(UNITPRICE)INTO AVERAGE_PRICE
    FROM INVOICELINE;
    RETURN AVERAGE_PRICE;
END;

DECLARE
A NUMBER;
BEGIN
A := AVERAGE_INVOICELINE_PRICE();
DBMS_OUTPUT.PUT_LINE('Average of Invoiceline Items: ' ||A);
END;
--FINISHED
    
    
-- 3.4.1 Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE FUNCTION OLDEREMPLOYEE (S OUT SYS_REFCURSOR)
RETURN VARCHAR
IS EMPLOYEE_FNAME VARCHAR(100);
BEGIN
    SELECT FIRSTNAME
    INTO EMPLOYEE_FNAME
    FROM EMPLOYEE;-- WHERE BIRTHDATE > '01-JAN-68';
    RETURN EMPLOYEE_FNAME;
END;

DECLARE
S SYS_REFCURSOR;
FIRST_NAME EMPLOYEE.FIRSTNAME%TYPE;
--EMPLOYEE_BIRTHDATE EMPLOYEE.BIRTHDATE%TYPE;
BEGIN
    OLDEREMPLOYEE(S);
    LOOP
        FETCH S INTO FIRST_NAME;
        EXIT WHEN S%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(FIRST_NAME);
    END LOOP;
    CLOSE S;
END;

-- 4.1.1 Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE GETFIRSTANDLASTNAME (S OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN S FOR 
    SELECT FIRSTNAME, LASTNAME 
    FROM EMPLOYEE;
END;

DECLARE
S SYS_REFCURSOR;
FIRST_NAME EMPLOYEE.FIRSTNAME%TYPE;
LAST_NAME EMPLOYEE.LASTNAME%TYPE;
BEGIN
    GETFIRSTANDLASTNAME(S);
    LOOP
        FETCH S INTO FIRST_NAME, LAST_NAME;
        EXIT WHEN S%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(FIRST_NAME||' '||LAST_NAME);
    END LOOP;
    CLOSE S;
END;


-- 4.2.1 Create a stored procedure that updates the personal information of an employee.
--There has to be a better way...
CREATE OR REPLACE PROCEDURE UPDATEEMPLOYEEINFO (W_EMPLOYEEIDCHECK NUMBER, W_LASTNAME VARCHAR, W_FIRSTNAME VARCHAR, W_TITLE VARCHAR, W_REPORTSTO NUMBER, W_BIRTHDATE VARCHAR, W_HIREDATE VARCHAR, 
W_ADDRESS VARCHAR, W_CITY VARCHAR, W_STATE VARCHAR, W_COUNTRY VARCHAR, W_POSTALCODE VARCHAR, W_PHONE VARCHAR, W_FAX VARCHAR, W_EMAIL VARCHAR)
IS
BEGIN
UPDATE EMPLOYEE
SET LASTNAME = W_LASTNAME, FIRSTNAME = W_FIRSTNAME, TITLE = W_TITLE, REPORTSTO = W_REPORTSTO, BIRTHDATE = W_BIRTHDATE, HIREDATE = W_HIREDATE, 
ADDRESS = W_ADDRESS, CITY = W_CITY, STATE = W_STATE,COUNTRY = W_COUNTRY, POSTALCODE = W_POSTALCODE, PHONE = W_PHONE,FAX = W_FAX, EMAIL = W_EMAIL
WHERE EMPLOYEEID = W_EMPLOYEEIDCHECK;
END;

DECLARE
BEGIN
    UPDATEEMPLOYEEINFO(19, 'Jesse5', 'Adams3', 'CTO', 7, '18-APR-20', '01-DEC-03', '66664 New Waver','San Jose', 'CA', 'USA', 'TPP 8x8', '+1 (410) 444-5555', '+1 (777) 777-7477', 'jesse.adam@whereami.com');
END;

-- 4.2.2 Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE GETMANAGERS (S OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN S FOR 
    SELECT FIRSTNAME, LASTNAME, TITLE
    FROM EMPLOYEE
    WHERE TITLE LIKE '%Manager%';
END;

DECLARE
S SYS_REFCURSOR;
FIRST_NAME EMPLOYEE.FIRSTNAME%TYPE;
LAST_NAME EMPLOYEE.LASTNAME%TYPE;
EMPLOYEE_TITLE EMPLOYEE.TITLE%TYPE;
BEGIN
    GETMANAGERS(S);
    LOOP
        FETCH S INTO FIRST_NAME, LAST_NAME, EMPLOYEE_TITLE;
        EXIT WHEN S%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(FIRST_NAME||' '||LAST_NAME||' '|| EMPLOYEE_TITLE);
    END LOOP;
    CLOSE S;
END;
-- 4.3.1 Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE GETCUSTOMERINFO (S OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN S FOR 
    SELECT FIRSTNAME, LASTNAME, COMPANY
    FROM CUSTOMER;
END;

DECLARE
S SYS_REFCURSOR;
FIRST_NAME CUSTOMER.FIRSTNAME%TYPE;
LAST_NAME CUSTOMER.LASTNAME%TYPE;
CUSTOMER_COMPANY CUSTOMER.COMPANY%TYPE;
BEGIN
    GETCUSTOMERINFO(S);
    LOOP
        FETCH S INTO FIRST_NAME, LAST_NAME, CUSTOMER_COMPANY;
        EXIT WHEN S%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(FIRST_NAME||' '||LAST_NAME||'   Customers Company: '|| CUSTOMER_COMPANY);
    END LOOP;
    CLOSE S;
END;

-- 5.0.1 Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
DECLARE
SEARCHID NUMBER;
CHECKID NUMBER;
NOTEXIST EXCEPTION;
BEGIN
    CHECKID := 30;
    SAVEPOINT INLINE;
    SELECT INVOICEID INTO SEARCHID
    FROM INVOICE
    WHERE INVOICEID = CHECKID;
    
    IF (CHECKID = 0) THEN
    RAISE NOTEXIST;
    END IF;
    
    DELETE FROM INVOICELINE
    WHERE INVOICEID IN ( SELECT INVOICEID FROM INVOICE
                         WHERE INVOICEID = SEARCHID);
      
    DELETE FROM INVOICE
    WHERE INVOICEID = SEARCHID;
    
    EXCEPTION
    WHEN NOTEXIST THEN
        ROLLBACK TO INLINE;
        
    COMMIT;
    
END;
/
-- 6.1.1 Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE TABLE TRIGGEROUTPUT (OUTPUT VARCHAR(15));  --MUST RUN THIS!!!!!!!!!!!!!!!!!!


CREATE OR REPLACE TRIGGER TR_AFTER_INSERT_EMPLOYEE
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
    INSERT INTO TRIGGEROUTPUT VALUES ('EMPLOYEE ADDED');
    --MUST RUN CREATE TABLE FROM 6.1.1!!!!!!!!!!!!!!!!
END;
/

-- 6.1.2 Create an after update trigger on the album table that fires after a row is inserted in the table

CREATE OR REPLACE TRIGGER TR_AFTER_UPDATE_ALBUM
AFTER UPDATE ON ALBUM
FOR EACH ROW
BEGIN
    INSERT INTO TRIGGEROUTPUT VALUES ('ALBUM UPDATED');
    --MUST RUN CREATE TABLE FROM 6.1.1!!!!!!!!!!!!!!!!
END;
/

-- 6.1.3 Create an after delete trigger on the customer table that fires after a row is deleted from the table
CREATE OR REPLACE TRIGGER TR_AFTER_DELETE_CUSTOMER
AFTER DELETE ON CUSTOMER
FOR EACH ROW
BEGIN
    INSERT INTO TRIGGEROUTPUT VALUES ('CUSTOMER DELETED');
    --MUST RUN CREATE TABLE FROM 6.1.1!!!!!!!!!!!!!!!!

END;
/
-- 7.1.1 Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId
SELECT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID
FROM CUSTOMER INNER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;


-- 7.2.1 Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL
FROM CUSTOMER FULL OUTER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

-- 7.3.1 Create a right join that joins album and artist specifying artist name and title
SELECT ARTIST.NAME, ALBUM.TITLE
FROM ARTIST
RIGHT JOIN ALBUM ON ARTIST.ARTISTID = ALBUM.ALBUMID;


-- 7.4.1 Create a cross join that joins album and artist and sorts by artist name in ascending order
SELECT ARTIST.NAME, ALBUM.TITLE
FROM ARTIST CROSS JOIN ALBUM
WHERE ARTIST.ARTISTID = ALBUM.ARTISTID
ORDER BY ARTIST.NAME ASC;


-- 7.5.1 Perform a self-join on the employee table, joining on the reportsto column
SELECT * FROM EMPLOYEE;
SELECT A.FIRSTNAME AS "A.FIRST NAME", A.LASTNAME AS "A.LAST NAME", B.FIRSTNAME AS "B.FIRST NAME", B.LASTNAME AS "B. LASTNAME", A.REPORTSTO AS "A.REPORTSTO", B.REPORTSTO AS "B.REPORTSTO"
FROM EMPLOYEE A, EMPLOYEE B
WHERE A.REPORTSTO = B.REPORTSTO;