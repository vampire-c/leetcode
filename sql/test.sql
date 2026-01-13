# 1Q1
create table Employee
(
    id        int,
    name      varchar(255),
    salary    int,
    managerId int
);

select e1.name as Employee
from Employee e1
         left join Employee e2 on e1.managerId = e2.id
where e1.salary > e2.salary;


# 1Q2
Create table If Not Exists Person
(
    personId  int,
    firstName varchar(255),
    lastName  varchar(255)
);
Create table If Not Exists Address
(
    addressId int,
    personId  int,
    city      varchar(255),
    state     varchar(255)
);

select firstName, lastName, city, state
from Person
         left join Address on Person.personId = Address.personId;


# 1Q3
Create table If Not Exists cinema
(
    id          int,
    movie       varchar(255),
    description varchar(255),
    rating      float(2, 1)
);

select id, movie, description, rating
from cinema
where description <> 'boring'
  and id % 2 = 1
order by rating desc;

# 1Q4
Create table If Not Exists Customer
(
    id         int,
    name       varchar(25),
    referee_id int
);
select name
from Customer
where referee_id != 2
   or referee_id is null;

# 2Q1
Create table If Not Exists orders
(
    order_number    int,
    customer_number int
);
select customer_number
from orders
group by customer_number
order by count(order_number) desc
limit 1;

# 2Q2
Create table If Not Exists Courses
(
    student varchar(255),
    class   varchar(255)
);
select class
from Courses
group by class
having count(class) >= 5;

# 2Q3
Create table If Not Exists Transactions
(
    id         int,
    country    varchar(4),
    state      enum ('approved', 'declined'),
    amount     int,
    trans_date date
);
select left(trans_date, 7)                    month,
       country,
       count(*)                               trans_count,
       sum(state = 'approved')                approved_count,
       sum(amount)                            trans_total_amount,
       sum(if(state = 'approved', amount, 0)) approved_total_amount
from Transactions
group by left(trans_date, 7), country;


# 2Q4
Create table If Not Exists Activity
(
    user_id       int,
    session_id    int,
    activity_date date,
    activity_type ENUM ('open_session', 'end_session', 'scroll_down', 'send_message')
);

select activity_date           as day,
       count(distinct user_id) as active_users
from Activity
where activity_date between '2019-06-28' and '2019-07-27'
group by activity_date;


# 3Q1
Create table If Not Exists Movies
(
    movie_id int,
    title    varchar(30)
);
Create table If Not Exists Users
(
    user_id int,
    name    varchar(30)
);
Create table If Not Exists MovieRating
(
    movie_id   int,
    user_id    int,
    rating     int,
    created_at date
);

# select Users.name
# from (
select user_id
from MovieRating
group by user_id
order by count(*) desc, user_id asc
#       ) as t
#          left join Users on t.user_id = Users.user_id
# order by t.user_id,t
limit 1;

select Movies.title
from MovieRating
         left join Movies on MovieRating.movie_id = Movies.movie_id
where created_at between '2020-02-01' and '2020-02-29'
group by movie_id
order by avg(rating) desc
limit 1
;

(select Users.name as results
 from MovieRating
          left join Users on MovieRating.user_id = Users.user_id
 group by MovieRating.user_id
 order by count(*) desc, Users.name asc
 limit 1)
union all
(select Movies.title as results
 from MovieRating
          left join Movies on MovieRating.movie_id = Movies.movie_id
 where MovieRating.created_at between '2020-02-01' and '2020-02-29'
 group by MovieRating.movie_id
 order by avg(MovieRating.rating) desc, Movies.title asc
 limit 1)
;

# 3Q2
Create table If Not Exists Students
(
    student_id   int,
    student_name varchar(20)
);
Create table If Not Exists Subjects
(
    subject_name varchar(20)
);
Create table If Not Exists Examinations
(
    student_id   int,
    subject_name varchar(20)
);


select t1.student_id, t1.student_name, t1.subject_name, IFNULL(t2.attended_exams, 0) as attended_exams
from (select *
      from Students
               cross join Subjects) t1
         left join
     (select Examinations.student_id, Examinations.subject_name, count(Examinations.subject_name) as attended_exams
      from Examinations
      group by Examinations.student_id, Examinations.subject_name) t2
     on t1.student_id = t2.student_id and t1.subject_name = t2.subject_name
order by t1.student_id, t1.subject_name;

# 3Q3
Create table If Not Exists Customer
(
    customer_id int,
    product_key int
);
Create table Product
(
    product_key int
);
select Customer.customer_id
from Customer
group by Customer.customer_id
having count(Customer.product_key) = (select count(Product.product_key) from Product);

