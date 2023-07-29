--liquibase formatted sql
--changeset giash:20230709
--comment: Create person table with name & nationality
create table if not exists person (
    id bigserial,
    name varchar(255) not null,
    nationality varchar(255) not null,
    constraint pk_person primary key(id)
);