create table user_roles(
    user_role_id number(11) not null,
    username varchar(45) not null,
    role varchar(45) not null,
    primary key(user_role_id),
    constraint fk_username foreign key (username) references users (username)
);