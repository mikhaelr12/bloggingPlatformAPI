CREATE TABLE post_tags (
                           post_id bigint NOT NULL,
                           tag varchar(255),
                           FOREIGN KEY (post_id) REFERENCES posts (id) ON DELETE CASCADE
);