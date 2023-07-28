--Practise1
select
	first_name || ' ' || last_name full_name ,
	email
from
	customer
order by
	customer_id desc

	--Practise2
select
	distinct on
	(country_id) country_id,
	city
from
	city
order by
	country_id ,
	city desc;

-- Practise3
select
	first_name ,
	length(first_name)
from
	customer
where
	length(first_name) >= 3
	and length(first_name) <= 5
	and first_name like 'A%'
order by
	length(first_name) asc
	
	--Practise4
	
select
	customer.customer_id,
	rental.rental_id,
	rental.rental_date
from
	rental,
	customer
where
	(customer.first_name = 'JON'
		and rental.customer_id = customer.customer_id
		and cast(rental_date as DATE) = '2022-08-21')
	or (customer.first_name = 'MICHELLE'
		and rental.customer_id = customer.customer_id
		and cast(rental_date as DATE) = '2022-08-21')
order by
	customer_id

-- Practise5
	
	select length,title  from film
	
	-- Practise 6
	
	select
	C.customer_id ,
	P.amount ,
	P.payment_date
from
	payment P,
	customer C
where
	c.first_name like '_ERT%'
	and c.customer_id = p.customer_id
	and p.payment_date between '2022-01-01' and '2022-03-01'
order by
	c.customer_id asc
	
	-- Practise 7
	
	select
	customer_id,
	staff_id,
	sum(amount)
from
	payment
group by
	customer_id,
	staff_id
order by
	customer_id asc;

-- Practise 8 Having

select
	store_id,
	count(customer_id)
from
	customer
group by
	store_id
having
	count(customer_id) >= 200

	-- Practice9 INNER JOIN
-- P9 s1
	select
	c.customer_id ,
	c.first_name customer_first_name,
	c.last_name customer_last_name,
	s.first_name staff_first_name,
	s.last_name staff_last_name,
	p.amount ,
	p.payment_date
from
	staff s ,
	payment p ,
	customer c
where
	(s.staff_id = p.staff_id
	and p.customer_id = c.customer_id)
order by
	p.payment_date asc
	
	--p9 s2
	
	select
	c.customer_id ,
	c.first_name customer_first_name,
	c.last_name customer_last_name,
	s.first_name staff_first_name,
	s.last_name staff_last_name,
	p.amount ,
	p.payment_date
from
	customer c
inner join payment on
	staff.staff_id = payment.staff_id
inner join staff on
	payment.customer_id = customer.customer_id)
order by
	payment.payment_date asc
	
	-- Example1 LEFT JOIN/ LEFT OUTER JOIN
	
	select
	film.film_id,
	title,
	inventory_id
from
	film
left join inventory 
on
	inventory.film_id = film.film_id
order by
	title;

-- example2

SELECT 
  review, 
  title
FROM 
  films
RIGHT JOIN film_reviews 
  ON film_reviews.film_id = films.film_id;
 
 -- Practise10 right join

select
	c.customer_id,
	c.first_name,
	c.last_name ,
	payment.amount ,
	payment.payment_date
from
	customer c
right join payment on
	payment.customer_id = c.customer_id
order by
	payment.amount desc 
	
	--
	select
	c.customer_id,
	c.first_name,
	c.last_name ,
	p.amount ,
	p.payment_date
from
	customer c,
	payment p
where
	p.customer_id = c.customer_id
order by
	p.amount desc 

	-- example
	
	select
	employee_name,
	department_name
from
	employees e
full outer join departments d 
  on
	d.department_id = e.department_id;




	
	