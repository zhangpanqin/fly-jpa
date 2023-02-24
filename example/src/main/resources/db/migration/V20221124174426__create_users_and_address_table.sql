CREATE TABLE users
(
    id                 BIGINT NOT NULL PRIMARY KEY,
    created_date       TIMESTAMP WITHOUT TIME ZONE,
    created_by         VARCHAR(255),
    last_modified_date TIMESTAMP WITHOUT TIME ZONE,
    last_modified_by   VARCHAR(255),
    version            INTEGER,
    deleted_at         BIGINT,
    username           VARCHAR(255),
    address_id         BIGINT
);

CREATE TABLE address
(
    id                 BIGINT NOT NULL PRIMARY KEY,
    created_date       TIMESTAMP WITHOUT TIME ZONE,
    created_by         VARCHAR(255),
    last_modified_date TIMESTAMP WITHOUT TIME ZONE,
    last_modified_by   VARCHAR(255),
    version            INTEGER,
    deleted_at         BIGINT,
    city               VARCHAR(255)
);