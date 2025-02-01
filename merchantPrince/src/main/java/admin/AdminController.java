package admin;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import product.Product;
import product.ProductRequestDTO;
import product.ProductResponseDTO;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	//상품 등록 api
	@PostMapping
	public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO productRequestDTO){
		Product product = adminService.createProduct(productRequestDTO);
		ProductResponseDTO responseDTO = new ProductResponseDTO(product);
		return ResponseEntity.status(201).body(responseDTO);
		// 201 응답
//		의미: 요청이 성공적으로 처리되어 새로운 리소스가 생성되었음을 나타냅니다.
//		언제 사용?: 새 데이터를 생성하는 API에서 사용됩니다. 예를 들어, 사용자가 상품을 새로 등록하는 경우 
//		POST 요청이 성공적으로 처리되면, 새로 생성된 리소스(상품)를 반환하면서 201 응답을 보냅니다.
		
	}
	
	//상품 수정 api
	@PutMapping("/{productId}")
	public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable Long productId, @RequestBody ProductRequestDTO productRequestDTO){
		Product product = adminService.updateProduct(productId, productRequestDTO);
		ProductResponseDTO responseDTO = new ProductResponseDTO(product);
		return ResponseEntity.ok(responseDTO);
		// 200응답
//		의미: 요청이 성공적으로 처리되었음을 나타내며, 요청에 대한 정상적인 응답이 포함됩니다.
//		언제 사용?: 데이터 조회와 같은 읽기 작업에서 사용됩니다. 예를 들어, 
//		상품 목록 조회와 같이 데이터를 성공적으로 반환하는 경우에 200 응답을 보냅니다.
	}
	
	//상품 삭제 api
	@DeleteMapping("{productId}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long productId){
		adminService.deleteProduct(productId);
		return ResponseEntity.noContent().build();
		// 204응답
//		의미: 요청이 성공적으로 처리되었지만, 반환할 내용이 없음을 나타냅니다.
//		언제 사용?: 리소스를 삭제하는 작업 후, 반환할 내용이 없을 때 사용됩니다. 
//		예를 들어, 사용자가 상품을 삭제했을 때 삭제된 후에는 반환할 데이터가 없으므로 204 상태 코드가 사용됩니다.
	}
	
	// 모든상품 조회 호출
	@GetMapping
	public ResponseEntity<List<ProductResponseDTO>> getAllProducts(){
		List<Product> products = adminService.getAllProduct();
		List<ProductResponseDTO> responseDTO = products.stream()
												.map(ProductResponseDTO::new)
												.collect(Collectors.toList());
		return ResponseEntity.ok(responseDTO);
		
	}
	
	// 개별상품 조회
	@GetMapping("/{productId}")
	public ResponseEntity<ProductResponseDTO> getProduct(@PathVariable Long productId){
		Product product = adminService.getProduct(productId);
		ProductResponseDTO responseDTO = new ProductResponseDTO(product);
		return ResponseEntity.ok(responseDTO);
	}
}
