CREATE TABLE IF NOT EXISTS user_items
(
    id         BIGSERIAL PRIMARY KEY,
    created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP NOT NULL,
    expired_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    user_id    BIGINT                                  NOT NULL,
    item_id    BIGINT                                   NOT NULL,
    shelf_life INT,
    memo       TEXT,
    UNIQUE (user_id, item_id),
    FOREIGN KEY (user_id) REFERENCES users (id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (item_id) REFERENCES items (id) ON UPDATE CASCADE ON DELETE CASCADE
);
