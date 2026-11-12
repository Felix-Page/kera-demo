INSERT INTO recipe (id, version, name, servings)
VALUES ('22222222-2222-2222-2222-222222222201', 0, 'Crêpes traditionnelles', 4),
       ('22222222-2222-2222-2222-222222222202', 0, 'Fondant au chocolat', 6)
ON CONFLICT (id) DO NOTHING;
