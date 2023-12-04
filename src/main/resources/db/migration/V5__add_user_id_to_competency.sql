ALTER TABLE competency
ADD COLUMN user_id BIGINT;

ALTER TABLE competency
ADD FOREIGN KEY (user_id) REFERENCES user(id);