CREATE TABLE Product(
	id SERIAL PRIMARY KEY,
	name VARCHAR(50) not null,
	price DEC(10,2) not null,
	stock_quantity int default 0
)

INSERT INTO Product (name, price, stock_quantity) VALUES
('Laptop', 1200.50, 10),
('Smartphone', 699.99, 25),
('Headphones', 89.99, 50),
('Tablet', 329.99, 15),
('Smartwatch', 199.99, 30),
('Keyboard', 49.99, 40),
('Mouse', 29.99, 60),
('Monitor', 249.99, 20),
('External Hard Drive', 99.99, 35),
('Printer', 149.99, 12);

select name,price from Product

select * from product where price > 500

select * from product where stock_quantity < 20

select * from product order by price desc limit 1

update product set price = price * 1.1

update product set stock_quantity = stock_quantity-5 where name = 'Keyboard'

update product set name = 'Type-C Cable' where name = 'USB Cable'

update product set stock_quantity = 0 where price > 2000

delete from product where name = 'Mouse'

delete from product where stock_quantity = 0

delete from product where price < 50

delete from product
