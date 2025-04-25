package co.Ucentral.SafePlay.persistencia.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Table(name = "videojuegos")
@Entity
public class VideoJuego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", nullable = false)
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @Column(name = "clasificacion", nullable = false)
    @NotBlank(message = "La clasificación no puede estar vacía")
    private String clasificacion;

    @Column(name = "descripcion", nullable = false)
    @NotBlank(message = "La descripción no puede estar vacía")
    private String descripcion;

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getClasificacion() { return clasificacion; }
    public void setClasificacion(String clasificacion) { this.clasificacion = clasificacion; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
