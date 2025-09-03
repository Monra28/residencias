package models;

import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

public class UsuarioTest {

    @Test
    public void testUsuarioCreation() {
        Usuario usuario = new Usuario();
        assertNotNull(usuario);
        assertNotNull(usuario.getFechaCreacion());
        assertNotNull(usuario.getFechaModificacion());
        assertTrue(usuario.getActivo());
        assertEquals("USUARIO", usuario.getRol());
    }

    @Test
    public void testUsuarioConstructorWithMinimumArguments() {
        String nombre = "Test User";
        String email = "test@example.com";
        String password = "password123";
        String rol = "ADMIN";

        Usuario usuario = new Usuario(nombre, email, password, rol);

        assertEquals(nombre, usuario.getNombre());
        assertEquals(email, usuario.getEmail());
        assertEquals(password, usuario.getPassword());
        assertEquals(rol, usuario.getRol());
        assertTrue(usuario.getActivo());
    }

    @Test
    public void testUsuarioConstructorWithAllArguments() {
        String nombre = "Full Name";
        String email = "full@example.com";
        String password = "securepass";
        String rol = "MODERATOR";
        String telefono = "123456789";
        String direccion = "Calle Falsa 123";

        Usuario usuario = new Usuario(nombre, email, password, rol, telefono, direccion);

        assertEquals(nombre, usuario.getNombre());
        assertEquals(email, usuario.getEmail());
        assertEquals(password, usuario.getPassword());
        assertEquals(rol, usuario.getRol());
        assertEquals(telefono, usuario.getTelefono());
        assertEquals(direccion, usuario.getDireccion());
        assertTrue(usuario.getActivo());
    }

    @Test
    public void testUsuarioSettersAndGetters() {
        Usuario usuario = new Usuario();

        Long id = 1L;
        String nombre = "Updated Name";
        String email = "updated@example.com";
        String password = "newpass";
        String rol = "GUEST";
        String telefono = "987654321";
        String direccion = "Avenida Siempre Viva 742";
        Boolean activo = false;
        LocalDateTime now = LocalDateTime.now();

        usuario.setId(id);
        usuario.setNombre(nombre);
        usuario.setEmail(email);
        usuario.setPassword(password);
        usuario.setRol(rol);
        usuario.setTelefono(telefono);
        usuario.setDireccion(direccion);
        usuario.setActivo(activo);
        usuario.setFechaCreacion(now.minusDays(5));
        usuario.setFechaModificacion(now.minusDays(1));

        assertEquals(id, usuario.getId());
        assertEquals(nombre, usuario.getNombre());
        assertEquals(email, usuario.getEmail());
        assertEquals(password, usuario.getPassword());
        assertEquals(rol, usuario.getRol());
        assertEquals(telefono, usuario.getTelefono());
        assertEquals(direccion, usuario.getDireccion());
        assertEquals(activo, usuario.getActivo());
        assertEquals(now.minusDays(5), usuario.getFechaCreacion());
        assertEquals(now.minusDays(1), usuario.getFechaModificacion());
    }

    @Test
    public void testPreUpdateMechanism() {
        Usuario usuario = new Usuario();
        LocalDateTime initialModTime = usuario.getFechaModificacion();

        try {
            Thread.sleep(10); // Small delay to ensure distinct timestamps
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        usuario.preUpdate();

        assertNotNull(usuario.getFechaModificacion());
        assertNotEquals(initialModTime, usuario.getFechaModificacion());
    }
}
