# prototype-app

Prototype project to create a Sign in / Sign up modal that will show two fields: user and password. This modal will interact with different brands in a larger company, so it should have different behaviors depending on the brand selected, and you should be able to switch brands with an URL parameter ("brand").

## Initial definitions


## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

You must have a Java JDK 7 or above installed, you can download it from [here](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) and install it following the [official documentation](http://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html).

You must have Eclipse Mars or above installed, you can download it from [here](http://www.eclipse.org/downloads/) and you can install it following the [official documentation](https://wiki.eclipse.org/Eclipse/Installation#Eclipse_4.5_.28Mars.29).

You must have Apache Tomcat 8 installed, you can download it from [here](https://tomcat.apache.org/download-80.cgi).

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

Add additional notes about how to deploy this on a live system

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

* **Alexis De Jesús Bautista** - *Initial work* -

## License

This project is not licensed.

