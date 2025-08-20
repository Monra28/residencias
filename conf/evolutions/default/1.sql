# --- !Ups

-- Crear tabla de usuarios
CREATE TABLE IF NOT EXISTS usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    rol VARCHAR(50) NOT NULL DEFAULT 'USUARIO',
    telefono VARCHAR(20),
    direccion TEXT,
    activo BOOLEAN NOT NULL DEFAULT TRUE,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_modificacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Crear tabla de categorías
CREATE TABLE IF NOT EXISTS categorias (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    activa BOOLEAN NOT NULL DEFAULT TRUE,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_modificacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Crear tabla de platillos
CREATE TABLE IF NOT EXISTS platillos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    descripcion TEXT,
    precio DECIMAL(10,2) NOT NULL,
    imagen_url VARCHAR(255),
    disponible BOOLEAN NOT NULL DEFAULT TRUE,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_modificacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Insertar datos de ejemplo para categorías
INSERT INTO categorias (nombre, descripcion) VALUES
('Entradas', 'Platos pequeños para comenzar la comida'),
('Platos Principales', 'Platos fuertes y principales'),
('Postres', 'Dulces y postres deliciosos'),
('Bebidas', 'Refrescos, jugos y bebidas'),
('Ensaladas', 'Ensaladas frescas y saludables');

-- Insertar datos de ejemplo para platillos
INSERT INTO platillos (nombre, categoria, descripcion, precio, imagen_url) VALUES
('Ensalada César', 'Ensaladas', 'Lechuga romana, crutones, parmesano y aderezo César', 8.50, '/images/ensalada-cesar.jpg'),
('Pasta Carbonara', 'Platos Principales', 'Pasta con salsa cremosa, panceta y parmesano', 15.99, '/images/pasta-carbonara.jpg'),
('Tiramisú', 'Postres', 'Postre italiano con café y mascarpone', 6.50, '/images/tiramisu.jpg'),
('Limonada Natural', 'Bebidas', 'Limonada fresca con menta', 3.50, '/images/limonada.jpg'),
('Sopa de Tomate', 'Entradas', 'Sopa cremosa de tomate con albahaca', 7.99, '/images/sopa-tomate.jpg');

-- Insertar usuario administrador de ejemplo
INSERT INTO usuarios (nombre, email, password, rol, telefono) VALUES
('Administrador', 'admin@restaurante.com', 'admin123', 'ADMIN', '123456789');

-- Crear índices para mejorar el rendimiento
CREATE INDEX idx_usuarios_email ON usuarios(email);
CREATE INDEX idx_platillos_categoria ON platillos(categoria);
CREATE INDEX idx_platillos_disponible ON platillos(disponible);
CREATE INDEX idx_categorias_activa ON categorias(activa);

# --- !Downs

DROP TABLE IF EXISTS platillos;
DROP TABLE IF EXISTS categorias;
DROP TABLE IF EXISTS usuarios;

