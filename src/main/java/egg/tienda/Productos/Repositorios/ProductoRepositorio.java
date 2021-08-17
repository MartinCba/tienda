package egg.tienda.Productos.Repositorios;

import egg.tienda.Productos.Entidades.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, String> {
    
    @Query("SELECT a FROM Producto a WHERE a.id = :id")
    public Producto buscarProducto(@Param("id") String id);
    
    @Query("SELECT c FROM Producto c WHERE c.nombre = :nombre")
    public Producto buscarProductoPorNombre(@Param("nombre") String nombre);

    @Query("SELECT b FROM Producto b WHERE b.activo = true ")
    public List<Producto> buscarActivos();
    
    

}
