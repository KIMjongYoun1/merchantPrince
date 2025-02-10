package order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cart.Cart;
import cart.CartRepository;

@Service
public class OrderService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private OrderRepository orderRepository;

	public OrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO) {

		List<Cart> cartItems = cartRepository.findByUserId(orderRequestDTO.getUserId());

		if (cartItems.isEmpty()) {
			throw new RuntimeException("장바구니가 비어있습니다.");
		}

//      상품 금액 합계
//		BigDecimal totalPrice = cartItems.stream()
//								.map(item -> item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
//								.reduce(BigDecimal.ZERO, BigDecimal::add);

		Order order = new Order();
		order.setUserId(orderRequestDTO.getUserId());
		order.setCartId(orderRequestDTO.getCartId());
		// order.setTotalPridce(totalPrice);
		order.setStatus("PENDING");

		Order savedOrder = orderRepository.save(order);

		return new OrderResponseDTO(savedOrder);

	}
}
