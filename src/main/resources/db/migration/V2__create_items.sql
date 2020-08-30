CREATE TABLE IF NOT EXISTS items(
    id          BIGSERIAL PRIMARY KEY,
    user_id     BIGINT                                NOT NULL,
    created_at  TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at  TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP NOT NULL,
    expired_at  TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    name        TEXT                                  NOT NULL,
    category    TEXT,
    memo        TEXT,
    image_url   TEXT,
--     sensitivity BOOLEAN,
    FOREIGN KEY (user_id) REFERENCES users (id) ON UPDATE CASCADE ON DELETE CASCADE
);
