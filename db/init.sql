DROP DATABASE IF EXISTS postgres;    

CREATE DATABASE postgres;    

\c postgres;        

create table Client (
    id bigint generated always as identity,
    time_create timestamp,
    time_modify timestamp,
    username varchar(128) unique,
    password varchar(128)
);

