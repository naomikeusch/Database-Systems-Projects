/* THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE WRITTEN BY OTHER STUDENTS - Naomi Keusch Baker */

select pnum
from part
where weight IN(select max(weight)
from part
where weight NOT IN(select max(weight)
from part))
