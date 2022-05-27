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
                    '男:',obs
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
from (((film left join inventory i on film.film_id = i.film_id) left join film_category fc on film.film_id=fc.film_id) left join film_actor fa on film.film_id=fa.film_id)

select * from JDBCTestVO;
select group_concat(COLUMN_NAME) from   information_schema.COLUMNS where TABLE_NAME='JDBCTestVO' and TABLE_SCHEMA='sakila';
show columns from JDBCTestVO;
select * from JDBCTestVO;
