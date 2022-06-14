# CafePosSystem

## 자바 콘솔 토이프로젝트<카페관리시스템>

## 개발 환경

<img src="https://img.shields.io/badge/Eclipse%20IDE-2C2255?style=flat&logo=Eclipse%20IDE&logoColor=white"/>

## 개발 언어

<img src="https://img.shields.io/badge/JAVA-007396?style=flat&logo=Java&logoColor=white"/>

  - JDK 11.02으로 진행하였습니다.

## 주요 기능

- 주문관리(주문기능)

- 메뉴관리

- 매출관리

- 회원관리

## 토이 프로젝트를 하는 이유

- 병원 예약 시스템은 팀프로젝트로 끝난 후에 진행했습니다. 개인 능력만으로 설계 및 구현을 해보고 싶어서 시작하게 되었습니다.

- 자바의 스트림, 컬렉션를 연습합니다.

- 데이터를 처리하는 혹은 출력을 관리하는 클래스 등 용도에 따라 구분하고 서로 상호작용적인 설계하려합니다.

- +) 6월 5일부터 git 컨벤션 규칙에 따라 커밋을 연습합니다.

## 진행하면서 있었던 일

- DB가 있어야 가능한 데이터 설계
  
  - 데이터 설계 중 주문번호와 주문내역 사이에 오류를 발견하지 못해서 구조적으로 문제가 발생했습니다.
  - 매일 시작할때마다 주문번호가 1로 초기화할 수 있는 방법이 없고, 주문정보(날짜정보, 관리자정보)와 주문내역을 같이 관리하여 중복된 데이터가 많이 생기는 방식으로 설계했습니다
  - Calendar로 날짜와 시간 데이터로 저장하고, 주문정보와 주문내역을 따로 분리하여 주문번호로 연결될 수 있는 방식으로 수정했습니다.

- 코드 테스트
  
  - 제작 후 다양한 테스트를 진행하지 못해서 오류가 발생했습니다
  - 예시) 회원관리
  - 회원의 추가, 수정, 삭제를 만든 후 새로 회원을 추가하고 수정, 삭제했을때에는 문제가 없었습니다
  - 중간에 있는 회원을 삭제한 후 추가, 수정, 삭제를 해보니 마지막 회원번호를 참조하여 새로운 회원을 생성해야하는 데 회원 데이터의 인덱스 번호로 접근하여 오류가 발생했습니다
  - 마지막 회원번호를 갖는 메소드를 만들어 해결하였습니다.
 
 - 코드 리팩토링
   - 기능, 메뉴마다 테스트를 진행하면서 중복된 코드를 변경했습니다
   - 예시) 매출관리
   - 매출관리에서 연, 월, 일매출은 조건만 다른 같은 코드로 작성되어있었습니다
   - 매개변수를 추가하여 연/월/일을 구분하고, 공통되는 코드를 묶어 메소드로 변경하였습니다
   - 예기) 회원관리
   - 회원 수정과 삭제에서 같은 방식으로 회원을 검색해서 메소드로 변경하였습니다.  

---

### 공통 기능

- 아이템 수에 따른 페이지 이동 기능

### 메뉴별 기능

- 메뉴관리, 카페에서 판매하는 메뉴의 CRUD기능

- 회원관리, 카페에 단골을 관리하기 위해 만든 메뉴
  - 회원 CRUD
  - 회원의 포인트, 쿠폰 수 관리

- 관리자 
  - 로그인
  - 로그아웃

- 주문관리
  - 주문 내역(비회원)
  - 진행 중인 주문 취소
  - 주문 내역(회원) : 포인트,쿠폰 적립, 쿠폰 사용

- 매출 관리(연월일별)
  - 매출액 출력
  - 음료 판매량 출력 
  - 쿠폰 사용에 따른 할인금액 출력

---

## 진행

- 테스트 진행중

- 출력되는 디자인 수정중

