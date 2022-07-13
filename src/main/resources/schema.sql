create table todos
(
    id bigint not null auto_increment,
    title varchar(255) not null,
    description varchar(255),
    status boolean not null default false,
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp,
    primary key (id)
);