package controllers;

import models.Platillo;
import models.Categoria;
import play.mvc.*;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class PlatilloController extends Controller {

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/restaurantes?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true",
            "root",
            "03or30malra"
        );
    }

    public Result listar() {
        try {
            List<Platillo> platillos = new ArrayList<>();
            List<Categoria> categorias = new ArrayList<>();
            
            // Cargar platillos desde la base de datos
            try (Connection conn = getConnection();
                 PreparedStatement stmt = conn.prepareStatement("SELECT * FROM platillos");
                 ResultSet rs = stmt.executeQuery()) {
                
                while (rs.next()) {
                    Platillo platillo = new Platillo();
                    platillo.setId(rs.getLong("id"));
                    platillo.setNombre(rs.getString("nombre"));
                    platillo.setCategoria(rs.getString("categoria"));
                    platillo.setDescripcion(rs.getString("descripcion"));
                    platillo.setPrecio(rs.getBigDecimal("precio"));
                    platillo.setImagenUrl(rs.getString("imagen_url"));
                    platillo.setDisponible(rs.getBoolean("disponible"));
                    platillos.add(platillo);
                }
            }
            
            // Cargar categorías desde la base de datos
            try (Connection conn = getConnection();
                 PreparedStatement stmt = conn.prepareStatement("SELECT * FROM categorias");
                 ResultSet rs = stmt.executeQuery()) {
                
                while (rs.next()) {
                    Categoria categoria = new Categoria();
                    categoria.setId(rs.getLong("id"));
                    categoria.setNombre(rs.getString("nombre"));
                    categoria.setDescripcion(rs.getString("descripcion"));
                    categoria.setActiva(rs.getBoolean("activa"));
                    categorias.add(categoria);
                }
            }
            
            return ok(views.html.platillos.render(platillos, categorias));
            
        } catch (Exception e) {
            // Si hay error, mostrar página sin datos
            return ok(views.html.platillos.render(new ArrayList<>(), new ArrayList<>()));
        }
    }

    public Result obtener(Long id) {
        try {
            try (Connection conn = getConnection();
                 PreparedStatement stmt = conn.prepareStatement("SELECT * FROM platillos WHERE id = ?")) {
                
                stmt.setLong(1, id);
                ResultSet rs = stmt.executeQuery();
                
                if (rs.next()) {
                    String nombre = rs.getString("nombre");
                    String precio = rs.getBigDecimal("precio").toString();
                    return ok("Platillo encontrado: " + nombre + " - $" + precio);
                } else {
                    return notFound("Platillo no encontrado");
                }
            }
        } catch (Exception e) {
            return internalServerError("Error: " + e.getMessage());
        }
    }

    public Result crear(Http.Request request) {
        try {
            // Obtener datos del formulario
            String nombre = request.body().asFormUrlEncoded().get("nombre")[0];
            String categoria = request.body().asFormUrlEncoded().get("categoria")[0];
            String descripcion = request.body().asFormUrlEncoded().get("descripcion")[0];
            String precioStr = request.body().asFormUrlEncoded().get("precio")[0];
            String imagenUrl = request.body().asFormUrlEncoded().get("imagenUrl")[0];
            String disponibleStr = request.body().asFormUrlEncoded().get("disponible")[0];
            
            // Insertar en la base de datos
            try (Connection conn = getConnection();
                 PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO platillos (nombre, categoria, descripcion, precio, imagen_url, disponible) VALUES (?, ?, ?, ?, ?, ?)")) {
                
                stmt.setString(1, nombre);
                stmt.setString(2, categoria);
                stmt.setString(3, descripcion);
                stmt.setBigDecimal(4, new java.math.BigDecimal(precioStr));
                stmt.setString(5, imagenUrl);
                stmt.setBoolean(6, "on".equals(disponibleStr));
                
                stmt.executeUpdate();
            }
            
            return redirect("/platillos");
            
        } catch (Exception e) {
            return internalServerError("Error al crear platillo: " + e.getMessage());
        }
    }

    public Result actualizar(Long id, Http.Request request) {
        try {
            // Obtener datos del formulario
            String nombre = request.body().asFormUrlEncoded().get("nombre")[0];
            String categoria = request.body().asFormUrlEncoded().get("categoria")[0];
            String descripcion = request.body().asFormUrlEncoded().get("descripcion")[0];
            String precioStr = request.body().asFormUrlEncoded().get("precio")[0];
            String imagenUrl = request.body().asFormUrlEncoded().get("imagenUrl")[0];
            String disponibleStr = request.body().asFormUrlEncoded().get("disponible")[0];
            
            // Actualizar en la base de datos
            try (Connection conn = getConnection();
                 PreparedStatement stmt = conn.prepareStatement(
                     "UPDATE platillos SET nombre=?, categoria=?, descripcion=?, precio=?, imagen_url=?, disponible=? WHERE id=?")) {
                
                stmt.setString(1, nombre);
                stmt.setString(2, categoria);
                stmt.setString(3, descripcion);
                stmt.setBigDecimal(4, new java.math.BigDecimal(precioStr));
                stmt.setString(5, imagenUrl);
                stmt.setBoolean(6, "on".equals(disponibleStr));
                stmt.setLong(7, id);
                
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    return redirect("/platillos");
                } else {
                    return notFound("Platillo no encontrado");
                }
            }
            
        } catch (Exception e) {
            return internalServerError("Error al actualizar platillo: " + e.getMessage());
        }
    }

    public Result eliminar(Long id) {
        try {
            try (Connection conn = getConnection();
                 PreparedStatement stmt = conn.prepareStatement("DELETE FROM platillos WHERE id = ?")) {
                
                stmt.setLong(1, id);
                int rowsAffected = stmt.executeUpdate();
                
                if (rowsAffected > 0) {
                    return ok("Platillo eliminado correctamente");
                } else {
                    return notFound("Platillo no encontrado");
                }
            }
        } catch (Exception e) {
            return internalServerError("Error al eliminar platillo: " + e.getMessage());
        }
    }
} 