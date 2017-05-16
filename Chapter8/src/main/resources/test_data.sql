insert into contact(first_name, last_name, birth_date, version)
values('Chris', 'Scaefer', '1981-05-03', 0);
insert into contact(first_name, last_name, birth_date, version)
values('Scott', 'Tiger', '1990-11-02', 0);
insert into contact(first_name, last_name, birth_date, version)
values('John', 'Smith', '1964-02-28', 0);

insert into contact_tel_detail(contact_id, tel_type, tel_number, version)
values(1, 'Mobile', '1234567890', 0);
insert into contact_tel_detail(contact_id, tel_type, tel_number, version)
values(1, 'Home', '1234567890', 0);
insert into contact_tel_detail(contact_id, tel_type, tel_number, version)
values(2, 'Home', '1234567890', 0);

insert into hobby(id) values('Swimming');
insert into hobby(id) values('Jogging');
insert into hobby(id) values('Programming');
insert into hobby(id) values('Movies');
insert into hobby(id) values('Reading');

insert into contact_hobby_detail(contact_id, hobby_id) values(1, 'Swimming');
insert into contact_hobby_detail(contact_id, hobby_id) values(1, 'Movies');
insert into contact_hobby_detail(contact_id, hobby_id) values(2, 'Swimming');

