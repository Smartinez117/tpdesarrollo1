package prueba.desarrolloFinal.controladores;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import prueba.desarrolloFinal.modelos.Docente;
import prueba.desarrolloFinal.servicios.DocenteServicioImpl;

@RestController
@RequestMapping("/api/v1/docentes")
public class DocenteControlador{
	 @Autowired
	 DocenteServicioImpl docenteServicio;

	 @GetMapping("/")
	 public List<Docente> obtenerDocentes() {
	        return docenteServicio.obtenertodo();
	 }

	 @PostMapping("/guardar")
	 public ResponseEntity<Docente> guardarDocente(@RequestBody Docente docente) {
	    Docente nuevo_docente = docenteServicio.guardar(docente);
	    return new ResponseEntity<>(nuevo_docente, HttpStatus.CREATED);
	 }

	 @GetMapping("/{legajo}")
	 public ResponseEntity<Docente> obtenerDocentePorLegajo(@PathVariable long legajo) {
	     Docente docente = docenteServicio.obtenerPorId(legajo);
	     return ResponseEntity.ok(docente);
	 }

	 @DeleteMapping("/{legajo}")
	 public ResponseEntity<HashMap<String, Boolean>> eliminarDocente(@PathVariable long legajo) {
	     docenteServicio.eliminar(legajo);
	     HashMap<String, Boolean> estadoEliminado = new HashMap<>();
	     estadoEliminado.put("eliminado", true);
	     return ResponseEntity.ok(estadoEliminado);
	 }
}
