-- Drop tables if they exist
DROP TABLE IF EXISTS bill;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS room;

-- Create table for Room
CREATE TABLE room (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      current_temperature INT NOT NULL,
                      is_air_condition_on BOOLEAN NOT NULL,
                      fan_speed INT NOT NULL,
                      mode INT NOT NULL,
                      daily_rent DOUBLE NOT NULL,
                      default_temperature INT NOT NULL DEFAULT 26
);

-- Create table for Customer
CREATE TABLE customer (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          accumulated_stay_time INT NOT NULL,
                          rent DOUBLE NOT NULL,
                          air_condition_fee DOUBLE NOT NULL,
                          room_id BIGINT,
                          FOREIGN KEY (room_id) REFERENCES room(id)
);

-- Create table for Bill
CREATE TABLE bill (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      amount DOUBLE NOT NULL,
                      date TIMESTAMP NOT NULL,
                      customer_id BIGINT,
                      FOREIGN KEY (customer_id) REFERENCES customer(id)
);
