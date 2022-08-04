CREATE TYPE emailType AS ENUM ('PERSONAL', 'CORPORATE');

CREATE TYPE gender AS ENUM ('MALE', 'FEMALE', 'OTHERS');

CREATE TABLE IF NOT EXISTS employees (id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL, CONSTRAINT employee_pkey PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS name (id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL, first VARCHAR NOT NULL, last VARCHAR NOT NULL, CONSTRAINT name_pkey PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS address (id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL, )
