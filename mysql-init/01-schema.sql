-- Create this file as mysql-init/01-schema.sql
-- It will automatically run when the MySQL container starts

-- Orders table to store Order entities
CREATE TABLE orders (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        consumer_id BIGINT NOT NULL,
                        restaurant_id BIGINT NOT NULL,
                        state VARCHAR(50) NOT NULL,
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Eventuate Tram tables for saga management
-- Message table for the event sourcing system
CREATE TABLE message (
                         id VARCHAR(255) NOT NULL,
                         destination VARCHAR(255) NOT NULL,
                         headers VARCHAR(1000) NOT NULL,
                         payload VARCHAR(4000) NOT NULL,
                         published SMALLINT DEFAULT 0,
                         creation_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         PRIMARY KEY (id)
);

-- Tables required by Eventuate Tram Saga framework
CREATE TABLE saga_instance (
                               saga_type VARCHAR(255) NOT NULL,
                               saga_id VARCHAR(100) NOT NULL,
                               state_name VARCHAR(100) NOT NULL,
                               last_request_id VARCHAR(100),
                               end_state INT(1),
                               compensating INT(1),
                               failed INT(1),
                               saga_data_type VARCHAR(1000) NOT NULL,
                               saga_data_json VARCHAR(1000) NOT NULL,
                               PRIMARY KEY (saga_type, saga_id)
);

CREATE TABLE saga_instance_participants (
                                            saga_type VARCHAR(255) NOT NULL,
                                            saga_id VARCHAR(100) NOT NULL,
                                            destination VARCHAR(100) NOT NULL,
                                            resource VARCHAR(100) NOT NULL,
                                            PRIMARY KEY (saga_type, saga_id, destination, resource)
);

CREATE TABLE saga_lock_table (
                                 target VARCHAR(100) NOT NULL,
                                 saga_type VARCHAR(255) NOT NULL,
                                 saga_id VARCHAR(100) NOT NULL,
                                 PRIMARY KEY (target)
);

CREATE TABLE saga_stash_table (
                                  message_id VARCHAR(100) NOT NULL,
                                  target VARCHAR(100) NOT NULL,
                                  saga_type VARCHAR(255) NOT NULL,
                                  saga_id VARCHAR(100) NOT NULL,
                                  message_headers VARCHAR(1000) NOT NULL,
                                  message_payload VARCHAR(4000) NOT NULL,
                                  PRIMARY KEY (message_id)
);

-- Create tables for message tracking
CREATE TABLE received_messages (
                                   consumer_id VARCHAR(255),
                                   message_id VARCHAR(255),
                                   creation_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                   PRIMARY KEY(consumer_id, message_id)
);

CREATE TABLE saga_enrolled_participants (
                                            saga_id VARCHAR(100) NOT NULL,
                                            saga_type VARCHAR(255) NOT NULL,
                                            destination VARCHAR(100) NOT NULL,
                                            resource VARCHAR(100) NOT NULL,
                                            PRIMARY KEY(saga_id, destination, resource)
);

-- Create indices for better performance
CREATE INDEX message_published_idx ON message(published, id);
CREATE INDEX message_destination_idx ON message(destination, id);