CREATE TABLE cliente (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(40) NOT NULL,
    cpf VARCHAR(50) NOT NULL,
    ativo TINYINT NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE gerente (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(40) NOT NULL,
    email VARCHAR(50) NOT NULL,
    senha VARCHAR(18) NOT NULL,
    ativo TINYINT NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE conta (
    id BIGINT NOT NULL, 
    email VARCHAR(50) NOT NULL,
    senha VARCHAR(18) NOT NULL,
    saldo DOUBLE NOT NULL,
    ativo TINYINT NOT NULL,
    gerenteid BIGINT,

    PRIMARY KEY (id),
    FOREIGN KEY (id) REFERENCES cliente(id),
    FOREIGN KEY (gerenteid) REFERENCES gerente(id)
);