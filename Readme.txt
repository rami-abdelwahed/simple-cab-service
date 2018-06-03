Configuration
---------------
1- Edit the file named application.properties at "\simple-cab\server\src\main\resources\application.properties"
2- Change these three parameters according to the available mysql database:
	a- spring.datasource.url
	b- spring.datasource.username
	c- spring.datasource.password
	Note: The application assumes that the given DB contains a schema having the table named cab_trip_data that was created and populated with data
			using the given SQL script.
3- Assuming JAVA_HOME is pointing to Java 8, change to the root directory of the ZIP archive.
4- Run ==> mvn clean install
5- Change to the direcotry named server.
6- Run ==> java -jar target\server-1.0-SNAPSHOT.jar
7- The SpringBoot application should be up and running, listening on port 8080.
8- Using Postman, or any similar tool, we can now send a post request to (http://localhost:8080/cabservice/query) with the parameters specified in the API.
