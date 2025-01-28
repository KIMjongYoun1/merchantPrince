package seller;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sellers")
@Getter
@Setter
public class Seller {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sellerNum;
	
	@Column(unique = true, nullable = false)
	private String sellerId;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String companyName;
	
	@Column(nullable = false)
	private String contactNumber;
	
	private String description;
	
	private LocalDateTime createdAt = LocalDateTime.now();
	private LocalDateTime updatedAt = LocalDateTime.now();
	
	
}
