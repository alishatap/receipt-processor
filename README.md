# receipt-processor
My implementation of Fetch's take home challenge, a receipt processor.
This is written in java17 and can be run using Docker.
## Getting Started
### Dependencies
* Make sure `docker` is installed in your terminal
* Make sure port `8080` is free on your computer, as this is the port the application uses
* To test the application, download [Postman](https://www.postman.com/downloads/)
### Setup
1. Download the project from GitHub
2. Open your computers terminal and navigate to the project folder
3. Execute the following command:
```
$ docker image build -t receipt-processor-image:latest .
```
## Running the code
### To run
1. While still in the project folder, execute the following command:
```
$ docker run -p 8080:8080 receipt-processor-image:latest
```
**The application should now be running in your terminal on port 8080.**
### To test
* Use the attached Postman collection to hit the `POST` and `GET` endpoints while the application is running.
  * Open Postman and navigate to File -> Import
  * Open the `Receipt Processor.postman_collection.json` file, found in the project under `src/main/resources/`
* IDs to use to test the `GET` endpoint can be obtained via the _response body_ of the `POST` commands. 