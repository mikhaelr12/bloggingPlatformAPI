create table tags (
    id bigint not null primary key,
    tag_name varchar(255)
);
alter table tags owner to root;

create sequence tag_id_seq;

alter sequence tag_id_seq owner to root;