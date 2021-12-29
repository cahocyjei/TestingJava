CREATE TABLE if NOT EXISTS movie(
id INT AUTO_INCREMENT PRIMARY KEY,
titulo VARCHAR(50) NOT NULL,
pais VARCHAR(30) NOT NULL,
fecha VARCHAR(10) NOT NULL,
genre VARCHAR(10) NOT NULL,
duracion DOUBLE NOT NULL,
capitulo INT NOT NULL);

INSERT INTO movie(titulo,pais,fecha,genre,duracion,capitulo)
VALUES('Cenicienta','Colombia','1980','DRAMA',154,10),
       ('Guerreros','Argentina','1970','ACTION',134,15),
       ('El Capo','España','2018','ACTION',180,30),
       ('Obsesion','Italia','2001','COMEDIA',220,25);