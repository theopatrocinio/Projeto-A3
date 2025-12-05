-- Criar o banco de dados se não existir
CREATE DATABASE IF NOT EXISTS sistema_curadoria;
USE sistema_curadoria;

-- Tabela de usuários
CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    idade INT NOT NULL,
    tipo ENUM('Administrador', 'Usuario') NOT NULL,
    login VARCHAR(50) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL, -- tamanho maior para hash
    ativo BOOLEAN DEFAULT TRUE
);

-- Tabela de interesses dos usuários
CREATE TABLE usuario_interesses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    interesse ENUM('IA Responsável', 'Cibersegurança', 'Privacidade & Ética Digital'),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE
);

-- Tabela de recursos
CREATE TABLE recursos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    categoria VARCHAR(100) NOT NULL,
    usuario_id INT NOT NULL,
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
        ON DELETE CASCADE
);

-- Inserir administrador padrão
INSERT INTO usuarios (nome, idade, tipo, login, senha) VALUES 
('Administrador', 30, 'Administrador', 'admin', 'admin123');
-- Inserir aluno padrão
INSERT INTO usuarios (nome, idade, tipo, login, senha) VALUES
('Aluno Exemplo', 20, 'Usuario', 'aluno', 'aluno123');
-- Inserir interesses do administrador (opcional)
INSERT INTO usuario_interesses (usuario_id, interesse) VALUES 
(1, 'IA Responsável'),
(1, 'Cibersegurança');

-- Consultas para conferência
SHOW TABLES;
SHOW DATABASES;
SELECT * FROM usuarios;
SELECT * FROM recursos;
SELECT * FROM usuario_interesses;
