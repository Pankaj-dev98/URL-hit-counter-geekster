# USER MANAGEMENT SYSTEM

**Name: Pankaj Kalra, Batch: FS-11**
[GITHUB](https://github.com/Pankaj-dev98/URL-hit-counter-geekster.git)

## Frameworks and languages used
- Source code: Java 20
- Base framework: SpringBoot with inbuilt TomCat server
- Dependencies: spring-starter-web: Includes several dependencies for JSON parsing, Spring MVC, Spring web REST for RESTful services, etc.

## Data Flow
- Controller: Rest controller is managed by java class "HitCounterController". It exposes all the required endpoints for this project.
- Services: Clients can use the project for the following services:
	+ Add a new visitor.
	+ Get a visitor's URL hit count by username
	+ Get sum of all URL hits of all visitors
	+ Increment a visitor's url-hit count
	+ Get all visitors and their respective hit-counts
	+ Get number of registered unique visitors

- Source code is available at: [GITHUB](https://github.com/Pankaj-dev98/URL-hit-counter-geekster.git)

- Database design: This application tracks number of url hits using a HashMap which maps usernames to their present URL-hits.


## Project Summary
All the required functionality has been tested and errors have been handeled with appropriate HTTP responses.


