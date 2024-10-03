package prueba.desarrolloFinal.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prueba.desarrolloFinal.modelos.Docente;
import prueba.desarrolloFinal.repositorios.DocenteRepositorio;


@Service
public class DocenteServicioImpl implements IDocenteServicio{
	@Autowired
    DocenteRepositorio docenteRepositorio;

    @Override
    public List<Docente> obtenertodo() {
        return docenteRepositorio.findAll();
    }

    @Override
    public Docente guardar(Docente docente) {
        return docenteRepositorio.save(docente);
    }

    @Override
    public Docente obtenerPorId(long legajo) {
        return docenteRepositorio.findById(legajo).orElse(null);
    }

    @Override
    public void eliminar(long legajo) {
        docenteRepositorio.deleteById(legajo);
    }
}
