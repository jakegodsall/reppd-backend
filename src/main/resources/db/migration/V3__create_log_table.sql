DROP TABLE IF EXISTS log;

CREATE TABLE log
(
    id                 BIGINT    NOT NULL UNIQUE AUTO_INCREMENT,
    created_date       TIMESTAMP,
    last_modified_date TIMESTAMP NOT NULL,
    version            BIGINT    NOT NULL DEFAULT 0,
    date               DATE      NOT NULL,
    value              BIGINT             DEFAULT 0,
    activity_id        BIGINT,
    PRIMARY KEY (id)
);

ALTER TABLE log
    ADD FOREIGN KEY (activity_id) REFERENCES activity (id);
