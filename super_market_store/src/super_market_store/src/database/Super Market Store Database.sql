create database super_market_store_system;
use super_market_store_system;

create table user(
	id int(11) not null auto_increment primary key,
	first_Name varchar(30),
    last_Name varchar(30),
    phone_number bigint,
    email varchar(20),
    user_password varchar(20),
    created_date date,
    modified_date date,
    created_by varchar(30),
    updated_by varchar(30),
    bool_active boolean
    
);

create table category(
	id int(11) not null auto_increment primary key,
    category_name varchar(50),
    category_code varchar(30),
    created_date date,
    modified_date date,
    created_by varchar(30),
    updated_by varchar(30),
    bool_active boolean
);

create table product(
	id int(11) not null auto_increment primary key,
    product_name varchar(40),
    category_id int(11) not null,
    brand varchar(30),
    product_description text,
    created_date date,
    modified_date date,
    created_by varchar(30),
    updated_by varchar(30),
    bool_active boolean,
    foreign key(category_id) references category(id)
);

create table customer_dealer(
	id int(11) not null primary key,
    customer_dealer_name varchar(50),
    email varchar(50),
    phone_number bigint,
    address text,
    created_date date,
    modified_date date,
    created_by varchar(30),
    updated_by varchar(30),
    bool_active boolean
);

create table stock(
	id int(11) not null auto_increment primary key,
    product_id int(11),
    product_quantity int(11),
    unit_purchase_price decimal,
    unit_sell_price decimal,
    dealer_id int(11),
    product_status enum('Available','Unavailable'),
    created_date date,
    modified_date date,
    created_by varchar(30),
    updated_by varchar(30),
    bool_active boolean,
    foreign key(product_id) references product(id),
    foreign key(dealer_id) references customer_dealer(id)
);

create table transaction(
	id int(11) not null auto_increment primary key,
    transcation_type enum('Purchase','Sale'),
    transaction_date date,
    transaction_no varchar(30),
    customer_dealer_id int(11),
    discount decimal,
    tax decimal,
    grand_total decimal,
    payment_method enum('Cash','Card'),
    payment_status enum('Paid','Unpaid'),
    created_date date,
    modified_date date,
    created_by varchar(30),
    updated_by varchar(30),
    bool_active boolean,
    foreign key(customer_dealer_id) references customer_dealer(id)

);

UPDATE Transaction
SET transaction_no = CONCAT(
    'SMS-',
    DATE_FORMAT(NOW(), '%Y%m%d%H%i%s'),
    id
);


create table transactionDetail(
	id int(11) not null auto_increment primary key,
    transaction_id int(11),
    product_id int(11),
    quatity int(11),
    price int(11),
    created_date date,
    modified_date date,
    created_by varchar(30),
    updated_by varchar(30),
    bool_active boolean,
    foreign key(transaction_id) references transaction(id),
    foreign key(product_id) references product(id)
);

alter table transactiondetail rename transaction_detail;
