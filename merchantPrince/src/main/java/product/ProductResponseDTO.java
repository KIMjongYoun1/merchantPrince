package product;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import productoption.ProductOptionRequestDTO;

@Getter
@Setter
public class ProductResponseDTO {
	
	private Long productId;
	private String name;
	private String description;
	private int price;
	private int stockQuantity;
	private String categofyName;
	private List<String> imageUrls; // 상품 이미지목록 추가
	private List<ProductOptionRequestDTO> options; // 상품 오션 목록 추가
	
	public ProductResponseDTO(Product product) {
		this.productId = product.getProductId();
		this.name = product.getName();
		this.description = product.getDescription();
		this.price = product.getPrice();
		this.stockQuantity = product.getStockQuantity();
		this.categofyName = product.getCategory().getName(); // category ENtity 생성필요
	}
}
