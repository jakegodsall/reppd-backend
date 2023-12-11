CREATE TABLE IF NOT EXISTS role (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    created_date TIMESTAMP,
    last_modified_date TIMESTAMP,
    version BIGINT DEFAULT 0,
    name VARCHAR(255) NOT NULL
);