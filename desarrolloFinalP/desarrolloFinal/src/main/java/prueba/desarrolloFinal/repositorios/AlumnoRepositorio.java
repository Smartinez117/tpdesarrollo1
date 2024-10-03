package prueba.desarrolloFinal.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import prueba.desarrolloFinal.modelos.Alumno;

@Repository
public interface AlumnoRepositorio extends JpaRepository<Alumno, Long>{

}
