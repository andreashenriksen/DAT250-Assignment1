# Technical problems
This project went mostly fine but I did end up getting an error message that I couldn't figure out how to solve. The error was `Failed to load class org.slf4j.impl.StaticLoggerBinder`, which I found out happens when no appropriate SLF4J binding could be found on the class path. 
I tried both adding the `slf4j-api-1.7.36.jar` and `slf4j-simple-1.7.36.jar` files to the project directory, and also adding them as maven dependencies in the `pom.xml`, but neither solution seemed to work. 
The program still runs and outputs the messages, but it just prints the error message each time it starts.
# Code
You can find the code for experiments 1-4 [here](https://github.com/andreashenriksen/DAT250-Assignment6/tree/master/src/main/java). 
I used the docker installation so that code is not in the repository as I only ran `docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:4.0-management` in the terminal.
# Pending issues
The only pending issue I have left is the unsolved error I mentioned in [Technical problems](#Technical-problems), other than that there isn't any pending issues that I've noticed.
