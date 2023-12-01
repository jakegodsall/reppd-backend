CREATE TABLE IF NOT EXISTS log (
    id BIGINT PRIMARY KEY,
    date DATE,
    value BIGINT DEFAULT 0,
    activity_id BIGINT
);

ALTER TABLE log
ADD FOREIGN KEY (activity_id) REFERENCES activity(id);