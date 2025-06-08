INSERT INTO users (email, level, password, points, role, username) VALUES
                                                                       ('admin@warhammer.com', 'Emperador', 'admin123', 9999, 'ADMIN', 'adminLord'),
                                                                       ('guest@terra.com', 'Ciudadano', 'guest123', 0, 'GUEST', 'guestette'),
                                                                       ('user@imperium.com', 'Soldado', 'pass123', 500, 'LOGGED_USER', 'marineRaquel'),
                                                                       ('infiltrado@chaos.com', 'Hereje', 'chaos123', -100, 'GUEST', 'hereticX'),
                                                                       ('reliquia@ordo.com', 'Archivero', 'archive777', 1500, 'LOGGED_USER', 'ancientOne');

INSERT INTO activity (day, description, duration, image, name, places, time, type) VALUES
                                                                                       ('2025-06-10', 'Batalla por el trono del Emperador', 180, 'throne_war.png', 'Trono Imperial', 50, '2025-06-10 15:00:00.000000', 'EVENT'),
                                                                                       ('2025-07-20', 'Taller de pintura de miniaturas', 120, 'painting_workshop.jpg', 'Pinta tu Marine', 20, '2025-07-20 17:30:00.000000', 'WORKSHOP'),
                                                                                       ('2025-08-05', 'Conferencia sobre el Caos', 90, 'chaos_gods.png', 'El Auge del Caos', 100, '2025-08-05 12:00:00.000000', 'EVENT'),
                                                                                       ('2025-09-15', 'Clase magistral de Lore', 60, 'lore_class.jpg', 'Lore Oscuro', 40, '2025-09-15 10:00:00.000000', 'WORKSHOP'),
                                                                                       ('2025-10-31', 'Especial de Halloween: Sobrevive a Nurgle', 150, 'nurgle_halloween.png', 'Noche del Miedo', 66, '2025-10-31 20:00:00.000000', 'EVENT');
