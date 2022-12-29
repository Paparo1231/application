create table order_table
(
    id                  integer      not null,
    person_id           integer      not null,
    delivery_meethod_id integer,
    status              varchar(256) not null
);

create table order_item_table
(
    id       integer not null,
    item_id  integer not null,
    order_id integer not null
);
