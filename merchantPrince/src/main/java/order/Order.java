package order;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "order")
@Getter
@Setter
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	
	@Column(name = "user_id")
	private String userId;
	
	@ManyToOne
	@JoinColumn(name = "cart_id", nullable = false)
	private Long cartId;
	
	@Column(name = "total_price", precision = 10, scale = 2, nullable = false)
	private BigDecimal totalPridce;
	
	@Enumerated(EnumType.STRING)
	@Column(name ="status")
	private String status;
	
	@CreationTimestamp
	@Column(name = "created_At", updatable = false)
	private LocalDateTime createdAt;
	
	
}
