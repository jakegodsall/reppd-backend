CREATE TABLE IF NOT EXISTS user_authority
(
    user_id      BIGINT NOT NULL,
    authority_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, authority_id),
    FOREIGN KEY (user_id) REFERENCES user (id),
    FOREIGN KEY (authority_id) REFERENCES authority (id)
);
