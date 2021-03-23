insert into tipo(nombre,descripcion) values('maquina1','maquina de hacer cosas');
insert into tipo(nombre,descripcion) values('maquina2','herramienta');

insert into ciudad(nombre,telefono) values('Bogota','maquina de hacer cosas');

insert into estado(nombre,descripcion) values('activo','activo');
insert into estado(nombre,descripcion) values('baja','Activo cancelado');

insert into activo(nombre,descripcion,serial,inventario,peso,alto,ancho,largo,color,fecha_compra,fecha_de_baja,ciudad_id,estado_id,tipo_id,valor_compra) values('activo1','descripcion1','serial1','inventario1',3.3,2.0,3.5,2.1, 'rojo','2021-02-02','2021-02-02',1,1,1,200);
insert into activo(nombre,descripcion,serial,inventario,peso,alto,ancho,largo,color,fecha_compra,fecha_de_baja,ciudad_id,estado_id,tipo_id,valor_compra) values('maquina','descripcion maquina','serial maquina','inventario1',3.3,2.0,3.5,2.1, 'rojo','2021-02-02','2021-02-02',1,1,2,200);
insert into activo(nombre,descripcion,serial,inventario,peso,alto,ancho,largo,color,fecha_compra,fecha_de_baja,ciudad_id,estado_id,tipo_id,valor_compra) values('oficina','descripcion oficina','serial oficina','inventario1',3.3,2.0,3.5,2.1, 'rojo','2021-02-02','2021-02-02',1,1,2,200);
