# Configuración de MySQL para el Proyecto Restaurante

## Requisitos Previos

1. **Instalar MySQL Server**
   - Descargar desde: https://dev.mysql.com/downloads/mysql/
   - O usar: `winget install Oracle.MySQL`
   - O usar XAMPP/WAMP que incluye MySQL

2. **Configurar MySQL**
   - Establecer contraseña root durante la instalación
   - Asegurar que MySQL esté ejecutándose en el puerto 3306

## Pasos para Configurar la Base de Datos

### Opción 1: Usando el Script SQL (Recomendado)

1. **Abrir MySQL Command Line Client o MySQL Workbench**

2. **Ejecutar el script de configuración:**
   ```sql
   source C:\Users\ramon\OneDrive\Documentos\PROYECTOS_RESI\restaurante\database_setup.sql
   ```

### Opción 2: Usando Play Framework Evolutions (Automático)

1. **Asegurar que MySQL esté ejecutándose**

2. **Verificar la configuración en `conf/application.conf`:**
   ```properties
   db.default.driver=com.mysql.cj.jdbc.Driver
   db.default.url="jdbc:mysql://localhost:3306/restaurantes?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true"
   db.default.username="root"
   db.default.password="03or30malra"
   ```

3. **Ejecutar la aplicación:**
   ```bash
   cd restaurante
   sbt run
   ```

   Play Framework creará automáticamente las tablas usando el archivo de evolución.

## Verificar la Conexión

### Usando MySQL Command Line:
```sql
mysql -u root -p
USE restaurantes;
SHOW TABLES;
SELECT * FROM usuarios;
SELECT * FROM categorias;
SELECT * FROM platillos;
```

### Usando la Aplicación:
1. Ejecutar `sbt run`
2. Abrir http://localhost:9000
3. Verificar que no hay errores de conexión en los logs

## Datos de Ejemplo Incluidos

### Usuario Administrador:
- **Email:** admin@restaurante.com
- **Password:** admin123
- **Rol:** ADMIN

### Categorías:
- Entradas
- Platos Principales
- Postres
- Bebidas
- Ensaladas

### Platillos de Ejemplo:
- Ensalada César ($8.50)
- Pasta Carbonara ($15.99)
- Tiramisú ($6.50)
- Limonada Natural ($3.50)
- Sopa de Tomate ($7.99)

## Solución de Problemas

### Error: "Access denied for user 'root'@'localhost'"
- Verificar que la contraseña en `application.conf` sea correcta
- Asegurar que el usuario root tenga permisos

### Error: "Unknown database 'restaurantes'"
- Ejecutar el script `database_setup.sql` primero
- O crear la base de datos manualmente:
  ```sql
  CREATE DATABASE restaurantes CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
  ```

### Error: "Communications link failure"
- Verificar que MySQL esté ejecutándose
- Verificar que el puerto 3306 esté disponible
- Verificar la configuración de firewall

## Configuración de Seguridad (Opcional)

Para producción, crear un usuario específico:
```sql
CREATE USER 'restaurante_user'@'localhost' IDENTIFIED BY 'tu_password_seguro';
GRANT ALL PRIVILEGES ON restaurantes.* TO 'restaurante_user'@'localhost';
FLUSH PRIVILEGES;
```

Luego actualizar `application.conf` con las nuevas credenciales.
