package product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {
	
	private Long productId;
	private String name;
	private String description;
	private int price;
	private int stockQuantity;
	private String categofyName;
	
	public ProductResponseDTO(Product product) {
		this.productId = product.getProductId();
		this.name = product.getName();
		this.description = product.getDescription();
		this.price = product.getPrice();
		this.stockQuantity = product.getStockQuantity();
		this.categofyName = product.getCategory().getName(); // category ENtity 생성필요
	}
}
