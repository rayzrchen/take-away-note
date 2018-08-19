create table users (
id raw(16) default uuid() not null primary key,
display_name varchar(255) not null,
password varchar(1000)

)