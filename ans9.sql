/* THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE WRITTEN BY OTHER STUDENTS - Naomi Keusch Baker */

SELECT DISTINCT supplier.snum
FROM supplier, part, spj
WHERE spj.pnum IN(SELECT spj.pnum
FROM spj
WHERE spj.jnum='j6')
AND supplier.snum=spj.snum

