----Tablas

create table Cliente(
	rut varchar(20) primary key,
    nombre varchar2(100) not null,
    correo varchar2(100) not null,
    sexo varchar2(50)not null,
    direccion varchar(100) not null,
    telefono varchar(20) not null,
    fecha_nacimiento date not null,
    contraseña varchar(150)not null,
    habilitado number(2)not null);               

create  table Insumo (
  id_insumo number(11) primary key ,
  descripcion varchar(100)  NOT NULL,
  cantidad_actual number(11) NOT NULL,
  cantidad_critica number(11) NOT NULL,
  cantidad_maxima number(11) NOT NULL);

create table Servicio (
  id_servicio number(11) primary key,
  nombre varchar(50)  NOT NULL,
  descripcion varchar(200)  NOT NULL,
  precio number(11) NOT NULL,
  habilitado number(1) NOT NULL);

create  table Trabajador (
  rut varchar(20)  primary key,
  nombre varchar2(50)  NOT NULL,
  fecha_nacimiento date NOT NULL,
  sexo varchar2(50)  NOT NULL,
  correo varchar2(50),
  direccion varchar2(100)  NOT NULL,
  telefono varchar2(20)  NOT NULL,
  contraseña varchar(100)  NOT NULL,
  tipo varchar2(20)  NOT NULL,
  especialidad varchar(50), 
  habilitado number(1) NOT NULL);

create table Consulta (
  id_consulta number(11) primary key ,
  id_servicio number(11) NOT NULL,
  fecha date NOT NULL,
  rut_cliente varchar(20)  NOT NULL,
  rut_trabajador varchar(20)  NOT NULL,
  estado varchar(10)  NOT NULL,
  total number(11) NOT NULL,
  hora number(11),
  minuto number(11),
	Constraint Consulta_Servicio_fk foreign key (id_servicio) references Servicio (id_servicio),
	CONSTRAINT Consulta_Cliente_fk FOREIGN KEY(rut_cliente)	REFERENCES Cliente(rut),
	constraint Consulta_Trabajador_fk foreign key(rut_trabajador) references Trabajador(rut));

create table Detalle_insumo (
  codigo varchar2(50)  primary key,
  id_insumo number(11) NOT NULL,
  cantidad_actual number(11) NOT NULL,
  fecha_vencimiento date ,  
  precio_compra_unidad number(11) NOT NULL,
  fecha_llegada date,  
	constraint Detalle_insumo_Insumo_fk foreign key(id_insumo) references Insumo(id_insumo));

create table Detalle_Insumo_Servicio (
  id_servicio number(11) NOT NULL,
  id_insumo number(11) NOT NULL,
  cantidad_insumo number(11) NOT NULL,
	constraint Detalle_IS_Servicio_fk foreign key(id_servicio) references Servicio(id_servicio));


create table Proveedor (
  rut varchar(20)  primary key,
  nombre varchar2(50)  NOT NULL,
  nombre_contacto varchar2(50)  NOT NULL,
  telefono_contacto varchar(20)  NOT NULL,
  correo_contacto varchar2(50)  NOT NULL,
  id_insumo number(11) NOT NULL,
  habilitado number(1) NOT NULL,
	constraint Proveedor_Insumo_fk foreign key(id_insumo) references Insumo(id_insumo));

create table Ficha_Social (
  rut_cliente varchar(20)  NOT NULL,
  liquidacion1 blob not null,
  liquidacion2 blob,
  liquidacion3 blob,
  certificado_AFP blob not null,
  finiquito blob not null,
	constraint Ficha_Social_Cliente_fk foreign key(rut_cliente) references Cliente(rut));


create table Pedido (
  id_pedido number(11) primary key ,
  fecha_pedido date NOT NULL,
  fecha_entrega date NOT NULL,
  valor_total number(11) NOT NULL,
  estado varchar(15)  NOT NULL,
  rut_trabajador varchar(20)  NOT NULL,
  rut_proveedor varchar(20)  NOT NULL,
  comentario varchar2(100)  NOT NULL,
   constraint Pedido_Trabajador_fk foreign key(rut_trabajador) references Trabajador(rut),
   constraint Pedido_Proveedor_fk foreign key(rut_proveedor) references Proveedor(rut));

