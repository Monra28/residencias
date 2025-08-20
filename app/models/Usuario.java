package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 100, nullable = false)
    private String nombre;

    @NotNull
    @Email
    @Column(length = 150, nullable = false, unique = true)
    private String email;

    @NotNull
    @Column(length = 255, nullable = false)
    private String password;

    @NotNull
    @Column(length = 50, nullable = false)
    private String rol = "USUARIO";

    @Column(length = 20)
    private String telefono;

    @Column(columnDefinition = "TEXT")
    private String direccion;

    @NotNull
    @Column(nullable = false)
    private Boolean activo = true;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    // Constructores
    public Usuario() {
        this.fechaCreacion = LocalDateTime.now();
        this.fechaModificacion = LocalDateTime.now();
    }

    public Usuario(String nombre, String email, String password, String rol) {
        this();
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    public Usuario(String nombre, String email, String password, String rol, String telefono, String direccion) {
        this();
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.rol = rol;
        this.telefono = telefono;
        this.direccion = direccion;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
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
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", rol='" + rol + '\'' +
                ", telefono='" + telefono + '\'' +
                ", activo=" + activo +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaModificacion=" + fechaModificacion +
                '}';
    }
}
