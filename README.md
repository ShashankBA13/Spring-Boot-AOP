# Spring Boot AOP project

- A simple project depicting how AOP can be used.
- Also contains Dockerfile and docker compose file

## Installation

Clone the repository

 ```
 https://github.com/ShashankBA13/Spring-Boot-AOP.git
 ```

Get into the Directory

```
cd Spring-Boot-AOP
```

Run the Project using Docker

```
docker compose up
```

Navigate to your favorite browser

```
http://localhost:9091/employee/all
```

You won't see anything because you haven't added anything yet!!!

Try adding some data using JSON

```
http://localhost:9091/employee/add

In the body send this data

    {
       "name": "Some Name"
    }
```

## Technologies Used

1. Java
2. Spring Boot
3. MySQL
4. Docker
