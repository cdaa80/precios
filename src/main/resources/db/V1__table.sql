create table prices(
 id varchar (100) not null,
 brand_id varchar(2) not null,
 start_date timestamp,
 end_date timestamp,
 price_list varchar(2) not null,
 product_id varchar(6) not null,
 priority int not null,
 price double,
 curr  varchar(3) not null,
  PRIMARY KEY (id)
);

