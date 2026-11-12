CREATE TABLE recipe_ingredient
(
    id            UUID PRIMARY KEY,
    created_at    TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at    TIMESTAMP                 DEFAULT CURRENT_TIMESTAMP,
    version       BIGINT           NOT NULL,
    recipe_id     UUID             NOT NULL REFERENCES recipe (id) ON DELETE CASCADE,
    ingredient_id UUID             NOT NULL REFERENCES ingredient (id),
    quantity      DOUBLE PRECISION NOT NULL CHECK (quantity > 0),
    unit          unit             NOT NULL
);
