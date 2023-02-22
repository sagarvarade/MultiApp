@echo off
start /b "ApiGateway-3" java -jar deployDirectory/ApiGateway-3.1.1.jar
start /b "ConfigServer-2" java -jar deployDirectory/ConfigServer-2.1.1.jar
start /b "NamingServer-1" java -jar deployDirectory/NamingServer-1.1.1.jar
start /b "SpringApp1-4" java -jar deployDirectory/SpringApp1-4.1.1.jar
start /b "SpringApp2-5" java -jar deployDirectory/SpringApp2-5.1.1.jar
pause
