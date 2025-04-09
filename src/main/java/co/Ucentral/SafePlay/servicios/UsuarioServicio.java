package co.Ucentral.SafePlay.servicios;

import co.Ucentral.SafePlay.persistencia.entidades.Usuario;
import co.Ucentral.SafePlay.persistencia.repositorio.UsuarioRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UsuarioServicio {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;
    public void registrarUsuario(Usuario usuario) {
        usuarioRepositorio.save(usuario);
    }

    public List<Usuario> obtenerTodos(){
        List<Usuario> listado = (List<Usuario>) usuarioRepositorio.findAll();
        return listado;
    }
    public boolean borrar(Usuario usuario){
        try{
            usuarioRepositorio.delete(usuario);
        }catch (Exception e){
            return false;
        }
        return true;
    }
    public void guardar(Usuario usuario) {
        usuarioRepositorio.save(usuario);
    }
    /*public Usuario validarUsuario(String nombreUsuario, String contrasena) {
        // Buscar el usuario por su nombre de usuario
        Usuario usuarioEncontrado = usuarioRepositorio.findByUsuario(nombreUsuario).orElse(null);

        if (usuarioEncontrado != null) {
            // Verificar que la contraseña coincida
            if (usuarioEncontrado.getContrasena().equals(contrasena)) {
                // Si la contraseña es correcta, imprimir el nombre del usuario
                System.out.println("Usuario autenticado: " + usuarioEncontrado.getUsuario());
                return usuarioEncontrado;  // Retornar el usuario autenticado
            } else {
                System.out.println("Contraseña incorrecta");
            }
        } else {
            System.out.println("Usuario no encontrado");
        }
        return null;
    }*/
}
