-- h4

--4

select distinct s.cursist
from inschrijvingen i inner join (select distinct cursist from inschrijvingen
where (cursus = 'XML')) s
on (s.cursist = i.cursist)
where (cursus = 'JAV');


--7

select s1.mnr
from(
select m.mnr,a.naam
from medewerkers m inner join afdelingen a
on (a.anr = m.afd)) s1
where s1.naam != 'OPLEIDINGEN';

--8

select distinct cursist
from inschrijvingen
where cursist not in(select cursist from inschrijvingen where cursus='JAV');

--10

select naam
from medewerkers
where mnr  in(select distinct chef from medewerkers
where chef is not null);

select naam
from medewerkers
where mnr not in(select distinct chef from medewerkers
where chef is not null);

--11

select *
from uitvoeringen
where cursus in (select code
from cursussen
where type='ALG')
and begindatum like '%99';

--h8

--4

select *
from(
select distinct i.cursus,i.begindatum, count(*) over (partition by i.cursus order by i.begindatum  )  as inschrijvingen
from inschrijvingen i)
order by begindatum;
--9

select m.naam,m.voorl
from medewerkers m,uitvoeringen u inner join inschrijvingen i
on (u.cursus = i.cursus and u.begindatum = i.begindatum)
where i.cursist = m.chef
order by u.docent;

--h9

--3

select m.mnr
from medewerkers m inner join uitvoeringen u
on (m.mnr != u.docent);
