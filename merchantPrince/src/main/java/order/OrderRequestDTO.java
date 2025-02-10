package order;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDTO {

	private String userId;

	private Long cartId;

	private BigDecimal totalPridce;

	private String status;

	private LocalDateTime createdAt;

}
