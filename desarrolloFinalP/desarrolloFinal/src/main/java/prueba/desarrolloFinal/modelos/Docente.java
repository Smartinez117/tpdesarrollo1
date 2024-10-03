package prueba.desarrolloFinal.modelos;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Docente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private long legajo; 
    private String nombre;

    public Docente() {}

	public long getLegajo() {
		return legajo;
	}

	public void setLegajo(long legajo) {
		this.legajo = legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    

}
