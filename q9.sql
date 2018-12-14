/* THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE WRITTEN BY OTHER STUDENTS - Naomi Keusch Baker */

select proj.jnum
from proj, spj, supplier
where proj.city != supplier.city
and spj.jnum=proj.jnum
and spj.snum = supplier.snum
group by proj.jnum
having count(*) >= 5