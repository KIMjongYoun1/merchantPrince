package inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;
	
	// 상품 재고 조회
	@GetMapping("/{productId}")
	public ResponseEntity<InventoryResponseDTO> getInventoryByProductId(@PathVariable Long productId){
		System.out.println("상품 재고조회 호출");
		
		Inventory inventory = inventoryService.getInventoryByProductId(productId);
		InventoryResponseDTO responseDTO = new InventoryResponseDTO(inventory);
		
		return ResponseEntity.ok(responseDTO);
	}
	
	// 재고추가
	@PostMapping("/add")
	public ResponseEntity<InventoryResponseDTO> addInventory(@RequestBody InventoryRequestDTO requestDTO){
		System.out.println("상품 재고추가 호출");
		
		Inventory inventory = inventoryService.addInventory(requestDTO.getProductId(), requestDTO.getQuantity(),
																requestDTO.getTransactionType());
		
		InventoryResponseDTO responseDTO = new InventoryResponseDTO(inventory);
		
		return ResponseEntity.ok(responseDTO);
	}
	
	//재고 수정
	@PostMapping("/{productId}")
	public ResponseEntity<InventoryResponseDTO> updateInventory(@PathVariable Long pruductId, @RequestBody InventoryRequestDTO requestDTO){
		System.out.println("재고 수정 호철");
		
		Inventory inventory = inventoryService.updateInventory(pruductId, requestDTO.getQuantity());
		InventoryResponseDTO responseDTO = new InventoryResponseDTO(inventory);
		return ResponseEntity.ok(responseDTO);
		
	}
}
