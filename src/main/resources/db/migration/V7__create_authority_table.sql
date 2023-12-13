DROP TABLE IF EXISTS authority;

CREATE TABLE authority
(
    id                 BIGINT      NOT NULL AUTO_INCREMENT,
    created_date       TIMESTAMP,
    last_modified_date TIMESTAMP,
    version            BIGINT DEFAULT 0,
    permission         VARCHAR(50) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);
