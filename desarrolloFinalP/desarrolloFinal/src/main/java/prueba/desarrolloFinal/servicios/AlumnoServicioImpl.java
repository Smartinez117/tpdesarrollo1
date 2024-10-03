package prueba.desarrolloFinal.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import prueba.desarrolloFinal.modelos.Alumno;
import prueba.desarrolloFinal.repositorios.AlumnoRepositorio;

public class AlumnoServicioImpl implements IAlumnoServicio{
	   @Autowired
	   AlumnoRepositorio alumnoRepositorio;

	   @Override
	   public List<Alumno> obtenertodo() {
	       return alumnoRepositorio.findAll();
	   }

	   @Override
	   public Alumno guardar(Alumno alumno) {
	       return alumnoRepositorio.save(alumno);
	   }

	   @Override
	   public Alumno obtenerPorId(long id) {
	       return alumnoRepositorio.findById(id).orElse(null);
	   }

	   @Override
	   public void eliminar(long id) {
	       alumnoRepositorio.deleteById(id);
	   }
}
