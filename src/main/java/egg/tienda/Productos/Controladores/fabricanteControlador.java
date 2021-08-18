package egg.tienda.Productos.Controladores;

import egg.tienda.Productos.Errores.ErrorServicio;
import egg.tienda.Productos.Servicios.FabricanteServicio;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/fabricante")
public class fabricanteControlador {
    
    @Autowired
    private FabricanteServicio fabricanteServicio;
    
     @GetMapping("/crear")
    public String fabricante() {
        return "fabricante/form-fabricante.html";
    }
     @PostMapping("/crear")
    public String crarFabricante(ModelMap modelo, @RequestParam String nombre) {
        try {
            fabricanteServicio.guardar(nombre);
        } catch (ErrorServicio ex) {
            modelo.put("error", ex.getMessage());
            Logger.getLogger(fabricanteControlador.class.getName()).log(Level.SEVERE, null, ex);
            return "fabricante/form-fabricante.html";
        }
        modelo.put("exito", nombre);
        return "fabricante/form-fabricante.html";
    }

}
