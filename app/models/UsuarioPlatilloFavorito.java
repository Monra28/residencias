package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuario_platillo_favoritos")
public class UsuarioPlatilloFavorito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "platillo_id", nullable = false)
    private Platillo platillo;

    @Column(name = "fecha_agregado")
    private LocalDateTime fechaAgregado;

    @Column(name = "nota")
    private String nota;

    // Constructores
    public UsuarioPlatilloFavorito() {
        this.fechaAgregado = LocalDateTime.now(); // Manual initialization after removing @WhenCreated
    }

    public UsuarioPlatilloFavorito(Usuario usuario, Platillo platillo) {
        this();
        this.usuario = usuario;
        this.platillo = platillo;
    }

    public UsuarioPlatilloFavorito(Usuario usuario, Platillo platillo, String nota) {
        this();
        this.usuario = usuario;
        this.platillo = platillo;
        this.nota = nota;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Platillo getPlatillo() {
        return platillo;
    }

    public void setPlatillo(Platillo platillo) {
        this.platillo = platillo;
    }

    public LocalDateTime getFechaAgregado() {
        return fechaAgregado;
    }

    public void setFechaAgregado(LocalDateTime fechaAgregado) {
        this.fechaAgregado = fechaAgregado;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    // No @Override as it no longer extends Model
    public String toString() {
        return "UsuarioPlatilloFavorito{" +
                "id=" + id +
                ", usuario=" + (usuario != null ? usuario.getNombre() : "null") +
                ", platillo=" + (platillo != null ? platillo.getNombre() : "null") +
                ", fechaAgregado=" + fechaAgregado +
                ", nota='" + nota + '\'' +
                '}';
    }
}