create table Detalle_Pedido (
  id_pedido number(11) NOT NULL,
  id_insumo number(11) NOT NULL,
  cantidad number(11) NOT NULL,
  precio_unidad number(11) NOT NULL,
  fecha_vencimiento date,
	constraint Detalle_Pedido_Pedido_fk foreign key(id_pedido) references Pedido(id_pedido));
    

--------
---triggers
--------
CREATE SEQUENCE insumo_seq START WITH 1 increment by 1;
CREATE SEQUENCE servicio_seq START WITH 1 increment by 1;
CREATE SEQUENCE consulta_seq START WITH 1 increment by 1;
CREATE SEQUENCE pedido_seq START WITH 1 increment by 1  ;

CREATE TRIGGER insumo_tri
BEFORE INSERT ON Insumo
FOR EACH ROW
BEGIN
  SELECT insumo_seq.NEXTVAL
  INTO   :new.id_insumo
  FROM   dual;
END;

CREATE OR REPLACE TRIGGER servicio_tri
BEFORE INSERT ON Servicio
FOR EACH ROW
BEGIN
  SELECT servicio_seq.NEXTVAL
  INTO   :new.id_servicio
  FROM   dual;
END;

CREATE OR REPLACE TRIGGER consulta_tri
BEFORE INSERT ON Consulta
FOR EACH ROW
BEGIN
  SELECT consulta_seq.NEXTVAL
  INTO   :new.id_consulta
  FROM   dual;
END;

CREATE OR REPLACE TRIGGER pedido_tri
BEFORE INSERT ON Pedido
FOR EACH ROW
BEGIN
  SELECT pedido_seq.NEXTVAL
  INTO   :new.id_pedido
  FROM   dual;
END;




---Datos

insert into Cliente values ('18.876.827-3', 'Josefa Mandela Perez', 'Josefa@protonmail.com','F', 'Las camelia N027 Rancagua', '986763527', '11/06/1990', 'f572708c936a05f26f7ecf358922a610', 1);
insert into Cliente values ('19.017.683-5', 'Andres Chacon Barrueco', 'andres.ch@protonmail.com','M', 'Santa Julia N180 Mostazal', '981865628', '06/06/1990', '06a04e8a6d0c8b4fe3ceb77245cf1f83',1);
insert into Cliente values ('19.850.084-4', 'Luisa Ricotto Laraquete', 'luisa@gmail.com','F', 'Los casiques  N080 Iquique', '966266366', '11/09/1990', 'cfd0ab413ea2fc0e21c719f5ff914636',1);

INSERT INTO Insumo (descripcion,cantidad_actual,cantidad_critica, cantidad_maxima) VALUES ( 'Anestesia Lidocaina', 100, 60, 200);
INSERT INTO Insumo (descripcion,cantidad_actual,cantidad_critica, cantidad_maxima) VALUES ( 'Lijas de amalgama', 73, 30, 100);
INSERT INTO Insumo (descripcion,cantidad_actual,cantidad_critica, cantidad_maxima) VALUES ( 'Guantes de latex', 203, 90, 300);
INSERT INTO Insumo (descripcion,cantidad_actual,cantidad_critica, cantidad_maxima) VALUES ( 'Arcos Inferiores 0.002mm', 100, 60, 200);
INSERT INTO Insumo (descripcion,cantidad_actual,cantidad_critica, cantidad_maxima) VALUES ( 'Barniz Fluorado', 37, 15, 50);
INSERT INTO Insumo (descripcion,cantidad_actual,cantidad_critica, cantidad_maxima) VALUES ( 'Jeringa 5ml', 68, 60, 200);
INSERT INTO Insumo (descripcion,cantidad_actual,cantidad_critica, cantidad_maxima) VALUES ( 'Arcos Superiores 0.002mm', 15, 7, 25);

INSERT INTO Servicio (nombre,descripcion,precio,habilitado) VALUES ('Ortodoncia', 'La ortodoncia es la ciencia que se encarga del estudio, prevencionn, diagnostico y tratamiento de  las anomalias de forma, posicion, relacion y funcion de las estructuras dentomaxilofaciales.', 15000, 1);
INSERT INTO Servicio (nombre,descripcion,precio,habilitado) VALUES ('Endodoncia', 'La endodoncia es aquella parte de la odontologia que se ocupa de la etiologia, prevencion,   patologia, diagnostico y tratamiento de las enfermedades de la pulpa dental.', 25000, 1);
INSERT INTO Servicio (nombre,descripcion,precio,habilitado) VALUES ('Odontologia General', 'Odontologia o Estomatologia es una rama de las ciencias de la salud que se encarga del diagnostico, tratamiento y prevencion de las enfermedades del aparato estomatognitico', 10000, 1);
INSERT INTO Servicio (nombre,descripcion,precio,habilitado) VALUES ('Odontopediatria', 'Es el odontólogo especializado en la prevención y realización de procedimientos dentales, generalmente, en niños de hasta 14 años de edad', 15000, 1);
INSERT INTO Servicio (nombre,descripcion,precio,habilitado) VALUES ('Implantologia', 'Especialista a cargo de reponer piezas dentales perdidas o que están por pasar a ese estado', 25000, 1);

