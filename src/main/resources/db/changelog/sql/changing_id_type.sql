create sequence users_table_id_seq
    as integer;

alter table users_table alter column id set default nextval('public.users_table_id_seq'::regclass);

alter sequence users_table_id_seq owned by users_table.id;

create unique index users_table_id_uindex
    on users_table (id);

alter table users_table
    add constraint users_table_pk
        primary key (id);
