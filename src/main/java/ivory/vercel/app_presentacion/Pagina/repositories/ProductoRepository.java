package ivory.vercel.app_presentacion.Pagina.repositories;

import ivory.vercel.app_presentacion.Pagina.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    
}
