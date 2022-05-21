use sakila;
select c1.country country, c2.city city from country c1 left join  city c2 on c1.country_id = c2.country_id;
delete
from country
where country='中国';
insert into country(country) values('中国');
