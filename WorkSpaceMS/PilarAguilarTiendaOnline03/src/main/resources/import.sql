insert into admin (basic_useruname, basic_user_name, basic_user_last_name, basic_user_password, basic_user_dni) VALUES ('admin', 'Pilar', 'Aguilar', '{bcrypt}$2a$10$RlcLSXIvm8VDjEBq19oB7OFEB3sJnxvJETStFrBeHwU1pYc0EGTTa', '12345678A');
insert into customer (basic_useruname, basic_user_name, basic_user_last_name, basic_user_password, basic_user_dni, customer_mail, customer_birth, customer_last_session, customer_phone, customer_address) VALUES ('alber01', 'Alberto', 'González', '{bcrypt}$2a$10$lsHpqw5K/gL8ooHr/LdZfOzcNKpknmIETBEwJZBwegqfAP3PrEdFq', '87654321Z', 'correo@ejemplo.com', '1990-01-01', '2024-05-13', '123456789', 'Calle Ejemplo 123');
insert into customer (basic_useruname, basic_user_password) values ('user', '{bcrypt}$2a$10$lsHpqw5K/gL8ooHr/LdZfOzcNKpknmIETBEwJZBwegqfAP3PrEdFq');

insert into category (category_name, category_description) VALUES ('Llaveros', 'Productos para llevar tus llaves con estilo');
insert into category (category_name, category_description) VALUES ('Felpudos', 'Bienvenidas originales para tu hogar');
insert into category (category_name, category_description) VALUES ('LEGO', 'Las mejores construcciones de tus sagas favoritas');
insert into category (category_name, category_description) VALUES ('Gorras', 'Gorras únicas para que vayas con el mejor estilo');
insert into category (category_name, category_description) VALUES ('Funkos', 'Figuras de colección para fans de películas, series y videojuegos');


INSERT INTO theme (theme_name, theme_description, theme_photo) VALUES ('Disney', 'Temas relacionados con Disney', 'foto_disney.jpg');
INSERT INTO theme (theme_name, theme_description, theme_photo) VALUES ('Deadpool', 'Temas relacionados con Deadpool', 'foto_deadpool.jpg');
INSERT INTO theme (theme_name, theme_description, theme_photo) VALUES ('Avengers', 'Temas relacionados con los Avengers', 'foto_avengers.jpg');
INSERT INTO theme (theme_name, theme_description, theme_photo) VALUES ('Star Wars', 'Temas relacionados con Star Wars', 'foto_star_wars.jpg');
INSERT INTO theme (theme_name, theme_description, theme_photo) VALUES ('DC', 'Temas relacionados con DC Comics', 'foto_dc.jpg');
INSERT INTO theme (theme_name, theme_description, theme_photo) VALUES ('Marvel', 'Temas relacionados con Marvel Comics', 'foto_marvel.jpg');
INSERT INTO theme (theme_name, theme_description, theme_photo) VALUES ('El Señor de los Anillos', 'Temas relacionados con El Señor de los Anillos', 'foto_señor_anillos.jpg');
INSERT INTO theme (theme_name, theme_description, theme_photo) VALUES ('Juego de Tronos', 'Temas relacionados con Juego de Tronos', 'foto_juego_tronos.jpg');
INSERT INTO theme (theme_name, theme_description, theme_photo) VALUES ('Pokémon', 'Temas relacionados con Pokémon', 'foto_pokemon.jpg');