INSERT INTO Trabajador VALUES ('11.756.660-9', 'Roberto Gonzales Feliciano', '19/02/1987', 'M', 'Roberto.GF@hotmail.com', 'Independencia N1167, Santiago', '9 828273546', '66df9ccc4f5eda4b4fff1a68e3f3dbcd', 'Dentista', 'Odontologia General', 1);
INSERT INTO Trabajador VALUES ('13.831.883-4', 'Diana Rodriguez Papala', '01/01/1998', 'F', 'DianaR@outlook.com', 'Av. Perez N872, Buin', '9 82937452', '38693b6fab3e37d602488565b8e28736', 'Secretaria', 'null', 1);
INSERT INTO Trabajador VALUES('16.014.886-1', 'Luis Fernandez Hurtado', '10/11/1985', 'M', 'LuisFer@outlook.com', 'Las hermanas N333, Paine', '9 63527163', '65f86f5d73caeb793c777836dfa01c7b', 'Administrativo', 'null', 1);
INSERT INTO Trabajador VALUES('17.031.885-4', 'Pedro Molina Soto', '10/11/1981', 'M', 'PedroM@outlook.com', 'Las hermanas N333, Paine', '9 63527163', '65f86f5d73caeb793c777836dfa01c7b', 'Dentista', 'Ortodoncia', 1);
INSERT INTO Trabajador VALUES('16.014.886-1', 'Cecilia Ortiz Mena', '15/04/1981', 'F', 'CeciliaO@outlook.com', 'Las hermanas N333, Paine', '9 6518921', '65f86f5d73caeb793c777836dfa01c7b', 'Dentista', 'Implantologia', 1);
INSERT INTO Trabajador VALUES('17.885.123-K', 'Valeria Molina Aviles', '17/05/1987', 'F', 'ValeriaM@outlook.com', 'Las primas N123, Paine', '9 63527163', '65f86f5d73caeb793c777836dfa01c7b', 'Dentista', 'Endodoncia', 1);
INSERT INTO Trabajador VALUES('15.675.243-8', 'Camila huentecura Solis', '19/04/1985', 'F', 'CamilaH@outlook.com', 'Los hermanos 456, Paine', '9 6518921', '65f86f5d73caeb793c777836dfa01c7b', 'Dentista', 'Odontopediatria', 1);



INSERT INTO Consulta (id_servicio,fecha,rut_cliente,rut_trabajador,estado,total) VALUES( 1, '11/05/2017', '18.876.827-3', '11.756.660-9', 'Realizada', 15000);
INSERT INTO Consulta (id_servicio,fecha,rut_cliente,rut_trabajador,estado,total) VALUES( 2, '19/11/2017', '19.017.683-5', '11.756.660-9', 'Realizada', 25000);
INSERT INTO Consulta (id_servicio,fecha,rut_cliente,rut_trabajador,estado,total) VALUES( 1, '11/05/2017', '18.876.827-3', '11.756.660-9', 'Realizada', 15000);
INSERT INTO Consulta (id_servicio,fecha,rut_cliente,rut_trabajador,estado,total) VALUES( 2, '19/11/2017', '19.017.683-5', '11.756.660-9', 'Realizada', 25000);
INSERT INTO Consulta (id_servicio,fecha,rut_cliente,rut_trabajador,estado,total) VALUES( 3, '19/09/2018', '19.017.683-5', '11.756.660-9', 'Pendiente', 15000);
INSERT INTO Consulta (id_servicio,fecha,rut_cliente,rut_trabajador,estado,total) VALUES( 1, '28/03/2018', '19.017.683-5', '11.756.660-9', 'Cancelada', 25000);

