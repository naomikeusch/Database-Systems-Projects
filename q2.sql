/* THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE WRITTEN BY OTHER STUDENTS - Naomi Keusch Baker */

select sname
from supplier, spj, proj B
where supplier.snum = spj.snum
And B.jnum = spj.jnum
group by sname
having count(DISTINCT B.city) = (Select count(DISTINCT A.city)
from proj A)
