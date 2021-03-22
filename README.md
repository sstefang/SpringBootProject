# What is the project about?
The project represents a basic authentication (login application) built with Spring Boot and Spring Security

The following technologies were used building this project:
1. Maven
2. Java 8
3. Spring Boot
4. Spring Security
5. Spring Data (JPA, Hibernate)
6. Spring MVC
7. JSP
8. MySQL


# How to run the project?
In order to run the project you will need the following prerequisite
1. A MySQL DB with 3 tables, user, role, user_roles (for the many to many relationship) defined as existing in project
2. An admin user (with an admin role)
3. Configure the application.properties to properly connect to your DB

# What are the main features of the application?

The main features are:
1. Login
2. Logout
3. Registry a new user
4. AutoLogin
5. Displaying all users information after you reach the welcome page (query over the user table)
6. Give automatically a "user" role to the one that registered
7. Validator implementation (with the errors defined in validator.properties)
8. Not allow duplicate username in the application (you will see in logs an exception of "UsernameAlreadyExistingException")
