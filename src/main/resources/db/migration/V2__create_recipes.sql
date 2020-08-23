CREATE TABLE IF NOT EXISTS recipes
(
    id         BIGSERIAL PRIMARY KEY,
    created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP NOT NULL,
    name       TEXT                                  NOT NULL,
    source     TEXT,
    source_url TEXT
);
