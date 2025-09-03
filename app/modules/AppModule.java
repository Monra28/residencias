package modules;

import com.google.inject.AbstractModule;
// import repositories.*; // Removed repositories import
import services.UsuarioService;

public class AppModule extends AbstractModule {
    
    @Override
    protected void configure() {
        // Registrar repositorios (Ebean-specific bindings removed)
        // bind(UsuarioRepository.class).asEagerSingleton(); // Removed Ebean binding
        // bind(CategoriaRepository.class).asEagerSingleton(); // Removed Ebean binding
        
        // Registrar servicios
        bind(UsuarioService.class).asEagerSingleton();
    }
}
