  create table if not exists "appointment"
  (
      id   varchar
              constraint pk_appointment primary key default uuid_generate_v4(),
      last_name varchar not null,
      first_name varchar not null,
      email varchar not null,
      contact varchar not null,
      message varchar not null,
      appointment_datetime timestamp with time zone,
      status "appointment_status_enum",
      car_id varchar references car(id)
  );
