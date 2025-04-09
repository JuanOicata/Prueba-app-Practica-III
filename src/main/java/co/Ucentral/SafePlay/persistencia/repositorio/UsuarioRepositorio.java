package co.Ucentral.SafePlay.persistencia.repositorio;

import co.Ucentral.SafePlay.persistencia.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioRepositorio extends JpaRepository<Usuario, String> {
    Optional<Usuario> findByUsuario(String usuario);
}
