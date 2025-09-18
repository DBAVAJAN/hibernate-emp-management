Hibernate Employee Management System
📋 Overview

A Java console application built with Hibernate ORM and MySQL to demonstrate full CRUD operations.
Users can Create, Read, Update, and Delete employee records directly from the terminal while Hibernate handles all database interactions.

✨ Key Features

Menu-Driven Console UI

1 → View employee by ID

2 → Insert new employee

3 → Update selected fields (name, email, age)

4 → Delete employee by ID

0 → Exit application

Hibernate ORM for seamless mapping between Java objects and MySQL tables.

MySQL Database with an employee table (id, name, email, age, sex).

🛠️ Tech Stack

Language: Java 17+

Framework: Hibernate 6

Database: MySQL 8

Build Tool: Maven

IDE: Eclipse

⚡ Workflow

Insert Data

Enter name, email, age, and sex.

Hibernate executes an INSERT query to store the record.

Fetch / View Data

Provide an employee ID.

Hibernate performs a SELECT query and displays the employee details.

Update Data

Choose which field (name, email, or age) to modify.

Hibernate runs an UPDATE query on the selected columns.

Delete Data

Provide an employee ID to remove.

Hibernate issues a DELETE query.

------------------------------------------------------------------------------------------
Database Schema
CREATE TABLE employee (
    id   INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    email VARCHAR(100),
    age  INT,
    sex  VARCHAR(10)
);
-----------------------------------------------------------------------------------------
How to Run

Clone this repository

git clone https://github.com/DBAVAJAN/hibernate-emp-management.git
cd hibernate-emp-management


Update your MySQL credentials in hibernate.cfg.xml.

Build and run:

mvn clean compile exec:java
