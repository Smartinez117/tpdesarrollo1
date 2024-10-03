package prueba.desarrolloFinal.controladores;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.*;

import prueba.desarrolloFinal.modelos.Curso;
import prueba.desarrolloFinal.servicios.CursoServicioImpl; 

@RestController 
@RequestMapping("/api/v1/cursos") 
public class CursoControlador {
	@Autowired 
    private CursoServicioImpl cursoServicio; 

    // Obtener todos los cursos
    @GetMapping("/") 
    public List<Curso> obtenerCursos() { 
         return cursoServicio.obtenertodo(); 
    } 

    // Guardar un nuevo curso
    @PostMapping("/guardar") 
    public ResponseEntity<Curso> guardarCurso(@RequestBody Curso curso) { 
         Curso nuevoCurso = cursoServicio.guardar(curso); 
         return new ResponseEntity<>(nuevoCurso, HttpStatus.CREATED); 
    } 

    // Obtener un curso por ID
    @GetMapping("/{id}") 
    public ResponseEntity<Curso> obtenerCursoPorId(@PathVariable long id) { 
         Curso curso = cursoServicio.obtenerPorId(id); 
         if (curso == null) { 
              return ResponseEntity.notFound().build(); 
         } 
         return ResponseEntity.ok(curso); 
    } 

    // Actualizar un curso existente
    @PutMapping("/{id}") 
    public ResponseEntity<Curso> actualizarCurso(@PathVariable long id, @RequestBody Curso curso) { 
         Curso cursoExistente = cursoServicio.obtenerPorId(id); 
         if (cursoExistente == null) { 
              return ResponseEntity.notFound().build(); 
         } 

         // Actualizar campos del curso existente
         cursoExistente.setTema(curso.getTema());
         cursoExistente.setDocente(curso.getDocente());
         cursoExistente.setFechaInicio(curso.getFechaInicio());
         cursoExistente.setFechaFin(curso.getFechaFin());
         cursoExistente.setPrecio(curso.getPrecio());

         Curso cursoActualizado = cursoServicio.guardar(cursoExistente); 
         return new ResponseEntity<>(cursoActualizado, HttpStatus.OK); 
    } 

    // Eliminar un curso por ID
    @DeleteMapping("/{id}") 
    public ResponseEntity<HashMap<String, Boolean>> eliminarCurso(@PathVariable long id) { 
         Curso cursoExistente = cursoServicio.obtenerPorId(id); 
         if (cursoExistente == null) { 
              return ResponseEntity.notFound().build(); 
         } 

         cursoServicio.eliminar(id); 
         HashMap<String, Boolean> estadoEliminado = new HashMap<>(); 
         estadoEliminado.put("eliminado", true); 
         return ResponseEntity.ok(estadoEliminado); 
    } 
 

}
