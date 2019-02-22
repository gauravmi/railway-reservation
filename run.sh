./gradlew clean shadowJar
java -jar ./build/libs/geodetestapp-all.jar server ./src/main/resources/reservation-system.yml
