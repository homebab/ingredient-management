CREATE TABLE IF NOT EXISTS items(
    id          BIGSERIAL PRIMARY KEY,
    created_at  TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at  TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    name        TEXT                                  NOT NULL,
    sensitivity BOOLEAN
);
