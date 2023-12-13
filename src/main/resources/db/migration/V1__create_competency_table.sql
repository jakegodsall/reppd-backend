DROP TABLE IF EXISTS competency;

CREATE TABLE competency
(
    id                 BIGINT        NOT NULL UNIQUE AUTO_INCREMENT,
    created_date       TIMESTAMP,
    last_modified_date TIMESTAMP,
    version            BIGINT DEFAULT 0,
    name               VARCHAR(100)  NOT NULL,
    description        VARCHAR(1000) NOT NULL,
    PRIMARY KEY (id)
);
