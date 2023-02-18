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
	1. SpringApp1 : Demo Spring Boot Application
	2. SpringApp2 : Demo Spring Boot Application
	3. AppRunner  : This has one main method on running AppRunner main method we will get directory (deployDirectory), & runApps.bat
					This code will copy all the jars from target folder to deployDirectory and re-generate that runApps.bat
    4. ConfigServer : This app will act as a config server for all this microservices
    5. ConfigServerValues : This folder contains the values required for ConfigServer application
    
Ports :
	ConfigSever : 8888
	SpringApp1  : 8081
	SpringApp2  : 8082
 