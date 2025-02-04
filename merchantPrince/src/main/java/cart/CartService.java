package cart;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import product.Product;
import product.ProductRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	// 장바구니 상품 추가
	public CartResponseDTO addCart(CartRequestDTO cartRequestDTO) {
		// 장바구니에 동일한 상품이 있는지 확인
		Optional<Cart> existingCartItem = cartRepository.findByUserIdAndProductId(cartRequestDTO.getUserId(),
																			cartRequestDTO.getProductId());
		
		if (existingCartItem.isPresent()) {
			 // 이미 있으면 수량 증가
			Cart cart = existingCartItem.get();
			cart.setQuantity(cart.getQuantity() + cartRequestDTO.getQuantity());
			cartRepository.save(cart);
			return new CartResponseDTO(cart);
		}
		// 없으면 새로추가
		
		Product product = productRepository.findById(cartRequestDTO.getProductId())
													.orElseThrow(() -> new RuntimeException("해당상품이 등록되어 있지 않습니다."));
		Cart newCartItem = new Cart();
		newCartItem.setUserId(cartRequestDTO.getUserId());
		newCartItem.setProduct(product);
		newCartItem.setQuantity(cartRequestDTO.getQuantity());
		
		cartRepository.save(newCartItem);
		return new CartResponseDTO(newCartItem);
	}
	
	// 특정 사용자 장바구니 조회
	public List<CartResponseDTO> getCartByUser(String userId){
		
		List<Cart> cartItems = cartRepository.findByUserId(userId);
		return cartItems.stream()
						.map(CartResponseDTO::new)
						.collect(Collectors.toList());
	}
	
	
	// 장바구니 수량 업데이트
	public CartResponseDTO updateCartQuantity(Long cartId, int quantity) {
		
		Cart cartItem = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("상품을 찾을수 없습니다."));
				
		cartItem.setQuantity(quantity);
		cartRepository.save(cartItem);
		return new CartResponseDTO(cartItem);
	}
	
	// 장바구니 삭제 
	public void removeCartItem(Long cartId) {
		
		Cart cartItem = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("상품을 찾을수 없습니다.")); 
		cartRepository.delete(cartItem);
	}
	
	// 특정 사용자 장바구니 전체 삭제
	public void clearCart(String userId) {
		
		List<Cart> cartItems = cartRepository.findByUserId(userId);
		
		if (cartItems.isEmpty()) {
			throw new RuntimeException("장바구니가 비어 있습니다.");
		}
		cartRepository.deleteAll(cartItems);
	}
}
