-- Script para verificar la conexión y datos de la base de datos
-- Ejecutar en MySQL Workbench

-- Verificar si la base de datos existe
SHOW DATABASES LIKE 'restaurantes';

-- Usar la base de datos
USE restaurantes;

-- Verificar que estamos en la base de datos correcta
SELECT DATABASE() as current_database;

-- Verificar si las tablas existen
SHOW TABLES;

-- Verificar datos en las tablas
SELECT 'USUARIOS:' as tabla;
SELECT COUNT(*) as total_usuarios FROM usuarios;
SELECT id, nombre, email, rol FROM usuarios LIMIT 5;

SELECT 'CATEGORIAS:' as tabla;
SELECT COUNT(*) as total_categorias FROM categorias;
SELECT * FROM categorias;

SELECT 'PLATILLOS:' as tabla;
SELECT COUNT(*) as total_platillos FROM platillos;
SELECT id, nombre, categoria, precio, disponible FROM platillos LIMIT 5;
