CREATE TABLE recipe
(
    id         UUID PRIMARY KEY,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP          DEFAULT CURRENT_TIMESTAMP,
    version    BIGINT    NOT NULL,
    name       TEXT      NOT NULL CHECK (btrim(name) <> ''),
    servings   INTEGER   NOT NULL CHECK (servings > 0)
);
