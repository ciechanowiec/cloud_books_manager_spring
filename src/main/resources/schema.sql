CREATE TABLE IF NOT EXISTS books (
  id INT NOT NULL AUTO_INCREMENT,
  title VARCHAR(300) NULL DEFAULT 'unknown',
  author VARCHAR(300) NULL DEFAULT 'unknown',
  price DOUBLE NULL DEFAULT 0,
  PRIMARY KEY (id));