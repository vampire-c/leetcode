Create table If Not Exists Activity (player_id int, device_id int, event_date date, games_played int);
Truncate table Activity;
insert into Activity (player_id, device_id, event_date, games_played) values ('1', '2', '2016-03-01', '5');
insert into Activity (player_id, device_id, event_date, games_played) values ('1', '2', '2016-05-02', '6');
insert into Activity (player_id, device_id, event_date, games_played) values ('2', '3', '2017-06-25', '1');
insert into Activity (player_id, device_id, event_date, games_played) values ('3', '1', '2016-03-02', '0');
insert into Activity (player_id, device_id, event_date, games_played) values ('3', '4', '2018-07-03', '5');


select player_id,
       MIN(event_date) first_login
from Activity
group by player_id
;


select player_id,
       event_date first_login
from (select player_id,
             event_date,
             RANK() over (
                 partition by
                     player_id
                 order by
                     event_date
                 ) rnk
      from Activity) X
where rnk = 1;



select distinct player_id,
                FIRST_VALUE(event_date) over (
                    partition by
                        player_id
                    order by
                        event_date
                    ) first_login
from Activity;



select distinct player_id,
                LAST_VALUE(event_date) over (
                    partition by
                        player_id
                    order by
                        event_date desc range between unbounded preceding
                        and unbounded following
                    ) first_login
from Activity;
