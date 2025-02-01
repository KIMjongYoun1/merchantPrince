package shop;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Category.CategoryEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import productimage.ProductImage;
import productoption.ProductOption;

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
	
	
	@Column(nullable = false)
	private int stockQuantity; // 재고수량 
	
	@Column(name = "created_at", updatable = false)
	private LocalDateTime createdAt = LocalDateTime.now();
	
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
	
	@ManyToOne
	@JoinColumn(name = "catagory_id", nullable = false)
	private CategoryEntity category; // 카테고리와의 관게
	  // 상품 옵션과 이미지의 관계 설정
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductOption> productOptions;  // 상품 옵션들 해당 테이블에 컬럼없어도 1:N 가능

//    orphanRemoval = true: 자식 엔티티가 부모 엔티티의 컬렉션에서 제거되면, 자식 엔티티도 DB에서 삭제됩니다.
//    orphanRemoval = false (기본값): 자식 엔티티가 컬렉션에서 제거되더라도, 자식 엔티티는 DB에서 삭제되지 않습니다.
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true) // orphanRemoval = 디비자동삭제를위함  false 로하면 삭제안됨
    private List<ProductImage> productImages = new ArrayList<>();
}
