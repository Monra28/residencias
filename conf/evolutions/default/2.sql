# --- !Ups

ALTER TABLE categorias
    ADD COLUMN imagen_url VARCHAR(255) AFTER descripcion;

ALTER TABLE platillos
    ADD COLUMN calificacion DECIMAL(2,1) DEFAULT 0.0 AFTER disponible,
    ADD COLUMN num_calificaciones INT DEFAULT 0 AFTER calificacion;

CREATE TABLE IF NOT EXISTS usuario_platillo_favoritos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    usuario_id BIGINT NOT NULL,
    platillo_id BIGINT NOT NULL,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE,
    FOREIGN KEY (platillo_id) REFERENCES platillos(id) ON DELETE CASCADE,
    UNIQUE (usuario_id, platillo_id)
);

-- Índices para mejorar el rendimiento
CREATE INDEX IF NOT EXISTS idx_platillos_categori-id ON platillos(categori-id);
CREATE INDEX IF NOT EXISTS idx_favoritos_usuario_id ON usuario_platillo_favoritos(usuario_id);
CREATE INDEX IF NOT EXISTS idx_favoritos_platillo_id ON usuario_platillo_favoritos(platillo_id);

-- Actualizar platillos existentes para asignar categorías
UPDATE platillos SET categori-id = (SELECT id FROM categorias WHERE nombre = platillos.categoria) WHERE categori-id IS NULL;

ALTER TABLE platillos DROP COLUMN categoria;

# --- !Downs

ALTER TABLE platillos
    DROP COLUMN calificacion,
    DROP COLUMN num_calificaciones;

ALTER TABLE categorias
    DROP COLUMN imagen_url;

DROP TABLE IF EXISTS usuario_platillo_favoritos;
