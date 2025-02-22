create table tipo_espacio(
id serial primary key,
nombre varchar(100) unique not null
);

create table rol(
id serial primary key,
nombre varchar(100) unique not null
);

create table estado_reserva(
id serial primary key,
nombre varchar(100) unique not null
);

create table espacio(
id serial primary key,
id_tipo_espacio int not null,
nombre varchar(150) not null,
capacidad int not null,
disponibilidad boolean not null,
foreign key(id_tipo_espacio) references tipo_espacio(id) on delete cascade
);

create table usuario(
id serial primary key,
id_rol int not null,
documento varchar(15) unique not null,
clave varchar(50) not null,
foreign key(id_rol) references rol(id) on delete cascade
);

create table reserva(
id serial primary key,
id_estado_reserva int not null,
id_usuario int not null,
id_espacio int not null,
fecha date not null,
hora_inicio time not null,
hora_fin time not null,
foreign key(id_estado_reserva) references estado_reserva(id) on delete cascade,
foreign key(id_usuario) references usuario(id) on delete cascade,
foreign key(id_espacio) references espacio(id) on delete cascade
);