INSERT INTO Detalle_insumo VALUES ('a1',1,50,'01/10/2020',300,'10/12/2017');
INSERT INTO Detalle_insumo VALUES ('a2', 1, 50, '01/10/2021', 300,'15/01/2018');
INSERT INTO Detalle_insumo VALUES ('a3', 2, 73, NULL, 500,'10/10/2017');
INSERT INTO Detalle_insumo VALUES ('a4', 3, 53, NULL, 550,'16/11/2017');
INSERT INTO Detalle_insumo VALUES ('a5', 3, 150, NULL, 550,'03/03/2018');
INSERT INTO Detalle_insumo VALUES ('a6', 3, 0, NULL, 550,'16/01/2016');
INSERT INTO Detalle_insumo VALUES ('a7', 4, 30, '05/10/2022', 700, '16/10/2017');
INSERT INTO Detalle_insumo VALUES ('a8', 4, 70, '05/05/2024', 700, '01/02/2018');
INSERT INTO Detalle_insumo VALUES ('a9', 4, 0, '05/10/2017', 700,'16/11/2015');
INSERT INTO Detalle_insumo VALUES ('a10', 5, 37, '11/03/2019', 100, '16/03/2017');
INSERT INTO Detalle_insumo VALUES ('a11', 6, 18, NULL, 350,'16/11/2017');
INSERT INTO Detalle_insumo VALUES ('a12', 6, 50, NULL, 350  ,'16/04/2019');
INSERT INTO Detalle_insumo VALUES ('a13', 7, 15, '18/07/2020', 850, '16/11/2017');

INSERT INTO Detalle_Insumo_Servicio VALUES (1, 1, 2);
INSERT INTO Detalle_Insumo_Servicio VALUES (1, 4, 4);
INSERT INTO Detalle_Insumo_Servicio VALUES (1, 5, 1);
INSERT INTO Detalle_Insumo_Servicio VALUES (1, 6, 4);
INSERT INTO Detalle_Insumo_Servicio VALUES (2, 1, 2);
INSERT INTO Detalle_Insumo_Servicio VALUES (2, 4, 5);
INSERT INTO Detalle_Insumo_Servicio VALUES (2, 6, 2);
INSERT INTO Detalle_Insumo_Servicio VALUES (2, 4, 2);
INSERT INTO Detalle_Insumo_Servicio VALUES (3, 3, 2);
INSERT INTO Detalle_Insumo_Servicio VALUES (3, 2, 2);

INSERT INTO Proveedor VALUES ('10.726.928-5', 'SSPS', 'Federico franks', '2 998793453', 'F.franks@SSPS.com', 6, 1);
INSERT INTO Proveedor VALUES ('11.134.234-5', 'InCa S.A', 'Luis Perez', '23435434', 'LuisPerez@Inca.com', 1, 1);
INSERT INTO Proveedor VALUES ('20.987.21-3', 'QuimInsu quimicos', 'Leonor Parada', '9 323456744', 'LeonorParada@QuimInsu.com', 2, 1);
INSERT INTO Proveedor VALUES ('32.918.352-8', 'AlfaDental spa', 'Juana Sosa', '9 716483622', 'JuanaSosa@AlfaDental.com', 4, 1);
INSERT INTO Proveedor VALUES ('40.526.583-8', 'DDENTi S.A', 'Ana Maria Cortez', '9 73628261', 'AnaCortez@DDenti.cl', 3, 1);
INSERT INTO Proveedor VALUES ('50.782.872-9', 'DENTOMAX', 'Eduardo Canales', '9 981348674', 'E.Canales@DENTOMAX.com', 7, 1);
INSERT INTO Proveedor VALUES ('9.782.983-7', 'HAND Herramientas', 'Andres Cortines', '2 98723433', 'AndresCortines@hand.com', 5, 1);

