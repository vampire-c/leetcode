Create table If Not Exists Person (Id int, Email varchar(255));
Truncate table Person;
insert into Person (id, email) values ('1', 'john@example.com');
insert into Person (id, email) values ('2', 'bob@example.com');
insert into Person (id, email) values ('3', 'john@example.com');


select *
from Person;


DELETE
FROM Person
WHERE id NOT IN (SELECT min_id
                 FROM (SELECT MIN(id) AS min_id
                       FROM Person
                       GROUP BY email) t);
