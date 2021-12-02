CREATE TABLE blog
(
    id                 BIGINT NOT NULL,
    created_date       TIMESTAMP WITHOUT TIME ZONE,
    created_by         VARCHAR(255),
    last_modified_date TIMESTAMP WITHOUT TIME ZONE,
    last_modified_by   VARCHAR(255),
    version            INTEGER,
    deleted_at         BIGINT,
    title              VARCHAR(255),
    user_id            BIGINT,
    content            VARCHAR(255),
    CONSTRAINT pk_blog PRIMARY KEY (id)
);