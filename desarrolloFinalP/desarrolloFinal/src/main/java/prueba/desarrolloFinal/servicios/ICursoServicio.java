package prueba.desarrolloFinal.servicios;

import java.util.List;

import prueba.desarrolloFinal.modelos.Curso;

public interface ICursoServicio {
	public List<Curso> obtenertodo();
	public Curso guardar(Curso curso);
	public Curso obtenerPorId(long id);
	public void eliminar(long id);
}
