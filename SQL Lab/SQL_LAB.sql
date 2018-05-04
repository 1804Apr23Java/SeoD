-- Select all records from the Employee table.
SELECT * FROM EMPLOYEE;


-- Select all records from the Employee table where last name is King.
SELECT * FROM EMPLOYEE
WHERE LASTNAME = 'King';


-- Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;


-- Select all albums in Album table and sort result set in descending order by title.
SELECT TITLE FROM ALBUM
ORDER BY TITLE DESC;


-- Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME FROM CUSTOMER
ORDER BY FIRSTNAME ASC;


-- Insert two new records into Genre table 
INSERT INTO GENRE (GENREID, NAME)
VALUES (26, 'Suicide Pop');

INSERT INTO GENRE (GENREID, NAME)
VALUES (27, 'Anything Goes');


-- Insert two new records into Employee table
-- Possible Null Values: Postco
INSERT INTO EMPLOYEE 
VALUES (19, 'Jesse', 'Adams', 'CTO', 7, '18-APR-20', '01-DEC-03', '66666 New Waver','San Jose', 'CA', 'USA', 'TPP 8x9', '+1 (410) 444-5555', '+1 (777) 777-7777', 'jesse.adams@whereami.com');

INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, PHONE, FAX, EMAIL)
VALUES(20, 'Owens', 'Gale', 'CPO', TO_DATE('19-APR-21 00:00:00', 'dd-mmm-yy hh24:mi:ss'), TO_DATE('02-MAR-18 00:00:00', 'dd-mmm-yy hh24:mi:ss'), '66667 New Waver','San Jose', 'CA', 'USA', '+1 (410) 444-5556', '+2 (777) 777-7777', 'owens.gales@whereami.com');


-- Insert two new records into Customer table
-- Possible Null values: Company State, postal code,fax,
INSERT INTO CUSTOMER
VALUES(95, 'Eric', 'McEric', 'Eida Corp', '5518 Street', 'Somewhere', 'Texas', 'USA', '44121', '300-xxx-55xx', '+55 555 5555', 'eric.mceric@gmail.com', 3);

INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, ADDRESS, CITY, COUNTRY, PHONE, EMAIL, SUPPORTREPID)
VALUES(96, 'Songoon', 'Park', 'xxx Street', 'Gangnam', 'S. Korea', '+82 17 5582 8422', 'park.songoon@gmail.com', 2);


-- Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';


-- Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”	
UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';


-- Select all invoices with a billing address like “T%” 
SELECT * FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';

-- Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 50;

-- Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM EMPLOYEE
WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04';

-- Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
DELETE FROM INVOICELINE
WHERE INVOICEID IN ( SELECT INVOICEID FROM INVOICE
                     WHERE CUSTOMERID IN ( SELECT CUSTOMERID FROM CUSTOMER
                                           WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter'));

DELETE FROM INVOICE
WHERE CUSTOMERID IN ( SELECT CUSTOMERID FROM CUSTOMER
                      WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter');
                    

DELETE FROM CUSTOMER
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';


-- Create a function that returns the current time.
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


-- Create a function that returns the length of name in MEDIATYPE table
CREATE OR REPLACE FUNCTION NAMELENGTH(( S OUT SYS_REFCURSOR))
RETURN NUMBER
IS LENGTHOFNAME NUMBER;
BEGIN
    OPEN S FOR 
    SELECT LENGTH(NAME) 
    INTO LENGTHOFNAME
    FROM MEDIATYPE;
    DBMS_OUTPUT.PUT_LINE('NAME LENGTH: ' || LENGTHOFNAME);
END;

DECLARE
BEGIN
    NAMELENGTH();
END;
-- Create a function that returns the average total of all invoices 
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


-- Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION MOST_EXPENSIVE_TRACK
RETURN VARCHAR
IS RICH_TRACK VARCHAR(100);
BEGIN
    SELECT NAME INTO RICH_TRACK
    FROM TRACK;
    WHERE MAX(UNITPRICE)
    RETURN RICH_TRACK;
END;


-- Create a function that returns the average price of invoiceline items in the invoiceline table
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
    
    
-- Create a function that returns all employees who are born after 1968.
-- Create a stored procedure that selects the first and last names of all the employees.
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

-- Create a stored procedure that updates the personal information of an employee.
-- Create a stored procedure that returns the managers of an employee.
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
-- Create a stored procedure that returns the name and company of a customer.
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
-- Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
-- Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER TR_INSERT_EMPLOYEE
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
      SELECT SQ_BEAR_FK.NEXTVAL INTO :NEW.BEAR_TYPE_ID FROM DUAL;
END;
-- Create an after update trigger on the album table that fires after a row is inserted in the table
-- Create an after delete trigger on the customer table that fires after a row is deleted from the table

-- Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId
SELECT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID
FROM CUSTOMER INNER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;


-- Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL
FROM CUSTOMER FULL OUTER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

-- Create a right join that joins album and artist specifying artist name and title
SELECT ARTIST.NAME, ALBUM.TITLE
FROM ARTIST
RIGHT JOIN ALBUM ON ARTIST.ARTISTID = ALBUM.ALBUMID;


-- Create a cross join that joins album and artist and sorts by artist name in ascending order
SELECT ARTIST.NAME, ALBUM.TITLE
FROM ARTIST CROSS JOIN ALBUM
WHERE ARTIST.ARTISTID = ALBUM.ARTISTID
ORDER BY ARTIST.NAME ASC;


-- Perform a self-join on the employee table, joining on the reportsto column
SELECT * FROM EMPLOYEE;
SELECT A.FIRSTNAME AS "A.FIRST NAME", A.LASTNAME AS "A.LAST NAME", B.FIRSTNAME AS "B.FIRST NAME", B.LASTNAME AS "B. LASTNAME", A.REPORTSTO AS "A.REPORTSTO", B.REPORTSTO AS "B.REPORTSTO"
FROM EMPLOYEE A, EMPLOYEE B
WHERE A.REPORTSTO = B.REPORTSTO;