# ♠️ java-blackjack ♠️

- 블랙잭 게임을 변형한 프로그램을 구현한다.
- 블랙잭 게임은 딜러와 플레이어 중 카드의 합이 21 또는 21에 가장 가까운 숫자를 가지는 쪽이 이기는 게임이다.
- 카드의 숫자 계산은 카드 숫자를 기본으로 하며, 예외로 Ace는 1 또는 11로 계산할 수 있으며, King, Queen, Jack은 각각 10으로 계산한다.
- 게임을 시작하면 플레이어는 두 장의 카드를 지급 받으며, 두 장의 카드 숫자를 합쳐 21을 초과하지 않으면서 21에 가깝게 만들면 이긴다.
- 21을 넘지 않을 경우 원한다면 얼마든지 카드를 계속 뽑을 수 있다.
- 딜러는 처음에 받은 2장의 합계가 16이하이면 반드시 1장의 카드를 추가로 받아야 하고, 17점 이상이면 추가로 받을 수 없다.
- 게임을 완료한 후 각 플레이어별로 승패를 출력한다.

# 🛠️ 기능 구현 목록

- [x] 입력
    - [x] 게임에 참여할 사람의 이름을 입력 받을 수 있다.
    - [x] 한 장 더 받을지 여부를 입력 받을 수 있다.
- [x] 입력 검증
    - [x] 카드 추가 여부를 올바른 형태 (y/n)으로 입력했는지 검증할 수 있다.
- [x] 도메인
    - [x] 이름은 빈 문자열일 수 없다.
    - [x] 게임 참가자의 핸드에 새로운 카드를 추가할 수 있다.
    - [x] 이름이 중복되는 플레이어는 존재할 수 없다.
    - [x] 플레이어가 없는 경우는 게임을 시작할 수 없다.
    - [x] 게임 참가자는 딜러 제외 3명 이하여야 한다.
    - [x] 카드합을 계산할 때 Ace 카드는 1 또는 11로 계산한다
    - [x] 카드합을 계산할 떄 J,Q,K카드는 각각 10으로 계산한다.
    - [x] 점수를 계산할 때 Ace 카드가 있는 경우 21을 넘지 않으면서 가장 가깝도록 유리하게 계산한다
    - [x] 카드합 비교를 통해서 플레이어의 승패를 결정할 수 있다.
    - [x] 카드합 비교를 통해서 딜러의 승패를 계산할 수 있다.
    - [x] 딜러는 17점 미만이면 카드를 받아야 한다.
    - [x] 딜러는 17점 이상이면 카드를 그만 받아야 한다.
    - [x] 핸드에서 에이스가 몇개있는지 파악할 수 있다
    - [x] 핸드의 합을 계산할 수 있다.
    - [x] 저지는 핸드에서 21에 가장 가까운 합을 구할 수 있다.
    - [x] 핸드의 최소합이 21을 초과하면 플레이어는 버스트한다.
    - [x] 핸드의 최소합이 21 이하면 플레이어는 카드를 뽑을지 여부를 선택할 수 있다.
    - [x] 핸드에 카드를 추가할 수 있다.
    - [x] 카드덱에서 카드를 지정한 개수만큼 건네줄 수 있다.
    - [x] 카드덱에서 카드를 한 장 뽑아서 건네줄 수 있다.
    - [x] 카드덱에서 보유한 카드 개수보다 많이 뽑으면 예외가 발생한다.
    - [x] 참여자의 핸드에 초기 카드를 분배할 수 있다.
    - [x] 플레이어는 10억까지 베팅할 수 있다.
    - [x] 플레이어는 핸드를 완성시키는 단계에서 버스트 하면 금액을 모두 잃는다.
    - [x] 처음 두 장의 카드 합이 21이 되는 블랙잭일 경우 베팅 금액의 1.5배를 추가로 얻는다. (소숫점 제거)
    - [x] 플레이어가 블랙잭이고 딜러도 블랙잭이면 플레이어는 베팅 금액을 그대로 돌려받는다.
    - [x] 플레이어가 딜러에게 승리하면 베팅 금액만큼을 추가로 얻는다.
- [x] 출력
    - [x] 각 참여자의 카드 정보를 출력할 수 있다.
    - [x] 각 참여자의 카드 합을 출력할 수 있다.
    - [x] 최종 승패를 출력할 수 있다.
