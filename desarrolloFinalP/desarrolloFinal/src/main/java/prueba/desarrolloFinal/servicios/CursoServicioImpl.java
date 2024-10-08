package prueba.desarrolloFinal.servicios;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import prueba.desarrolloFinal.modelos.Curso;
import prueba.desarrolloFinal.repositorios.CursoRepositorio;

public class CursoServicioImpl implements ICursoServicio{
	   @Autowired
	   private CursoRepositorio cursoRepositorio;

	   @Override
	   public List<Curso> obtenertodo() {
	       return cursoRepositorio.findAll();
	   }

	   @Override
	   public Curso guardar(Curso curso) {
	       return cursoRepositorio.save(curso);
	   }

	   @Override
	   public Curso obtenerPorId(long id) {
	       return cursoRepositorio.findById(id).orElse(null);
	   }

	   @Override
	   public void eliminar(long id) {
	       cursoRepositorio.deleteById(id);
	   }
}
