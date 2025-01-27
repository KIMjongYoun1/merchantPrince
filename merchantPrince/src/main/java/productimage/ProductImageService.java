package productimage;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import product.Product;
import product.ProductRepository;

@Service
public class ProductImageService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductImageRepository productImageRepository;

	// 상품 이미지 등록
	public ProductImageResponseDTO addProductImage(ProductImageRequestDTO requestDTO) {

		Product produt = productRepository.findById(requestDTO.getProductId())
				.orElseThrow(() -> new RuntimeException("상품을 찾을 수 없습니다."));

		ProductImage productImage = new ProductImage();
		productImage.setProduct(produt); // 상품 연관 이미지
		productImage.setImageUrl(requestDTO.getImageUrl()); // 이미지 url 설정
		// DB 저장
		ProductImage saveProductImage = productImageRepository.save(productImage);
		// 저장된 이미지 responseDTO로 변환하여 반환
		return new ProductImageResponseDTO(saveProductImage);
	}

//	public ProductImage addProductImage(Long productId, String imageUrl) {
//		// 상품id로 선 조회
//		Product product = productRepository.findById(productId)
//											.orElseThrow(() -> new RuntimeException("상품을 찾을 수 없습니다"));
//		
//		ProductImage productImage = new ProductImage();
//		productImage.setProduct(product);// 상품과 연관된 이미지 설정
//		productImage.setImageUrl(imageUrl);// url 설정
//		return productImageRepository.save(productImage);
//	}
	
	//상품 이미지 수정
	public ProductImageResponseDTO updateProductImage(Long imageId, ProductImageRequestDTO requestDTO) {
		ProductImage productImage = productImageRepository.findById(imageId)
														.orElseThrow(() -> new RuntimeException("이미지를 찾을 수 없습니다."));
		productImage.setImageUrl(requestDTO.getImageUrl());
		ProductImage updatedProductImage = productImageRepository.save(productImage);
		return new ProductImageResponseDTO(updatedProductImage);
	}

	// 상품 이미지 조회
	public List<ProductImageResponseDTO> getImageProductId(Long productId) {
		List<ProductImage> productImages = productImageRepository.findByProductId(productId);
		// 스트림으로 라인업 , 맵으로 조건설정, 최종연산 collect, forEach 등 실행함 행위
		return productImages.stream().map(productImage -> new ProductImageResponseDTO(productImage)) // ProductImage를
																										// 받아서 DTO로 변환
				.collect(Collectors.toList());
	}

	// 상품 이미지 삭제
	public void deleteImage(Long productId) {
		productImageRepository.deleteById(productId);
	}

}
