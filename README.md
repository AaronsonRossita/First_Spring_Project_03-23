Server built with Java using Springboot framework.
During lectures, I developed this Spring Boot project to teach students the basics of server-side development. 
It covers creating RESTful APIs for managing customer data, utilizing an H2 in-memory database, caching with Redis, and making server calls with FeignClient. 
Through practical exercises, students learn to build efficient server applications using Java.

Technologies Used

Java 17
Spring Boot Framework (various libraries)
Maven (for dependency management)
Redis (for caching)
Docker (for containerization)

Installation

Clone the repository.
Install Docker if not already installed.
Navigate to the project directory.
Run the following command to start Redis using Docker:
Copy code
docker-compose up -d
Build the project using Maven:
Copy code
mvn clean install
