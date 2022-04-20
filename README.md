# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

# 요구사항
1. 자동차 경주 게임이다.
2. 매 회차 개별 자동차는 전진이 가능하다.
3. 전진은 매회 1칸이하로 이동 가능하다.
4. 전진 조건은 0~9 사이 Random 값을 추출하여, 4이상일 경우 전진(1칸)
5. 완료된 이후 누가 우승했는지 알림
6. 각 자동차의 이름과 게임의 회차는 플레이어로부터 입력받는다.

# 게임설계
1. Domain
   1. 자동차
      1. 정렬을 위한 comparable (내림차순)
      2. 해당 회차 랜덤 값
      3. 자동차 이름
         1. 길이 체크
      4. 전진 횟수
   2. 자동차 리스트
      1. 전진 횟수에 따른 정렬
         1. Max 리스트 추출
      2. 이름 리스트
         1. 이름 리스트에 따른 대수 판별
         2. 이름 중복 처리
      3. 게임 회수
      4. 현재 회차 
2. Service
   1. 랜덤 숫자 생성
      1. Random => ThreadLocalRandom으로 변경
         1. Random의 단점
            1. RandomSeed가 같을 경우 중복값
            2. 불필요한 자원 낭비
               1. 중복을 피하기 위해 매번 currentTimeMillis() 호출
            3. unsafe를 직접 호출하여 oldseed값을 변경
            4. 참고 : https://intrepidgeeks.com/tutorial/implementation-principle-of-random-and-threadlocalrandom
   2. 에러
      1. 에러 종류에 따른 구분
      2. 에러 종류별 메세지
   3. 게임
      1. 자동차 전진 판별
3. UI
   1. 사용자 입력
   2. 문자열 이름으로 파싱
   3. 문자열 숫자로 파싱
   4. 문자열 검증
   5. 문자열 타입 구분

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)
