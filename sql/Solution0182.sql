Create table If Not Exists Person (id int, email varchar(255));
Truncate table Person;
insert into Person (id, email) values ('1', 'a@b.com');
insert into Person (id, email) values ('2', 'c@d.com');
insert into Person (id, email) values ('3', 'a@b.com');

select Person.email
from Person
group by Person.email
having count(Person.email) > 1
;
