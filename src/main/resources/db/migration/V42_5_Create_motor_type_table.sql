create table if not exists "motor_type"
(
    id   varchar
        constraint pk_motor_type primary key default uuid_generate_v4(),
    name varchar          not null
);
