package prueba.desarrolloFinal.controladores;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import prueba.desarrolloFinal.modelos.Alumno;
import prueba.desarrolloFinal.servicios.AlumnoServicioImpl;

@RestController
@RequestMapping("/api/v1/alumnos")
public class AlumnoControlador {
	   @Autowired
	   AlumnoServicioImpl alumnoServicio;

	   @GetMapping("/")
	   public List<Alumno> obtenerAlumnos() {
	       return alumnoServicio.obtenertodo();
	   }

	   @PostMapping("/guardar")
	   public ResponseEntity<Alumno> guardarAlumno(@RequestBody Alumno alumno) {
	       Alumno nuevo_alumno = alumnoServicio.guardar(alumno);
	       return new ResponseEntity<>(nuevo_alumno, HttpStatus.CREATED);
	   }

	   @GetMapping("/{id}")
	   public ResponseEntity<Alumno> obtenerAlumnoPorId(@PathVariable long id) {
	       Alumno alumno = alumnoServicio.obtenerPorId(id);
	       return ResponseEntity.ok(alumno);
	   }

	   @DeleteMapping("/{id}")
	   public ResponseEntity<HashMap<String, Boolean>> eliminarAlumno(@PathVariable long id) {
	       alumnoServicio.eliminar(id);
	       HashMap<String, Boolean> estadoEliminado = new HashMap<>();
	       estadoEliminado.put("eliminado", true);
	       return ResponseEntity.ok(estadoEliminado);
	   }	

}
