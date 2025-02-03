package shop;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.Setter;
import product.Product;
import productimage.ProductImage;

@Getter
@Setter
public class ShopResponseDTO {
	
	private Long productId;
	private String name;
	private String description;
	private int price;
	private String categofyName;
	private List<String> imageUrls; 
	
	public ShopResponseDTO(Product product) {
		this.productId = product.getProductId();
		this.name = product.getName();
		this.description = product.getDescription();
		this.price = product.getPrice();
		this.categofyName = product.getCategory().getName();
		this.imageUrls = product.getProductImages().stream()
												.map(ProductImage::getImageUrl)
												.collect(Collectors.toList());
	}
	
}
