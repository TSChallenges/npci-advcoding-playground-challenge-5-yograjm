# Implementing REST endpoints for Flight API
## Advanced Coding Playground Challenge-5 [20 Marks]

### Problem Statement
In this project, data is given regarding flights. Your task is to implement several REST endpoints to handle this data.

### Steps to Follow
1. This GitHub repository will be accessible to you once you accept the Challenge.
2. You have to work directly in this GitHub repository. It is like your own copy of the original repository.

3. The folder structure is as given below: (showing major files only)
   ```
   root
   ├── pom.xml
   └── src/main
       ├── java/com/example/api
       |   ├── controller
       |   |   └── FlightController.java
       |   ├── model
       |   |   └── Flight.java
       |   ├── repository
       |   |   └── FlightRepository.java
       |   └── FlightApiApplication.java
       └── resources
           └── application.properties
   ```

4. Review the code/comments present in above files to understand the structure.
5. Implement the required classes/methods.
6. To work on the files, you can clone this GitHub repository onto your system and then open it with an IDE like IntelliJ, or Eclipse.
7. Once done, push your changes from your system to this remote GitHub repository.

### Files to Work On
- `src/main/java/com/example/api/model/Flight.java`
- `src/main/java/com/example/api/repository/FlightRepository.java`
- `src/main/java/com/example/api/controller/FlightController.java`

## Data:
Example of a flight data JSON object:
```
{
   "id": 1,
   "flight": "MH17"
   "origin": "Malesiya",
   "destination": "China",
   "speed_series": [200, 350, 400, 500, 650, 740, 600]
}
```

## Requirements:
The REST service must expose the `/flight` endpoint, which allows for managing the collection of flight records in the following way:

**POST request to `/flight`:**

- Creates a new flight data record.
- Expects a valid flight data object as its body payload, except that it does not have an id property; you can assume that the given object is always valid.
- Adds the given object to the collection and assigns a unique integer id to it.
- The response code is 201 and the response body is the created record, including its unique id.

**GET request to `/flight`:**

- The response code is 200 and the response body is an array of matching records, ordered by their ids in increasing order.
- Accepts an optional query string parameter, origin, for example /flight/?origin=KTM. When this parameter is present, only the records with the matching origin are returned.
- Accepts an optional query string parameter, orderBy, that can take one of two values: either "destination" or "-destination".
  - If the value is "destination", then the ordering is by destination in ascending order.
  - If it is "-destination", then the ordering is by date in descending order.
  - If there are two records with the same destination, the one with the smaller id must come first.

**GET request to `/flight/<id>`:**

- Returns a record with the given id.
- If the matching record exists, the response code is 200 and the response body is the matching object.
- If there is no record in the collection with the given id, the response code is 404.

## Commands
- run: 
```bash
mvn clean spring-boot:run
```
- install: 
```bash
mvn clean install
```
- test: 
```bash
mvn clean test
```

## Submission Requirements:
Implement the required API endpoints for the provided Spring Boot application. You can use Postman or cURL commands to test your API endpoints.

After completing the challenge and developing the solution code in your system, commit and push the changes to this repository. 
  - Stage your changes and commit the files:
    ```
    git add .
    git commit -m "Completed the challenge"
    ```
  - Push your changes to the GitHub repository:
    ```
    git push
    ```

## Grading Criteria:
- To implement the flight endpoint with POST correctly, ensuring that the flight data is created and returned with the correct ID [4 Marks]
- To implement the flight endpoint with GET list correctly, ensuring that all flights are retrieved and matched with expected records [4 Marks]
- To implement the flight endpoint with GET list and origin filter correctly, ensuring that only flights from the specified origin are returned [4 Marks]
- To implement the flight endpoint with GET list and destination order correctly, ensuring that flights are sorted by destination and ID as expected [4 Marks]
- To implement the flight endpoint with GET by ID correctly, ensuring that the correct flight is retrieved based on the provided ID [4 Marks]

Good luck, and happy coding!
