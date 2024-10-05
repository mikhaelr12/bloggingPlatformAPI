create table posts(
    id bigint not null primary key,
    title varchar(255),
    content varchar(255),
    category varchar(255),
    tag_id bigint,

    constraint FK_TAG_POST foreign key (tag_id) references tags (id)
);

alter table posts owner to root;

create sequence post_id_seq;

alter sequence post_id_seq owner to root;