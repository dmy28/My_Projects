--verific ca ID_client este unic
update client set ID_client=1200 where nume='Gavril';

--verific constrangerea nume nu este null
update client set Nume=' ' where nume='Pavele';


--verifc constrangerea nr de telefon
update client set TELEFON=0712345678934 where nume='Amariei';


--verific constrangerea email
update client set email='vladutzz@' where prenume='Vlad';


--verifc nr de telefon este unic
update client set TELEFON=0709025112   where prenume='Gigi';

--verific email este unic 
update client set email='popescuion@gmail.com' where prenume='Vlad';

--verific ca id_comanda este unic
update COMENZI set ID_comanda=2004 where ID_CLIENT=1200;

--verific constrangerea pret > 0
update plata set total_pret = -90 where ID_plata=3010;


--verific id_actor este unic
update actori set ID_ACTOR=25006 where ID_ACTOR=25000;


--verific id_rezervare este unic
update REZERVARI set ID_REZERVARE= 6016 where ID_REZERVARE=6000;

--verifc id_spectacol este unic
update SPECTACOLE set ID_SPECTACOL=9035 WHERE ID_SPECTACOL=9055;

--verifc constrangerea tip_spectacol 
update SPECTACOLE set TIP_SPECTACOL='Musical' where ID_SPECTACOL=9055;

--verific daca data spectacolului nu este in trecut
insert into spectacole values(null,'Balet','Romeo si Julieta',to_date('1.03.2021 18.30','DD.MM.YYYY HH24.MI'));

--verific daca data rezervarii nu este in viitor
insert into rezervari values(null,9020,to_date('8.06.2024', 'DD.MM.YYYY'));

--verific daca data comenzii nu este in viitor
insert into comenzi VALUES(null,1212,3020,6076,to_date('8.08.2024', 'DD.MM.YYYY'));

--verifc constrangerea numar
update locuri set numar=20 where ID_REZERVARE=6068;

--verific constrangerea rand
update locuri set rand='Z' where ID_REZERVARE=6076;

--verific id_loc sa fie  unic 
update locuri set id_loc= 111 where ID_REZERVARE=6016;

--verific pret not null
update Plata set total_pret=0 where id_plata =3010;

--verific nume not null
update CLIENT set nume=' ' where id_client = 1200;




