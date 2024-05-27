create extension if not exists "uuid-ossp";
create table if not exists "brand"
(
    id   varchar
        constraint pk_brand primary key default uuid_generate_v4(),
    name varchar          not null
);