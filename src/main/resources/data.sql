INSERT INTO DEVICE_TYPE VALUES ('1', 'Windows Server');
INSERT INTO DEVICE_TYPE VALUES ('2', 'Windows Workstation');
INSERT INTO DEVICE_TYPE VALUES ('3', 'Mac');
INSERT INTO DEVICE VALUES ('1', 'SystemName1', '1');
INSERT INTO DEVICE VALUES ('2', 'SystemName2', '2');
INSERT INTO DEVICE VALUES ('3', 'SystemName3', '3');
INSERT INTO SERVICE_TYPE  VALUES ('1', 4, 'Mainteinance', '1');
INSERT INTO SERVICE_TYPE  VALUES ('2', 5, 'Backup', '1');
INSERT INTO SERVICE_TYPE  VALUES ('3', 6, 'Antivirus', '1');
INSERT INTO SERVICE_TYPE  VALUES ('4', 2, 'Mainteinance', '2');
INSERT INTO SERVICE_TYPE  VALUES ('5', 3, 'Backup', '2');
INSERT INTO SERVICE_TYPE  VALUES ('6', 4, 'Antivirus', '2');
INSERT INTO SERVICE_TYPE  VALUES ('7', 7, 'Mainteinance', '3');
INSERT INTO SERVICE_TYPE  VALUES ('8', 5, 'Backup', '3');
INSERT INTO SERVICE_TYPE  VALUES ('9', 8, 'Antivirus', '3');
INSERT INTO CUSTOMER VALUES ('1', 'Address1', 'Customer1');
INSERT INTO CUSTOMER_DEVICE VALUES ('1', 4, '1', '1');
INSERT INTO CUSTOMER_DEVICE VALUES ('2', 2, '1', '3');