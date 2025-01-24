package inventory;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import product.Product;

@Entity
@Table(name = "inventory")
@Getter
@Setter
public class Inventory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long inventoryId;
	
	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;
	
	private int quantity; // 입출고 재고수량
	
	// jpa 데이터 저장형식 어노테이션임 데이터값을 문자열로 저장함 가독성이 좋음
	@Enumerated(EnumType.STRING)
	private InventoryTransactionType transactionType;
	
	private LocalDateTime createdAt = LocalDateTime.now();
	private LocalDateTime updatedAt = LocalDateTime.now();
	
	// 재고 입출고를 구분하기 위한 Enum 타입
	public enum InventoryTransactionType{
		IN, OUT
	}
	
	
}
