use sql_training;
SELECT
    CASE occupation
        WHEN 1 THEN
            '学⽣'
        WHEN 2 THEN
            '教师'
        WHEN 3 THEN
            '医⽣'
        WHEN 4 THEN
            '护⼠'
        WHEN 5 THEN
            '程序员'
        ELSE
            '未知'
        END AS `职业`,
    CAST(
            CONCAT(
                    '男:',
                    COUNT(IF(sex = 1, 1, NULL)),
                    ', ⼥:',
                    COUNT(IF(sex = 2, 1, NULL))
                ) AS CHAR
        ) AS `性别`
FROM
    `person01`
GROUP BY
    occupation;

use sakila;
select c1.country country, c2.city city from country c1 left join  city c2 on c1.country_id = c2.country_id;
delete
from country
where country='中国';
insert into country(country) values('中国');

use sakila;
CREATE TEMPORARY table JDBCTestVO
select film.film_id, film.title,film.description,film.length,film.replacement_cost, i.inventory_id,i.store_id, fc.category_id,fa.actor_id
from (((film left join inventory i on film.film_id = i.film_id) left join film_category fc on film.film_id=fc.film_id) left join film_actor fa on film.film_id=fa.film_id);

select * from JDBCTestVO;
select group_concat(COLUMN_NAME) from   information_schema.COLUMNS where TABLE_NAME='JDBCTestVO' and TABLE_SCHEMA='sakila';
show columns from JDBCTestVO;
select * from JDBCTestVO;


select sakila.film.film_id,sakila.film.replacement_cost, sakila.film.title,sakila.film.description,sakila.film.length, i.inventory_id,i.store_id, fc.category_id,fa.actor_id from (((sakila.film left join sakila.inventory i on film.film_id = i.film_id) left join sakila.film_category fc on film.film_id=fc.film_id) left join sakila.film_actor fa on film.film_id=fa.film_id);

select sakila.film.film_id,sakila.film.replacement_cost, sakila.film.title,sakila.film.description,sakila.film.length, i.inventory_id,i.store_id, fc.category_id,fa.actor_id from (((sakila.film left join sakila.inventory i on film.film_id = i.film_id) left join sakila.film_category fc on film.film_id=fc.film_id) left join sakila.film_actor fa on film.film_id=fa.film_id) group by sakila.film.film_id, sakila.film.replacement_cost, sakila.film.title, sakila.film.description, sakila.film.length, i.inventory_id, i.store_id, fc.category_id, fa.actor_id with rollup;

select group_concat(sakila.film_actor.actor_id) actorList,sakila.film_actor.film_id filmId from sakila.film_actor group by sakila.film_actor.film_id;



select sakila.actor.actor_id actorId,sakila.actor.last_name,sakila.actor.first_name where sakila.actor.actor_id=(?);
select group_concat(sakila.film_actor.actor_id) actorList,sakila.film_actor.film_id filmId from sakila.film_actor group by sakila.film_actor.film_id;

#代替上面的查询，两张表都只遍历一次
use sakila;
select sakila.actor.actor_id,sakila.actor.last_name,sakila.actor.first_name,sakila.actor.last_update,sakila.film_actor.film_id from sakila.film_actor inner join sakila.actor  on film_actor.actor_id = actor.actor_id order by sakila.film_actor.film_id;



create table split_test(
                           id int auto_increment primary key,
                           translation varchar(20) not null ,
                           following varchar(20) not null
);
insert into split_test(translation, following) values
                                                   ('apple','2,3'),
                                                   ('banana','3,1'),
                                                   ('pear','1,2');
use mybatis_test;


select
    id,
    translation,
    (select translation from split_test where id in (select substring_index(following,',',1) from split_test)) first_follow,
    (select translation from split_test where id in (select substring_index(following,',',-1) from split_test)) second_follow
from split_test;

select translation from split_test where id in (select substring_index(following,',',1) from split_test);
select translation from split_test where id in (select substring_index(following,',',-1) from split_test);

set global log_bin_trust_function_creators=TRUE;
create function func1
(tid int)
    returns  varchar(20)
    return
        (select translation from split_test where id=tid);
select
    id,
    translation,
    func1(substring_index(following,',',1)) first_follow,
    func1(substring_index(following,',',-1)) second_follow
from split_test;

select
    id,
    (select @ids:=GROUP_CONCAT(following) from split_test where find_in_set(id,following))