package merchantPrince;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	  @Override
	    public void addCorsMappings(CorsRegistry registry) {
		  System.out.println("CORS 설정이 적용되었습니다.");
	        registry.addMapping("/**") // 모든 엔드포인트에 대해 CORS 허용
	                .allowedOrigins("http://localhost:8080") // Vue 개발 서버 URL
	                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 허용할 HTTP 메서드
	                .allowedHeaders("*") // 모든 헤더 허용
	                .allowCredentials(true); // 쿠키 전송 허용
	    }
	}
/*
 * 프론트랑 포트달라서 크로스 문제 해결위해 웹콘피그 클래스 생성
 */