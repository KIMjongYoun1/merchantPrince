package inventory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventoryResponseDTO {
	
	private Long inventoryId;
	private Long productId;
	private int quantity;
	private String transactionType; // 입출고 인아웃 
	
	public InventoryResponseDTO(Inventory inventory) {
		
		this.inventoryId = inventory.getInventoryId();
		this.productId = inventory.getProduct().getProductId();
		this.quantity = inventory.getQuantity();
		this.transactionType = inventory.getTransactionType().name();  // Enum 타입을 String으로 변환
	}
}
