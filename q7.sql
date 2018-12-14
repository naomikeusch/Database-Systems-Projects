/* THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE WRITTEN BY OTHER STUDENTS - Naomi Keusch Baker */

select a.jnum, sum(qty)
from proj a, spj b, part c
where b.jnum = a.jnum
and pname = 'Screw'
and c.pnum = b.pnum
group by a.jnum
having sum(qty) >= all(select sum(qty)
from proj a, spj b, part c
where a.jnum = b.jnum
and pname = "Screw"
and c.pnum = b.pnum
group by a.jnum)