CREATE TABLE orders(
  orderid int NOT NULL,
  custname varchar(20) DEFAULT NULL,
  PRIMARY KEY (orderid)
);

CREATE TABLE shippingaddress(
  addressid int NOT NULL,
  houseno varchar(20) DEFAULT NULL,
  city varchar(20) DEFAULT NULL,
  pincode varchar(20) DEFAULT NULL,
  PRIMARY KEY (addressId)
);

CREATE TABLE item(
  itemid int NOT NULL,
  itemname varchar(20) DEFAULT NULL,
  itemprice double DEFAULT NULL,
  PRIMARY KEY (itemId)
);