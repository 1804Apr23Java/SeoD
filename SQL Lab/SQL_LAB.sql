-- Select all records from the Employee table.
SELECT * FROM EMPLOYEE;


-- Select all records from the Employee table where last name is King.
SELECT * FROM EMPLOYEE
WHERE LASTNAME = 'King';


-- Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;


-- Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM ALBUM
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
VALUES(20, 'Owens', 'Gale', 'CPO', '19-apr-21', '02-DEC-03', '66667 New Waver','San Jose', 'CA', 'USA', '+1 (410) 444-5556', '+2 (777) 777-7777', 'owens.gales@whereami.com');


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
SELECT * FROM EMPLOYEE; -- Still fixing

-- Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
DELETE FROM CUSTOMER
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter'; --Still Working on it

-- Create a function that returns the current time.
-- Create a function that returns the length of name in MEDIATYPE table
-- Create a function that returns the average total of all invoices 
-- Create a function that returns the most expensive track
-- Create a function that returns the average price of invoiceline items in the invoiceline table
-- Create a function that returns all employees who are born after 1968.
-- Create a stored procedure that selects the first and last names of all the employees.
-- Create a stored procedure that updates the personal information of an employee.
-- Create a stored procedure that returns the managers of an employee.
-- Create a stored procedure that returns the name and company of a customer.
-- Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
-- Create an after insert trigger on the employee table fired after a new record is inserted into the table.
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