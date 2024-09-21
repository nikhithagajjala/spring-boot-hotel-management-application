# Hotel Management System

## API Usage

### 1. Add a Hotel
- **Method**: POST
- **Endpoint**: /hotels/add
- **Description**: Adds a new hotel to the system.
- **Request Body**:
    - JSON object containing the hotel's name and address.
  ```json
  {
  "name": "Marriott",
  "address": "Los Angeles"
  }
- **Response**:
    - Error (400): Returns an error message if the request is invalid.
    - Success (201): Returns the newly added hotel object.
  ```json
  {
  "id": 1,
  "name": "Marriott",
  "address": "Los Angeles"
  }

- **Example**: POST /hotels/add

### 2. Get Hotel by ID
- **Method**: GET
- **Endpoint**: /hotels/get/{id}
- **Description**: Retrieves hotel details by ID.
- **Path Variable**:
    - id - ID of the hotel.
- **Response**:
    - Error (404): Returns an error message if not found.
    - Success (200): Returns the hotel object.
  ```json
      {
      "id": 1,
      "name": "Marriott",
      "address": "Los Angeles"
      }

- **Example**: GET /hotels/get/1

### 3. Update Hotel
- **Method**: PUT
- **Endpoint**: /hotels/update/{id}
- **Description**: Updates the details of an existing hotel.
- **Path Variable**:
    - id - ID of the hotel.
- **Request Body**:
    - JSON object containing the entire details of hotel or only the field that is to be updated.
  ```json
  {
  "address": "Seattle"
  }
  or
  {
  "name": "Marriott",
  "address": "Seattle"
  }
- **Response**:
    - Error (404): Returns an error message if not found.
    - Success (200): Returns the updated hotel object.
  ```json
      {
      "id": 1,
      "name": "Marriott",
      "address": "Seattle"
      }

- **Example**: PUT /hotels/update/1

### 4. Get Hotel by Name
- **Method**: GET
- **Endpoint**: /hotels/get/name/{name}
- **Description**: Retrieves hotel details by name.
- **Path Variable**:
    - name - Name of the hotel.
- **Response**:
    - Error (404): Returns an error message if not found.
    - Success (200): Returns the hotel object.
  ```json
      {
      "id": 1,
      "name": "Marriott",
      "address": "Seattle"
      }
- **Example**: GET /hotels/get/name/Marriott

### 5. Delete Hotel
- **Method**: DELETE
- **Endpoint**: /hotels/delete/{id}
- **Description**: Deletes a hotel by ID.
- **Path Variable**:
    - id - ID of the hotel.
- **Response**:
    - Error (404): Returns an error message if not found.
    - Success (200): Returns a success message.
  ```
    Hotel with ID 1 has been deleted successfully. 
  ```
- **Example**: DELETE /hotels/delete/1

## How to Run

1. **Clone the repository**:
   ```bash
   git clone git@github.com:nikhithagajjala/spring-boot-hotel-management-application.git

2. **Navigate to the project directory**:
   ```bash
   cd spring-boot-hotel-management-application/hotel-management

3. **Build the project**:  Make sure you have Maven installed. You can build the project using:
   ```bash
   mvn clean install

4. **Run the application**: Start the Spring Boot application with the following command:
   ```bash
   mvn spring-boot:run

5. **Access the API**: Open your web browser or use a tool like Postman to access the API at:
   ```bash
   http://localhost:8080/hotels