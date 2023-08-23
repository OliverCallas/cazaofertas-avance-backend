INSERT INTO users (id, username, password, enabled, authority) VALUES (1, 'oliver', '$2a$12$qvSYteuDLRMxRbcj4zXhvOvlvx3.Hyci7nf6mxz1hcKCEIaTfj9Ki', 1, 'ROLE_USER');
INSERT INTO profiles_users (id, first_name, last_name,gender, country, user_id) VALUES (1, 'beaver', 'oliver', 'm', 'peru', 1);
INSERT INTO publicaciones (id, titulo,categoria,imagen,ubicacion,descripcion,fecha,estado) VALUES (1, 'Hamburguesa Parrillera a Luca','Hamburguesas','IMAGEN','Av Benavides 1304 Miraflores','Con la App Fpay puedes aceder a la promo de 1 hamburguesa a 1 sol aprovecha sobrino','2023-06-15','Activo');
INSERT INTO publicaciones (id, titulo,categoria,imagen,ubicacion,descripcion,fecha,estado) VALUES (2, 'Tarjeta de Video MSI 1050 a S/850','Hardware','IMAGEN','Av Petit Thouars 1556','Acercate al Piso 2 de Compupalace en la tienda Impacto para aprovechar esta promo no te la pierdas','2023-06-15','Activo');
INSERT INTO publicaciones (id, titulo,categoria,imagen,ubicacion,descripcion,fecha,estado) VALUES (3, '','','','','Acercate al Piso 2 de Compupalace en la tienda Impacto para aprovechar esta promo no te la pierdas','2023-06-15','');

SELECT setval(pg_get_serial_sequence('users', 'id'), COALESCE((SELECT MAX(id) + 1 FROM users), 1), false);
SELECT setval(pg_get_serial_sequence('profiles_users', 'id'), COALESCE((SELECT MAX(id) + 1 FROM profiles_users), 1), false);
SELECT setval(pg_get_serial_sequence('publicaciones', 'id'), COALESCE((SELECT MAX(id) + 1 FROM publicaciones), 1), false);
