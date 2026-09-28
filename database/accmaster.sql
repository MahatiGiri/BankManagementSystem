create database IF NOT EXISTS ccitdb;

use ccitdb;

create table IF NOT EXISTS accmaster(
    accno int primary key,
    name varchar(100) not null,
    balance decimal(12,2) not null,
    acctype Enum('Saving','Current','Fixed Deposit') not null
);