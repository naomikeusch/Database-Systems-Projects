/* THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE WRITTEN BY OTHER STUDENTS - Naomi Keusch Baker */

select proj.jnum, part.pnum, snum
from proj, part, spj
where proj.jnum=spj.jnum
and part.pnum = spj.pnum
and weight >= all (select weight
from part)
group by proj.jnum
having count(distinct part.pnum) >= All(select count(distinct part.pnum)
from part
where weight >= all(select weight
from part)
)