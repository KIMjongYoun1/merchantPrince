package Category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="categories")
@Getter
@Setter
public class CategoryEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryId;
	
	@Column(nullable = false, length = 255)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "perent_id", referencedColumnName = "categoryId", nullable = true)
	private CategoryEntity parentCategory;

}
