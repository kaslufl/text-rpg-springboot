insert into character(idDiscord, name, background)
values (40039, 'Guts', 'Black Swordsman');

insert into equipment(name, description, attack, defense)
values ('Big Sword', 'Big sword made from steel', 5, 0);

insert into equipment(name, description, attack, defense)
values ('Black Cape', 'A cape dyed black', 0, 1);

insert into equipmentCharacter(characterId, equipmentId)
values (1, 1);

insert into equipmentCharacter(characterId, equipmentId)
values (1, 2);