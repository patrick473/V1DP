--1

select u.cursus, u.begindatum, c.lengte,c.omschrijving
from uitvoeringen u inner join cursussen c
on u.cursus = c.code;


--2

select m.naam,u.docent
from uitvoeringen u inner join inschrijvingen i
on (i.begindatum = u.begindatum)
inner join medewerkers m on (m.mnr= i.cursist)
where i.cursus = 'S02';

-- overige opdracht

--1

select a.naam,m.naam
from afdelingen a inner join medewerkers m
on (a.hoofd = m.mnr);

--2

select m.naam,a.naam,a.locatie
from medewerkers m inner join afdelingen a
on (m.afd = a.anr);
--3

select m.naam
from medewerkers m inner join inschrijvingen i
on (i.cursist = m.mnr)
where i.cursus = 'S02'
and i.begindatum like '12-APR-99';

--4

select m.naam, s.toelage * 12 as Jaarlijkse_Toelage
from medewerkers m ,schalen s
where (s.ondergrens > m.maandsal)
and (m.maandsal <s.bovengrens);
