package product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping
	public ResponseEntity<ProductResponseDTO> createProduct(@Valid @RequestBody ProductRequestDTO productRequestDTO){
		Product product = productService.createProduct(productRequestDTO);
		ProductResponseDTO responseDTO = new ProductResponseDTO(product);
		return ResponseEntity.ok(responseDTO);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductResponseDTO> getProduct(@PathVariable Long id){
		Product product = productService.getProduct(id);
		ProductResponseDTO responseDTO = new ProductResponseDTO(product);
		return ResponseEntity.ok(responseDTO);
	}
}
