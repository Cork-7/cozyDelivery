# 미니 프로젝트 

## 개발 환경
- Language: Java
- Framework: Spring Boot
- Build Tool: Gradle
- Database: MySQL
- ORM: Spring Data JPA
- IDE: IntelliJ IDEA
- API Test: Swagger UI
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
  <summary>### Product</summary>summary>
  - 상품 등록
  <img width="1430" height="369" alt="스크린샷 2026-03-27 오후 4 18 53" src="https://github.com/user-attachments/assets/a11ad314-b102-4ab8-8af1-ed08014a5f7e" />
  <img width="1414" height="670" alt="스크린샷 2026-03-27 오후 4 19 25" src="https://github.com/user-attachments/assets/3b20e95c-dc44-4b64-aacc-ce15c3b131fb" />
- 상품 단일 조회
  <img width="1427" height="929" alt="스크린샷 2026-03-27 오후 4 20 11" src="https://github.com/user-attachments/assets/cb0979f8-4ece-4adf-8ce3-1c7cc22ac608" />
- 상품 전체 조회
  <img width="1417" height="832" alt="스크린샷 2026-03-27 오후 4 20 46" src="https://github.com/user-attachments/assets/ebc43ed2-ab32-43b0-9f9c-09f8c73ef5ea" />
- 상품 수정
  <img width="1418" height="460" alt="스크린샷 2026-03-27 오후 4 21 38" src="https://github.com/user-attachments/assets/ef65138c-a47a-4700-a8cf-b7e85aeae625" />
- 상품 삭제
  <img width="1419" height="797" alt="스크린샷 2026-03-27 오후 4 22 10" src="https://github.com/user-attachments/assets/339a2c53-bc1a-449d-8f10-963b2332a037" />
  <img width="520" height="149" alt="스크린샷 2026-03-27 오후 4 22 34" src="https://github.com/user-attachments/assets/c85e3d7a-f8fe-4ec8-a67a-82b0c4d6baef" />
</details>


<details>
### Order
- 주문
</details>



