CREATE TABLE IF NOT EXISTS endgameusers
( firstname varchar(40) , lastname varchar(40) ,
email varchar(80), username varchar(20), password varchar(20),
 PRIMARY KEY(username)
 );
CREATE TABLE IF NOT EXISTS questions ( username varchar(20) , questionid int, answer varchar(80));
CREATE TABLE IF NOT EXISTS consumerresult( parentuser varchar(30), consumer varchar(30) , result int, showresult int);