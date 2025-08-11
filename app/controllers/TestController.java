package controllers;

import play.mvc.*;

public class TestController extends Controller {

    public Result index() {
        return ok("Test controller funciona");
    }
} 