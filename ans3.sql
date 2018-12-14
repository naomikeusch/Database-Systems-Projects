/*  THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE WRITTEN BY OTHER STUDENTS - Naomi Keusch Baker */


SELECT DISTINCT supplier.snum
FROM supplier, spj, proj
WHERE supplier.snum NOT IN( SELECT supplier.snum
FROM supplier, spj, proj
WHERE supplier.snum = spj.snum
AND proj.jnum = spj.jnum
AND proj.city = supplier.city)

