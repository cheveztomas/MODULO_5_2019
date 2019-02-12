CREATE DATABASE EJEMPLO

GO
USE EJEMPLO

GO

CREATE TABLE CLIENTES(
	ID_CLIENTE INT IDENTITY(1,1) CONSTRAINT PK_CLIENTES PRIMARY KEY NOT NULL,
	NOMBRE VARCHAR(30) NOT NULL,
	DIRECCION VARCHAR(80),
	TELEFONO VARCHAR(10)
)

CREATE TABLE PRODUCTOS(
	ID_PRODUCTO INT IDENTITY(1,1) CONSTRAINT PK_PRODUCTOS PRIMARY KEY NOT NULL,
	DESCRIPCION VARCHAR(30) NOT NULL,
	PRECIO DECIMAL(10,2) NOT NULL
)

CREATE TABLE FACTURA(
	NUM_FACTURA INT IDENTITY(1,1) CONSTRAINT PK_FACTURA PRIMARY KEY NOT NULL,
	ID_CLIENTE INT NOT NULL,
	FECHA DATE NULL,
	ESTADO VARCHAR(15)
)

CREATE TABLE DETALLE_FACTURA(
	NUM_FACTURA INT NOT NULL,
	ID_PRODUCTO INT NOT NULL,
	CANTIDAD INT NOT NULL,
	PRECIO_VENTA DECIMAL(10,2)
)

--ESPECIFICACIONES DE LOS DATOS
--****************************************************************************

ALTER TABLE PRODUCTOS
	ADD CONSTRAINT CHK_PRECIO_PRODUCTOS
		CHECK (PRECIO>0)

ALTER TABLE FACTURA
	ADD CONSTRAINT DF_FECHA_FACTURA
		DEFAULT GETDATE() FOR FECHA

ALTER TABLE FACTURA
	ADD CONSTRAINT CHK_ESTADO_FACTURA
		CHECK(ESTADO IN ('PENDIENTE','CANCELADA','ANULADA'))

ALTER TABLE FACTURA
	ADD CONSTRAINT DF_ESTADO_FACTURA
		DEFAULT 'PENDIENTE' FOR ESTADO

ALTER TABLE DETALLE_FACTURA
	ADD CONSTRAINT CHK_CANTIDAD_DETALLE_FACTURA
		CHECK(CANTIDAD>0)

ALTER TABLE DETALLE_FACTURA
	ADD CONSTRAINT CHK_PRECIO_VENTA_DETALLE_FACTURA
		CHECK(PRECIO_VENTA>=0)

ALTER TABLE DETALLE_FACTURA
	ADD CONSTRAINT DF_DETALLE_FACTURA
		DEFAULT 0 FOR PRECIO_VENTA

ALTER TABLE FACTURA
	ADD CONSTRAINT FK1_ID_CLIENTE_FACTURA
		FOREIGN KEY (ID_CLIENTE) REFERENCES CLIENTES(ID_CLIENTE)

ALTER TABLE DETALLE_FACTURA
	ADD CONSTRAINT FK1_NUM_FACTURA_DETALLE_FACTURA
		FOREIGN KEY(NUM_FACTURA) REFERENCES FACTURA(NUM_FACTURA)

ALTER TABLE DETALLE_FACTURA
	ADD CONSTRAINT FK2_ID_PRODUCTO_DETALLE_FACTURA
		FOREIGN KEY (ID_PRODUCTO) REFERENCES PRODUCTOS(ID_PRODUCTO)

ALTER TABLE DETALLE_FACTURA
	ADD CONSTRAINT PKC_ID_DETALLE_FACTURA
		PRIMARY KEY CLUSTERED (NUM_FACTURA, ID_PRODUCTO)
GO

--PROCEDIMEINTOS ALMACENADOS
--***************************************************************************
--3)

--a
CREATE PROCEDURE SP_ELIMINAR_CLIENTES(@ID_Cliente int,
									  @msj varchar(150) OUT)
