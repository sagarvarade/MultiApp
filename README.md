<pre>
# MultiApp
Spring boot Maven Mutli module project

This is Spring Boot Multi-Module Project Consist multiple Spring project inside one Parent POM.

So build will be easy and one point for project.

# Build
1. Maven Update
2. Maven Clean Install (MultiApp) run

# Scripts Folder
This will contain scripts that can be executed from eclipse only
1. MultiApp.launch  : Clean Install maven
2. AppRunnner.launch: Copy Jars and build runApps.

# Development 
Projects : 
	1. NamingServer       : This is for Naming the severs
	2. ConfigServer : This application will act as a configuration server for all this micro-services 
    3. ConfigServerValues : https://github.com/sagarvarade/ConfigServerValues 
    					  : For configuration server values we are depend on this repository 
    4. API Gateway   : API Gateway for application
	5. SpringApp1 : Demo Spring Boot Application 
	6. SpringApp2 : Demo Spring Boot Application 
	
	7. AppRunner  : This has one main method on running AppRunner main method we will get directory (deployDirectory), & runApps.bat 
					This code will copy all the jars from target folder to deployDirectory and re-generate that runApps.bat 
    8. Authentication : Auth Application
Ports :  
	NamingServer  : 8761  
	ConfigSever   : 8888
	API Gateway   : 8765	
	SpringApp1    : 8081  
	SpringApp2    : 8082  
 	AppRunner     : Not required port
 	Authentication : 8200

Project In brief :
This project is Maven multi module type of project, Here I am trying to explore services necessary for Spring Microserivices.

To Build,
1. Check out > Maven update, Maven Install, 
2. Then find out AppRunner.java file and run this one.
3. 2nd step will create deployDirectory on same location, And copy all the jars present from all the target/*.jars to this  deployDirectory location.
4. After 3rs Step AppRunner.java will create one runApps.bat file on same location

Jars Version details

Eg. ApiGateway-3.1.1  > 3 Will be started third,1 Major version, 1 Minor version

To run :
 Form command prompt run this runApps.bat file, Make sure all the ports mentioned are not in used.

To Kill Port:
killPort.bat can be used to kill port.


URLS :
Get  : http://localhost:8761/  : For Naming Server

http://localhost:8765/authentication/auth/testtoken : Token verfication for API Gateway

Post : http://localhost:8765/authentication/products/authenticate  body : {"username":"sagar","password":"sagar"} , For Api gateway login to db

Once you get token from login , you need to send that token for each next request call to any web service

Get  : Spring App 1. http://localhost:8081/springapp1/hello1
Get  : Spring App 2. http://localhost:8082/springapp2/hello2

Get  : Spring App 1. http://localhost:8765/springapp1/helloworld/hello1  : Through API gateway
Get  : Spring App 2. http://localhost:8765/springapp2/helloworld/hello2  : Through API gateway
					 
					 
Config Server URLS : http://localhost:8888/springapp1/springapp1
				   : http://localhost:8888/springapp2/springapp2	



DB insert for Auth DB:
DROP DATABASE IF EXISTS `authentication`;
CREATE DATABASE IF NOT EXISTS `authentication` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `authentication`;

-- Dumping structure for table authentication.userinfo
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE IF NOT EXISTS `userinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `roles` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table authentication.userinfo: 0 rows
DELETE FROM `userinfo`;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` (`id`, `email`, `name`, `password`, `roles`) VALUES
	(1, 'a@gmail.com', 'sagar', '$2a$10$zan24hGdotQG9VEOKNkQoO01Owv9GF5CIihhOGHgv5zNbF2HJrmBy', 'ROLE_ADMIN');
	
Username : sagar , password : sagar

</pre>
 
 