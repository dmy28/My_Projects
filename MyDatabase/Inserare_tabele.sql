--inserare date in tabela client
insert into client values(null, 'Popescu', 'Ioan', 'Strada Depozitelor 20, Iasi','popescuion@gmail.com', 0734434676);
insert into client values(null, 'Amariei', 'Vlad', 'Strada Florariei 28, iasi','amarieivlad@gmail.com', 0754982474);
insert into client values(null, 'Ionescu', 'Gigi', 'Strada Ciurchi 56, Iasi','ionescugigi@gmail.com', 0712875498);
insert into client values(null, 'Gavril', 'Irina', 'Strada Nicolina 17, Iasi','gavrilirina@gmail.com', 0734458245);
insert into client values(null, 'Pavele', 'Petru', 'Strada Bucium 107, Iasi','pavelepetru@gmail.com', 0709025637);

select * from CLIENT;


--inserare date in table spectacole
insert into spectacole values(null,'Opera','Tosca',to_date('17.01.2024 19.30', 'DD.MM.YYYY HH24.MI'));
insert into spectacole values(null,'Balet','Giselle',to_date('22.02.2024 18.30','DD.MM.YYYY HH24.MI'));
insert into spectacole values(null,'Opera','UN BALLO IN MASCHERA',to_date('31.01.2024 20.30','DD.MM.YYYY HH24.MI'));
insert into spectacole values(null,'Balet','Lacul Lebedelor',to_date('28.02.2024 19.00','DD.MM.YYYY HH24.MI'));
insert into spectacole values(null,'Balet','Romeo si Julieta',to_date('1.03.2024 18.30','DD.MM.YYYY HH24.MI'));

select * from SPECtacole;

--inserare date in tabela actori
insert into actori values(null,'Buzea','Ion');
insert into actori values(null,'Bretan','Nicolae');
insert into actori values(null,'Ianculescu','Magda');
insert into actori values(null,'Ivan','Simina');
insert into actori values(null,'Oatu','Cezar');

select * from actori;

--inserare date in tabela plata
insert into plata VALUES(null,150);
insert into plata VALUES(null,80);
insert into plata VALUES(null,100);
insert into plata VALUES(null,120);
insert into plata VALUES(null,90);


select * from plata;

--inserare date in tabela comenzi
insert into comenzi VALUES(null,1200,3000,6060,TO_DATE('10.01.2024', 'DD.MM.YYYY'));
insert into comenzi VALUES(null,1203,3005,6068,to_date('1.02.2024', 'DD.MM.YYYY'));
insert into comenzi VALUES(null,1206,3010,6064,to_date('28.01.2024', 'DD.MM.YYYY'));
insert into comenzi VALUES(null,1209,3015,6072,to_date('15.02.2024', 'DD.MM.YYYY'));
insert into comenzi VALUES(null,1212,3020,6076,to_date('8.01.2024', 'DD.MM.YYYY'));


select *from comenzi;

--inserare date in table rezervari
insert into rezervari values(null,9000,to_date('10.01.2024', 'DD.MM.YYYY'));
insert into rezervari values(null,9005,to_date('28.01.2024', 'DD.MM.YYYY'));
insert into rezervari values(null,9010,to_date('15.02.2024', 'DD.MM.YYYY'));
insert into rezervari values(null,9015,to_date('1.02.2024', 'DD.MM.YYYY'));
insert into rezervari values(null,9020,to_date('8.01.2024', 'DD.MM.YYYY'));

select *from rezervari;



--inserare date in tabela locuri
insert into locuri values (null,6060,'B',10, 'A' );
insert into locuri values (null,6068,'N',8,  'A');
insert into locuri values (null,6064,'G',11, 'A' );
insert into locuri values (null,6072,'L',1, 'F');
insert into locuri values (null,6076,'G',17, 'F' );

select * from locuri;



--inserare date in tabela spectacole-actori
insert into "Spectacole-Actori" VALUES(9000,25000);
insert into "Spectacole-Actori" VALUES(9005,25002);
insert into "Spectacole-Actori" VALUES(9010,25004);
insert into "Spectacole-Actori" VALUES(9020,25008);
insert into "Spectacole-Actori" VALUES(9015,25006);


select * from "Spectacole-Actori";









