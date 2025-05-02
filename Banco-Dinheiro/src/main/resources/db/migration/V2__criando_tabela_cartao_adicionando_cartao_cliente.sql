CREATE TABLE cartao (
    id BIGINT NOT NULL AUTO_INCREMENT,
    numero VARCHAR(16) NOT NULL,
    ativo TINYINT NOT NULL,
    limite DOUBLE NOT NULL,
    tipocartao TINYINT NOT NULL,
    titular BIGINT NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (titular) REFERENCES conta(id)
);

ALTER TABLE conta 
    ADD COLUMN tipoconta TINYINT NOT NULL;