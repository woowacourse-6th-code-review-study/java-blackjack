# 블랙잭


## 기능 요구 사항

### 플레이어 이름

### 플레이어

- [X] 플레이어는 이름을 갖는다
- [X] 플레이어는 카드들을 갖는다
- [X] 플레이어는 카드를 저장한다 
- [X] 죽었는지 안 죽었는지 여부를 반환한다 (21을 초과하는지)


### 카드

- [X] 문자와 모양을 상태로 갖는다 


### Hand(카드들)

- [X] 여러개의 카드를 갖는다
- [X] 카드의 총합 계산한다 
- [X] 카드 추가한다 


### 카드 게임

- [X] 각 플레이어에게 카드를 2장씩 지급한다
- [X] 플레이어마다 추가 지급한다


### 덱

- [X] 모든 카드를 1장씩 갖고 있다. 
- [X] 랜덤으로 카드를 뽑는다.


### 게임 승패 결정

- [X] 딜러와 모든 플레이어의 승패 여부를 결정한다. 
  - [X] 딜러와 플레이어 둘다 21을 초과할 경우, 플레이어가 패배한다. 
  - [X] 카드 합계가 딜러는 21 이하, 플레이어는 21 초과인 경우, 플레이어가 패배한다.  
  - [X] 카드 합계가 딜러는 21 초과, 플레이어는 21 이하인 경우, 플레이어가 승리한다. 
  - [X] 카드 합계가 딜러와 플레이어 모두 21 이하인 경우, 숫자가 큰 사람이 승리한다.
  - [X] 카드 합계가 딜러와 플레이어 모두 21 이하이고 동일한 경우, 무승부다. 


### 인풋 뷰

- [X] 참가자의 이름을 입력받는다.
  - [X] 이름은 쉼표 기준으로 분리한다.
- [X] 카드 추가 여부를 입력받는다. 
  - [X] y 또는 n이 아닌 경우, 예외를 발생한다. 
  - [X] 사용자 카드 합이 21을 초과하면, 카드 추가 여부를 묻지 않는다.
  - [X] 플레이어가 n을 입력할 때까지 카드 추가 여부를 묻는다.


### 아웃풋 뷰

- [X] 딜러와 플레이어 전원에게 초기에 분배한 카드 출력한다. 
  - [X] 딜러의 카드는 1장만 공개한다. 
- [X] 플레이어가 보유한 모든 카드를 출력한다.
- [X] 딜러가 추가 카드를 발급 받았는지 여부 출력한다. 
- [X] 보유한 모든 카드의 합을 출력한다. 
- [X] 최종 승패를 출력한다. 


## 베팅 

### 카지노

- [ ] 은행과 유사한 역할로 플레이어의 계좌를 관리한다.
- [ ] 계좌는 사용자 이름으로 맵핑한다. 
- [ ] 승패 결과에 따라 송금을 진행한다. 
- [ ] 플레이어의 잔고를 조회한다. 


### 잔고

- [x] 사용자의 돈을 저장한다. 
- [x] 입금할 수 있다. 
- [x] 출금할 수 있다. 