INSERT INTO product (product_name,product_description,product_pvp,product_stock_quantity,product_image,product_image_alternative_text,product_date,category_category_id) VALUES ('LLAVERO PLAYSTATION: DUALSHOCK','Compra el llavero de Dualshock. El mando de tu consola favorita irá contigo allá donde vayas.',3.99,36,'https://media.game.es/COVERV2/3D_L/207/207412.png','Llavero Dualshock','2024-03-05',1);
INSERT INTO product (product_name,product_description,product_pvp,product_stock_quantity,product_image,product_image_alternative_text,product_date,category_category_id) VALUES ('LLAVERO THE LAST OF US: LOGO','Compra el llavero del premiado videojuego The Last Of Us. ',3.99,23,'https://media.game.es/COVERV2/3D_L/207/207420.png','Llavero Last of Us','2024-03-05',1);
INSERT INTO product (product_name,product_description,product_pvp,product_stock_quantity,product_image,product_image_alternative_text,product_date,category_category_id) VALUES ('LLAVERO STAR WARS THE MANDALORIAN: CASCO','Esta maravilla de llavero 3D fabricado con licencia oficial y con una excelente calidad tanto de acabados como de materiales, homenajea al cazarrecompensas protagonista de la serie de Disney +, The Mandalorian.',3.99,12,'https://media.game.es/COVERV2/3D_L/184/184565.png','Llavero Mando','2024-03-05',1);
INSERT INTO product (product_name,product_description,product_pvp,product_stock_quantity,product_image,product_image_alternative_text,product_date,category_category_id) VALUES ('LLAVERO STAR WARS: THE CHILD','Hazte con los nuevos y originales llaveros de goma de Star Wars: The Mandalorian, el mejor accesorio para organizar las llaves de casa, del trabajo, etc.',3.99,14,'https://media.game.es/COVERV2/3D_L/181/181506.png','Llavero Grogu','2024-03-06',1);
INSERT INTO product (product_name,product_description,product_pvp,product_stock_quantity,product_image,product_image_alternative_text,product_date,category_category_id) VALUES ('LLAVERO MARVEL: SPIDER-MAN','Hazte con los nuevos y originales llaveros de goma de Marvel, el mejor accesorio para organizar las llaves de casa, del trabajo, etc.',3.99,36,'https://media.game.es/COVERV2/3D_L/181/181496.png','Llavero Spidey','2024-04-04',1);
INSERT INTO product (product_name,product_description,product_pvp,product_stock_quantity,product_image,product_image_alternative_text,product_date,category_category_id) VALUES ('LLAVERO GUARDIANES DE LA GALAXIA: BABY GROOT','Hazte con los nuevos y originales llaveros de goma de Guardianes de la Galaxia, el mejor accesorio para organizar las llaves de casa, del trabajo, etc.',3.99,41,'https://media.game.es/COVERV2/3D_L/181/181499.png','Llavero Groot','2024-04-15',1);
INSERT INTO product (product_name,product_description,product_pvp,product_stock_quantity,product_image,product_image_alternative_text,product_date,category_category_id) VALUES ('LLAVERO HARRY POTTER SLYTHERIN','Llavero licencia oficial - Tamaño aprox. 4.5 x 6 cm - Material: caucho.',3.99,24,'https://media.game.es/COVERV2/3D_L/173/173610.png','Llavero Slytherin','2024-03-21',1);
INSERT INTO product (product_name,product_description,product_pvp,product_stock_quantity,product_image,product_image_alternative_text,product_date,category_category_id) VALUES ('LLAVERO DE HARRY POTTER: ESCUDO DE HOGWARTS','Nuestra selección de merchandise de Harry Potter es perfecta para cualquier muggle que quiera tener un trocito del universo mágico de este singular perosnaje.',6.95,48,'https://media.game.es/COVERV2/3D_L/184/184572.png','Llavero Hogwarts','2024-01-27',1);
INSERT INTO product (product_name,product_description,product_pvp,product_stock_quantity,product_image,product_image_alternative_text,product_date,category_category_id) VALUES ('FELPUDO CONTROLLER NES','Este felpudo hará las delicias de los fans de Nintendo, quedará perfecto en la entrada de tu casa, dándolo un toque único y original.',14.95,19,'https://media.game.es/COVERV2/3D_L/139/139122.png','Felpudo NES','2024-04-19',2);
INSERT INTO product (product_name,product_description,product_pvp,product_stock_quantity,product_image,product_image_alternative_text,product_date,category_category_id) VALUES ('FELPUDO SUPER MARIO BIENVENIDO','Este felpudo hará las delicias de los fans de la saga, quedará perfecto en la entrada de tu casa, dándolo un toque único y original.',19.99,26,'https://media.game.es/COVERV2/3D_L/176/176034.png','Felpudo Mario','2024-03-13',2);

