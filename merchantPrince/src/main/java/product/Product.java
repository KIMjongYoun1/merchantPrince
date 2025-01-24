package product;

import java.time.LocalDateTime;

import Category.CategoryEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="products")
@Getter
@Setter
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // 오토인크리먼트임 일단
	private Long productId;
	
	@Column(nullable = false, length = 255)
	private String name;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private int price;
	
	@ManyToOne
	@JoinColumn(name = "catagory_id", nullable = false)
	private CategoryEntity category; // 카테고리와의 관게
	
	@Column(nullable = false)
	private int stockQuantity; // 재고수량 
	
	@Column(name = "created_at", updatable = false)
	private LocalDateTime createdAt = LocalDateTime.now();
	
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
}
