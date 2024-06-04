  CREATE TYPE IF NOT EXISTS "appointment_status_enum" AS ENUM(
    'PENDING',
    'VALIDATED',
    'REJECTED',
    'ARCHIVED'
  );
