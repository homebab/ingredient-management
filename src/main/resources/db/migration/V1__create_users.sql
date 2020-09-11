CREATE TABLE IF NOT EXISTS users
(
    id         BIGSERIAL PRIMARY KEY,
--     socialId   TEXT UNIQUE                           NOT NULL,
    created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP NOT NULL,
    email      TEXT UNIQUE                           NOT NULL,
    name       TEXT                                  NOT NULL,
    age        INT,
    gender     TEXT,
    image_url  TEXT,
    active     BOOLEAN     DEFAULT TRUE              NOT NULL
);
