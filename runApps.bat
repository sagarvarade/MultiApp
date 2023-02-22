@echo off
start /b "1" java -jar deployDirectory/NamingServer-1.1.1.jar
start /b "2" java -jar deployDirectory/ConfigServer-1.2.1.jar
start /b "3" java -jar deployDirectory/ApiGateway-1.3.1.jar
start /b "4" java -jar deployDirectory/SpringApp1-1.4.1.jar
start /b "5" java -jar deployDirectory/SpringApp2-1.5.1.jar
pause
