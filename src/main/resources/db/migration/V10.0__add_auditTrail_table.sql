CREATE TABLE audit_trail (
  id BIGINT NOT NULL AUTO_INCREMENT,
  sale_id BIGINT,
  account_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (account_id) REFERENCES account(id),
    CONSTRAINT fk_sale_id FOREIGN KEY(sale_id) REFERENCES sale(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);