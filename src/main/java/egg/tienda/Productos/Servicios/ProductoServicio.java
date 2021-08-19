package egg.tienda.Productos.Servicios;

import egg.tienda.Productos.Entidades.Producto;
import egg.tienda.Productos.Errores.ErrorServicio;
import egg.tienda.Productos.Repositorios.ProductoRepositorio;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServicio {
    
    @Autowired
    private ProductoRepositorio productoRepositorio;
    
    @Transactional
    public Producto guardar(String nombre, Integer precio, String descripcion) throws ErrorServicio {
     
        validar(nombre, precio, descripcion);
        
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setDescripcion(descripcion);
        producto.setActivo(true);
        producto.setCreado(new Date());
        
        return productoRepositorio.save(producto);
    }
    
    @Transactional
    public Producto alta(String id) {
        
        Producto producto = productoRepositorio.getById(id);
        
        producto.setActivo(true);
        return productoRepositorio.save(producto);
    }
    
    @Transactional
    public Producto baja(String id) {
        
        Producto producto = productoRepositorio.getById(id);
        
        producto.setActivo(false);
        return productoRepositorio.save(producto);
    }
    
    public List<Producto> listarActivos() {
        return productoRepositorio.buscarActivos();
    }
    
    public List<Producto> listarTodos() {
        return productoRepositorio.findAll();
    }
    
    public void validar(String nombre, Integer precio, String descripcion) throws ErrorServicio {
        
        if (nombre == null || nombre.isEmpty() || nombre.contains("  ")) {
            throw new ErrorServicio("El nombre del producto no puede ser nulo");
        }
        if (precio == null) {
            throw new ErrorServicio("El precio del producto no puede ser nulo");
        }
        if (descripcion == null || descripcion.isEmpty() || descripcion.contains("  ")) {
            throw new ErrorServicio("la descripcion no puede ser nula");
        }
    }
    
}
