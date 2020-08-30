CREATE TABLE IF NOT EXISTS users
(
    id         BIGSERIAL PRIMARY KEY,
    created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP NOT NULL,
    email      TEXT UNIQUE                           NOT NULL,
    name       TEXT                                  NOT NULL,
    age        int,
    gender     TEXT,
    image_url  TEXT
);
