INSERT INTO "public"."address" ("id", "created_date", "created_by", "last_modified_date", "last_modified_by", "version",
                                "deleted_at", "city")
VALUES (1, '2022-11-24 10:09:51.26411', '1', '2022-11-24 10:09:51.26411', '1', 1, -1, 'address_武汉'),
       (2, '2022-11-24 10:09:51.26411', '1', '2022-11-24 10:09:51.26411', '1', 1, -1, 'address_河南');

INSERT INTO "public"."users" ("id", "created_date", "created_by", "last_modified_date", "last_modified_by", "version",
                              "deleted_at", "username", "address_id")
VALUES (11, '2022-11-24 10:08:31.579461', '1', '2022-11-24 10:09:07.416731', '1', 1, -1, 'users_11', 1),
       (21, '2022-11-24 10:08:31.579461', '1', '2022-11-24 10:09:07.416731', '1', 1, -1, 'users_22', 2);


CREATE TABLE users2
(
    id                 BIGINT NOT NULL PRIMARY KEY,
    created_date       TIMESTAMP WITHOUT TIME ZONE,
    created_by         VARCHAR(255),
    last_modified_date TIMESTAMP WITHOUT TIME ZONE,
    last_modified_by   VARCHAR(255),
    version            INTEGER,
    deleted_at         BIGINT,
    username           VARCHAR(255)
);

CREATE TABLE address2
(
    id                 BIGINT NOT NULL PRIMARY KEY,
    created_date       TIMESTAMP WITHOUT TIME ZONE,
    created_by         VARCHAR(255),
    last_modified_date TIMESTAMP WITHOUT TIME ZONE,
    last_modified_by   VARCHAR(255),
    version            INTEGER,
    deleted_at         BIGINT,
    city               VARCHAR(255),
    user_id            BIGINT
);
INSERT INTO "public"."address2" ("id", "created_date", "created_by", "last_modified_date", "last_modified_by",
                                 "version",
                                 "deleted_at", "city", "user_id")
VALUES (1, '2022-11-24 10:09:51.26411', '1', '2022-11-24 10:09:51.26411', '1', 1, -1, 'address2_武汉', 100),
       (2, '2022-11-24 10:09:51.26411', '1', '2022-11-24 10:09:51.26411', '1', 1, -1, 'address2_河南', 200);

INSERT INTO "public"."users2" ("id", "created_date", "created_by", "last_modified_date", "last_modified_by", "version",
                               "deleted_at", "username")
VALUES (100, '2022-11-24 10:08:31.579461', '1', '2022-11-24 10:09:07.416731', '1', 1, -1, 'users2_11'),
       (200, '2022-11-24 10:08:31.579461', '1', '2022-11-24 10:09:07.416731', '1', 1, -1, 'users2_22');