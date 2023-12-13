DROP TABLE IF EXISTS activity;

CREATE TABLE activity (
    id BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
    created_date TIMESTAMP,
    last_modified_date TIMESTAMP,
    version BIGINT DEFAULT 0,
    name VARCHAR(100) NOT NULL,
    competency_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (competency_id) REFERENCES competency(id)
);