package prueba.desarrolloFinal.servicios;

import java.util.List;

import prueba.desarrolloFinal.modelos.Alumno;

public interface IAlumnoServicio {
	public List<Alumno> obtenertodo();
	public Alumno guardar(Alumno alumno);
	public Alumno obtenerPorId(long id);
	public void eliminar(long id);
}
