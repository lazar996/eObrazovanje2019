INSERT INTO  predmet (naziv,opis) VALUES ("Matematika","Matematicka analiza");
INSERT INTO  predmet (naziv,opis) VALUES ("Veronauka","Matematicka analiza");
INSERT INTO  predmet (naziv,opis) VALUES ("Ruski jezik","Matematicka analiza");
INSERT INTO  predmet (naziv,opis) VALUES ("Nemacki jezik","Matematicka analiza");
INSERT INTO  predmet (naziv,opis) VALUES ("Spanski jezik","Matematicka analiza");
INSERT INTO  predmet (naziv,opis) VALUES ("Engleski jezik","Matematicka analiza");
INSERT INTO  predmet (naziv,opis) VALUES ("Srpski jezik","Matematicka analiza");
INSERT INTO  predmet (naziv,opis) VALUES ("Hemija","Matematicka analiza");
INSERT INTO  predmet (naziv,opis) VALUES ("Fizika","Matematicka analiza");
INSERT INTO  predmet (naziv,opis) VALUES ("Matematika 4","Matematicka analiza");
INSERT INTO  predmet (naziv,opis) VALUES ("Matematika 3","Matematicka analiza");
INSERT INTO  predmet (naziv,opis) VALUES ("Matematika 2","Matematicka analiza");
INSERT INTO  predmet (naziv,opis) VALUES ("Programiranje","Matematicka analiza");
INSERT INTO  predmet (naziv,opis) VALUES ("Obrada signala","Matematicka analiza");
INSERT INTO  predmet (naziv,opis) VALUES ("Mrezna oprema","Matematicka analiza");
INSERT INTO  predmet (naziv,opis) VALUES ("Racunarske mreze","Matematicka analiza");
INSERT INTO  predmet (naziv,opis) VALUES ("Fizicko","Matematicka analiza");
INSERT INTO  predmet (naziv,opis) VALUES ("Muzicko","Matematicka analiza");
INSERT INTO  predmet (naziv,opis) VALUES ("Likovno","Matematicka analiza");
INSERT INTO  predmet (naziv,opis) VALUES ("Administriranje","Matematicka analiza");
INSERT INTO  predmet (naziv,opis) VALUES ("Tehnicko","Matematicka analiza");
INSERT INTO  predmet (naziv,opis) VALUES ("Biologija","Matematicka analiza");
INSERT INTO  predmet (naziv,opis) VALUES ("Geografija","Matematicka analiza");
INSERT INTO  predmet (naziv,opis) VALUES ("Istorija","Matematicka analiza");

INSERT INTO korisnik (jmbg,broj,email,grad,ime,korisnicko_ime,lozinka,prezime,tip_korisnika,ulica) VALUES ("12345","1","pera@gmail.com","Novi Sad","Petar", "pera","123","Peric","ucenik","Protina");
INSERT INTO korisnik (jmbg,broj,email,grad,ime,korisnicko_ime,lozinka,prezime,tip_korisnika,ulica) VALUES ("5678","2","marko@gmail.com","Beograd","Marko", "marko","123","Markovic","nastavnik","Marka Kraljevica");
INSERT INTO ucenik (broj_indeksa, jmbg) VALUES ("1", "1");

INSERT INTO dokumenta (dokumenti_id,download_uri,naziv,tip_dokumenta,jmbg) VALUES ("1","1","1","1","1");

--INSERT INTO pohadjanje_predmeta (predmet_id,jmbg) values(1,1);
