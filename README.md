# NinjaOne Backend Interview Project

The project is the solution purposed by Ivan Camilo Garavito to the problem mentioned

## Starting the Application

Run the `BackendInterviewProjectApplication` class

Endpoints: 

Device
* Find all devices: http://localhost:8080/device (GET)
* Find device by id: http://localhost:8080/device/{id} (GET)
* Add device: http://localhost:8080/device (POST)
* Update device: http://localhost:8080/device/{id} (PUT)
* Delete device: http://localhost:8080/device/{id} (DELETE)

Service Type
* Add service type: http://localhost:8080/servicetype (POST)
* Delete service type: http://localhost:8080/servicetype/{id} (DELETE)

Customer Device Controller
* Calculate monthly cost per customer: http://localhost:8080/customerdevice/calculatecost/{customerid} (GET)

Resources:

Collection located in resources/Ninjaone.postman_collection can be imported in postman to have some util endpoints.

## H2 Console 

In order to see and interact with your db, access the h2 console in your browser.
After running the application, go to:

http://localhost:8080/h2-console

Enter the information for the url, username, and password in the application.yml:

```yml
url: jdbc:h2:mem:localdb
username: sa 
password: password
```