AS
	BEGIN TRY
	--Se verifica si hay algún cliente con facturas.
		IF (EXISTS(SELECT 1 FROM FACTURA WHERE ID_CLIENTE=@ID_Cliente))
			BEGIN
				SET @msj='Cliente no se puede eliminar ya que cuenta con facturas asigandas.'
			END
		ELSE
			BEGIN
			--En caso de que el cliente no tenga facturas se elimina el cliente
				DELETE CLIENTES WHERE ID_CLIENTE=@ID_Cliente
				SET @msj='Cliente eliminado de forma satisfactoria.'
			END
	END TRY
	BEGIN CATCH
		SET @msj='Error al tratar de eliminar cliente.'
		RAISERROR('Error al tratar de eliminar cliente.',16,1)
	END CATCH
GO

/*USE [EJEMPLO]
GO

DECLARE @RC int
DECLARE @ID_Cliente int='1'
DECLARE @msj varchar(150)=''

-- TODO: Set parameter values here.

EXECUTE @RC = [dbo].[SP_ELIMINAR_CLIENTES] 
   @ID_Cliente
  ,@msj OUTPUT
GO

*/

--b)
CREATE PROCEDURE SP_GUARDAR_ACTUALIZAR_CLIENTE(@id_cliente int out,
									@nombre varchar(30),
									@direccion varchar(80),
									@telefono varchar(10),
									@msj varchar(150) out)
AS
	BEGIN TRY
	--Se verifica si el cliente existe.
		IF(NOT EXISTS(SELECT 1 FROM CLIENTES WHERE ID_CLIENTE=@id_cliente))
			BEGIN
			--Si el cliente no existe se inserta uno nuevo.
				INSERT INTO CLIENTES(NOMBRE, DIRECCION, TELEFONO)
				VALUES(@nombre,@direccion,@telefono)

				SET @msj='Cliente insertado de forma satisfactoria.'
			END
		ELSE
			BEGIN
			--En caso de que si exista se actualiza el existente con los datos.
				UPDATE CLIENTES
				SET NOMBRE=@nombre,
					DIRECCION=@direccion,
					TELEFONO=@telefono
				WHERE ID_CLIENTE=@id_cliente
				SET @msj='Cliente a sido actualizado de forma correcta.'
			END
	END TRY
	BEGIN CATCH
		SET @msj='Error al agregar o actualizar el cliente.'
		RAISERROR('Error al tratar de incertar o actualizar el cliente.',16,2)
	END CATCH
GO

/*USE [EJEMPLO]
GO

DECLARE @RC int
DECLARE @id_cliente int='-1'
DECLARE @nombre varchar(30)='TOMAS'
DECLARE @direccion varchar(80)='PALMARES'
DECLARE @telefono varchar(10)='89677620'
DECLARE @msj varchar(150)=''

-- TODO: Set parameter values here.

EXECUTE @RC = [dbo].[SP_GUARDAR_ACTUALIZAR_CLIENTE] 
   @id_cliente OUTPUT
  ,@nombre
  ,@direccion
  ,@telefono
  ,@msj OUTPUT
GO

SELECT * FROM CLIENTES*/

--c)
CREATE PROCEDURE SP_BUSCAR_CLIENTE(@id_cliente int)
AS
	BEGIN TRY
	--Se hace la consulta que busca al cliente con el id indicado.
		SELECT ID_CLIENTE, NOMBRE, DIRECCION, TELEFONO FROM CLIENTES WHERE ID_CLIENTE=@id_cliente
	END TRY
	BEGIN CATCH
		RAISERROR('Error al tratar de buscar el cliente.',16,3)
	END CATCH
GO

/*
USE [EJEMPLO]
GO

DECLARE @RC int
DECLARE @id_cliente int=1

-- TODO: Set parameter values here.

EXECUTE @RC = [dbo].[SP_BUSCAR_CLIENTE] 
   @id_cliente
GO
*/

--4)

--A)
CREATE PROCEDURE SP_ELIMINAR_PRODUCTO(@id_producto int,
									  @msj varchar(150) out)
