package ivory.vercel.app_presentacion.Pagina.controllers;

import ivory.vercel.app_presentacion.Pagina.models.Persona;
import ivory.vercel.app_presentacion.Pagina.repositories.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/persona")
public class PersonaController {
    
    @Autowired
    private PersonaRepository personaRepository;
    
    @CrossOrigin
    @PostMapping("/save")
    public ResponseEntity<Persona> savePersona(@RequestBody Persona persona){
        Persona savedPersona = personaRepository.save(persona);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPersona);
    }
    
    @CrossOrigin
    @GetMapping("/get")
    public List<Persona> getPersonas(){
        return personaRepository.findAll();
    }
}
