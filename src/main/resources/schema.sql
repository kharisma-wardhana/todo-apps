create table users
(
    id bigint not null AUTO_INCREMENT,
    name varchar(255) not null,
    username varchar(255) not null,
    email varchar(255) not null,
    password varchar(255) not null,
    is_active boolean not null default false,
    created_at timestamp default CURRENT_TIMESTAMP,
    updated_at timestamp default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
    primary key (id)
);

create table todos
(
    id bigint not null AUTO_INCREMENT,
    userid bigint not null,
    title varchar(255) not null,
    description varchar(255),
    is_done boolean not null default false,
    is_active boolean not null default false,
    created_at timestamp default CURRENT_TIMESTAMP,
    updated_at timestamp default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
    primary key (id)
);