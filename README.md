# staff-manager

## Developed using: 
-JDK 8
-Eclipse IDE for Enterprise Java Developers 2020-12
-WildFly 22.0.0.Final
-MySQL Database 


## Setup the Application:

### MAVEN
1. After github project cloning, import the project to Eclipse as 'Existing Maven Project'

### MYSQL
2. Execute the SQL code located in 'DbUtil.sql' project file 

### WILDFLY
3. Go to Window>Preferences>Server>Runtime Environments>'Add...'>'Red Hat Jboss Middleware'>'	JBoss AS, WildFly, & EAP Server Tools'
4. Accept all terms, finish it and install accepting all security conditions
5. Restart Eclipse
6. Once Eclipse is restarted, go to Window>Preferences>Server>Runtime Environments>'Add...'>JBoss Community'>'WildFly 22 Runtime'
7. Browse the path to WildFly directory in 'Home Directory'
8. In 'Runtime JRE' box select 'Alternate JRE:'> select the java version installed in your system
9. Go to 'Servers' Eclipse view, right-click>New>Server>WildFly 22 and go always next then
10. Right-click the project in 'Project Explorer' view, go to Properties>Targeted Runtimes>WildFly 22.0 Runtime>Apply and Close

### DATASOURCE (web console)
11. Go to https://mvnrepository.com/artifact/mysql/mysql-connector-java/8.0.22 and download the jar file
12. Locally, go to the bin folder of your WildFly installation, execute the 'add-user.bat' or 'add-user.sh' script in command prompt
13. Add a management user (a)> set username/password>(blank)>yes 
14. Go to 'http://localhost:8080/', 'Administration Console', log in, go to 'Deployments', 'Upload Deployment'> set our JDBC jar file> 'Next'> 'Finish'
15. Go to 'Configuration'>'Subsystems'>'Datasources & Drivers'>'Datasources'>'Add Datasource'
16. Set: 'MySQL'>'JNDI Name: java:/piMySqlDS'>'Driver Name: mysql-connector-java-8.0.22.jar'>
17. Set: 'Connection URL: jdbc:mysql://localhost:3306/picompany', your database username/password
18. Test the connection

### LOMBOK PROJECT
19. Locally, go to ~/.m2/repository/org/projectlombok/lombok/1.18.16/lombok-1.18.16.jar
20. Run it, Install/Update
21. In Eclipse, right-click the project and go to Maven>Update Project>OK
22. Restart Eclipse
