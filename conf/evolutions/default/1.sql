# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table t_user (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  school_year                   integer,
  height                        integer,
  food                          varchar(255),
  constraint pk_t_user primary key (id)
);


# --- !Downs

drop table if exists t_user;

