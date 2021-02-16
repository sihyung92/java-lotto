# java-lotto
로또 미션 진행을 위한 저장소

## 기능 요구사항
### 로또
- 금액에 맞추어 천원당 한 장의 로또를 발급하는 기능 
- 로또 한장당 6개의 로또번호를 자동으로 발급해주는 기능
  - 각 로또번호의 범위는 1 ~ 45
- 당첨 로또 번호와 비교하여 당첨여부를 확인하는 기능
  - 번호가 3개까지 일치하면 5등
  - 번호가 4개 일치하면 4등
  - 번호가 5개 일치하면 3등
  - 번호가 5개 일치하고 보너스 번호가 일치하면 2등
  - 번호가 6개 일치하면 1등  
- 당첨 로또를 상금으로 환산해주는 기능
  - 5등 상금 : 5,000원
  - 4등 상금 : 50,000원
  - 3등 상금 : 1,500,000원 (150만)
  - 2등 상금 : 30,000,000원 (3000만)
  - 1등 상금 : 2,000,000,000원 (20억)  
- 구매금액과 비교하여 수익률을 계산하는 기능

### 뷰 
- 금액을 입력받는 기능 
    - 예외처리 : 입력받은 값이 숫자가 아닐 때
    - 예외처리 : 천원 단위가 아니면 예외
- 구매한 로또의 목록을 출력하는 기능
  - 로또의 각 번호는 오름차순으로 출력
- 당첨번호와 보너스 볼 번호를 입력받는 기능
    - 예외처리 : ',' 로 구분되어있는 숫자 인지
    - 예외처리 : 총 6개로 나누어져 있는지
    - 예외처리 : 각 숫자가 1~45 범위 안에 있는지
    
로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
로또 1장의 가격은 1000원이다.

## 프로그래밍 요구사항
- indent(인덴트, 들여쓰기) depth를 2단계에서 1단계로 줄여라.
- depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
- else를 사용하지 마라.
- 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
- method가 한 가지 일만 하도록 최대한 작게 만들어라.
- 배열 대신 ArrayList를 사용한다.
- java enum을 적용해 프로그래밍을 구현한다.
- 규칙 3: 모든 원시값과 문자열을 포장한다.
- 규칙 5: 줄여쓰지 않는다(축약 금지).
- 규칙 8: 일급 콜렉션을 쓴다.
- 힌트
- 로또 자동 생성은 Collections.shuffle() 메소드 활용한다.
- Collections.sort() 메소드를 활용해 정렬 가능하다.
- ArrayList의 contains() 메소드를 활용하면 어떤 값이 존재하는지 유무를 판단할 수 있다.