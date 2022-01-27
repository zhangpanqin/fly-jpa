CREATE TABLE blog2
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
    content            VARCHAR(255)
);
CREATE TABLE user_info2
(
    id                 BIGINT NOT NULL primary key,
    created_date       TIMESTAMP,
    created_by         VARCHAR(255),
    last_modified_date TIMESTAMP,
    last_modified_by   VARCHAR(255),
    version            INTEGER,
    deleted_at         BIGINT,
    name               VARCHAR(255)
);