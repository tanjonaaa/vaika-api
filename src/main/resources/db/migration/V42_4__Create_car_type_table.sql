create table if not exists "car_type"
(
    id   varchar
        constraint pk_car_type primary key default uuid_generate_v4(),
    name varchar          not null
);
