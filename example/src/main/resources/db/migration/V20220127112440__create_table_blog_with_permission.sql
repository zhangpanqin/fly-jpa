CREATE TABLE blog_with_permission
(
    id                 BIGINT NOT NULL primary key,
    created_date       TIMESTAMP WITHOUT TIME ZONE,
    created_by         VARCHAR(255),
    last_modified_date TIMESTAMP WITHOUT TIME ZONE,
    last_modified_by   VARCHAR(255),
    version            INTEGER,
    deleted_at         BIGINT,
    title              VARCHAR(255),
    user_id            BIGINT,
    content            VARCHAR(255),
    dept_id            BIGINT
);