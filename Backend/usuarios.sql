-- Script para crear la base de datos y la tabla de usuarios
CREATE DATABASE IF NOT EXISTS blevelup_db;
USE blevelup_db;

CREATE TABLE IF NOT EXISTS usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    correo VARCHAR(255) NOT NULL UNIQUE,
    usuario VARCHAR(100) NOT NULL UNIQUE,
    contrasena VARCHAR(255) NOT NULL
); 