package ivory.vercel.app_presentacion.Pagina.repositories;

import ivory.vercel.app_presentacion.Pagina.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
    
}
