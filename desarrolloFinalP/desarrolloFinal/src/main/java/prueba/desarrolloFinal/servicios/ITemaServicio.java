package prueba.desarrolloFinal.servicios;

import java.util.List;

import prueba.desarrolloFinal.modelos.Tema;

public interface ITemaServicio {
	public List<Tema> obtenertodo();
	public Tema guardar(Tema tema);
	public Tema obtenerPorId(long id);
	public void eliminar(long id);
}
