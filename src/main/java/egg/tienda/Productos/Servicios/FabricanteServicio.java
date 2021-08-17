package egg.tienda.Productos.Servicios;

import egg.tienda.Productos.Entidades.Fabricante;
import egg.tienda.Productos.Entidades.Producto;
import egg.tienda.Productos.Errores.ErrorServicio;
import egg.tienda.Productos.Repositorios.FabricanteRepositorio;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FabricanteServicio {

    @Autowired
    private FabricanteRepositorio fabricanteRepositorio;

    @Transactional
    public Fabricante guardar(String nombre) throws ErrorServicio {
        validar(nombre);

        Fabricante fabricante = new Fabricante();
        fabricante.setNombre(nombre);
        fabricante.setActivo(true);
        fabricante.setCreado(new Date());

        return fabricanteRepositorio.save(fabricante);
    }

    @Transactional
    public Fabricante alta(String id) {

        Fabricante fabricante = fabricanteRepositorio.getById(id);

        fabricante.setActivo(true);
        return fabricanteRepositorio.save(fabricante);
    }

    @Transactional
    public Fabricante baja(String id) {

        Fabricante fabricante = fabricanteRepositorio.getById(id);

        fabricante.setActivo(false);
        return fabricanteRepositorio.save(fabricante);
    }

    public List<Fabricante> listarActivos() {
        return fabricanteRepositorio.buscarActivos();
    }

    public List<Fabricante> listarTodos() {
        return fabricanteRepositorio.findAll();
    }

    public void validar(String nombre) throws ErrorServicio {
        if (nombre == null || nombre.isEmpty() || nombre.contains("  ")) {
            throw new ErrorServicio("El nombre del fabricante no puede ser nulo");
        }

    }

}
