create table character (
    id bigint auto_increment primary key,
    idDiscord bigint unique,
    name varchar(45),
    background varchar(240)
);

create table equipment (
    id int auto_increment primary key,
    name varchar(45),
    description varchar(200),
    attack int,
    defense int
);

create table equipmentCharacter (
    characterId bigint,
    equipmentId int,

    foreign key (characterId) references character(id),
    foreign key (equipmentId) references equipment(id)
);