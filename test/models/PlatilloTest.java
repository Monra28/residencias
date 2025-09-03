package models;

import org.junit.Test;
import static org.junit.Assert.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PlatilloTest {

    @Test
    public void testPlatilloCreation() {
        Platillo platillo = new Platillo();
        assertNotNull(platillo);
        assertNotNull(platillo.getFechaCreacion());
        assertNotNull(platillo.getFechaModificacion());
        assertTrue(platillo.getDisponible());
    }

    @Test
    public void testPlatilloConstructorWithArguments() {
        String nombre = "Pizza";
        String categoria = "Italiana";
        String descripcion = "Deliciosa pizza de pepperoni";
        BigDecimal precio = new BigDecimal("12.50");
        String imagenUrl = "http://example.com/pizza.jpg";
        Boolean disponible = false;

        Platillo platillo = new Platillo(nombre, categoria, descripcion, precio, imagenUrl, disponible);

        assertEquals(nombre, platillo.getNombre());
        assertEquals(categoria, platillo.getCategoria());
        assertEquals(descripcion, platillo.getDescripcion());
        assertEquals(precio, platillo.getPrecio());
        assertEquals(imagenUrl, platillo.getImagenUrl());
        assertEquals(disponible, platillo.getDisponible());
    }

    @Test
    public void testPlatilloSettersAndGetters() {
        Platillo platillo = new Platillo();

        Long id = 1L;
        String nombre = "Hamburguesa";
        String categoria = "Comida Rápida";
        String descripcion = "Clásica hamburguesa con queso";
        BigDecimal precio = new BigDecimal("8.75");
        String imagenUrl = "http://example.com/hamburguesa.jpg";
        Boolean disponible = false;
        LocalDateTime now = LocalDateTime.now();

        platillo.setId(id);
        platillo.setNombre(nombre);
        platillo.setCategoria(categoria);
        platillo.setDescripcion(descripcion);
        platillo.setPrecio(precio);
        platillo.setImagenUrl(imagenUrl);
        platillo.setDisponible(disponible);
        platillo.setFechaCreacion(now.minusDays(1));
        platillo.setFechaModificacion(now);

        assertEquals(id, platillo.getId());
        assertEquals(nombre, platillo.getNombre());
        assertEquals(categoria, platillo.getCategoria());
        assertEquals(descripcion, platillo.getDescripcion());
        assertEquals(precio, platillo.getPrecio());
        assertEquals(imagenUrl, platillo.getImagenUrl());
        assertEquals(disponible, platillo.getDisponible());
        assertEquals(now.minusDays(1), platillo.getFechaCreacion());
        assertEquals(now, platillo.getFechaModificacion());
    }

    @Test
    public void testPreUpdateMechanism() {
        Platillo platillo = new Platillo();
        LocalDateTime initialModTime = platillo.getFechaModificacion();
        
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Simulate an update call
        platillo.preUpdate();
        
        assertNotNull(platillo.getFechaModificacion());
        assertNotEquals(initialModTime, platillo.getFechaModificacion());
    }
}
