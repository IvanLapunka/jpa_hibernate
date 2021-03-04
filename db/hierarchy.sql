DROP SCHEMA IF EXISTS hierarchies cascade;
CREATE SCHEMA hierarchies AUTHORIZATION "admin";

create table hierarchies.science_book (
	id serial not null primary key,
	title varchar(100) not null,
	publish_year int null,
	author varchar(100) not null,
	science varchar(100) not null
);

create table hierarchies.fiction_book (
	id serial not null primary key,
	title varchar(100) not null,
	publish_year int null,
	author varchar(100) not null,
	genre varchar(100) not null,
	is_poem boolean not null
);

create table hierarchies.book (
	id serial not null primary key,
	title varchar(100) not null,
	publish_year int null,
	author varchar(100) not null,
	genre varchar(100) null,
	is_poem boolean null,
	science varchar(100) null,
	class_name varchar(100) not null
);

create table hierarchies.join_science_book (
	id int8 not null primary key,
	science varchar(100) not null
);

create table hierarchies.join_fiction_book (
	id int8 not null primary key,
	genre varchar(100) not null,
	is_poem boolean not null
);

create table hierarchies.join_book (
	id serial not null primary key,
	title varchar(100) not null,
	publish_year int null,
	author varchar(100) not null,
	class_name varchar(100) not null
);


create table hierarchies.per_table_science_book (
	id serial not null primary key,
	title varchar(100) not null,
	publish_year int null,
	author varchar(100) not null,
	science varchar(100) not null
);

create table hierarchies.per_table_fiction_book (
	id serial not null primary key,
	title varchar(100) not null,
	publish_year int null,
	author varchar(100) not null,
	genre varchar(100) not null,
	is_poem boolean not null
);

create table hibernate_sequences (sequence_name varchar(255) not null, next_val int8, primary key (sequence_name));
insert into hibernate_sequences(sequence_name, next_val) values ('default',0);