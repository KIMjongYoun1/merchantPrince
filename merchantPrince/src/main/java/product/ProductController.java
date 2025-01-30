package product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PutMapping("/{productId}")
	public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable Long productId, @Valid @RequestBody ProductRequestDTO productRequestDTO){
		Product updateProduct = productService.updateProduct(productId, productRequestDTO);
		ProductResponseDTO responseDTO = new ProductResponseDTO(updateProduct);
		return ResponseEntity.ok(responseDTO);
		
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductResponseDTO> getProduct(@PathVariable Long id){
		Product product = productService.getProduct(id);
		ProductResponseDTO responseDTO = new ProductResponseDTO(product);
		return ResponseEntity.ok(responseDTO);
	}
	
	@GetMapping("/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long productId){
		productService.deleteProduct(productId);
		return ResponseEntity.ok("상품이삭제 되었습니다!");
	}
	
	
}
