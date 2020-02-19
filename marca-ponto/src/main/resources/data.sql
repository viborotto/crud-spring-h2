DROP TABLE IF EXISTS usuarios;

CREATE TABLE usuarios (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  nomeCompleto VARCHAR(250) NOT NULL,
  cpf VARCHAR(250) NOT NULL,
  email VARCHAR(250) DEFAULT NULL,
  dataCadastro DATE NOT NULL
);

INSERT INTO usuarios (nomeCompleto, cpf, email, dataCadastro) VALUES
  ('Vittoria', '1298398138', 'vittoriaborotto@gmail.com', 20200219);