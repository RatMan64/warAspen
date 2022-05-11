# War Using springboot

## frameworks and languages used
java language: java 11                                                      
framework: Spring Boot    
DB: DynamoDB
## installation
1.clone this repo

2.set env vars for AWS_ACCESS_KEY_ID and , AWS_SECRET_ACCESS_KEY. these must be asked for from me.

3.if in intellij: you should be able to run the project in intellij by pressing the green triangle either in the top right or in the application class  if in terminal: run ```mvn spring-boot:run```




##endpoints
###/war
this endpoint plays war against two npcs telling you if you won or lost. if /war is input then a random id will be assigned unless ?id={username} is used

###/getwinsfor
this endpoint gets the amount of wins that have been achieved by this user using ?id={username}.