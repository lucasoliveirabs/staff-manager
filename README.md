# staff-manager

##Developed using: 
-JDK 8
-Eclipse IDE for Enterprise Java Developers 2020-12
-WildFly 22.0.0.Final
-MySQL Database 


##Setup the Application:

###MAVEN
1.0. After github project cloning, import the project to Eclipse as 'Existing Maven Project'

###MYSQL
2.0. Execute the SQL code located in 'DbUtil.sql' project file 

###WILDFLY
3.0. Go to Window>Preferences>Server>Runtime Environments>'Add...'>'Red Hat Jboss Middleware'>'	JBoss AS, WildFly, & EAP Server Tools'
3.1. Accept all terms, finish it and install accepting all security conditions
3.2. Restart Eclipse
3.3. Once Eclipse is restarted, go to Window>Preferences>Server>Runtime Environments>'Add...'>JBoss Community'>'WildFly 22 Runtime'
3.4. Browse the path to WildFly directory in 'Home Directory'
3.5. In 'Runtime JRE' box select 'Alternate JRE:'> select the java version installed in your system
3.6. Go to 'Servers' Eclipse view, right-click>New>Server>WildFly 22 and go always next then
3.7. Right-click the project in 'Project Explorer' view, go to Properties>Targeted Runtimes>WildFly 22.0 Runtime>Apply and Close

###DATASOURCE (web console)
4.0. Go to https://mvnrepository.com/artifact/mysql/mysql-connector-java/8.0.22 and download the jar file
4.1. Locally, go to the bin folder of your WildFly installation, execute the 'add-user.bat' or 'add-user.sh' script in command prompt
4.2. Add a management user (a)> set username/password>(blank)>yes 
4.3. Go to 'http://localhost:8080/', 'Administration Console', log in, go to 'Deployments', 'Upload Deployment'> set our JDBC jar file> 'Next'> 'Finish'
4.4. Go to 'Configuration'>'Subsystems'>'Datasources & Drivers'>'Datasources'>'Add Datasource'
4.5. Set: 'MySQL'>'JNDI Name: java:/piMySqlDS'>'Driver Name: mysql-connector-java-8.0.22.jar'>
4.6. Set: 'Connection URL: jdbc:mysql://localhost:3306/picompany', your database username/password
4.7. Test the connection

###LOMBOK PROJECT
5.0. Locally, go to ~/.m2/repository/org/projectlombok/lombok/1.18.16/lombok-1.18.16.jar
5.1. Run it, Install/Update
5.2. In Eclipse, right-click the project and go to Maven>Update Project>OK
5.3. Restart Eclipse
