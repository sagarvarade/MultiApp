@echo off
start /b "1" java -jar deployDirectory/NamingServer-1.1.1.jar
timeout 5 > NUL 
start /b "2" java -jar deployDirectory/ConfigServer-2.1.1.jar
timeout 5 > NUL 
start /b "3" java -jar deployDirectory/ApiGateway-3.1.1.jar
timeout 5 > NUL 
start /b "4" java -jar deployDirectory/SpringApp1-4.1.1.jar
timeout 5 > NUL 
start /b "5" java -jar deployDirectory/SpringApp2-5.1.1.jar
timeout 5 > NUL 
start /b "6" java -jar deployDirectory/authentication-6.1.1.jar
timeout 5 > NUL 
pause
