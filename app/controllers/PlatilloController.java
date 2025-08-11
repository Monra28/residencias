package controllers;

import play.mvc.*;

public class PlatilloController extends Controller {

    public Result listar() {
        return ok(views.html.platillos.render());
    }

    public Result obtener(Long id) {
        return ok("Platillo con id: " + id + " - Funciona correctamente");
    }

    public Result crear(Http.Request request) {
        return ok("Crear platillo - Funciona correctamente");
    }

    public Result actualizar(Long id, Http.Request request) {
        return ok("Actualizar platillo: " + id + " - Funciona correctamente");
    }

    public Result eliminar(Long id) {
        return ok("Eliminar platillo: " + id + " - Funciona correctamente");
    }
} 