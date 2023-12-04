CREATE TABLE IF NOT EXISTS log (
    id BIGINT PRIMARY KEY,
    created_date TIMESTAMP,
    last_modified_date TIMESTAMP,
    version BIGINT DEFAULT 0,
    date DATE,
    value BIGINT DEFAULT 0,
    activity_id BIGINT
);

ALTER TABLE log
ADD FOREIGN KEY (activity_id) REFERENCES activity(id);