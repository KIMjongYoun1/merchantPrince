package Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	//카테고리 생성
	@PostMapping
	public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody CategoryRequestDTO categoryRequestDTO){
		CategoryEntity category = categoryService.createCategory(categoryRequestDTO);
		CategoryResponseDTO responseDTO = new CategoryResponseDTO(category);
		return ResponseEntity.ok(responseDTO);
	}
	
	// 카테고리 조회
	@GetMapping("/{id}")
	public ResponseEntity<CategoryResponseDTO> getCategory(@PathVariable Long id){
		CategoryEntity category = categoryService.getCategory(id);
		CategoryResponseDTO responseDTO = new CategoryResponseDTO(category);
		return ResponseEntity.ok(responseDTO);
	}
}