AS
	BEGIN TRY
	--Se verifica si existe algún producto relacionado con los detalles de factura.
		IF(NOT EXISTS(SELECT 1 FROM DETALLE_FACTURA WHERE ID_PRODUCTO=@id_producto))
			BEGIN
			--Si no existe la relación con los detalles de factura se elimina el regostro de productos
				DELETE PRODUCTOS WHERE ID_PRODUCTO=@id_producto
				SET @msj='Producto eliminado de forma correcta.'
			END
		ELSE
			BEGIN
			--En caso de que exista la relación se le informa al usuario que no se puede borrar ese registro.
				SET @msj='No se puede eliminar este producto.'
			END
	END TRY
	BEGIN CATCH
		SET @msj='Error al eliminar el producto.'
		RAISERROR('Error al eliminar el producto.',16,4)
	END CATCH
GO
/*USE [EJEMPLO]
GO

DECLARE @RC int
DECLARE @id_producto int='1'
DECLARE @msj varchar(150)=''

-- TODO: Set parameter values here.

EXECUTE @RC = [dbo].[SP_ELIMINAR_PRODUCTO] 
   @id_producto
  ,@msj OUTPUT
GO
*/

--B)
CREATE PROCEDURE SP_GUARDAR_ACTUALIZAR_PRODUCTO(@id_producto int out,
												@descripcion varchar(30),
												@precio decimal(10,2),
												@msj varchar(150) out)
AS
	BEGIN TRY
	--Se verifica si el registro ya existe.
		IF(NOT EXISTS(SELECT 1 FROM PRODUCTOS WHERE ID_PRODUCTO=@id_producto))
			BEGIN
			--En caso de que no exista se inserta un nuevo pruducto
				INSERT INTO PRODUCTOS(DESCRIPCION,PRECIO)
				VALUES(@descripcion,@precio)
				SET @msj='Producto guardado de forma correcta.'
			END
		ELSE
			BEGIN
			--En caso de que si exista se actualiza el producto.
				UPDATE PRODUCTOS
				SET DESCRIPCION=@descripcion,
					PRECIO=@precio
				WHERE ID_PRODUCTO=@id_producto
				SET @msj='Producto actualizado de forma correcta.'
			END
	END TRY
	BEGIN CATCH
		SET @msj='Error al tratar de insertar o actualizar el producto.'
		RAISERROR('Error al tratar de insertar o actualizar el producto.',16,5)
	END CATCH
GO

/*USE [EJEMPLO]
GO

DECLARE @RC int
DECLARE @id_producto int='2'
DECLARE @descripcion varchar(30)='Leche'
DECLARE @precio decimal(10,2)='600'
DECLARE @msj varchar(150)=''

-- TODO: Set parameter values here.

EXECUTE @RC = [dbo].[SP_GUARDAR_ACTUALIZAR_PRODUCTO] 
   @id_producto OUTPUT
  ,@descripcion
  ,@precio
  ,@msj OUTPUT
GO

select * from productos
*/

--5)

--A)
CREATE PROCEDURE SP_ANULAR_FACTURA(@num_factura int,
								   @msj varchar(150) out)
AS
	BEGIN TRY
	--Se verifica si la factura está cancelada.
		IF(EXISTS(SELECT 1 FROM FACTURA WHERE NUM_FACTURA=@num_factura AND ESTADO='CANCELADA'))
			BEGIN
			--En caso de que la factura esté cancelada se anula la factura.
				UPDATE FACTURA
				SET	ESTADO='ANULADA'
				WHERE NUM_FACTURA=@num_factura
				SET @msj='Factura anulada de forma correcta.'
			END
	END TRY
	BEGIN CATCH
		SET @msj='Error al tratar de anular la factura.'
		RAISERROR('Error al trartar de anular la factura.',16,6)
	END CATCH
GO

/*USE [EJEMPLO]
GO

DECLARE @RC int
DECLARE @num_factura int=1
DECLARE @msj varchar(150)=''

-- TODO: Set parameter values here.

EXECUTE @RC = [dbo].[SP_ANULAR_FACTURA] 
   @num_factura
  ,@msj OUTPUT
GO
*/

--B)
CREATE PROCEDURE SP_ELIMINAR_FACTURA(@num_factura int,
									 @msj varchar(150)out)
