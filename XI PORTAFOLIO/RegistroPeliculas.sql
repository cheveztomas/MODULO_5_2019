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

ALTER TABLE PELICULAS
	ADD CONSTRAINT DF_DURACION
	DEFAULT(2)
	FOR DURACION

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
AS
BEGIN TRY
--SE VERIFICA SI EXISTE YA UN REGISTRO CON EL C�DIGO INSERTADO.
	IF(EXISTS(SELECT 1 FROM PELICULAS WHERE ID_PELICULA=@id_pelicula))
		BEGIN
		--EN CASO DE QUE SI EXISTA SE ACTUALIZA
			UPDATE PELICULAS
				SET TITULO=@titulo,
					FECHA_ESTRENO=@fecha_estreno,
					DURACION=@duracion
				WHERE ID_PELICULA=@id_pelicula

			SET @msj='Pelicula actualizada.'
		END
	ELSE
		BEGIN
		--EN CASO CONTRARIO SE INSERTA.
			INSERT INTO PELICULAS(TITULO,FECHA_ESTRENO,DURACION)
			VALUES (@titulo,@fecha_estreno,@duracion)

			SELECT @id_pelicula=IDENT_CURRENT('PELICULAS')

			SET @msj='Pelicula ingresada de forma correcta.'
		END
END TRY
BEGIN CATCH
	RAISERROR('Error al tratar de guardar la pelicula.',16,1)
END CATCH

GO
CREATE PROCEDURE SP_ELIMINAR_PELICULA(@id_pelicula int,
									  @msj varchar(150) out)
AS
BEGIN TRY
	IF(EXISTS(SELECT 1 FROM PELICULAS WHERE ID_PELICULA=@id_pelicula))
		BEGIN
			DELETE PELICULAS WHERE ID_PELICULA=@id_pelicula
			SET @msj='Pelicula eliminada de forma corresta.'
		END
	ELSE
		BEGIN
			SET @msj='Pelicula no se puede eliminar ya que'
		END
END TRY
BEGIN CATCH
	RAISERROR('Error al tartar de eliminar la pelicula.',16,2)
END CATCH

GO
CREATE PROCEDURE SP_GUARDAR_DIRECTORES(@id_director int out,
									   @nombre varchar(50),
									   @msj varchar(150) out)
AS
BEGIN TRY
	IF(NOT EXISTS(SELECT 1 FROM DIRECTORES WHERE ID_DIRECTOR=@id_director))
		BEGIN
			INSERT INTO DIRECTORES(NOMBRE)
			VALUES(@nombre)

			SELECT @id_director=IDENT_CURRENT('DIRECTORES')
			SET @msj='Director agregado.'
		END
	ELSE
		BEGIN
			UPDATE DIRECTORES
			SET	NOMBRE=@nombre
			WHERE ID_DIRECTOR=@id_director

			SET @msj='Director actualizado.'
		END
END TRY
BEGIN CATCH
	RAISERROR('Error al tratar de eliminar el director.',16,3)
END CATCH

GO
CREATE PROCEDURE SP_ELIMINAR_DIRECTOR(@id_director int,
									  @msj varchar(150) out)
AS
BEGIN TRY
	IF(EXISTS(SELECT 1 FROM DIRECTORES WHERE ID_DIRECTOR=@id_director))
		BEGIN
			DELETE DIRECTORES WHERE ID_DIRECTOR=@id_director
			SET @msj='Director eliminado de forma correcta.'
		END
	ELSE
		BEGIN
			SET @msj='No se puede eliminar director ya que no se encontr� el registro.'
		END
END TRY
BEGIN CATCH
	RAISERROR('Error al tratar de eliminar el director.',16,4)
END CATCH

GO
CREATE PROCEDURE SP_ASIGNAR_DIRECTOR_PELICULA(@id_pelicula int,
											  @id_director int,
											  @msj varchar(150) out)
AS
BEGIN TRY
	IF(NOT EXISTS(SELECT 1 FROM PELICULAS_DIRECTORES WHERE ID_DIRECTOR=@id_director AND ID_PELICULA=@id_pelicula))
		 BEGIN
			INSERT INTO PELICULAS_DIRECTORES(ID_PELICULA,ID_DIRECTOR)
			VALUES(@id_pelicula,@id_director)

			SET @msj='Pel�cula asignada de forma correcta.'
		 END
	ELSE
		BEGIN
			SET @msj='Ya se encuentra la relaci�n.'
		END
END TRY
BEGIN CATCH
	RAISERROR('Error al tratar de asignar un director a la pel�cula.',16,5)
END CATCH

GO
CREATE PROCEDURE SP_ELIMINAR_ASIGNACION_DE_PELICULA(@id_pelicula int,
													@id_director int,
													@msj varchar(150) out)
AS
BEGIN TRY
	IF(EXISTS(SELECT 1 FROM PELICULAS_DIRECTORES WHERE ID_DIRECTOR=@id_director AND ID_PELICULA=@id_pelicula))
		BEGIN
			DELETE PELICULAS_DIRECTORES WHERE ID_DIRECTOR=@id_director AND ID_PELICULA=@id_pelicula
			SET @msj='Se elimin� el director de la pel�cula de forma correcta.'
		END
	ELSE
		BEGIN
			SET @msj='No se encuentra el director o la pel�cula seleccionada.'
		END
END TRY
BEGIN CATCH
		RAISERROR('No se pudo eliminar el director de la pel�cula.',16,6)
END CATCH