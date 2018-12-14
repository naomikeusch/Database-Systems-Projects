/* THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE WRITTEN BY OTHER STUDENTS - Naomi Keusch Baker */

SELECT DISTINCT A.snum, C.pnum
FROM part C, spj A
WHERE C.weight >=ALL(SELECT DISTINCT weight
FROM part, spj
WHERE spj.snum = A.snum
AND part.pnum = spj.pnum)
AND C.pnum=A.pnum

