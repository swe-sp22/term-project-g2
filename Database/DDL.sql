drop database if exists Gym;
create database if not exists Gym;

set foreign_key_checks=0;

use Gym;

create table if not exists `User`( 
    `username` varchar(256) not null,
    `password` varchar(256) not null,
    primary key(username) 
);

create table if not exists `Member`(
    `MID` int auto_increment,
    name varchar(256) not null,
    phone_no varchar(256) not null,
    dob date not null,
    MSID int,
    EID int,
    primary key (MID),
    foreign key (MSID) references `Membership type`(MSID),
    foreign key (EID) references Employee(EID)
);

create table if not exists `Membership type`(
    MSID int auto_increment,
    duration varchar(256) not null,
    price float not null,
    primary key (MSID)
);

create table if not exists Employee(
    EID int auto_increment,
    name varchar(256) not null,
    address varchar(256) not null,
    phone_no varchar(256) not null,
    dob date not null,
    role varchar(256) not null,
    salary varchar(256) not null,
    primary key (EID)   
);

set foreign_key_checks=1;