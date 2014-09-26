-- create table invoice_bill (invoice_id bigint not null, bills_id bigint not null, billid bigint, primary key (invoice_id, billid))
INSERT INTO invoice_bill VALUES
  (1, 1, 50.0),
  (2, 2, 25.23),
  (2, 3, 12.23),
  (4, 4, 76.10),
  (7, 5, 37.45);

-- create table invoice_ec (invoice_id bigint not null, ecpayment_id bigint not null, ecid bigint, primary key (invoice_id, ecid))
INSERT INTO invoice_ec VALUES
  (1, 1, 9.49),
  (1, 2, 21.50),
  (2, 3, 4.99),
  (2, 4, 5.99),
  (3, 5, 6.00),
  (3, 6, 14.35),
  (4, 7, 56.02),
  (4, 8, 100.23),
  (5, 9, 9.49),
  (5, 10, 21.50),
  (6, 11, 4.99),
  (6, 12, 5.99),
  (7, 13, 6.00),
  (7, 14, 14.35),
  (8, 15, 5.23),
  (8, 16, 14.00),
  (9, 17, 15.00),
  (9, 18, 47.34);

--  create table car (id bigint generated by default as identity, available boolean not null, badge varchar(255), primary key (id))

--  create table driver (id bigint generated by default as identity, birthDay date, firstname varchar(25), lastname varchar(25), primary key (id))
INSERT INTO driver VALUES
  (1, CURDATE(), 'Konrad', 'Ott'),
  (2, CURDATE(), 'Sven', 'Klemmer'),
  (3, CURDATE(), 'Sample', 'Driver 1'),
  (4, CURDATE(), 'Sample', 'Driver 2'),
  (5, CURDATE(), 'Sample', 'Driver 3'),
  (6, CURDATE(), 'Sample', 'Driver 4'),
  (7, CURDATE(), 'Sample', 'Driver 5'),
  (8, CURDATE(), 'Sample', 'Driver 6'),
  (9, CURDATE(), 'Sample', 'Driver 7');

--  create table invoice (id bigint generated by default as identity, date date, income decimal(19,2), state integer, car_id bigint, driver_id bigint, store_id bigint, primary key (id))
INSERT INTO invoice VALUES
  (1, CURDATE(), 111.01, 0, 1, 9, 1),
  (2, CURDATE(), 222.20, 0, 2, 8, 2),
  (3, CURDATE(), 333.03, 0, 3, 7, 3),
  (4, CURDATE(), 444.40, 0, 4, 6, 1),
  (5, CURDATE(), 555.05, 0, 5, 5, 2),
  (6, CURDATE(), 666.60, 0, 6, 4, 3),
  (7, CURDATE(), 777.07, 0, 7, 3, 1),
  (8, CURDATE(), 888.80, 0, 8, 2, 2),
  (9, CURDATE(), 999.09, 0, 9, 1, 3);

--  create table chef (id bigint generated by default as identity, firstname varchar(255), lastname varchar(255), primary key (id))
INSERT INTO chef VALUES (1, 'Konrad', 'Ott');

--  create table chef_store (chef_id bigint not null, stores_id bigint not null, storeid bigint not null, primary key (chef_id, storeid))
INSERT INTO chef_store VALUES (1, 1, 1), (1, 2, 2), (1, 3, 3);

--  create table store (id bigint generated by default as identity, store_key varchar(255), store_type integer, primary key (id))
INSERT INTO store VALUES (1, 'Sample Store 1', 0), (2, 'Sample Store 2', 1), (3, 'Sample Store 3', 1);

--  create table store_car (store_id bigint not null, car_id bigint not null, carid bigint not null, primary key (store_id, carid))
INSERT INTO store_car
VALUES (1, 1, 1), (1, 2, 2), (1, 3, 3), (2, 4, 4), (2, 5, 5), (2, 6, 6), (3, 7, 7), (3, 8, 8), (3, 9, 9);

--  create table store_driver (store_id bigint not null, driver_id bigint not null, driverid bigint not null, primary key (store_id, driverid))
INSERT INTO store_driver VALUES
  (1, 1, 1),
  (1, 2, 2),
  (1, 3, 3),
  (2, 4, 4),
  (2, 5, 5),
  (2, 6, 6),
  (3, 7, 7),
  (3, 8, 8),
  (3, 9, 9);

--  create table store_invoice (store_id bigint not null, invoice_id bigint not null, invoiceid bigint not null, primary key (store_id, invoiceid))
INSERT INTO store_invoice VALUES
  (1, 1, 1),
  (2, 2, 2),
  (3, 3, 3),
  (1, 4, 4),
  (2, 5, 5),
  (3, 6, 6),
  (1, 7, 7),
  (2, 8, 8),
  (3, 9, 9);

-- create table car (id bigint generated by default as identity, available boolean not null, badge varchar(255), primary key (id))
INSERT INTO car VALUES (1, TRUE, 'A-BC-001'), (2, TRUE, 'A-BC-002'), (3, TRUE, 'A-BC-003'), (4, TRUE, 'A-BC-004'),
  (5, TRUE, 'A-BC-005'), (6, TRUE, 'A-BC-006'), (7, TRUE, 'A-BC-007'), (8, TRUE, 'A-BC-008'), (9, TRUE, 'A-BC-009');

-- create table store (id bigint generated by default as identity, store_key varchar(255), store_type integer, chef_id bigint, primary key (id))
--  create table chef (id bigint generated by default as identity, firstname varchar(255), lastname varchar(255), primary key (id))

--  create table driver (id bigint generated by default as identity, birthDay date, firstname varchar(25), lastname varchar(25), primary key (id))

--  create table invoice (id bigint generated by default as identity, date date, income double, state integer, car_id bigint, driver_id bigint, store_id bigint, primary key (id))
-- create table invoice_bill (Invoice_id bigint not null, bills double)
-- create table invoice_ec (Invoice_id bigint not null, ecpayment double)

--  create table junit_person (id bigint generated by default as identity, value varchar(255), primary key (id))
