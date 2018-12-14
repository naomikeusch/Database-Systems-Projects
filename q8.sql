/* THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE WRITTEN BY OTHER STUDENTS - Naomi Keusch Baker */

select distinct sname, count(*)
from supplier, spj, proj
where pnum = 'p3'
and supplier.snum = spj.snum
and proj.jnum = spj.jnum
group by sname
having count(*) >= all (select count(*)
from supplier, spj, proj
where supplier.snum=spj.snum
and proj.jnum = spj.jnum
and pnum = 'p3'
group by spj.jnum)