# 3Q4
Create table If Not Exists Tree
(
    id   int,
    p_id int
);
select id,
       (case
            when p_id is null then 'Root'
            when id in (select p_id from Tree) then 'Inner'
            else 'Leaf' end) as type
from Tree
;

# 4Q1
Create table If Not Exists Trips
(
    id         int,
    client_id  int,
    driver_id  int,
    city_id    int,
    status     ENUM ('completed', 'cancelled_by_driver', 'cancelled_by_client'),
    request_at varchar(50)
);
Create table If Not Exists Users
(
    users_id int,
    banned   varchar(50),
    role     ENUM ('client', 'driver', 'partner')
);


select t.request_at                                             as Day,
       round(sum(if(status = 'completed', 0, 1)) / count(*), 2) as 'Cancellation Rate'
from (WITH temp_view AS (select Users.users_id
                         from Users
                         where Users.banned = 'Yes')
      select if(Trips.client_id in (select users_id from temp_view) or
                Trips.driver_id in (select users_id from temp_view),
                'Yes', 'No') as banned,
             status,
             request_at
      from Trips
      where request_at between '2013-10-01' and '2013-10-03') as t
where t.banned = 'No'
group by t.request_at
;

# 4Q2
Create table If Not Exists Scores
(
    id    int,
    score DECIMAL(3, 2)
);
select Scores.score,
       DENSE_RANK() over (
           order by
               Scores.score desc
           ) as 'rank'
from Scores
order by Scores.score desc;

select s1.score,
       (select count(distinct s2.score)
        from Scores s2
        where s2.score >= s1.score) as 'rank'
from Scores s1
order by s1.score desc;

# 4Q3
Create table If Not Exists Logs
(
    id  int,
    num int
);
SELECT DISTINCT num AS ConsecutiveNums
FROM (SELECT num,
             ROW_NUMBER() OVER (PARTITION BY num ORDER BY id) AS rn,
             ROW_NUMBER() OVER (ORDER BY id)                  AS global_rn
      FROM Logs) t
GROUP BY num, (global_rn - rn)
HAVING COUNT(*) >= 3;


# 5Q1
Create Table If Not Exists Insurance
(
    pid      int,
    tiv_2015 float,
    tiv_2016 float,
    lat      float,
    lon      float
);
select ROUND(sum(Insurance.tiv_2016), 2) as tiv_2016
from Insurance
where Insurance.tiv_2015
    in (select tiv_2015
        from Insurance
        group by tiv_2015
        having count(*) > 1)
  and concat(lat, lon)
    in (select concat(lat, lon)
        from Insurance
        group by lat, lon
        having count(*) = 1)
;

# 5Q2
Create table If Not Exists Employee
(
    id           int,
    name         varchar(255),
    salary       int,
    departmentId int
);
Create table If Not Exists Department
(
    id   int,
    name varchar(255)
);
select t.name        as Department,
       Employee.name as Employee,
       t.max         as Salary
from Employee
         join (select Employee.departmentId, max(Employee.salary) as max, Department.name
               from Employee
                        join Department on Employee.departmentId = Department.id
               group by departmentId) t
              on Employee.departmentId = t.departmentId
where Employee.salary = t.max
;

# 5Q3
Create table If Not Exists Sales
(
    sale_id    int,
    product_id int,
    year       int,
    quantity   int,
    price      int
);

select Sales.product_id,
       Sales.year first_year,
       Sales.quantity,
       Sales.price
from Sales,
     (select product_id, min(year) year
      from Sales
      group by product_id) t
where Sales.product_id = t.product_id
  and Sales.year = t.year
;


# 5Q4
Create table If Not Exists Stadium
(
    id         int,
    visit_date DATE NULL,
    people     int
);


select id,
       visit_date,
       people,

       ROW_NUMBER() OVER (PARTITION BY id ORDER BY visit_date) AS rn
from Stadium
where people >= 100
;


with t as (SELECT id,
                  visit_date,
                  people,
                  id - ROW_NUMBER() OVER (ORDER BY visit_date) AS global_rn
           FROM Stadium
           WHERE people >= 100),
     t2 as (SELECT t.id,
                   t.visit_date,
                   t.people,
                   t.global_rn
            FROM t
            GROUP BY t.global_rn
            HAVING COUNT(*) >= 3)
select t.id,
       t.visit_date,
       t.people
from t,
     t2
where t2.global_rn = t.global_rn
order by t.visit_date
;

