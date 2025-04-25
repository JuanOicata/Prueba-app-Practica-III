package co.Ucentral.SafePlay.persistencia.repositorio;

import co.Ucentral.SafePlay.persistencia.entidades.VideoJuego;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface VideoJuegoRepositorio extends JpaRepository<VideoJuego, Long> {
    Optional<VideoJuego> findByNombre(String nombre);
}
