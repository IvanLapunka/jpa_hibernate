DROP SCHEMA IF EXISTS relations cascade;
CREATE SCHEMA relations AUTHORIZATION "admin";

create table relations.zoo (
	id serial not null primary key,
	name varchar(100) not null
--	,
--	creation_date date not null
);

create table relations.aviary(
	id serial not null primary key,
	name varchar(50) not null,
	zoo_id int not null references relations."zoo"(id)
);

create table relations.animal (
	id serial not null primary key,
	name varchar(50) not null,
	group_name varchar(50) not null,
	nick_name varchar(50) not null,
	aviary_id int null references relations."aviary"(id)
);

create table relations.worker(
	id serial not null primary key,
	full_name varchar(50) not null,
	salary int8 null,
	zoo_id int not null references relations."zoo"(id)
);

create table relations.aviary_worker(
	aviary_id int not null references relations."aviary"(id),
	worker_id int not null references relations."worker"(id)
);
