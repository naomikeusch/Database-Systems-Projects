/* THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE WRITTEN BY OTHER STUDENTS - Naomi Keusch Baker */

SELECT DISTINCT proj.jnum
FROM proj
WHERE proj.jnum IN (SELECT proj.jnum
from proj, supplier, spj
WHERE proj.city = supplier.city
AND proj.jnum = spj.jnum
AND supplier.snum = spj.snum
)

