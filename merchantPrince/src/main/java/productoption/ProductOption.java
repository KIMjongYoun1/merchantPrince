package productoption;

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
@Table(name = "product_options")
@Getter
@Setter
public class ProductOption {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long optionId;
		
		@ManyToOne
		@JoinColumn(name = "product_id", nullable = false)
		private Product product;
		
		private String name;
		private String value;
}