AS
	BEGIN TRY
	--Se verifica si la factura se encuentra en estado pendiente
		IF(EXISTS(SELECT 1 FROM FACTURA WHERE NUM_FACTURA=@num_factura AND ESTADO='PENDIENTE'))
			BEGIN
			--De ser pendiente se elimina la factura primero eliminando la tabla hija y despues la tabla padre.
				DELETE DETALLE_FACTURA WHERE NUM_FACTURA=@num_factura
				DELETE FACTURA WHERE NUM_FACTURA=@num_factura
				SET @msj='Factura eliminada de forma correcta.'
			END
		ELSE
			BEGIN
				IF(EXISTS(SELECT 1 FROM FACTURA WHERE NUM_FACTURA=@num_factura AND ESTADO='CANCELADA'))
					BEGIN
						--En caso contrario que la facturá se enceuntra en estado cancelado se invoca el metodo de anular facturar.
							DECLARE @RC int
							EXECUTE @RC = [dbo].[SP_ANULAR_FACTURA] 
							@num_factura,@msj OUTPUT
					END
			END
	END TRY
	BEGIN CATCH
		SET @msj='Error al eliminar la factura.'
		RAISERROR('Error al tratar de eliminar la factura.',16,7)
	END CATCH
GO
/*USE [EJEMPLO]
GO

DECLARE @RC int
DECLARE @num_factura int='5'
DECLARE @msj varchar(150)=''

-- TODO: Set parameter values here.

EXECUTE @RC = [dbo].[SP_ELIMINAR_FACTURA] 
   @num_factura
  ,@msj OUTPUT
GO
*/

--C)
CREATE PROCEDURE SP_GUARDAR_ACTUALIZAR_FACTURA(@num_factura int,
											   @id_cliente int,
											   @fecha date,
											   @estado varchar(15),
											   @msj varchar(100))
AS
	BEGIN TRY
	--Se verifica si existe ya un registro con el numero de factura.
		IF(NOT EXISTS(SELECT 1 FROM FACTURA WHERE NUM_FACTURA=@num_factura))
			BEGIN
			--Si no se encuentra el registro se inserta.
				INSERT INTO FACTURA(ID_CLIENTE,FECHA,ESTADO)
				VALUES(@id_cliente,@fecha,@estado)
				SET @msj='Factura agregada de forma correcta.'
			END
		ELSE
			IF(EXISTS(SELECT 1 FROM FACTURA WHERE NUM_FACTURA=@num_factura AND ESTADO='PENDIENTE'))
				BEGIN
				--En caso contrario se actualiza el registro.
					UPDATE FACTURA
					SET ID_CLIENTE=@id_cliente,
						FECHA=@fecha,
						ESTADO=@estado
					WHERE NUM_FACTURA=@num_factura
					SET @msj='Factura actualizada de forma correcta.'
				END
				ELSE
					BEGIN
						SET @msj='La factura no se puede actualizar ya que no se encuentra en estado pendiente.'
					END
	END TRY
	BEGIN CATCH
		SET @msj='Error al tratar de insertar o actualizar la factura.'
		RAISERROR('Error al tratar de insertar o actualizar la factura.',16,8)
	END CATCH
GO

/*USE [EJEMPLO]
GO

DECLARE @RC int
DECLARE @num_factura int='-1'
DECLARE @id_cliente int='1'
DECLARE @fecha date=NULL
DECLARE @estado varchar(15)='CANCELADA'
DECLARE @msj varchar(100)=''

-- TODO: Set parameter values here.

EXECUTE @RC = [dbo].[SP_GUARDAR_ACTUALIZAR_FACTURA] 
   @num_factura
  ,@id_cliente
  ,@fecha
  ,@estado
  ,@msj
GO
SELECT * FROM FACTURA
*/
--INSERT INTO FACTURA(ID_CLIENTE)
--VALUES (1)

--6)

--A)
CREATE PROCEDURE SP_ELIMINAR_DETALLE_FACTURA(@num_factura int,
											 @id_producto int,
											 @msj varchar(100) out)
AS
	