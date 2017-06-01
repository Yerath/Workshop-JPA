CREATE TABLE audit_trail (
  id BIGINT NOT NULL,
  sale_id BIGINT,
  account_id BIGINT,
  PRIMARY KEY (id)
);

ALTER TABLE sale
ADD COLUMN audit_trail_id BIGINT NOT NULL,
ADD FOREIGN KEY (audit_trail_id) REFERENCES audit_trail(id);