# railway-reservation

Implementation of gemfire Write behind cache event handling -

Prequisites :
* java8 
* Postgres (preferably 11.0) https://www.postgresql.org/docs/9.3/tutorial-install.html
* Gemfire 9.5.1 https://gemfire.docs.pivotal.io/97/gemfire/getting_started/installation/install_intro.html


## Setup instructions

## Postgres Setup
* Make sure you have psql command line utility installed. run "psql --version"
* execute "psql -f ./migration/db.sql" from terminal

## Gemfire setup
* Build project
 ```bash
     ./gradlew clean build
 ```
* Build shadowJar 
```bash
    ~/.gradlew clean shadowJar
```
* Publish event processor library to local maven 
```bash
    ./gradlew publishToMavenLocal
```
* copy lib jar to /tmp as gemfire script picks up from this location
```bash
    cp ~/.m2/repository/com/tw/eventprocessor/1.1/eventprocessor-1.1.jar /tmp
```
* Open gfsh shell from <GEMFIRE_INSTALLATION>/bin/gfsh
* run command "run --file=./migration/regions.gfsh"
* Run below commands to verify the installation
* list members -> should list locator and server1
* list deployed -> should list eventprocessor-1.1.jar 
* list regions -> should list "booking" region
* list async-event-queue -> should list "bookingQueue" entry
* describe region --name=booking -> make sure "async-event-queue-id" is mapped to "bookingQueue"

# Run  Build
```bash
    ./gradlew clean build
```

# Run Application
```bash
    sh run.sh
```

# Api

* Booking request :
```bash
    curl -X POST \
      http://localhost:8080/book \
      -H 'Content-Type: application/json' \
      -d '{
        "userId":"100312",
        "userName": "user51",
        "fromStation": "s2",
        "toStation": "s2",
        "train": "t2"
    }'
```


* List all bookings : 
```bash
    curl -X GET \
      http://localhost:8080/bookings \
      -H 'Content-Type: application/json'
```
