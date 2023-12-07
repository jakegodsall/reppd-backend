CREATE TABLE IF NOT EXISTS authority (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    created_date TIMESTAMP,
    last_modified_date TIMESTAMP,
    version BIGINT DEFAULT 0,
    role VARCHAR(255)
);