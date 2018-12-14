/* THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE WRITTEN BY OTHER STUDENTS - Naomi Keusch Baker */

SELECT DISTINCT proj.jnum
FROM proj, part, spj
WHERE proj.jnum = spj.jnum
AND part.pnum = spj.pnum
AND color = 'Red'
AND proj.city= part.city

