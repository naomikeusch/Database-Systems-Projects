/* THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE WRITTEN BY OTHER STUDENTS - Naomi Keusch Baker */

SELECT DISTINCT snum
FROM supplier
WHERE snum NOT IN(SELECT supplier.snum
FROM supplier, proj, spj
WHERE spj.snum = supplier.snum
AND proj.jnum = spj.jnum
AND proj.city != supplier.city)

