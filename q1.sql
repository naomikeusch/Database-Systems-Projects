/* THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE WRITTEN BY OTHER STUDENTS - Naomi Keusch Baker */

Select sname, count(jnum)
from supplier, spj
where supplier.snum = spj.snum
And spj.jnum = 'j4'
group by sname
having count(jnum) >= 3
