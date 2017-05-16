--1

select code,omschrijving
from cursussen
where lengte = 4;


--2

select *
from medewerkers
order by functie,GBdatum desc;

--3

select cursus
from uitvoeringen
where locatie='DE MEERN' or locatie = 'UTRECHT';

--5

select voorl,naam
from medewerkers
where not( naam = 'JANSEN' and  voorl ='R');


--Overige opdrachten

--1

insert into uitvoeringen
values('S02',to_date('05/13/17','MM/DD/YY'),7369,'Leerdam');
--2

insert into medewerkers
values(7935,'Van De looy','T','Stagair',7902,to_date('10/23/98','MM/DD/YY'),700,null,20,'m');

insert into medewerkers
values(7936,'Rheither','P','Stagair',7902,to_date('4/12/91','MM/DD/YY'),700,null,20,'m');


--3
update schalen
set ondergrens = 4001,
    snr = 6
where ondergrens = 3001;

insert into schalen
values(5,3001,4000,350);
--4

insert into cursussen
values('DP','Data Processing', 'DSG',6);

insert into uitvoeringen
values('DP',sysdate,7902,'Utrecht');
insert into uitvoeringen
values('DP',sysdate+1,7566,'Utrecht');

insert into inschrijvingen
values(7499,'DP',sysdate,null);

insert into inschrijvingen
values(7934,'DP',sysdate+1,null);

--5


update medewerkers
set maandsal = maandsal * 1.055
where( afd=30 and functie='VERKOPER');

update medewerkers
set maandsal = maandsal * 1.07
where( afd=30 and functie='MANAGER');

--6

delete from medewerkers
where naam = 'MARTENS';

delete from medewerkers
where naam = 'ALDERS';

-- alders kan niet verwijderd worden omdat hij nog een cursus volgt

--7

insert into medewerkers
values(7937,'Kottman','P','Manager',7839,to_date('19/06/99','DD/MM/YY'),1400,null,null,'m');

insert into afdelingen
values(afdelingsequence.nextval,'FINANCIEN','LEERDAM',7937);

update medewerkers
set afd=140
where mnr=7937;
