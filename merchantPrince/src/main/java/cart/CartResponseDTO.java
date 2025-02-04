package cart;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import product.ProductResponseDTO;

@Getter
@Setter
public class CartResponseDTO {
	
	private Long cartId;
	private String userId;
	private ProductResponseDTO product;
	private int quantity;
	private LocalDateTime createdAt;
	
	public CartResponseDTO(Cart cart) {
		this.cartId = cart.getCartId();
		this.userId = cart.getUserId();
		this.product = new ProductResponseDTO(cart.getProduct()); // 생성자 활용필요 
		this.quantity = cart.getQuantity();
		this.createdAt = cart.getCreatedAt();
	}
	
}