INSERT INTO product (product_name,product_description,product_pvp,product_stock_quantity,product_image,product_image_alternative_text,product_date,category_category_id) VALUES ('FELPUDO STAR WARS: BOBA FETT','Tus personajes favoritos plasmados en felpudos de gran calidad.',14.99,16,'https://media.game.es/COVERV2/3D_L/204/204477.png','Felpudo Boba','2024-02-20',2);
INSERT INTO product (product_name,product_description,product_pvp,product_stock_quantity,product_image,product_image_alternative_text,product_date,category_category_id) VALUES ('FELPUDO STAR WARS THE MANDALORIAN THE CHILD','Compra el Felpudo de The Mandalorian de The Child.',19.9,27,'https://media.game.es/COVERV2/3D_L/215/215889.png','Felpudo Grogu','2024-05-02',2);
INSERT INTO product (product_name,product_description,product_pvp,product_stock_quantity,product_image,product_image_alternative_text,product_date,category_category_id) VALUES ('FELPUDO MARVEL: SPIDERMAN','Compra el Felpudo de Spiderman con la imagen de sus ojos de la franquicia de Marvel.',19.9,21,'https://media.game.es/COVERV2/3D_L/204/204476.png','Felpudo Spidey','2024-05-06',2);
INSERT INTO product (product_name,product_description,product_pvp,product_stock_quantity,product_image,product_image_alternative_text,product_date,category_category_id) VALUES ('FELPUDO VENGADORES INFINITY WAR: INFINITE POWER','El Felpudo Vengadores Infinity War: Infinite Power, que muestra la imagen del guantelete del infinito.',20.95,29,'https://media.game.es/COVERV2/3D_L/159/159803.png','Felpudo Gaunlet','2024-05-06',2);
INSERT INTO product (product_name,product_description,product_pvp,product_stock_quantity,product_image,product_image_alternative_text,product_date,category_category_id) VALUES ('FELPUDO DE GOMA HARRY POTTER: ALOHOMORA','Felpudo de goma con la famosa frase del encantamiento de apertura con el que poder abrir puertas y ventanas protegidas por magia, en la famosa saga del mago Harry Potter.',9.99,6,'https://media.game.es/COVERV2/3D_L/184/184188.png','Felpudo HP','2024-02-14',2);
INSERT INTO product (product_name,product_description,product_pvp,product_stock_quantity,product_image,product_image_alternative_text,product_date,category_category_id) VALUES ('FELPUDO PLATTFORM 9 3 4 HARRY POTTER','Compra la alfombra original de la Plataforma 9 3/4 de Harry Potter y dale un toque mágico a la entrada de tu casa, ¡del resto te encargas tú!',20.15,18,'https://media.game.es/COVERV2/3D_L/V1F/V1F9LF.png','Felpudo 9 3/4','2024-03-31',2);
INSERT INTO product (product_name,product_description,product_pvp,product_stock_quantity,product_image,product_image_alternative_text,product_date,category_category_id) VALUES ('LEGO SUPER MARIO PACK INICIAL: AVENTURAS CON MARIO 71360','Super Mario y LEGO se unen para darte horas de diversión. Explora el divertidísimo universo LEGO de Super Mario con el Pack Inicial: Aventuras con Mario, que incluye 7 ladrillos de acción que interactúan de distintas maneras con la figura de LEGO de Mario, Bowsy y Goomba.',54.99,29,'https://media.game.es/COVERV2/3D_L/182/182233.png','Lego Mario','2024-05-08',3);
INSERT INTO product (product_name,product_description,product_pvp,product_stock_quantity,product_image,product_image_alternative_text,product_date,category_category_id) VALUES ('LEGO MINECRAFT: LA CASA CHAMPIÑÓN 21179','Lleva a tu jugador de Minecraft a otra dimensión con el set LEGO Minecraft La Casa-Champiñón, un fantástico regalo para niños a partir de 8 años.',19.99,14,'https://media.game.es/COVERV2/3D_L/198/198326.png','Lego Minecraft','2024-01-07',3);
INSERT INTO product (product_name,product_description,product_pvp,product_stock_quantity,product_image,product_image_alternative_text,product_date,category_category_id) VALUES ('LEGO STAR WARS CASCO DEL COMANDANTE CLON CODY 75350','Compra el casco del Comandante Clon Cody, dispuesto para la batalla basada en Star Wars: Las Guerras Clon, rinde homenaje a un leal mariscal clon.',69.99,36,'https://media.game.es/COVERV2/3D_L/214/214553.png','Lego casco','2024-05-04',3);
INSERT INTO product (product_name,product_description,product_pvp,product_stock_quantity,product_image,product_image_alternative_text,product_date,category_category_id) VALUES ('LEGO STAR WARS: CAZA ESTELAR JEDI DE OBI-WAN KENOBI 75333','Este set de juguete construible incluye 2 minifiguras LEGO Star Wars: Obi-Wan y, por primera vez, el Kaminiano Taun We, así como una figura LEGO del droide astromecánico R4-P17 para estimular el juego de interpretación creativo.',24.99,29,'https://media.game.es/COVERV2/3D_L/205/205980.png','Lego caza estelar','2024-05-04',3);

