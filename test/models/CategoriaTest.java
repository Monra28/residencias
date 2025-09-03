package models;

import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CategoriaTest {

    @Test
    public void testCategoriaCreation() {
        Categoria categoria = new Categoria();
        assertNotNull(categoria);
        assertNotNull(categoria.getFechaCreacion());
        assertNotNull(categoria.getFechaModificacion());
        assertTrue(categoria.getActiva());
    }

    @Test
    public void testCategoriaConstructorWithArguments() {
        String nombre = "Postres";
        String descripcion = "Categoría para dulces y postres.";

        Categoria categoria = new Categoria(nombre, descripcion);

        assertEquals(nombre, categoria.getNombre());
        assertEquals(descripcion, categoria.getDescripcion());
        assertTrue(categoria.getActiva());
    }

    @Test
    public void testCategoriaSettersAndGetters() {
        Categoria categoria = new Categoria();

        Long id = 10L;
        String nombre = "Bebidas";
        String descripcion = "Bebidas frías y calientes.";
        Boolean activa = false;
        LocalDateTime now = LocalDateTime.now();

        categoria.setId(id);
        categoria.setNombre(nombre);
        categoria.setDescripcion(descripcion);
        categoria.setActiva(activa);
        categoria.setFechaCreacion(now.minusHours(2));
        categoria.setFechaModificacion(now);

        assertEquals(id, categoria.getId());
        assertEquals(nombre, categoria.getNombre());
        assertEquals(descripcion, categoria.getDescripcion());
        assertEquals(activa, categoria.getActiva());
        assertEquals(now.minusHours(2), categoria.getFechaCreacion());
        assertEquals(now, categoria.getFechaModificacion());
    }

    @Test
    public void testPreUpdateMechanism() {
        Categoria categoria = new Categoria();
        LocalDateTime initialModTime = categoria.getFechaModificacion();

        try {
            Thread.sleep(10); // Small delay to ensure distinct timestamps
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        categoria.preUpdate();

        assertNotNull(categoria.getFechaModificacion());
        assertNotEquals(initialModTime, categoria.getFechaModificacion());
    }
}
