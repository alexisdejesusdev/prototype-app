# prototype-app

Prototype project to create a Sign in / Sign up modal that will show two fields: user and password. This modal will interact with different brands in a larger company, so it should have different behaviors depending on the brand selected, and you should be able to switch brands with an URL parameter ("brand").

## Project Architecture

The project uses the following structure:

Front-end:
* /webapp 
  This folder includes all the web resources used in the front-end.
  * /css
    Contains the following files, mostly separated to better find where to modify any style concerning the different components from the view:
    * button.css
    * modal.css
    * style.css
  * /js
    Contains the following files, and folder, separated by function responsibilities.
    * /lib
      Contains the jQuery library used in the project according to the technical requirements.
    * app.js
      The functional requirements of the Sign In and Sign Up operations are defined in this file, in other words the flow of the application.
    * utils.js
      Contains utility functions to reuse and/or keep the functional file as clean as possible.
    * validation.js
      Contains only validation concerned functions so anyone can identify this requirements and modify accordingly if necessary.
  * /properties
    Contains the messages properties for a better decoupled i18n.
    * Messages_en.properties
    * Messages_es.properties
    * Messages.properties
  * /secure
    This folder contains only an HTML file to simulate the actual page after the sign in functionality.
    * index.html
  * /templates
    This folder and its contents where created to separate the view from the application code to better decouple this two layers.
    * signIn.html
    * singUp.html
  * /WEB-INF
    Contains only the web descriptor required for any J2EE application.
    * web.xml
  * login.html
    Following the requirements instructions this is the Sign In / Sign Up page where the functionality will be tested.

Back-end:
Following the maven project structure here lies the java functional code, the utilized resources such as configuration files and properties and also the test classes.
* /src/main/java
  This folder is mainly divided by the basic layers into packages, presented from top to bottom:
  * com.luxoft.example.controller
  * com.luxoft.example.service
  * com.luxoft.example.dao
  * com.luxoft.example.model
* /src/main/resources
  Contains the Spring config file and the back-end messages.
  * /spring
    * applicationContext.xml
  * config_en.properties
  * config_es.properties
  * config.properties
* /src/test/java
  Contains a testing implementation of the service layer conditions to ensure that the front-end operations will be executed as required. The tested conditions are as follows:
  * UserServiceImplTest.signUpSuccessAlphaBrand
  * UserServiceImplTest.signUpSuccessBetaBrand
  * UserServiceImplTest.signUpErrorUserAlreadyExists
  * UserServiceImplTest.signUpErrorPasswordMissing
  * UserServiceImplTest.signUpErrorTermsNotAccepted
  * UserServiceImplTest.signInSuccess
  * UserServiceImplTest.signInErrorPasswordDoesntMatch
  * UserServiceImplTest.signInErrorBrandDoesntMatch
  
## Design Patterns Used
As a pretty basic application there aren't many patterns that are applied. Just for the sake of simplicity they where applied only where applicable. 

* In general terms the whole application uses the Model-View-Controller pattern as described in the previous section and it can be review in the actual code.

* Another pattern can be found in the class com.luxoft.example.service.validator.factory.UserValidatorFactory which uses the Factory pattern to hide the construction details of the actual implementation of a UserValidator interface. This can also be validated at the com.luxoft.example.service.impl.UserServiceImpl class at line 33.

* The singleton pattern is used implicitly throughout the whole project where there are spring beans instantiated, since they're being  defined with their default scope (singleton) however i did find an explicit use of this pattern for the classes com.luxoft.example.service.validator.impl.AlphaBrandUserValidatorImpl and com.luxoft.example.service.validator.impl.BetaBrandUserValidatorImpl where this could be applied to improve the performance and rest assured that only one instance of those classes where created at any time at the application level. 

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

