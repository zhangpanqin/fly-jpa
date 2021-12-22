CREATE TABLE user_info
(
    id                 BIGINT NOT NULL primary key ,
    created_date       TIMESTAMP,
    created_by         VARCHAR(255),
    last_modified_date TIMESTAMP,
    last_modified_by   VARCHAR(255),
    version            INTEGER,
    deleted_at         BIGINT,
    name              VARCHAR(255)
);