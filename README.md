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
* Build project -> "~/.gradlew clean build"
* Build shadowJar -> "~/.gradlew clean shadowJar"
* Publish event processor library to local maven -> "./gradlew publishToMavenLocal"
* copy lib jar to /tmp as gemfire script picks up from this location -> "cp ~/.m2/<path-to-event-processor-lib>/eventprocessor-1.1.jar /tmp"
* Open gfsh shell from <GEMFIRE_INSTALLATION>/bin/gfsh
* run command "run --file=./migration/regions.gfsh"
* Run below commands to verify the installation
* list members -> should list locator and server1
* list deployed -> should list eventprocessor-1.1.jar 
* list regions -> should list "booking" region
* list async-event-queue -> should list "bookingQueue" entry
* describe region --name=booking -> make sure "async-event-queue-id" is mapped to "bookingQueue"

# Run  Build
./gradlew clean build

# Run Application
sh run.sh

# Api

* Booking request :
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


* List all bookings
curl -X GET \
  http://localhost:8080/bookings \
  -H 'Content-Type: application/json' \
