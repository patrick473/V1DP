-- opdrachten 7.11


--1

--2

-- omdat de tabel afdelingen nog niet bestond toen de tabel gecreeerd werd.

--3

-- omdat het eerste getal nog niet geinitialliseerd is

--4

--omdat i_eval_check controlleert wat voor getal het is, niet of er een getal is.

--5

-- dan wordt deze check pas uitgevoerd als de transactie voltooid is.

--6

-- Deze insert faalt al

-- verdere opdrachten

--1
    alter table medewerkers
    add geslacht char(1 byte);
    alter table medewerkers
    add constraint GeslachtCheck check (geslacht='m' or geslacht='f');
--2
CREATE SEQUENCE  "DATAPROCESSING"."AFDELINGSEQUENCE"  MINVALUE 50 MAXVALUE 9999999999999999999999999999 INCREMENT BY 10 START WITH 110 ;

--3

CREATE TABLE "DATAPROCESSING"."HISTORIEADRES"
 (	"POSTCODE" VARCHAR2(6 BYTE),
  "HUISNUMMER" NUMBER,
  "INGANGSDATUM" DATE CONSTRAINT "ID" NOT NULL ENABLE,
  "EINDDATUM" DATE,
  "TELEFOON" NUMBER(10,0),
  "MED_MNR" NUMBER(4,0) NOT NULL ENABLE,
   CONSTRAINT "DATE_CHECK" CHECK (einddatum > ingangsdatum) ENABLE,
   CONSTRAINT "PR_KEY" PRIMARY KEY ("POSTCODE", "HUISNUMMER", "INGANGSDATUM")
   CONSTRAINT "M_MNR_FK" FOREIGN KEY ("MED_MNR")
	  REFERENCES "DATAPROCESSING"."MEDEWERKERS" ("MNR") ENABLE
   ) ;
