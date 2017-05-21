--h4

--6

select mnr, functie,gbdatum
from medewerkers
where gbdatum < '01-JAN-60';
--9

select *
from medewerkers
where naam like '% %';


--h8

--5
select *
from(
select distinct i.cursus,i.begindatum, count(*) over (partition by i.cursus order by i.begindatum  )  as inschrijvingen
from inschrijvingen i
where i.begindatum like '%-99')
where inschrijvingen > 3;

--7
select *
from(
select distinct m.naam, i.cursus, count(*) over(partition by i.cursist order by i.cursus)  as inschrijvingen
from inschrijvingen i inner join medewerkers m
on( i.cursist = m.mnr)
)
where inschrijvingen > 1;

--overige opdrachten

--1

select *
from(
select distinct cursus,count(*) over(partition by cursus) as cursussen
from uitvoeringen
);

--2

--a
SELECT	 TRUNC(TRUNC(MONTHS_BETWEEN(max(gbdatum ), min(gbdatum))) / 12) num_years
from medewerkers;
--b
Select  Trunc(Months_Between(Sysdate, median(gbdatum))/12)   leeftijd
 From medewerkers;
--3
select count(*),avg(nvl(m.comm, 0)) as gemiddeld ,avg(m.comm) AS gemiddeld_verkoper
FROM MEDEWERKERS M;
