CREATE TABLE T_CUSTOMER (
    CUST_ID          BIGSERIAL       PRIMARY KEY,
    CUST_FIRST_NAME  VARCHAR(100)    NOT NULL,
    CUST_LAST_NAME   VARCHAR(100)    NOT NULL,
    EMAIL_ADDR       VARCHAR(200)    UNIQUE NOT NULL,
    CREATED_AT       TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE T_PRODUCT (
    PROD_ID          BIGSERIAL       PRIMARY KEY,
    PROD_NAME        VARCHAR(150)    NOT NULL,
    PROD_DESC        VARCHAR(500),
    UNIT_PRICE_CENTS INT             NOT NULL CHECK (UNIT_PRICE_CENTS >= 0),
    ACTIVE_FLAG      CHAR(1)         NOT NULL DEFAULT 'Y'
);

CREATE TABLE T_ORDER (
    ORDER_ID         BIGSERIAL       PRIMARY KEY,
    ORDER_NUMBER     VARCHAR(50)     NOT NULL UNIQUE,
    ORDER_DATE       DATE            NOT NULL,
    CUSTOMER_ID      BIGINT          NOT NULL REFERENCES T_CUSTOMER(CUST_ID),
    STATUS_CODE      VARCHAR(20)     NOT NULL
);

CREATE TABLE T_ORDER_LINE (
    ORDER_LINE_ID    BIGSERIAL       PRIMARY KEY,
    ORDER_ID         BIGINT          NOT NULL REFERENCES T_ORDER(ORDER_ID),
    LINE_NUMBER      INT             NOT NULL,
    PRODUCT_ID       BIGINT          NOT NULL REFERENCES T_PRODUCT(PROD_ID),
    QTY              INT             NOT NULL CHECK (QTY > 0),
    LINE_TOTAL_CENTS INT             NOT NULL CHECK (LINE_TOTAL_CENTS >= 0)
);

INSERT INTO T_CUSTOMER (CUST_FIRST_NAME, CUST_LAST_NAME, EMAIL_ADDR)
VALUES
('Anna', 'Svensson', 'anna.svensson@example.com'),
('Björn', 'Lindberg', 'bjorn.lindberg@example.com'),
('Carina', 'Håkansson', 'carina.hakansson@example.com'),
('David', 'Johansson', 'david.johansson@example.com'),
('Elin', 'Karlsson', 'elin.karlsson@example.com');

INSERT INTO T_PRODUCT (PROD_NAME, PROD_DESC, UNIT_PRICE_CENTS, ACTIVE_FLAG)
VALUES
('USB-C Cable', '1m charging cable', 12900, 'Y'),
('Laptop Stand', 'Aluminium portable stand', 49900, 'Y'),
('Gaming Mouse', 'Ergonomic RGB mouse', 34900, 'Y'),
('Noise Cancelling Headphones', 'ANC over-ear', 129900, 'Y'),
('HDMI Adapter', 'USB-C to HDMI', 19900, 'N');

INSERT INTO T_ORDER (ORDER_NUMBER, ORDER_DATE, CUSTOMER_ID, STATUS_CODE)
VALUES
('ORD-1001', '2025-01-10', 1, 'CREATED'),
('ORD-1002', '2025-01-12', 2, 'SHIPPED'),
('ORD-1003', '2025-01-15', 1, 'DELIVERED'),
('ORD-1004', '2025-01-18', 3, 'CREATED');

INSERT INTO T_ORDER_LINE (ORDER_ID, LINE_NUMBER, PRODUCT_ID, QTY, LINE_TOTAL_CENTS)
VALUES
-- Order 1001
(1, 1, 1, 2, 2 * 12900),
(1, 2, 2, 1, 49900),

-- Order 1002
(2, 1, 3, 1, 34900),
(2, 2, 5, 1, 19900),

-- Order 1003
(3, 1, 4, 1, 129900),

-- Order 1004
(4, 1, 1, 1, 12900),
(4, 2, 3, 1, 34900);
