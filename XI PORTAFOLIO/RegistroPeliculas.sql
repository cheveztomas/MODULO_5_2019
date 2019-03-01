CREATE DATABASE REGISTRO_PELICULAS
GO

USE REGISTRO_PELICULAS
GO

CREATE TABLE PELICULAS(
	ID_PELICULA INT IDENTITY(1,1) CONSTRAINT PK_PELICULAS PRIMARY KEY,
	TITULO VARCHAR(50) NOT NULL,
	FECHA_ESTRENO DATE NOT NULL,
	DURACION INT NOT NULL
)

CREATE TABLE DIRECTORES(
	ID_DIRECTOR INT IDENTITY(1,1) CONSTRAINT PK_FIRECTORES PRIMARY KEY,
	NOMBRE VARCHAR(50) NOT NULL
)

CREATE TABLE PELICULAS_DIRECTORES(
	ID_PELICULA INT NOT NULL,
	ID_DIRECTOR INT NOT NULL
)

--TABLA PELICULAS
ALTER TABLE PELICULAS
	 ADD CONSTRAINT DF_FECHA_ESTRENO
	 DEFAULT(GETDATE())
	 FOR FECHA_ESTRENO

--TABLA PELICULAS DIRECTORES
ALTER TABLE PELICULAS_DIRECTORES
	ADD CONSTRAINT PK_PELICULAS_DIRECTORES
	PRIMARY KEY CLUSTERED(ID_PELICULA,ID_DIRECTOR)

ALTER TABLE PELICULAS_DIRECTORES
	ADD CONSTRAINT FK1_PELICULAS_DIRECTORES
	FOREIGN KEY(ID_PELICULA) REFERENCES PELICULAS(ID_PELICULA)

ALTER TABLE PELICULAS_DIRECTORES
	ADD CONSTRAINT FK2_PELICULAS_DIRECTORES
	FOREIGN KEY (ID_DIRECTOR) REFERENCES DIRECTORES(ID_DIRECTOR) ON DELETE CASCADE

INSERT INTO PELICULAS(TITULO,FECHA_ESTRENO,DURACION)
VALUES('LOS VENGADORES','20190506','2')

INSERT INTO PELICULAS(TITULO,FECHA_ESTRENO,DURACION)
VALUES('BATMAN','20191224','3')

INSERT INTO PELICULAS(TITULO,FECHA_ESTRENO,DURACION)
VALUES('SUPER MAN','20190605','1')

INSERT INTO DIRECTORES(NOMBRE)
VALUES('JUAN CARLOS')

INSERT INTO DIRECTORES(NOMBRE)
VALUES('ROMARIO')

INSERT INTO DIRECTORES(NOMBRE)
VALUES('JUAN JOS�')

INSERT INTO PELICULAS_DIRECTORES(ID_DIRECTOR,ID_PELICULA)
VALUES(1,2)

INSERT INTO PELICULAS_DIRECTORES(ID_DIRECTOR,ID_PELICULA)
VALUES(2,3)

INSERT INTO PELICULAS_DIRECTORES(ID_DIRECTOR,ID_PELICULA)
VALUES(3,1)

--PROCEDIMIENTOS ALMACENADOS
GO
CREATE PROCEDURE SP_GUARDAR_PELICULAS(@id_pelicula int out,
									  @titulo varchar(50),
									  @fecha_estreno date,
									  @duracion int,
									  @msj varchar(150) out)
BEGIN TRY
	
END TRY
BEGIN CATCH
	RAISERROR('Error al tratar de guardar la pelicula.',16,1)
END CATCH