package inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import product.Product;
import product.ProductRepository;

@Service
public class InventoryService {
	
	@Autowired
	private InventoryRepository inventoryRepository;
	
	 @Autowired
	 private ProductRepository productRepository; 
	
	// 상품 ID로 재고조회
	public Inventory getInventoryByProductId(Long productId) {
		return inventoryRepository.findByProductProductId(productId)
								  .orElseThrow(() -> new RuntimeException("재고를 찾을 수 없습니다."));
	}
	
	// 재고추가
	public Inventory addInventory(Long productId, int quantity, Inventory.InventoryTransactionType transactionType) {
		
		Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("상품을 찾을 수 없습니다."));  // Product 조회
		
		Inventory inventory = new Inventory();
		inventory.setProduct(product);
		inventory.setQuantity(quantity);
		inventory.setTransactionType(transactionType);
		
		return inventoryRepository.save(inventory);
		
	}
	
	// 재고수정
	public Inventory updateInventory(Long productId, int quantity) {
		
		Inventory inventory = getInventoryByProductId(productId);
		inventory.setQuantity(quantity);
		return inventoryRepository.save(inventory);
	}
}
