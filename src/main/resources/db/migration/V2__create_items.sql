CREATE TABLE IF NOT EXISTS items
(
    id          BIGSERIAL PRIMARY KEY,
    created_at  TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at  TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP NOT NULL,
    name        TEXT                                  NOT NULL,
    category    TEXT                                  NOT NULL,
    description TEXT,
    fridge      INT,
    freezer     INT,
    room        INT
--     sensitivity      BOOLEAN
);

COMMENT ON COLUMN items.fridge is 'shelf life on fridge';
COMMENT ON COLUMN items.freezer is 'shelf life on freezer';
COMMENT ON COLUMN items.room is 'shelf life on room';