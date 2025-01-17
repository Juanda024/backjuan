
package co.edu.personasapi.infraestructura;

import co.edu.personasapi.domain.Persona;
import co.edu.personasapi.domain.PersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({ "/personasrest" })
public class PersonaRest {
	@Autowired
	PersonaService service;

	@GetMapping("/getall")
	public List<Persona> listar() {
		return service.listar();
	}

	@PostMapping("/submit")
	public Persona agregar(@RequestBody Persona p) {
		return service.add(p);
	}

	@GetMapping("/getbyid/{id}")
	public Persona listarId(@PathVariable("id") int id) {
		return service.listarId(id);
	}

	@PutMapping("/editar/{id}")
	public Persona editar(@RequestBody Persona p, @PathVariable("id") int id) {
		p.setId(id);
		return service.edit(p);
	}

	@DeleteMapping("/eliminar/{id}")
	public Persona eliminar(@RequestBody Persona p, @PathVariable("id") int id) {
		p.setId(id);
		return service.delete(id);
	}

}
