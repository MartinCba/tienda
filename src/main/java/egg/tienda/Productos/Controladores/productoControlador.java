package egg.tienda.Productos.Controladores;

import egg.tienda.Productos.Errores.ErrorServicio;
import egg.tienda.Productos.Servicios.ProductoServicio;
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
@RequestMapping("/producto")
public class productoControlador {

    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping("/crear")
    public String producto() {
        return "producto/form-producto.html";
    }

    @PostMapping("/crear")
    public String crarProducto(ModelMap modelo, @RequestParam String nombre, @RequestParam Integer precio, @RequestParam String descripcion) {
        try {
            productoServicio.guardar(nombre, precio, descripcion);
        } catch (ErrorServicio ex) {
            modelo.put("error2", ex.getMessage());
            Logger.getLogger(productoControlador.class.getName()).log(Level.SEVERE, null, ex);
            return "producto/form-producto.html";
        }
        modelo.put("exito2", nombre);
        return "producto/form-producto.html";
    }

}
