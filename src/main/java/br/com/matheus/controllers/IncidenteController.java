package br.com.matheus.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.matheus.model.entities.Incidente;
import br.com.matheus.model.repositories.IncidenteRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/incidentes")
public class IncidenteController {

	//MÉTODO PARA GARANTIR QUE A DATA SEJA INTERPRETADA CORRETAMENTE
	@InitBinder
	public void initBinder(WebDataBinder binder){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@Autowired
	private IncidenteRepository incidenteRepository;

	@PostMapping
	public @ResponseBody Incidente criarIncidente(@Valid Incidente incidente) {
		
		incidente.setCreatedAt(new Date());
		incidente.setUpdatedAt(new Date());
		incidenteRepository.save(incidente);

		return incidente;
	}
	
	@GetMapping("/listarIncidentes")
	public Iterable<Incidente> obterIncidentes() {
		return incidenteRepository.findAll();
	}
	
	@GetMapping("/ordenar")
	public Iterable<Incidente> obterIncidentesFiltrado(){
		
		Pageable page = PageRequest.of(0, 20, Sort.by(Sort.Order.desc("createdAt")));
				
		return incidenteRepository.findAll(page);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> obterIncidente(@PathVariable int id) {
		Optional<Incidente> incidente = incidenteRepository.findById(id);
		
		if(incidente.isPresent()) {
			 return ResponseEntity.ok(incidente.get());
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum registro");
		}
	}
	
	@PutMapping
	public Incidente atualizarIncidente(@Valid Incidente incidente) {
		incidente.setUpdatedAt(new Date());
		incidenteRepository.save(incidente);
		
		return incidente;
	}
	
	@PutMapping("/encerrar")
	public Incidente encerrarIncidente(@Valid Incidente incidente) {
		incidente.setClosedAt(new Date());
		incidenteRepository.save(incidente);
		
		return incidente;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluirIncidente(@PathVariable int id) {
		
		Optional<Incidente> incidente = incidenteRepository.findById(id);
		
		if(incidente.isPresent()) {
			incidenteRepository.deleteById(id);
			return ResponseEntity.ok().body("Incidente nro "+ id + " excluído com sucesso!");
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado!");
		}
	}
}
