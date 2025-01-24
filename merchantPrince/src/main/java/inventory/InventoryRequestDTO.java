package inventory;

import inventory.Inventory.InventoryTransactionType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventoryRequestDTO {
	
	private Long productId; // 상품아이디
	private int quantity;	//수량 
	private InventoryTransactionType transactionType; // 입출고여부 인아웃
}
