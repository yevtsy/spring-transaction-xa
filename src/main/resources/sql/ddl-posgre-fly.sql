-- create sequence fly_booking_id_seq start with 1 increment by 1;

create table TBL_FLY_BOOKING (
    id INTEGER not null,
    client_name VARCHAR(200),
    fly_number VARCHAR(200),
    leave VARCHAR(200),
    arrive VARCHAR(200),
    date DATE NOT NULL,
    primary key (id)
);