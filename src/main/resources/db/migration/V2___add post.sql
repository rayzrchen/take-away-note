create table post (
  id      uuid default random_uuid() primary key,
  author  varchar(255)   not null,
  content varchar(32000) not null
);