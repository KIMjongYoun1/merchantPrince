package productimage;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductImageResponseDTO {
	
	private Long imageId;
	private String imageUrl;
	private Long productId;
	
	public ProductImageResponseDTO (ProductImage productImage) {
		this.imageId = productImage.getImageId();
		this.imageUrl = productImage.getImageUrl();
		this.productId = productImage.getProduct().getProductId();
	}



	
	
}
