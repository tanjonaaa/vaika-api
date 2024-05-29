create table if not exists "car"
(
    id   varchar
        constraint pk_car primary key default uuid_generate_v4(),
    color varchar          not null,
    description varchar,
    model varchar,
    name varchar not null,
    pinned boolean,
    place_number integer,
    power varchar,
    price double precision,
    brand_id varchar references brand(id),
    motor_type_id varchar references motor_type(id),
    type_id varchar references car_type(id)
);
