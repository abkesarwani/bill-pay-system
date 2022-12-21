INSERT INTO Biller(name) VALUES  
('internet'), 
('electicity'),
('gas connection'),
('mobile bill');


INSERT INTO Biller_Wallet (biller_id , amount) VALUES  
(1,1000), 
(2,1000), 
(3,1000), 
(4,1000);


INSERT INTO Customer(id,email) VALUES  
(1,'abhi@gmail.com'), 
(2,'abhishek@gmail.com');

INSERT INTO Customer_Wallet (cust_id, amount) VALUES  
(1,1000), 
(2,1000);



INSERT INTO Biller_Data (biller_id,cust_id,amount_to_paid,month_year) VALUES  
(1,1,1000,'DECEMBER-2022'), 
(2,1,1500,'DECEMBER-2022'), 
(3,1,800,'DECEMBER-2022'), 
(4,1,1000,'DECEMBER-2022'),
(1,2,1000,'DECEMBER-2022'), 
(2,2,1700,'DECEMBER-2022'), 
(3,2,850,'DECEMBER-2022'), 
(4,2,1080,'DECEMBER-2022');
