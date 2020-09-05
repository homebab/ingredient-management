CREATE TABLE IF NOT EXISTS items
(
    id               BIGSERIAL PRIMARY KEY,
    created_at       TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at       TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP NOT NULL,
    name             TEXT,
    category         TEXT,
    description      TEXT,
    refrigerated     INT,
    frozen           INT,
    room_temperature INT
--     sensitivity      BOOLEAN
);

COPY items(name, category, refrigerated, frozen, room_temperature) FROM '\\item.csv' DELIMITER ',' CSV HEADER;

COMMENT ON COLUMN items.refrigerated is 'shelf life in case of refrigerated storage';
COMMENT ON COLUMN items.frozen is 'shelf life in case of frozen storage';
COMMENT ON COLUMN items.room_temperature is 'shelf life in case of room temperature storage';