# simple-cab-service
A SpringBoot application using mysql and Hazelcast.

# Configuration

- Edit the file named application.properties at "\simple-cab\server\src\main\resources\application.properties"
- Change these three parameters according to the available mysql database:
	- spring.datasource.url
	- spring.datasource.username
	- spring.datasource.password
	
  Note: The application assumes that the given DB contains a schema having the table named cab_trip_data that was created and populated with data
			using the given SQL script.
 
- Assuming JAVA_HOME is pointing to Java 8, change to the root directory of the ZIP archive.
- Run `mvn clean install`
- Change to the direcotry named server.
- Run `java -jar target\server-1.0-SNAPSHOT.jar`
- The SpringBoot application should be up and running, listening on port 8080.
- Using Postman, or any similar tool, we can now send a post request to (http://localhost:8080/cabservice/query) with the parameters specified in the API.

