/* THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE WRITTEN BY OTHER STUDENTS - Naomi Keusch Baker */

SELECT DISTINCT A.snum
FROM supplier A, spj B, part C
WHERE weight < ALL(SELECT weight
FROM supplier D, part E, spj F
WHERE D.snum = F.snum
AND E.pnum = F.pnum
AND D.sname = 'Blake')
AND C.pnum = B. pnum
AND A.snum = B.snum

