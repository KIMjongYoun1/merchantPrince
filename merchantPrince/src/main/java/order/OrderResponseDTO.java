package order;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponseDTO {

	private Long orderId;

	private String userId;

	private Long cartId;

	private BigDecimal totalPridce;

	private String status;

	private LocalDateTime createdAt;
	
	public OrderResponseDTO(Order order) {
		this.orderId = order.getOrderId();
		this.userId = order.getUserId();
		this.cartId = order.getCartId();
		this.totalPridce = order.getTotalPridce();
		this.status = order.getStatus();
		this.createdAt = order.getCreatedAt();
	}
	
}