You must have a Java JDK 7 or above installed, you can download it from [here](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) and install it following the [official documentation](http://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html).

You must have Eclipse Mars or above installed, you can download it from [here](http://www.eclipse.org/downloads/) and you can install it following the [official documentation](https://wiki.eclipse.org/Eclipse/Installation#Eclipse_4.5_.28Mars.29).

You must have Apache Tomcat 8 installed, you can download it from [here](https://tomcat.apache.org/download-80.cgi) and you can install it following the [official documentation](https://tomcat.apache.org/tomcat-8.0-doc/index.html).

You must have Apache Maven 3 or above installed, you can download it from [here](https://maven.apache.org/download.cgi) and you can install it following the [official documentation](https://maven.apache.org/install.html) or use the embedded maven installation inside eclipse.

### Installing

To get a development env running you should follow the next steps:

1. Download or clone the git repository into your local machine.
[https://github.com/alexisdejesusdev/prototype-app.git](https://github.com/alexisdejesusdev/prototype-app.git)

2. Open the eclipse executable and import the maven project from the filesystem where it was downloaded or cloned.

Image [here](https://drive.google.com/open?id=0B0VKN70UtF7nMkpIcGdXRTFZRlU)

Image [here](https://drive.google.com/open?id=0B0VKN70UtF7ndFRMR1hHaFRVRkE)

Image [here](https://drive.google.com/open?id=0B0VKN70UtF7nR2xERWJMNC05c2s)

3. The project will then appear as a maven project in the project explorer.

Image [here](https://drive.google.com/open?id=0B0VKN70UtF7nQmhWMTdDblF0dEE)

4. Right click the Servers view to add a new server.

Image [here](https://drive.google.com/open?id=0B0VKN70UtF7nUVJDWVVUSVJGdTA)

5. Select Apache -> Tomcat v8.0 Server and click next.

Image [here](https://drive.google.com/open?id=0B0VKN70UtF7nR3dMa0k2cHFqM28)

6. Select the Tomcat installation directory from the file system and click next.

Image [here](https://drive.google.com/open?id=0B0VKN70UtF7ndFlDUGVUMDVvQU0)

7. Select the Tomcat installation directory from the file system and click next.

Image [here](https://drive.google.com/open?id=0B0VKN70UtF7ndFlDUGVUMDVvQU0)

8. Select the prototype-app project, click Add > and then click Finish.

Image [here](https://drive.google.com/open?id=0B0VKN70UtF7nTlZnaFV6Vno3YzA)

Image [here](https://drive.google.com/open?id=0B0VKN70UtF7nOXdWZTlON3BGOFE)

9. The project will appear on the servers view, click on the Tomcat v8.0 server name and click the Start Server button the server will start after that.

Image [here](https://drive.google.com/open?id=0B0VKN70UtF7ncEpQM042aXlUWWM)

Image [here](https://drive.google.com/open?id=0B0VKN70UtF7nOEpaVjFWS3pKVjQ)

10. Open the Chrome browser and enter to the following URL into the address bar. [http://localhost:8080/prototype-app/login.html?brand=Alpha&lan=en](http://localhost:8080/prototype-app/login.html?brand=Alpha&lan=en)

Image [here](https://drive.google.com/open?id=0B0VKN70UtF7nWS12LVZXeWRkQXc)

## How to test the application
The supported operations based on the initial requirements are the following:

* Signing in as an Alpha brand, English language: [http://localhost:8080/prototype-app/login.html?brand=Alpha&lan=en](http://localhost:8080/prototype-app/login.html?brand=Alpha&lan=en)

* Signing in as an Alpha brand, Spanish language: [http://localhost:8080/prototype-app/login.html?brand=Alpha&lan=es](http://localhost:8080/prototype-app/login.html?brand=Alpha&lan=es)

* Signing in as a Beta brand, English language: [http://localhost:8080/prototype-app/login.html?brand=Beta&lan=en](http://localhost:8080/prototype-app/login.html?brand=Beta&lan=en)

* Signing in as a Beta brand, Spanish language: [http://localhost:8080/prototype-app/login.html?brand=Beta&lan=es](http://localhost:8080/prototype-app/login.html?brand=Beta&lan=es)


## Additional tests

The test will automatically run while building the maven project, however you can find them in the folder: src/text/java. 

The provided tests are just a reference of the main validations that the service layer performs, they're meant to exemplify how the full test will be done.  


## Deployment

To build and deploy the whole project and test it outside eclipse the next steps should be followed:

1. From the command line or maven console, move to the folder where the pom.xml file is saved.

2. Run the command mvn clean install.

3. After the process is finished move to the target folder created as a result of the previous step and copy the file called prototype-app.war.

4. Paste the copied file to the webapps folder of the tomcat installation directory.

5. Start the tomcat service as told in the [official documentation] (https://tomcat.apache.org/tomcat-8.0-doc/setup.html).

6. Open the Chrome browser and enter to the following URL into the address bar. [http://localhost:8080/prototype-app/login.html?brand=Alpha&lan=en](http://localhost:8080/prototype-app/login.html?brand=Alpha&lan=en)

## Built Version

* Latest built version: [download](https://drive.google.com/open?id=0B0VKN70UtF7nallUNG9vR0liUEU).

* Built with [Maven](https://maven.apache.org/) - Dependency Management

## Authors

* **Alexis De Jesús Bautista** - *Initial work* -

## License

This project is not licensed.

