CREATE TABLE recipe_step
(
    id          UUID PRIMARY KEY,
    created_at  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP          DEFAULT CURRENT_TIMESTAMP,
    version     BIGINT    NOT NULL,
    recipe_id   UUID      NOT NULL REFERENCES recipe (id) ON DELETE CASCADE,
    step_number INTEGER   NOT NULL CHECK (step_number > 0),
    description TEXT      NOT NULL CHECK (btrim(description) <> ''),
    UNIQUE (recipe_id, step_number)
);
