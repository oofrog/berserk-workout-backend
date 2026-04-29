# 🏋️‍♂️ 운동 루틴 관리 서비스 (Workout Routine Service)
> **Spring Boot와 JPA를 활용한 객체 지향적 운동 루틴 설계 프로젝트**
<img width="400" height="320" alt="image" src="https://github.com/user-attachments/assets/91946564-f10d-44d3-9434-2e4b18a1310b" />

## 🔗 Preview
<img width="2196" height="1642" alt="Group 1" src="https://github.com/user-attachments/assets/892ca908-de69-4532-b10e-629c964e4908" />

## 🛠 Tech Stack
* **Language:** Java 17
* **Framework:** Spring Boot 3.x
* **ORM:** Spring Data JPA
* **Database:** H2 (In-memory)
* **Build Tool:** Gradle

## 💎 Key Features & Engineering
* **Server-side Rendering:** Controller에서 Model 객체를 통해 데이터를 View로 전달하고, Thymeleaf를 활용해 동적인 웹 페이지를 생성하는 전 과정을 구현했습니다.
* **Form Handling & Validation:** 유저의 운동 루틴 입력 데이터를 서버에서 검증(Validation)하고, 객체 지향적으로 데이터를 처리하는 로직을 구축했습니다.
* **N:M 관계의 객체 지향적 구현:** '운동'과 '루틴'의 다대다 관계를 DB 레벨뿐만 아니라, 화면에서 사용자에게 어떻게 보여지고 선택되어야 하는지 고민하며 엔티티를 설계했습니다.

## 📝 Lessons Learned
1. **웹 서비스의 전체 흐름 파악:** HTTP 요청부터 Controller의 처리, 그리고 View로 데이터가 렌더링되기까지의 'Full-cycle'을 직접 구현하며 웹 서비스의 동작 원리를 깊이 있게 이해했습니다.
2. **효율적인 상태 관리:** 서버에서 화면의 상태를 제어하는 경험을 통해, 이후 REST API 협업 시 프론트엔드 개발자가 어떤 데이터를 필요로 할지 역지사지로 생각할 수 있는 시야를 갖게 되었습니다.
