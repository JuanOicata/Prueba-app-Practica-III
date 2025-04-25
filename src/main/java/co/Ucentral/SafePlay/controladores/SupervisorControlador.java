package co.Ucentral.SafePlay.controladores;

import co.Ucentral.SafePlay.persistencia.entidades.VideoJuego;
import co.Ucentral.SafePlay.servicios.VideoJuegoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SupervisorControlador {

    @Autowired
    private VideoJuegoServicio videoJuegoServicio;

    // Muestra la página de supervisor con todos los videojuegos
    @GetMapping("/supervisor")
    public String mostrarPaginaSupervisor(Model model) {
        model.addAttribute("videoJuegos", videoJuegoServicio.obtenerTodos());
        return "supervisor";  // Página del supervisor con la lista de videojuegos
    }

    // Mostrar formulario para agregar un videojuego
    @GetMapping("/agregarVideoJuego")
    public String mostrarFormularioDeAgregar(Model model) {
        model.addAttribute("videoJuego", new VideoJuego());
        return "agregarVideoJuego";  // Vista para agregar videojuego
    }

    // Guardar un videojuego nuevo
    @PostMapping("/agregarVideoJuego")
    public String agregarVideoJuego(@ModelAttribute VideoJuego videoJuego) {
        videoJuegoServicio.agregarVideoJuego(videoJuego);
        return "redirect:/supervisor";  // Redirige a la página de supervisor
    }

    // Eliminar un videojuego
    @GetMapping("/eliminarVideoJuego")
    public String eliminarVideoJuego(@RequestParam Long id) {
        videoJuegoServicio.eliminarVideoJuego(id);
        return "redirect:/supervisor";  // Redirige a la página de supervisor después de eliminar
    }

    // Editar un videojuego
    @GetMapping("/editarVideoJuego")
    public String editarVideoJuego(@RequestParam Long id, Model model) {
        VideoJuego videoJuego = videoJuegoServicio.obtenerPorId(id);
        model.addAttribute("videoJuego", videoJuego);
        return "editarVideoJuego";  // Vista para editar videojuego
    }

    // Guardar cambios después de editar un videojuego
    @PostMapping("/editarVideoJuego")
    public String editarVideoJuego(@ModelAttribute VideoJuego videoJuego) {
        videoJuegoServicio.editarVideoJuego(videoJuego);
        return "redirect:/supervisor";  // Redirige a la página de supervisor
    }

    // Buscar un videojuego
    @GetMapping("/buscarVideoJuego")
    public String buscarVideoJuego(@RequestParam String nombre, Model model) {
        VideoJuego videoJuego = videoJuegoServicio.buscarVideoJuegoPorNombre(nombre);
        model.addAttribute("videoJuego", videoJuego);
        return "buscarResultado";  // Vista con el resultado de la búsqueda
    }
}
