# 미니 프로젝트 

## 개발 환경
- Language: Java
- Framework: Spring Boot
- Build Tool: Gradle
- Database: MySQL
- ORM: Spring Data JPA
- IDE: IntelliJ IDEA
- API Test: Postman
- DB Tool: DBeaver


## 프로젝트 
### 필수 과제
1. 상품 CRUD
- 상품 등록
- 상품 단건 조회
- 상품 목록 조회
- 상품 수정
- 상품 삭제

2. 주문 생성 및 조회
- 등록된 상품 ID를 이용한 주문 생성
- 주문 단건 조회
- 주문 조회 시 상품 이름 포함
- 상품 이름 수정 시, 기존 주문 조회 결과에도 변경된 상품 이름이 반영되도록 연관관계 설계

### 도전 과제
1. 주문 목록 조회
- 주문 목록 페이지네이션 조회
- 응답 데이터에 상품 이름 포함
- N+1 문제 보안 구현

2. 상품 재고 차감
- 상품에 재고(stack)필드 추가
- 주문 생성 시 재고 차감
- 재고가 0이면 주문 생성 불가
- 재고 차감의 원자성(Automic) 고려

## 응답 화면
<details>
  <summary>Product</summary>
  
#### 상품 등록
  <img width="822" height="550" alt="스크린샷 2026-04-03 오후 2 24 54" src="https://github.com/user-attachments/assets/e08e5a5d-b77f-45d6-bed6-8105aa778331" />

#### 상품 단일 조회
  <img width="781" height="542" alt="스크린샷 2026-04-03 오후 2 25 56" src="https://github.com/user-attachments/assets/f702c0aa-a249-4e84-8ee5-28d0676db7f6" />
  
#### 상품 전체 조회
  <img width="790" height="843" alt="스크린샷 2026-04-03 오후 2 26 33" src="https://github.com/user-attachments/assets/0ed47045-7975-4313-995f-7652fe5cd6e8" />

#### 상품 수정
  <img width="775" height="536" alt="스크린샷 2026-04-03 오후 2 28 01" src="https://github.com/user-attachments/assets/24fb2951-dbf1-43d1-97db-0ada56b270fd" />

#### 상품 삭제
  <img width="726" height="450" alt="스크린샷 2026-04-03 오후 2 39 59" src="https://github.com/user-attachments/assets/063f32f6-7979-41f0-8714-997782477297" />
  <br />
  <img width="567" height="225" alt="스크린샷 2026-04-03 오후 2 40 59" src="https://github.com/user-attachments/assets/951887bd-83c4-4d98-9009-858dcfab1f05" />
</details>


<details>
<summary>Order</summary>
  
#### 주문
  <img width="768" height="572" alt="스크린샷 2026-04-03 오후 2 41 59" src="https://github.com/user-attachments/assets/801004c9-ed4f-43f1-8f93-13172f730ca0" />

#### 주문 단일 조회
<img width="777" height="575" alt="스크린샷 2026-04-03 오후 2 49 34" src="https://github.com/user-attachments/assets/324f6606-1810-4a14-978f-aa0ae92fa03f" />

#### 주문 전제 조회 (페이징)
<img width="1223" height="955" alt="스크린샷 2026-04-03 오후 2 50 13" src="https://github.com/user-attachments/assets/7535de69-8cf1-46dc-80d7-09b469286b2c" />

#### 제품 이름으로 조회
<img width="1206" height="956" alt="스크린샷 2026-04-03 오후 2 50 37" src="https://github.com/user-attachments/assets/50433553-c7c8-43da-8cf8-c4b802c5fb0a" />
</details>




