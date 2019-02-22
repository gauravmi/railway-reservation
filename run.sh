./gradlew clean shadowJar
java -jar ./build/libs/railway-reservation-all.jar server ./src/main/resources/reservation-system.yml
