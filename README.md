# End-Game
_Requriements_
1. IntellJ or Eclipe
2. Maven
3. MySql
4. Java 8
5. apache tom cat server
  5a. if Intellj it is available in plugin
  5b. if eclipse you can configure the downlaoded tomcat server bin file

## DataBase Setup: 
_My Sql Version- 5.*_

Tables To be Created:

###### 1. create table endgameusers ( firstname varchar(40) , lastname varchar(40) , email varchar(80), username varchar(20), password varchar(20),   PRIMARY KEY(username));
###### 2. create table questions ( username varchar(20) , questionid int, answer varchar(80));
###### 3. create table consumerresult( parentuser varchar(30), consumer varchar(30) , result(30));

## Pending_Items 
###### UI:
> Modify View Pages with HTML and CSS and if possible use bootstrap
> Validations using javascript
###### Questions:
> Add Questions and Options in the view as well as Backend.
###### Backend:
> Error Handling and RollBack Data in case of failures
> Manual Testing 
