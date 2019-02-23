CREATE DATABASE railway_reservation;

CREATE USER test;

\password test;

ALTER USER test WITH SUPERUSER;

GRANT ALL PRIVILEGES ON DATABASE railway_reservation TO test;

GRANT CONNECT ON DATABASE railway_reservation TO test;

GRANT USAGE ON SCHEMA PUBLIC TO test;

GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA PUBLIC TO test;

GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA PUBLIC TO test;

\connect railway_reservation;

CREATE TABLE booking(
    user_id VARCHAR(40) UNIQUE,
    username VARCHAR(40),
    booking_id varchar(40) UNIQUE,
    from_station varchar(40),
    to_station varchar(40),
    train varchar(40)
);