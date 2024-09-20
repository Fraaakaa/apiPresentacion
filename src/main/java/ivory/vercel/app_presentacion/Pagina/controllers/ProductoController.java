package ivory.vercel.app_presentacion.Pagina.controllers;

import ivory.vercel.app_presentacion.Pagina.models.Producto;
import ivory.vercel.app_presentacion.Pagina.repositories.ProductoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {
    
    @Autowired
    private ProductoRepository productoRepository;
    
    @CrossOrigin
    @GetMapping
    public List<Producto> getAllProducts(){
        return productoRepository.findAll();
    }
    
    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductById(@PathVariable Long id){
        Optional<Producto> product = productoRepository.findById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @CrossOrigin
    @PostMapping
    public ResponseEntity<Producto> createProduct(@RequestBody Producto product){
        Producto savedProduct = productoRepository.save(product);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }
    
    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        if(!productoRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        
        productoRepository.deleteById(id);
        
        return ResponseEntity.noContent().build();
    }
    
    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<Producto> updatedProduct(@PathVariable Long id, @RequestBody Producto updatedProduct){
        if(!productoRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        
        updatedProduct.setPnro(id);
        Producto savedProduct = productoRepository.save(updatedProduct);
        
        return ResponseEntity.ok(savedProduct);
    }
}

