package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "categorias")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @NotNull
    @Column(nullable = false)
    private Boolean activa = true;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    // Constructores
    public Categoria() {
        this.fechaCreacion = LocalDateTime.now();
        this.fechaModificacion = LocalDateTime.now();
    }

    public Categoria(String nombre, String descripcion) {
        this();
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getActiva() {
        return activa;
    }

    public void setActiva(Boolean activa) {
        this.activa = activa;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @PreUpdate
    public void preUpdate() {
        this.fechaModificacion = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", activa=" + activa +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaModificacion=" + fechaModificacion +
                '}';
    }
}
