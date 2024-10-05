create table posts(
    id bigint not null primary key,
    title varchar(255) not null ,
    content varchar(255) not null ,
    category varchar(255) not null ,
    created_at timestamp ,
    updated_at timestamp,
    tag_id bigint,

    constraint FK_TAG_POST foreign key (tag_id) references tags (id)
);

alter table posts owner to root;

create sequence post_id_seq;

alter sequence post_id_seq owner to root;