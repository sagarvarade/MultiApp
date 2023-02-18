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
2. AppRunnner.launch: Copy Jars and build runApps.bat

# Developement 
Projects :
	1. SpringApp1 : Demo Spring Boot Application
	2. SpringApp2 : Demo Spring Boot Application
	3. AppRunner  : This has one main method on running AppRunner main method we will get directory (deployDirectory), & runApps.bat
					This code will copy all the jars from target folder to deployDirectory and re-generate that runApps.bat
					