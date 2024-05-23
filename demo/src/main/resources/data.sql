-- Insert initial data for Room
INSERT INTO room (current_temperature, is_air_condition_on, fan_speed, mode, daily_rent) VALUES
                                                                                             (26, false, 0, 0, 100.0),
                                                                                             (26, false, 0, 0, 100.0),
                                                                                             (26, false, 0, 0, 100.0),
                                                                                             (26, false, 0, 0, 100.0),
                                                                                             (26, false, 0, 0, 100.0);

-- Insert initial data for Customer
INSERT INTO customer (name, accumulated_stay_time, rent, air_condition_fee, room_id) VALUES
                                                                                         ('Customer 1', 0, 0.0, 0.0, 1),
                                                                                         ('Customer 2', 0, 0.0, 0.0, 2),
                                                                                         ('Customer 3', 0, 0.0, 0.0, 3),
                                                                                         ('Customer 4', 0, 0.0, 0.0, 4),
                                                                                         ('Customer 5', 0, 0.0, 0.0, 5);
