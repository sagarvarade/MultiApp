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

# Developement 
Projects :
	1. SpringApp1 : Demo Spring Boot Application <br>
	2. SpringApp2 : Demo Spring Boot Application <br>
	3. AppRunner  : This has one main method on running AppRunner main method we will get directory (deployDirectory), & runApps.bat <br>
					This code will copy all the jars from target folder to deployDirectory and re-generate that runApps.bat <br>
    4. ConfigServer : This app will act as a config server for all this microservices <br>
    5. ConfigServerValues : https://github.com/sagarvarade/ConfigServerValues <br>
    					  : For Config server valus we are depend on this repository <br>
    6. NamingServer       : this is for Naming the severs
    
Ports :  <br>
	NamingServer  : 8082  <br>
	ConfigSever : 8888	<br>
	SpringApp1  : 8081  <br>
	SpringApp2  : 8082  <br>
 
1. <br>
<br>
2.<br>
<br>
3. <br>
<br>
4. <br>
<br>
5.ConfigServerValues : This has below URLs' <br>
http://localhost:8888/SpringApp1/default  <br>
http://localhost:8888/SpringApp1/dev      <br>
<br>
http://localhost:8888/SpringApp2/default  <br>
http://localhost:8888/SpringApp2/dev      <br>

 