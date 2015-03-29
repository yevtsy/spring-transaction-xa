create sequence hotel_booking_id_seq start with 1 increment by 1;

create table TBL_HOTEL_BOOKING (
    id INTEGER not null,
    client_name VARCHAR(200),
    hotel_name VARCHAR(200),
    arrival DATE NOT NULL,
    departure DATE NOT NULL,
    primary key (id)
);