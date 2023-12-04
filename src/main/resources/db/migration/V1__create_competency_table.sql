CREATE TABLE IF NOT EXISTS competency (
    id BIGINT PRIMARY KEY,
    created_date TIMESTAMP,
    last_modified_date TIMESTAMP,
    version BIGINT DEFAULT 0,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL
);