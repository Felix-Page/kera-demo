INSERT INTO recipe_step (id, version, recipe_id, step_number, description)
VALUES ('44444444-4444-4444-4444-444444444401', 0, '22222222-2222-2222-2222-222222222201', 1, 'Tamiser la farine dans un saladier avec le sucre et la pincée de sel.'),
       ('44444444-4444-4444-4444-444444444402', 0, '22222222-2222-2222-2222-222222222201', 2, 'Incorporer les oeufs au centre puis verser progressivement le lait en fouettant.'),
       ('44444444-4444-4444-4444-444444444403', 0, '22222222-2222-2222-2222-222222222201', 3, 'Ajouter le beurre fondu et laisser reposer la pâte 30 minutes.'),
       ('44444444-4444-4444-4444-444444444404', 0, '22222222-2222-2222-2222-222222222201', 4, 'Cuire les crêpes dans une poêle chaude légèrement beurrée 1 à 2 minutes par face.'),
       ('44444444-4444-4444-4444-444444444405', 0, '22222222-2222-2222-2222-222222222202', 1, 'Préchauffer le four à 180°C et faire fondre le chocolat avec le beurre.'),
       ('44444444-4444-4444-4444-444444444406', 0, '22222222-2222-2222-2222-222222222202', 2, 'Fouetter les oeufs et le sucre jusqu''à ce que le mélange blanchisse.'),
       ('44444444-4444-4444-4444-444444444407', 0, '22222222-2222-2222-2222-222222222202', 3, 'Incorporer la farine puis le mélange chocolat-beurre fondu.'),
       ('44444444-4444-4444-4444-444444444408', 0, '22222222-2222-2222-2222-222222222202', 4, 'Verser dans un moule beurré et enfourner pendant 20 minutes.')
ON CONFLICT (id) DO NOTHING;
