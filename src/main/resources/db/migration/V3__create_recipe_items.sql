CREATE TABLE IF NOT EXISTS recipe_items
(
    id         BIGSERIAL PRIMARY KEY,
    created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP NOT NULL,
    recipe_id  BIGINT                                   NOT NULL,
    item_id    BIGINT                                   NOT NULL,
    UNIQUE (recipe_id, item_id),
    FOREIGN KEY (recipe_id) REFERENCES recipes (id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (item_id) REFERENCES items (id) ON UPDATE CASCADE ON DELETE CASCADE
);
