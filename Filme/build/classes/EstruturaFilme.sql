/**
 * Author:  Crispim Paiano dos Santos
 * Created: 08/10/2018
 */

DROP DATABASE IF EXISTS kleitom;
CREATE DATABASE kleitom;
USE kleitom;

CREATE TABLE filmes(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    diretor VARCHAR(100),
    categoria VARCHAR(100),
    atorPrincipal VARCHAR(100),
    faixaEtaria VARCHAR(100),
    idiomaOriginal VARCHAR(100),
    ano SMALLINT UNSIGNED,
    tempoFilme TINYINT UNSIGNED,
    orcamento DOUBLE,
    faturamento DOUBLE,
    legenda BOOLEAN,
    dublado BOOLEAN
    
);