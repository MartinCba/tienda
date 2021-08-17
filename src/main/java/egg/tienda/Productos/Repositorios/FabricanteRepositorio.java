package egg.tienda.Productos.Repositorios;

import egg.tienda.Productos.Entidades.Fabricante;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FabricanteRepositorio extends JpaRepository<Fabricante, String> {

    @Query("SELECT a FROM Fabricante a WHERE a.id = :id")
    public Fabricante buscarFabricante(@Param("id") String id);

    @Query("SELECT c FROM Fabricante c WHERE c.nombre = :nombre")
    public Fabricante buscarFabricantePorNombre(@Param("nombre") String nombre);

    @Query("SELECT b FROM Fabricante b WHERE b.activo = true ")
    public List<Fabricante> buscarActivos();

}
