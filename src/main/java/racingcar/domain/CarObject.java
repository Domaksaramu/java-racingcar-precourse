package racingcar.domain;

/**
 * currentRoundNumber 현재 회차 숫자
 * forwardCount 전진 횟수 누적 카운트
 */
public class CarObject {
    private Integer currentRoundNumber;
    private Integer forwardCount;

    public Integer getCurrentRoundNumber() {
        return currentRoundNumber;
    }

    public Integer getForwardCount() {
        return forwardCount;
    }

    public void setCurrentRoundNumber(Integer currentRoundNumber) {
        this.currentRoundNumber = currentRoundNumber;
    }

    public void setForwardCount(Integer forwardCount) {
        this.forwardCount = forwardCount;
    }
}
