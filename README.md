# HNG Stage 1

### Overview

The **HNG Stage-1** project is a Spring Boot application designed to classify number which is passed as parameter at the endpoint.

### Features

+ **Classify number**: View properties of number.
+ **RESTful API**: Exposed endpoints to interact with the project.
+ **Spring Boot**: Utilizes the Spring Boot framework for rapid development and deployment.

### Endpoint/Usage

Once the application is running, you can access the **number** information by making a GET request to the endpoint as described below.

+ GET `/api/classify-number/<number-of-choice>`: Retrieves project information in json.
  - An example endpoint is: `/api/classify-number/9474`, with response is as follows,

```json
    {
          "number": 9474,
          "digit_sum": 24,
          "fun_fact": "'9474' is an Armstrong number because: 4^4 + 7^4 + 4^4 + 9^4 = 9474.0",
          "is_prime": false,
          "is_perfect": false,
          "properties": [
            "armstrong",
            "even"
          ]
    }
```

### Contributing
Contributions are welcome! Please fork the repository and submit a pull request for any enhancements or bug fixes.

### License

&copy; 2024 Oluwafisayomi Folaranmi. All rights reserved.
