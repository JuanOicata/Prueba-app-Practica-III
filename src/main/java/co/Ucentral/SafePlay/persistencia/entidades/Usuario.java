package co.Ucentral.SafePlay.persistencia.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "usuarios")
@Entity
public class Usuario {

    @Id
    @Column(name = "usu_usuario")
    private String usuario;

    @Column(name = "usu_contrasena", nullable = false)
    private String contrasena;

    @Column(name = "usu_nombre", nullable = false)
    private String nombre;

    @Column(name = "usu_cedula", nullable = false)
    private long cedula;

    @Column(name = "usu_telefono", nullable = false)
    private long telefono;

    // Constructor vacío
    public Usuario() {}

    // Constructor con todos los campos
    public Usuario(String usuario, String contrasena, String nombre, long cedula, long telefono) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
    }

    // Getters y setters
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }
}