insert into product (product_name, product_description, product_pvp, product_stock_quantity, product_date, category_category_id) values ('Llavero R2-D2', 'Llavero metálico con diseño de R2-D2 de Star Wars', 9.99, 50, '2024-05-06', 1);
insert into product (product_name, product_description, product_pvp, product_stock_quantity, product_date, category_category_id) values ('Figura Iron Man', 'Figura de acción de Iron Man con luces y sonidos', 19.99, 30, '2024-05-06', 2);
insert into product (product_name, product_description, product_pvp, product_stock_quantity, product_date, category_category_id) values ('Camiseta Batman', 'Camiseta negra con el logo de Batman estampado', 14.99, 100, '2024-05-06', 3);

insert into admin (basic_useruname, basic_user_name, basic_user_last_name, basic_user_password, basic_user_password_check, basic_user_dni, basic_user_photo) VALUES ('admin', 'Juan', 'Pérez', '{bcrypt}$2a$10$RlcLSXIvm8VDjEBq19oB7OFEB3sJnxvJETStFrBeHwU1pYc0EGTTa', '{bcrypt}$2a$10$RlcLSXIvm8VDjEBq19oB7OFEB3sJnxvJETStFrBeHwU1pYc0EGTTa', '12345678A', 'ruta/foto1.jpg');
insert into customer (basic_useruname, basic_user_name, basic_user_last_name, basic_user_password, basic_user_password_check, basic_user_dni, basic_user_photo, customer_mail, customer_birth, customer_last_session, customer_phone, customer_address) VALUES ('user', 'Alberto', 'González', '{bcrypt}$2a$10$lsHpqw5K/gL8ooHr/LdZfOzcNKpknmIETBEwJZBwegqfAP3PrEdFq', '{bcrypt}$2a$10$lsHpqw5K/gL8ooHr/LdZfOzcNKpknmIETBEwJZBwegqfAP3PrEdFq', '87654321Z', 'ruta/foto1.jpg', 'correo@ejemplo.com', '1990-01-01', '2024-05-13', '123456789', 'Calle Ejemplo 123');

insert into customer (basic_useruname, basic_user_password, basic_user_password_check) values ('user', '{noop}1234','{noop}1234');

insert into category (category_name, category_description) VALUES ('llaveros', 'Productos para llevar tus llaves con estilo');
insert into category (category_name, category_description) VALUES ('felpudos', 'Bienvenidas originales para tu hogar');
insert into category (category_name, category_description) VALUES ('carteras', 'Carteras y monederos de diseño para todas las ocasiones');
insert into category (category_name, category_description) VALUES ('tazas', 'Tazas únicas para disfrutar tu bebida favorita');
insert into category (category_name, category_description) VALUES ('funkos', 'Figuras de colección para fans de películas, series y videojuegos');


INSERT INTO theme (theme_name, theme_description, theme_photo) VALUES ('Disney', 'Temas relacionados con Disney', 'foto_disney.jpg');
INSERT INTO theme (theme_name, theme_description, theme_photo) VALUES ('Deadpool', 'Temas relacionados con Deadpool', 'foto_deadpool.jpg');
INSERT INTO theme (theme_name, theme_description, theme_photo) VALUES ('Avengers', 'Temas relacionados con los Avengers', 'foto_avengers.jpg');
INSERT INTO theme (theme_name, theme_description, theme_photo) VALUES ('Star Wars', 'Temas relacionados con Star Wars', 'foto_star_wars.jpg');
INSERT INTO theme (theme_name, theme_description, theme_photo) VALUES ('DC', 'Temas relacionados con DC Comics', 'foto_dc.jpg');
INSERT INTO theme (theme_name, theme_description, theme_photo) VALUES ('Marvel', 'Temas relacionados con Marvel Comics', 'foto_marvel.jpg');
INSERT INTO theme (theme_name, theme_description, theme_photo) VALUES ('El Señor de los Anillos', 'Temas relacionados con El Señor de los Anillos', 'foto_señor_anillos.jpg');
INSERT INTO theme (theme_name, theme_description, theme_photo) VALUES ('Juego de Tronos', 'Temas relacionados con Juego de Tronos', 'foto_juego_tronos.jpg');
INSERT INTO theme (theme_name, theme_description, theme_photo) VALUES ('Pokémon', 'Temas relacionados con Pokémon', 'foto_pokemon.jpg');
