/* THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE WRITTEN BY OTHER STUDENTS - Naomi Keusch Baker */

select a.jnum, count(*)
from proj a, spj b, supplier c
where a.city != c.city
and b.jnum=a.jnum
and b.snum = c.snum
group by a.jnum
having count(*) <(select count(*)
from proj, spj, supplier
where proj.city=supplier.city
and spj.jnum= proj.jnum
and spj.snum=supplier.snum
group by proj.jnum
having proj.jnum = a.jnum)