package prueba.desarrolloFinal.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import prueba.desarrolloFinal.modelos.Curso;

public interface CursoRepositorio extends JpaRepository<Curso, Long>{

}
