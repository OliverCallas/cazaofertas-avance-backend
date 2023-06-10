
INSERT INTO usuarios (id, username,password, enabled,  rol) VALUES (1,'oliver','$2a$12$qvSYteuDLRMxRbcj4zXhvOvlvx3.Hyci7nf6mxz1hcKCEIaTfj9Ki', 1, 'ROLE_ADMIN');

SELECT setval(pg_get_serial_sequence('usuarios', 'id'), COALESCE((SELECT MAX(id) + 1 FROM usuarios), 1), false);