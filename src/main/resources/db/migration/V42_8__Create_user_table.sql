create table if not exists "user"
(
    id       varchar
        constraint pk_user primary key default uuid_generate_v4(),
    username varchar not null,
    email    varchar not null,
    password varchar not null
)