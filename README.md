# User Display Exercise

This exercise will provide you with practice with IntelliJ, Tomee+, MySqL and Maven, while providing a refresher
on many topics from Advanced Java including servlets, jsps, properties, jdbc, expression language (el) and beans. 

## Getting Started

To begin using this project:

1. Download the zip file from GitHub.
2. Extract the zip on your computer.
3. From the IntelliJ Welcome Screen, choose "Open". Use the browser to navigate to the directory that you just extracted.
4. Edit the run configuration.
5. Build and deploy.
6. The application should deploy, but it will not function correctly since there is no database connected at this point.
7. Explore the code to understand what's been given to you.


## Next Steps

1. Create the database. You can use the sql below, or, you may write your own.

        mysql> CREATE DATABASE sample;
       
1. Select the database you just created. 

        mysql> use sample
    
1. Create the users table.
    
        mysql> create table users (
             id             int(11) NOT NULL auto_increment,
            first_name      varchar(25),
            last_name       varchar(30),
            date_of_birth   date,
            PRIMARY KEY  (id)
        );

1. Populate the users table. 

        insert into users values (1, 'Joe', 'Coyne', '1964/04/01');
        insert into users values (2, 'Fred', 'Hensen', '1988/05/08');
        insert into users values (3, 'Barney', 'Curry', '1947/11/11');
        insert into users values (4, 'Karen', 'Mack', '1986/07/08');
        insert into users values (5, 'Dianne', 'Klein', '1991/09/22');
        insert into users values (6, 'Dawn', 'Tillman', '1979/08/30');
        
1. Find and complete the TODO in "database.properties" to configure the program to use the database you created above. Question: did you know you can easily find all TODOs in intelliJ with a single click?

1. Once the TODOs are completed, build and deploy. The application should open in the browser showing you a list of users. It's not pretty, but you'll fix that in a little bit.

## Next Next Steps

1. The completed application will provide the ability to search for and display users from the database. The user display/search results
    should include id, first name, last name, and age. At minimum, provide a last name search. Some TODOs have been added to help you get started.
# exercise1
