package co.Ucentral.SafePlay.controladores;

import co.Ucentral.SafePlay.persistencia.entidades.Usuario;
import co.Ucentral.SafePlay.servicios.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@Controller
public class UsuarioControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("/")
    public String mostrarFormularioRegistroRoot(Model model) {
        model.addAttribute("elusuario", new Usuario());
        return "registro";
    }

    // Muestra el formulario
    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("elusuario", new Usuario()); // <- esto es esencial
        return "registro"; // <- nombre del archivo HTML sin extensión
    }

    // Guarda el usuario enviado desde el formulario
    @PostMapping("/almacenar")
    public String guardarUsuario(@ModelAttribute("elusuario") Usuario usuario) {
        usuarioServicio.guardar(usuario);
        return "redirect:/registro"; // puedes redirigir a otra página si quieres
    }

    @Controller
    public class TestControlador {
        @GetMapping("/test")
        public String test() {
            return "test";
        }
    }

}
