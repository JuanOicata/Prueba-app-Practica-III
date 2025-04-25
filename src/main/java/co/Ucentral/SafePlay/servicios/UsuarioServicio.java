package co.Ucentral.SafePlay.servicios;

import co.Ucentral.SafePlay.persistencia.entidades.Usuario;
import co.Ucentral.SafePlay.persistencia.repositorio.UsuarioRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UsuarioServicio {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    // Registrar un usuario
    public void registrarUsuario(Usuario usuario) {
        usuarioRepositorio.save(usuario);
    }

    // Obtener todos los usuarios
    public List<Usuario> obtenerTodos() {
        List<Usuario> listado = (List<Usuario>) usuarioRepositorio.findAll();
        return listado;
    }

    // Borrar un usuario
    public boolean borrar(Usuario usuario) {
        try {
            usuarioRepositorio.delete(usuario);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    // Guardar un usuario
    public void guardar(Usuario usuario) {
        usuarioRepositorio.save(usuario);
    }

    // Buscar usuarios por rol
    public List<Usuario> obtenerPorRol(String role) {
        return usuarioRepositorio.findByRole(role);
    }

    // Validar usuario por nombre de usuario y rol
    public Optional<Usuario> validarUsuario(String nombreUsuario, String contrasena, String role) {
        Optional<Usuario> usuarioEncontrado = usuarioRepositorio.findByUsuario(nombreUsuario);

        if (usuarioEncontrado.isPresent()) {
            Usuario usuario = usuarioEncontrado.get();
            if (usuario.getContrasena().equals(contrasena) && usuario.getRole().equals(role)) {
                return Optional.of(usuario);
            }
        }
        return Optional.empty(); // Si no se encuentra o la contraseña/rol no coinciden
    }
}
