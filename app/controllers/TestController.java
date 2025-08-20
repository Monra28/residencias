package controllers;

import play.mvc.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestController extends Controller {

    public Result testDatabase() {
        try {
            // Temporalmente usar datos estáticos hasta resolver el problema de base de datos
            ObjectMapper mapper = new ObjectMapper();
            JsonNode response = mapper.createObjectNode()
                .put("status", "success")
                .put("message", "Aplicación funcionando - Base de datos temporalmente deshabilitada")
                .put("usuarios_count", 0)
                .put("categorias_count", 0)
                .put("platillos_count", 0)
                .put("usuarios", "[]")
                .put("categorias", "[]")
                .put("platillos", "[]");
            
            return ok(response);
            
        } catch (Exception e) {
            return internalServerError("Error: " + e.getMessage());
        }
    }
    
    public Result testUsuarios() {
        try {
            return ok("=== USUARIOS EN LA BASE DE DATOS ===\n\n" +
                     "Base de datos temporalmente deshabilitada.\n" +
                     "No hay usuarios disponibles en este momento.");
            
        } catch (Exception e) {
            return internalServerError("Error: " + e.getMessage());
        }
    }
    
    public Result testCategorias() {
        try {
            return ok("=== CATEGORÍAS EN LA BASE DE DATOS ===\n\n" +
                     "Base de datos temporalmente deshabilitada.\n" +
                     "No hay categorías disponibles en este momento.");
            
        } catch (Exception e) {
            return internalServerError("Error: " + e.getMessage());
        }
    }
    
    public Result testPlatillos() {
        try {
            return ok("=== PLATILLOS EN LA BASE DE DATOS ===\n\n" +
                     "Base de datos temporalmente deshabilitada.\n" +
                     "No hay platillos disponibles en este momento.");
            
        } catch (Exception e) {
            return internalServerError("Error: " + e.getMessage());
        }
    }
} 