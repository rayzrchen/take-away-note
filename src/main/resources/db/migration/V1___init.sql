create table car (
  id           uuid default random_uuid() primary key,
  licenseplate varchar(255) not null,
  color        varchar(255) not null
);