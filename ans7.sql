/* THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE WRITTEN BY OTHER STUDENTS - Naomi Keusch Baker */

SELECT DISTINCT A.snum
FROM supplier A, spj B, part C
WHERE A.snum NOT IN(SELECT DISTINCT D.snum
FROM supplier D, part E, spj F
WHERE D.snum = F.snum
AND E.pnum = F.pnum
AND E.pname= 'Nut')
AND A.snum = B.snum
AND C.pnum = B.pnum

