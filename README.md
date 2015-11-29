
SG
===============
### SG(HackerEarth Recruitment Test App)
##### Simple Spring MVC application with eclipse IDE(not with Maven) Task Done

  -Importing CSV file to Postgres DB at deployment time
  
  -Set Spring MVC application with proper configuration file (applicationContext.xml and spring-mvc.xml in addition to web.xml)
  
  -then writing @Controllers, @Services, @Repository and wiring all of them with Autowiring. and Using spring DI as per requirement.
  
  -Time Based greeting and Total user Count is also displayed in Home Page.
  
  -Converting Ethnic Group from Int to String.
  
  -Convertin weight from gms to Kg,s.
  
  -Spring Rest based Searching

##### Importing DB values from CSV

The *member_details.CSV* is placed inside WEB-INF folder and consequently read by the **DBImportListener** at context initialization time and after that the values are persisted in the Postgres DB with the help of Spring-MVC dataSource configured inside the *applicationContext.xml*
```sh
	<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		<property name="driverClassName" value="org.postgresql.Driver" />
		<property name="url" value="jdbc:postgresql://localhost:5432/sg" />
		<property name="username" value="postgres" />
		<property name="password" value="postgres" />
	</bean>	
```
For running the application provide your DB parameters for running

##### DB Member table Structure

Firts initialized a Database and create a table with following schema.
```sh
	CREATE TABLE member
	(
  		id character varying(10),
  		status text,
  		race character varying(20),
  		weight character varying(8),
  		height character varying(10),
  		is_veg character varying(10)
	)
```sh


##### Displaying Users

At the startUp *index.jsp* is called which redirects the request to the welcome.jsp which is intercepted by the @Controller. Controller injects all necessary parameters and a list of members(*trimmed size of list to only contain 50 members details*).All the values passed from the @Controller are then rendered on jsp with the help of JSTL tag Lib. In addition Bootstrap Front end library is used and bootstrap datatable plugin is used to meet the searching criteria.
In addition a search box is provided which can be used to look up in database and search on the basis of status and race. This calls the Spring @Controller and then searched result is returned as json which is then rendered to the Search Result table.


##### Further Improvements

~~Although it doesnot meets the requirements like searching by calling Spring rest to search a user by status/id etc. but this solution can also works for small DB Store.~~


##### Sample Screen Shot
![alt tag](https://github.com/kailash-a/SG/blob/master/WebContent/resources/img/screenshotnew.png)
