create table if not exists "image"
(
    id   varchar
        constraint pk_image primary key default uuid_generate_v4(),
    url varchar          not null,
    car_id varchar references car(id)
);
