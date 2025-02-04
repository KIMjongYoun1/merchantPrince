package cart;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import product.Product;

@Entity
@Table(name = "cart")
@Getter
@Setter
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cartId; // ✅ PRIMARY KEY 설정

	private String userId;

	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

	private int quantity;

	@CreationTimestamp
	private LocalDateTime createdAt;

}