INSERT INTO product (product_name,product_description,product_pvp,product_stock_quantity,product_image,product_image_alternative_text,product_date,category_category_id) VALUES ('LEGO MARVEL: ARMERÍA DE IRON MAN 76216','Compra la Armería de Iron Man LEGO Marvel, está llena de detalles realistas, funciones alucinantes e icónicas minifiguras que encantarán a los fans de la Saga Infinity de Marvel Studios.',89.99,37,'https://media.game.es/COVERV2/3D_L/202/202736.png','Lego Iron Man','2024-02-21',3);
INSERT INTO product (product_name,product_description,product_pvp,product_stock_quantity,product_image,product_image_alternative_text,product_date,category_category_id) VALUES ('LEGO MARVEL: BABY GROOT 76217','Compra el set de LEGO Marvel Yo Soy Groot, podrás poner en las manos de tu peque de 10 años o más un modelo móvil del Bebé Groot, el encantador personaje del universo cinematográfico Marvel.',49.99,33,'https://media.game.es/COVERV2/3D_L/202/202737.png','Lego Groot','2024-05-08',3);
INSERT INTO product (product_name,product_description,product_pvp,product_stock_quantity,product_image,product_image_alternative_text,product_date,category_category_id) VALUES ('LEGO HARRY POTTER: CARRUAJE Y THESTRALS DE HOGWARTS 76400','Compra el set de LEGO de Harry Potter Carruaje y Thestrals de Hogwarts, un juguete construible para niños a partir de 7 años con mágicos animales que cuidar y paseos en carruaje llenos de aventuras.',14.99,12,'https://media.game.es/COVERV2/3D_L/202/202742.png','Lego HP carruaje','2024-03-09',3);
INSERT INTO product (product_name,product_description,product_pvp,product_stock_quantity,product_image,product_image_alternative_text,product_date,category_category_id) VALUES ('LEGO HARRY POTTER: PATIO DE HOGWARTS RESCATE DE SIRIUS 76401','Compra el set de LEGO en donde los magos, brujas y Muggles a partir de 8 años podrán explorar un mundo mágico de juego imaginativo con LEGO Harry Potter Patio de Hogwarts: Rescate de Sirius.',39.99,33,'https://media.game.es/COVERV2/3D_L/202/202743.png','Lego HP Sirius','2024-03-21',3);
INSERT INTO product (product_name,product_description,product_pvp,product_stock_quantity,product_image,product_image_alternative_text,product_date,category_category_id) VALUES ('GORRA PLAYSTATION CORE','Sony ya ha lanzado la consola de nueva generación PlayStation 5, y para celebrarlo, en GAME te traemos la nueva línea de merchandising oficial de PS5: ropa, tazas, botellas, monederos,... ¡Y mucho más!',19.95,8,'https://media.game.es/COVERV2/3D_L/186/186308.png','Gorra PS','2024-05-12',4);
INSERT INTO product (product_name,product_description,product_pvp,product_stock_quantity,product_image,product_image_alternative_text,product_date,category_category_id) VALUES ('GORRA PLAYSTATION 5','Sony ya ha lanzado la consola de nueva generación PlayStation 5, y para celebrarlo, en GAME te traemos la nueva línea de merchandising oficial de PS5: ropa, tazas, botellas, monederos,... ¡Y mucho más!',14.99,15,'https://media.game.es/COVERV2/3D_L/186/186310.png','Gorra PS5','2024-05-12',4);
INSERT INTO product (product_name,product_description,product_pvp,product_stock_quantity,product_image,product_image_alternative_text,product_date,category_category_id) VALUES ('GORRA YODA THE CHILD THE MANDALORIAN STAR WARS','Gorra del personaje The Child de la increíble serie Mandalorian y viaja junto a Grogu, mientras haces parte de la legendaria franquicia Star Wars.',11.1,12,'https://media.game.es/COVERV2/3D_L/V1F/V1FB5J.png','Gorra Grogu','2024-01-26',4);
INSERT INTO product (product_name,product_description,product_pvp,product_stock_quantity,product_image,product_image_alternative_text,product_date,category_category_id) VALUES ('GORRA STAR WARS: DARTH VADER WITH METAL BADGE','La gorra Star Wars Darth Vader es el complemento ideal para los fans de Star Wars, te acompañará en todas tus aventuras vayas donde vayas.',14.95,19,'https://media.game.es/COVERV2/3D_L/174/174783.png','Gorra Vader','2024-02-21',4);
INSERT INTO product (product_name,product_description,product_pvp,product_stock_quantity,product_image,product_image_alternative_text,product_date,category_category_id) VALUES ('GORRA VENGADORES: QUANTUM','La gorra Vengadores Quantum es el complemento ideal para los fans de Vengadores, te acompañará en todas tus aventuras vayas donde vayas.',19.99,21,'https://media.game.es/COVERV2/3D_L/174/174790.png','Gorra Avengers','2024-04-11',4);
INSERT INTO product (product_name,product_description,product_pvp,product_stock_quantity,product_image,product_image_alternative_text,product_date,category_category_id) VALUES ('GORRA SPIDER-MAN: 3D SNAPBACK','La gorra Marvel Spiderman es el complemento ideal para los fans de Spiderman, te acompañará en todas tus aventuras vayas donde vayas.',14.99,17,'https://media.game.es/COVERV2/3D_L/174/174782.png','Gorra Spidey','2024-04-15',4);


