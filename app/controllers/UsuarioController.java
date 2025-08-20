package controllers;

import play.mvc.*;
import play.libs.Json;
import com.fasterxml.jackson.databind.JsonNode;
import models.Usuario;
import java.util.List;
import java.util.Optional;

public class UsuarioController extends Controller {

    public Result listar() {
        // Simulación de lista de usuarios (en un caso real usarías la base de datos)
        return ok("Lista de usuarios - Funciona correctamente");
    }

    public Result obtener(Long id) {
        return ok("Usuario con id: " + id + " - Funciona correctamente");
    }

    public Result crear(Http.Request request) {
        JsonNode json = request.body().asJson();
        if (json == null) {
            return badRequest("Se esperaba JSON");
        }
        
        String nombre = json.findPath("nombre").asText();
        String email = json.findPath("email").asText();
        String password = json.findPath("password").asText();
        String rol = json.findPath("rol").asText("USUARIO");
        
        // Aquí normalmente validarías y guardarías en la base de datos
        return ok("Usuario creado: " + nombre + " - Funciona correctamente");
    }

    public Result actualizar(Long id, Http.Request request) {
        JsonNode json = request.body().asJson();
        if (json == null) {
            return badRequest("Se esperaba JSON");
        }
        
        // Aquí normalmente actualizarías en la base de datos
        return ok("Usuario actualizado: " + id + " - Funciona correctamente");
    }

    public Result eliminar(Long id) {
        // Aquí normalmente eliminarías de la base de datos
        return ok("Usuario eliminado: " + id + " - Funciona correctamente");
    }

    public Result vistaUsuarios() {
        return ok(views.html.usuarios.render());
    }

    public Result buscarPorEmail(String email) {
        return ok("Buscando usuario con email: " + email + " - Funciona correctamente");
    }

    public Result cambiarEstado(Long id) {
        return ok("Estado del usuario " + id + " cambiado - Funciona correctamente");
    }
}
