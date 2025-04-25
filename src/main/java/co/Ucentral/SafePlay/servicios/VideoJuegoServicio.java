package co.Ucentral.SafePlay.servicios;

import co.Ucentral.SafePlay.persistencia.entidades.VideoJuego;
import co.Ucentral.SafePlay.persistencia.repositorio.VideoJuegoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoJuegoServicio {

    @Autowired
    private VideoJuegoRepositorio videoJuegoRepositorio;

    // Obtener todos los videojuegos
    public List<VideoJuego> obtenerTodos() {
        return videoJuegoRepositorio.findAll();
    }

    // Agregar un videojuego nuevo
    public void agregarVideoJuego(VideoJuego videoJuego) {
        videoJuegoRepositorio.save(videoJuego);
    }

    // Eliminar un videojuego por ID
    public void eliminarVideoJuego(Long id) {
        videoJuegoRepositorio.deleteById(id);
    }

    // Editar un videojuego
    public void editarVideoJuego(VideoJuego videoJuego) {
        videoJuegoRepositorio.save(videoJuego);
    }

    // Buscar un videojuego por nombre
    public VideoJuego buscarVideoJuegoPorNombre(String nombre) {
        return videoJuegoRepositorio.findByNombre(nombre).orElse(null);
    }

    // Obtener videojuego por ID
    public VideoJuego obtenerPorId(Long id) {
        Optional<VideoJuego> videoJuego = videoJuegoRepositorio.findById(id);
        return videoJuego.orElse(null);
    }
}
