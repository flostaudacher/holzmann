drop database swp;
create database swp;
use swp;

CREATE TABLE benutzer (
	benutzerid int auto_increment ,
	email varchar(255) not null ,
	vorname varchar(50) not null,
	nachname varchar(50) not null,
	passwort varchar(50) not null,
	nickname varchar(50) not null,
	usergroup char(1) not null,
	gesperrt boolean not null default false,
	-- CONSTRAINTS
	primary key(benutzerid),
	constraint u_email unique(email),
	constraint u_nickname unique(nickname),
	constraint c_usergroup check(
	usergroup in ('A','B','C'))
);

CREATE TABLE themengebiete (
	themengebietID int auto_increment primary key,
	themengebiete varchar(50) not null unique
);

CREATE TABLE artikle (
	artikleID int auto_increment primary key,
	autorID int not null,
	themengebietID int not null,
	kopfzeile varchar(50) not null,
	zusammenfassung varchar(255) not null,
	artikelText text not null,
	istgesperrt boolean not null default false
);

CREATE TABLE kommentare (
	kommentarId int auto_increment primary key,
	vonBenutzerId int not null,
	zuArtikleId int not null,
	kommentar varchar(3000) not null,
	zeitpunkt timestamp not null default current_timestamp,
	zuKommentarId int,
	istgesperrt boolean not null default false
);

ALTER TABLE artikle add constraint artikleThemenRef foreign key(themengebietID) references themengebiete(themengebietID);
ALTER TABLE artikle add constraint artikelBenutzer foreign key(autorID) references benutzer(benutzerid);
ALTER TABLE kommentare add constraint kommentarZuBenutzer foreign key(vonBenutzerId) references benutzer(benutzerid);
ALTER TABLE kommentare add constraint kommentarZuArtikle foreign key(zuArtikleId) references artikle(artikleID);
ALTER TABLE kommentare add constraint kommentarZuKommentar foreign key(zuKommentarId) references kommentare(kommentarId);

insert into benutzer (email,vorname,nachname,passwort,nickname,usergroup,gesperrt) values ("gunther@gmail.com","gunther","laner","123123","gunni","B",false);
insert into benutzer (email,vorname,nachname,passwort,nickname,usergroup,gesperrt) values ("awolf@tsn.at", "Armin", "Wolf", "hallo123", "Armi", "A", false);
insert into benutzer (email,vorname,nachname,passwort,nickname,usergroup,gesperrt) values ("simonegger@gmail.com","simon","egger","123123","simi","C",false);

select * from benutzer;
insert into themengebiete (themengebiete) values ('sport');
insert into themengebiete (themengebiete) values ('politik');

insert into artikle (autorID,themengebietID,kopfzeile,zusammenfassung,artikelText) values (1,1,"hallo","zusammenfassung über hallo","Text zu hallo");
insert into artikle (autorID,themengebietID,kopfzeile,zusammenfassung,artikelText) values (1,2,"junge","zusammenfassung über junge","Text zu junge");
insert into artikle (autorID,themengebietID,kopfzeile,zusammenfassung,artikelText) values (1,2,"madl","zusammenfassung über madl","Text zu madl");

insert into kommentare (vonBenutzerId,zuArtikleId,kommentar,zuKommentarId,istgesperrt) values (3,1,"hallo kommentar",null,false);
insert into kommentare (vonBenutzerId,zuArtikleId,kommentar,zuKommentarId,istgesperrt) values (2,1,"junge kommentar",11,false);
insert into kommentare (vonBenutzerId,zuArtikleId,kommentar,zuKommentarId,istgesperrt) values (1,1,"madl kommentar",15,false);
select * from kommentare;

insert into kommentare (vonBenutzerId,zuArtikleId,kommentar,zuKommentarId,istgesperrt) values (3,1,"schiach kommentar",null,false);
insert into kommentare (vonBenutzerId,zuArtikleId,kommentar,zuKommentarId,istgesperrt) values (2,1,"sehr schiach kommentar",null,false);



