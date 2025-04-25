package co.Ucentral.SafePlay.persistencia.repositorio;

import co.Ucentral.SafePlay.persistencia.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface UsuarioRepositorio extends JpaRepository<Usuario, String> {

    // Buscar por nombre de usuario
    Optional<Usuario> findByUsuario(String usuario);

    // Buscar usuarios por rol
    List<Usuario> findByRole(String role);  // role = "jugador" o "supervisor"
}
