package co.Ucentral.SafePlay.controladores;

import co.Ucentral.SafePlay.persistencia.entidades.Usuario;
import co.Ucentral.SafePlay.servicios.UsuarioServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@Controller
public class UsuarioControlador {

    @GetMapping("/")
    public String mostrarPaginaPrincipal() {
        return "index"; // Devuelve index.html
    }
    @Autowired
    private UsuarioServicio usuarioServicio;

    // Muestra el formulario
    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("elusuario", new Usuario()); // <- esto es esencial
        return "registro"; // <- nombre del archivo HTML sin extensión
    }

    @PostMapping("/almacenar")
    public String guardarUsuario(@Valid @ModelAttribute("elusuario") Usuario usuario, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "registro"; // Vuelve al formulario si hay errores
        }
        usuarioServicio.guardar(usuario);
        return "redirect:/registro";
    }




}
