DROP TABLE IF EXISTS TB_EXCHANGE_TYPE;

CREATE TABLE TB_EXCHANGE(
ID INT AUTO_INCREMENT PRIMARY KEY,
CURRENCY_TYPE VARCHAR(3) NOT NULL,
CURRENCY_TYPE_DESCRIPTION VARCHAR(40) NOT NULL,
CURRENCY_EXCHANGE_RATE DOUBLE NOT NULL
);

INSERT INTO TB_EXCHANGE(CURRENCY_TYPE,CURRENCY_TYPE_DESCRIPTION,CURRENCY_EXCHANGE_RATE)values
('PEN','Nuevo Sol','0.2477'),
('EUR','Euro','4.541465'),
('JPY','Yen','0.035501'),
('CNY','Yuan','0.632098'),
('USD','Dólar','4.0360');