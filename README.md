# Bank Management System

A console-based Bank Management System developed using Core Java, JDBC and MySQL. This project allows users to perform basic banking operations through a menu-driven interface.

## Features

* Create a new bank account
* View all bank accounts
* Search account by account number
* Update account holder details and account type
* Deposit money
* Withdraw money with balance validation
* Delete a bank account

## Technologies Used

* Java (Core Java)
* JDBC (Java Database Connectivity)
* MySQL
* Git and GitHub

## Project Structure

```text
BankManagementSystem/
├── src/
│   ├── Demo.java
│   ├── DBConnection.java
│   ├── AccountDao.java
│   └── Account.java
├── database/
│   └── accmaster.sql
├── README.md
└── .gitignore
```

## Database Configuration

1. Install MySQL and create a database:

   ```sql
    create database IF NOT EXISTS ccitdb;

    use ccitdb;     
   ```

2. Create the `accmaster` table:

   ```sql
   create table IF NOT EXISTS accmaster(
    accno int primary key,
    name varchar(100) not null,
    balance decimal(12,2) not null,
    acctype Enum('Saving','Current','Fixed Deposit') not null
    );
   ```

3. Configure the database URL, username, and password in `DBConnection.java`.

4. Add MySQL Connector/J to the project's classpath.

## How to Run

1. Clone this repository:

   ```bash
   git clone https://github.com/MahatiGiri/BankManagementSystem.git
   ```

2. Open the project in your Java IDE or terminal.

3. Configure the MySQL database connection.

4. Compile and run the Java application with MySQL Connector/J available in the classpath.

5. Use the console menu to perform banking operations.

## Learning Outcomes

Through this project, I practiced:

* JDBC connectivity with MySQL
* SQL CRUD operations
* PreparedStatement and ResultSet
* Exception handling
* Java methods, classes, and objects
* Menu-driven programming using switch-case and loops

## Author

**Mahati Giri**

GitHub: [MahatiGiri](https://github.com/MahatiGiri)
