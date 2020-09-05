CREATE TABLE IF NOT EXISTS user_items
(
    id         BIGSERIAL PRIMARY KEY,
    user_id    BIGINT                                NOT NULL,
    item_id    BIGINT,
    created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP NOT NULL,
    expired_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    name       TEXT                                  NOT NULL,
    tag        TEXT,
    storage    TEXT                                  NOT NULL,
    memo       TEXT,
    image_url  TEXT,
    FOREIGN KEY (user_id) REFERENCES users (id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (item_id) REFERENCES items (id) ON UPDATE CASCADE ON DELETE CASCADE
);
