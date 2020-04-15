create table tbl_users(
	id int auto_increment,
	first_name varchar(100) not null,
	middle_name varchar(100),
	last_name varchar(100) not null,
	username varchar(200) not null,
	password varchar(100) not null,
	email varchar(500) not null,
	address varchar(200) not null,
	created_date date not null,
	created_by varchar(200) not null
);

create table tbl_loyalty_discount(
	id int auto_increment,
	required_tenure_in_days bigint not null,
	discount float,
	created_date date not null,
	created_by varchar(200) not null
);

create table tbl_total_bill_discount(
	id int auto_increment,
	amount float not null,
	discount float,
	created_date date not null,
	created_by varchar(200) not null
);

create table tbl_product(
	id int auto_increment,
	sname varchar(1000) not null,
	price float not null,
	ptype varchar(100) not null,
	created_date date not null,
	created_by varchar(200) not null
);

create table tbl_internal_users_discount(
	id int auto_increment,
	association_type varchar(200) not null,
	discount float not null,
	created_date date not null,
	created_by varchar(200) not null,
);

create table tbl_user_associations(
	user_id int,
	association_id int,
);