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

GO

--PROCEDIMEINTOS ALMACENADOS
--***************************************************************************