INSERT INTO product (product_name,product_description,product_pvp,product_stock_quantity,product_image,product_image_alternative_text,product_date,category_category_id) VALUES ('GORRA GRYFFINDOR HARRY POTTER','Compra en GAME la nueva Gorra de Gryffindor de la increíble saga Harry Potter y lleva contigo la casa que tanto amas, ¡conviértete en el mejor mago o bruja de toda tu familia!',16.1,24,'https://media.game.es/COVERV2/3D_L/V1F/V1F8A2.png','Gorra Gryffindor','2024-03-11',4);
INSERT INTO product (product_name,product_description,product_pvp,product_stock_quantity,product_image,product_image_alternative_text,product_date,category_category_id) VALUES ('GORRA HARRY POTTER: SLYTHERIN','Demuestra tu amor por Slytherin con esta gorra tipo snapback, con unos detalles de lujo que complementarán perfectamente con tu outfit al más puro estilo Harry Potter.',9.99,11,'https://media.game.es/COVERV2/3D_L/189/189693.png','Gorra Slytherin','2024-03-11',4);
INSERT INTO product (product_name,product_description,product_pvp,product_stock_quantity,product_image,product_image_alternative_text,product_date,category_category_id) VALUES ('FIGURA POP ASSASSINS CREED EIVOR','Compra la figura funko Pop del protagonista vikingo del juego de acción y mundo abierto Assassins Creed Valhalla, Eivor.',15.99,22,'https://media.game.es/COVERV2/3D_L/207/207836.png','Funko Assassins','2024-05-09',5);
INSERT INTO product (product_name,product_description,product_pvp,product_stock_quantity,product_image,product_image_alternative_text,product_date,category_category_id) VALUES ('FIGURA POP FORTNITE: THE FOUNDATION','Compra la figura funko POP de The Foundation de el videojuego Fortnite, una unidad sintiente orgánica con un traje que lo ha mantenido vivo en realidadades infinitas y en la Nada, el líder de los Siete.',15.99,16,'https://media.game.es/COVERV2/3D_L/201/201588.png','Funko Fornite','2024-05-12',5);
INSERT INTO product (product_name,product_description,product_pvp,product_stock_quantity,product_image,product_image_alternative_text,product_date,category_category_id) VALUES ('FIGURA POP VINYL STAR WARS MANDALORIAN THE MANDALORIAN','Las nuevas figuras POP! de Star Wars: The Mandalorian ya están aquí. ',15.99,18,'https://media.game.es/COVERV2/3D_L/217/217923.png','Funko Mando','2024-05-12',5);
INSERT INTO product (product_name,product_description,product_pvp,product_stock_quantity,product_image,product_image_alternative_text,product_date,category_category_id) VALUES ('FIGURA POP STAR WARS AHSOKA: AHSOKA TANO','Compra la figura funko pop de Ahsoka, de la serie con su propio nombre que se emite en Disney+ de la expadawan Jedi y aprendiz de Anakin Skywalker.',15.99,25,'https://media.game.es/COVERV2/3D_L/215/215047.png','Funko Ahsoka','2024-04-30',5);
INSERT INTO product (product_name,product_description,product_pvp,product_stock_quantity,product_image,product_image_alternative_text,product_date,category_category_id) VALUES ('FIGURA POP MARVEL ANT MAN: ANT-MAN','Ant-Man y la Avispa: Quantumanía, es una nueva película de Marvel de superhéroes, en donde emprenderán una aventura explorando el Reino Cuántico que supera sus límites y los enfrenta a Kang el Conquistador.',15.99,27,'https://media.game.es/COVERV2/3D_L/212/212598.png','Funko Antman','2024-04-06',5);
INSERT INTO product (product_name,product_description,product_pvp,product_stock_quantity,product_image,product_image_alternative_text,product_date,category_category_id) VALUES ('FIGURA POP HARRY POTTER 20TH: HARRY','Compra la figura Pop de el mago más famoso de Hogwarts, Harry, en su edición 20 Aniversario.',15.99,34,'https://media.game.es/COVERV2/3D_L/205/205212.png','Funko Harry','2024-02-11',5);
INSERT INTO product (product_name,product_description,product_pvp,product_stock_quantity,product_image,product_image_alternative_text,product_date,category_category_id) VALUES ('FIGURA POP HARRY POTTER 20TH: HERMIONE', 'Compra la figura Pop de una de las mejores amigas y compañeras de la escuela Hogwarts y gran maga, Hermione, en su edición 20 Aniversario.', 15.99, 31, 'https://media.game.es/COVERV2/3D_L/205/205213.png', 'Funko Hermione', '2024-02-11', 5);
INSERT INTO product (product_name,product_description,product_pvp, product_stock_quantity,product_image,product_image_alternative_text,product_date,category_category_id) VALUES ('FIGURA POP MARVEL PORTADA: THE AMAZING SPIDER-MAN', 'Las nuevas figuras POP! de Marvel ya están aquí. Una cuidada selección de figuras que, como siempre, vienen avaladas por la calidad y el mimo que Funko pone en todos su productos oficiales.', 29.99, 20, 'https://media.game.es/COVERV2/3D_L/221/221396.png', 'Funko Spidey', '2024-04-15', 5);


