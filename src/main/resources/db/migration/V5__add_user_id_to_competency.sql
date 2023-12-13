ALTER TABLE competency
    ADD COLUMN user_id BIGINT NOT NULL;


ALTER TABLE competency
    ADD FOREIGN KEY (user_id) REFERENCES user (id);