INSERT INTO Pedido (fecha_pedido,fecha_entrega,valor_total,estado,rut_trabajador,rut_proveedor,comentario) VALUES ('10/11/2017', '10/12/2017', 150000, 'Recibido', '16.014.886-1', '11.134.234-5', 'Este pedido llego con exito.');
INSERT INTO Pedido (fecha_pedido,fecha_entrega,valor_total,estado,rut_trabajador,rut_proveedor,comentario) VALUES ('15/12/2017', '15/01/2018', 129500, 'Recibido', '16.014.886-1', '11.134.234-5', 'Este pedido llego con exito.');
INSERT INTO Pedido (fecha_pedido,fecha_entrega,valor_total,estado,rut_trabajador,rut_proveedor,comentario) VALUES ('10/11/2017', '10/10/2017', 569000, 'Recibido', '16.014.886-1', '20.987.21-3', 'Este pedido llego con exito.');
INSERT INTO Pedido (fecha_pedido,fecha_entrega,valor_total,estado,rut_trabajador,rut_proveedor,comentario) VALUES ('09/11/2017', '16/11/2017', 24500, 'Recibido', '16.014.886-1', '40.526.583-8', 'Este pedido llego con exito.');
INSERT INTO Pedido (fecha_pedido,fecha_entrega,valor_total,estado,rut_trabajador,rut_proveedor,comentario) VALUES ('15/12/2017', '03/01/2018', 61500, 'Recibido', '16.014.886-1', '40.526.583-8', 'Este pedido llego con exito.');
INSERT INTO Pedido (fecha_pedido,fecha_entrega,valor_total,estado,rut_trabajador,rut_proveedor,comentario) VALUES ('01/01/2016', '16/01/2016', 3900, 'Recibido', '16.014.886-1', '40.526.583-8', 'Este pedido llego con exito.');
INSERT INTO Pedido (fecha_pedido,fecha_entrega,valor_total,estado,rut_trabajador,rut_proveedor,comentario) VALUES ('01/08/2017', '16/09/2017', 187200, 'Recibido', '16.014.886-1', '32.918.352-8', 'Este pedido llego con exito.');
INSERT INTO Pedido (fecha_pedido,fecha_entrega,valor_total,estado,rut_trabajador,rut_proveedor,comentario) VALUES ('30/01/2018', '01/02/2018', 148000, 'Recibido', '16.014.886-1', '32.918.352-8', 'Este pedido llego con exito.');
INSERT INTO Pedido (fecha_pedido,fecha_entrega,valor_total,estado,rut_trabajador,rut_proveedor,comentario) VALUES ('30/10/2015', '16/11/2015', 83500, 'Recibido', '16.014.886-1', '32.918.352-8', 'Este pedido llego con exito.');
INSERT INTO Pedido (fecha_pedido,fecha_entrega,valor_total,estado,rut_trabajador,rut_proveedor,comentario) VALUES ('28/02/2017', '16/03/2017', 314000, 'Recibido', '16.014.886-1', '9.782.983-7', 'Este pedido llego con exito.');
INSERT INTO Pedido (fecha_pedido,fecha_entrega,valor_total,estado,rut_trabajador,rut_proveedor,comentario) VALUES ('28/10/2017', '16/11/2017', 24500, 'Recibido', '16.014.886-1', '10.726.928-5', 'Este pedido llego con exito.');
INSERT INTO Pedido (fecha_pedido,fecha_entrega,valor_total,estado,rut_trabajador,rut_proveedor,comentario) VALUES ('28/03/2018', '16/04/2018', 22500, 'Recibido', '16.014.886-1', '10.726.928-5', 'Este pedido llego con exito.');
INSERT INTO Pedido (fecha_pedido,fecha_entrega,valor_total,estado,rut_trabajador,rut_proveedor,comentario) VALUES ('28/10/2017', '16/11/2017', 95800, 'Recibido', '16.014.886-1', '50.782.872-9', 'Este pedido llego con exito.');


INSERT INTO Detalle_Pedido VALUES (1, 1, 50, 3000,null);
INSERT INTO Detalle_Pedido VALUES (2, 1, 50, 2590,null);
INSERT INTO Detalle_Pedido VALUES (3, 2, 100, 5690,null);
INSERT INTO Detalle_Pedido VALUES (4, 3, 50, 490,null);
INSERT INTO Detalle_Pedido VALUES (5, 3, 150, 410,null);
INSERT INTO Detalle_Pedido VALUES (6, 3, 100, 390,null);
INSERT INTO Detalle_Pedido VALUES (7, 4, 120, 1560,null);
INSERT INTO Detalle_Pedido VALUES (8, 4, 100, 1480,null);
INSERT INTO Detalle_Pedido VALUES (9, 4, 50, 1670,null);
INSERT INTO Detalle_Pedido VALUES (10, 5, 70, 4490,null);
INSERT INTO Detalle_Pedido VALUES (11, 6, 50, 490,null);
INSERT INTO Detalle_Pedido VALUES (12, 6, 50, 450,null);
INSERT INTO Detalle_Pedido VALUES (13, 7, 20, 4790,null);