package controllers;

import play.mvc.*;

public class Categoriacontorller extends Controller {

    public Result listar() {
        return ok("Lista de categorías - Funciona correctamente");
    }

    public Result obtener(Long id) {
        return ok("Categoría con id: " + id + " - Funciona correctamente");
    }

    public Result crear(Http.Request request) {
        return ok("Crear categoría - Funciona correctamente");
    }

    public Result actualizar(Long id, Http.Request request) {
        return ok("Actualizar categoría: " + id + " - Funciona correctamente");
    }

    public Result eliminar(Long id) {
        return ok("Eliminar categoría: " + id + " - Funciona correctamente");
    }
}
