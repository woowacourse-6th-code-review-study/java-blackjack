# java-blackjack

블랙잭 미션 저장소

## 페어와 지킬 컨벤션
1. 클래스 정의 다음 줄은 공백으로 한다.
2. test code에 사용하는 메서드는 `static import`한다.

## 요구사항
### 카드
- [x] 카드는 모양과 수로 이루어져 있다.
  - [x] 모양으로는 스페이드, 다이아, 하트, 클로버가 있다.
  - [x] 수로는 Ace, King, Queen, Jack과 2 이상 10 이하의 정수가 있다.
- [x] 카드의 숫자 계산은 카드 숫자를 기본으로 한다.
  - [x] Ace는 1 또는 11로 계산할 수 있다.
  - [x] King, Queen, Jack은 각각 10으로 계산한다.
  
### 덱
- [x] 맨 위의 카드 한 장을 뽑는다.
- [x] 덱에 카드가 없는 경우, 예외를 발생한다.

### 플레이어
- [x] 덱에서 카드를 한 장 뽑는다.
- [x] 지금까지 뽑은 카드의 점수를 계산한다.

### 이름
- [x] 이름은 2글자 이상 5글자 이하이다.
- [x] 이름은 공백으로만 구성될 수 없다.

### 플레이어들
- [x] 플레이어들의 이름은 중복될 수 없다.
- [x] 플레이어들의 인원수는 1명 이상 10명 이하이다.

### 딜러
- [x] 플레이어의 기능을 상속한다.
- [x] 17점 이상이 될 때까지 카드를 계속 뽑는다.

### 게임 결과
- [x] 게임 결과를 아래의 순서대로 올바르게 판단한다.
  1. 플레이어의 점수가 21점을 초과하면 딜러가 승리한다.
  2. 플레이어의 점수가 21점을 초과하지 않으면서 딜러의 점수가 21점을 초과하면 플레이어가 승리한다.
  3. 딜러와 플레이어의 점수를 비교해 승패를 결정한다.
  4. 점수가 같으면 무승부이다.
- [x] 각 플레이어별 게임 결과를 저장한다.

---

### 게임 흐름
- [x] (hit, stand) 21을 넘지 않을 경우 원한다면 카드를 계속 뽑을 수 있다.
- [x] 게임이 시작할 때 딜러와 플레이어는 두 장의 카드를 지급 받는다.
- [x] 플레이어의 카드는 모두에게 공개된다.
- [x] 딜러의 두 번째 카드는 공개되지 않는다.
- [x] 플레이어가 카드를 새로 뽑을 때마다 카드 현황을 공개한다.
- [x] 각 플레이어는 딜러와만 승패를 겨룬다.
- [x] 딜러는 모든 플레이어와 승패를 겨룬다.
- [x] 게임을 완료한 후 딜러를 포함한 모든 플레이어의 승패를 확인한다.
