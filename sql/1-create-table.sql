create table registration (id bigint, name varchar(25), email varchar(30), phone_number varchar(12)); 
alter table registration add primary key (id);      
alter table registration modify column id bigint auto_increment;   
	