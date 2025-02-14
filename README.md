# MerchantPrince 🏪  
**이커머스 기능을 구현한 프로젝트**로, **상품 등록/조회, 장바구니, 주문** 등의 기능을 포함합니다.  
유저(User)와 판매자(Seller)의 역할을 구분하여, **판매자는 상품을 등록하고 관리하며, 유저는 상품을 검색하고 구매할 수 있도록 설계**되었습니다.  

---

## **📌 프로젝트 개요**
- **프로젝트명:** MerchantPrince  
- **개발 기간:** 2025.01 ~ 진행 중  
- **주요 기능:**  
  ✅ **판매자(Seller) 페이지**  
    - 상품 등록 / 수정 / 삭제  
    - 등록된 상품 목록 조회  
    - 개별 상품 상세 조회  

  ✅ **소비자(User) 페이지**  
    - 전체 상품 조회  
    - 카테고리별 검색  
    - 장바구니 추가 및 관리  
    - 주문 기능 (결제 제외)  

  ✅ **관리자(Admin) 페이지**  
    - 판매자 관리  
    - 상품 관리  
    - 유저 관리  

---

## **📌 기술 스택**
### **💻 Backend**
- **Java 21**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **MariaDB**
- **Lombok**
- **Spring Validation**

### **🌐 Frontend (예정)**
- **Vue.js**  

### **🛠 DevOps & 기타**
- **Git & GitHub**

---

## **📌 현재 진행 상황 (2025.02 기준)**  
✅ **백엔드 개발 진행 중 (기능 80% 구현 완료)**  
✅ **상품(Product), 주문(Order), 장바구니(Cart), 관리자(Admin) 패키지 설계 완료**  
✅ **JPA 관계 설정 및 API 구현 완료 (등록, 수정, 삭제, 조회 기능 구현됨)**  
✅ **유저(User) & 판매자(Seller) 역할 구분 및 인증 기능 개발됨 (JWT 미적용)**  
✅ **Admin 패키지에서 판매자 관리 기능 추가됨**  
✅ **User 패키지에서 소비자가 볼 상품 목록, 상품 상세 조회 구현됨**  

---

## **📌 남은 작업 및 계획**
### **📌 Backend**
- [ ] **장바구니(Cart) 기능 추가**  
- [ ] **주문(Order) 기능 보완 (재고 차감, 상태 변경)**  
- [ ] **상품 리뷰(Review) 기능 추가 (프로젝트 완료 후 확장 예정)**  

### **📌 Frontend (추후 개발)**
- [ ] **Vue.js로 프론트엔드 UI 개발**  
- [ ] **API 연동 (상품 조회, 장바구니, 주문)**  
- [ ] **Admin 페이지 구성**  

---

## **📌 데이터베이스 설계**
### **📍 주요 테이블**
- `users` (유저 및 판매자 계정 관리)
- `sellers` (판매자 정보)
- `products` (상품 정보)
- `product_images` (상품 이미지)
- `product_options` (상품 옵션)
- `cart` (장바구니)
- `orders` (주문 내역)
- `reviews` (상품 리뷰, 추후 추가 예정)

---


