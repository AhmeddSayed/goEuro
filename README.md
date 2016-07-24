# An implementation for The GoEuro Test for developers
Test Origin: https://github.com/goeuro/dev-test

GoEuro API:  http://api.goeuro.com/api/v2/position/suggest/en/CITY_NAME

This Java application will take parameters (possibly multiple city names) as an input
And will call the GoEuro Api to retrieve the data and construct a CSV file with the (id, name, type, longitude and latitude).

#To use this Java application:

1- Download the JAR file.
https://github.com/AhmeddSayed/goEuro/raw/master/goEuro-1.0-SNAPSHOT.jar

2- Run from the terminal:
java -jar goEuro-1.0-SNAPSHOT.jar alexandria

3- You can also pass it multiple ciry names:
java -jar goEuro-1.0-SNAPSHOT.jar alexandria berlin barcelona
