CREATE EXTENSION IF NOT EXISTS "pgcrypto";


CREATE TABLE pontos_interesse (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nome VARCHAR(30) NOT NULL,
    x INT NOT NULL,
    y INT NOT NULL
);