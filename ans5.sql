/* THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE WRITTEN BY OTHER STUDENTS - Naomi Keusch Baker */

SELECT DISTINCT A.jnum
FROM proj A, spj B, part C
WHERE A.jnum NOT IN(SELECT DISTINCT D.jnum
FROM proj D, part E, spj F
WHERE D.jnum = F.jnum
AND E.pnum = F.pnum
AND (E.pname='Bolt' OR E.pname= 'Nut'))
AND A.jnum = B.jnum
AND C.pnum = B.pnum

