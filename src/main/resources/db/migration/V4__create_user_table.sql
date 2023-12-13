DROP TABLE IF EXISTS user;

CREATE TABLE user
(
    id                      BIGINT       NOT NULL UNIQUE AUTO_INCREMENT,
    created_date            TIMESTAMP,
    last_modified_date      TIMESTAMP,
    version                 BIGINT  DEFAULT 0,
    username                VARCHAR(100) NOT NULL UNIQUE,
    first_name              VARCHAR(100) NOT NULL,
    last_name               VARCHAR(100) NOT NULL,
    email                   VARCHAR(100) NOT NULL UNIQUE,
    password                VARCHAR(255)  NOT NULL,
    enabled                 BOOLEAN DEFAULT 1,
    account_non_expired     BOOLEAN DEFAULT 1,
    credentials_non_expired BOOLEAN DEFAULT 1,
    account_not_locked      BOOLEAN DEFAULT 1,
    PRIMARY KEY (id)
);

