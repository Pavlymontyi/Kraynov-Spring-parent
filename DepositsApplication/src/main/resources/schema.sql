CREATE TABLE BANKS(
  ID          INTEGER     NOT NULL AUTO_INCREMENT,
  NAME        VARCHAR(45) NOT NULL,
  PRIMARY KEY(ID)
);

CREATE TABLE BANK_PRODUCTS(
  ID          INT         NOT NULL AUTO_INCREMENT,
  BANK_ID     INT         NOT NULL,
  NAME        VARCHAR(45) NOT NULL,
  URL         VARCHAR(255),
  version     INT,
  PRIMARY KEY (ID),
  CONSTRAINT FK_BANK_PRODUCTS_1 FOREIGN KEY(BANK_ID)
  REFERENCES BANKS(ID)
);

CREATE TABLE CLIENTS(
  LOGIN       VARCHAR(255) NOT NULL,
  PASSWORD    VARCHAR(45)  NOT NULL,
  PRIMARY KEY (LOGIN)
);

CREATE TABLE DEPOSITS(
  ID          INT         NOT NULL AUTO_INCREMENT,
  OPENED_WHEN DATE,
  PRODUCT_ID  INT         NOT NULL,
  LOGIN       VARCHAR(255) NOT NULL,
  PRIMARY KEY (ID),
  CONSTRAINT FK_DEPOSITS_1 FOREIGN KEY(PRODUCT_ID)
  REFERENCES BANK_PRODUCTS(ID),
  CONSTRAINT FK_DEPOSITS_2 FOREIGN KEY(LOGIN)
  REFERENCES CLIENTS(LOGIN)
);

CREATE TABLE INCOMES(
  ID          INT         NOT NULL AUTO_INCREMENT,
  DEPOSIT_ID  INT,
  VALUE       INT         NOT NULL,
  INCOME_DATE DATE,
  PRIMARY KEY (ID),
  CONSTRAINT FK_INCOMES_1 FOREIGN KEY(DEPOSIT_ID)
  REFERENCES DEPOSITS(ID)
);

--todo: change type for column VALUE of INCOMES table