/* THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE WRITTEN BY OTHER STUDENTS - Naomi Keusch Baker */

select a.snum, proj.jnum, count(*)
from supplier a, proj, spj
where spj.snum=a.snum
and proj.jnum = spj.jnum
group by a.snum, proj.jnum
having count(*)>= all(select count(*)
from supplier, proj, spj
where spj.snum=supplier.snum
and proj.jnum = spj.jnum
and supplier.snum = a.snum
group by supplier.snum, proj.jnum)