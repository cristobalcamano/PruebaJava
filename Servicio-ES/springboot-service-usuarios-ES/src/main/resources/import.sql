insert into usuario(usuario,contraseña,email,telefono) values ('usuario1','$2a$10$Qa..m1XRCFNHcsHSOL0oUeQe3uMlwInIdmJw76gV8rLiHc865v3EO','carlos.zaens@demo.com','1234567')
insert into usuario(usuario,contraseña,email,telefono) values ('usuario2','$2a$10$Qa..m1XRCFNHcsHSOL0oUeQe3uMlwInIdmJw76gV8rLiHc865v3EO','maria.torres@demo.com','7654321')

insert into rol(nombre, descripcion) values('ADMIN' , 'Administrador del sistema')
insert into rol(nombre, descripcion) values('USER' , 'usuario del sistema')
                        
insert into usuarios_rol(usuario_id , rol_id) values(1,1)
insert into usuarios_rol(usuario_id , rol_id) values(1,2)
insert into usuarios_rol(usuario_id , rol_id) values(2,1)
