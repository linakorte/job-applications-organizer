# Job-Application-Organizer

The Job Application Organizer is a back-end Spring Boot web application to help users organize their job applications during seeking for new job opportunities.

## Table of Contents

- [About](#about)
- [Features](#features)
- [Technologies Used](#technologies-used)

## About

The Job Application Organizer is a back-end Spring Boot web application to help users organize their job applications while seeking for new job opportunities.
It is composed of 3 tables: Job, Company and Users.
Anyone can view all of the Job Positions and Companies listed.
Anyone can create a new User with Token Bearer Authentication. 


## Features

A registered user can fully access the application:
- Insert a new Job Position (This operation automatically creates the relative Company entry in the Company table if it is not already present)
- Update any fields in an existing Job Position (This operation automatically creates the relative Company entry in the Company table if it is not already present)
- Delete one or all of the Job Positions
- View all the Job Positions provided by one Company
- Insert a new Company
- Update any fields in an existing Company
- Delete one or all of the Companies that are not related to any Job Position
- View all application users

## Technologies Used

- Java 17, Maven
- Spring Framework 3.1.5
- Spring Data
- Spring Security
- MySQL 8
