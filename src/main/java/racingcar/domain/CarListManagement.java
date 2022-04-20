package racingcar.domain;

import java.util.*;


public class CarListManagement {
    private List<CarObject> carsList;
    private Integer carsNumber = 0;

    public CarListManagement(){
        this.carsList = new ArrayList<>();
    }

    /**
     * 입력받은 자동차 이름 리스트로부터 CarObject 리스트를 생성
     * @param carNames 자동차 이름 리스트
     */
    public CarListManagement(List<String> carNames){
        this.carsList = createCarListByNames(carNames);
        this.carsNumber = carNames.size();
        verifyDuplicateNames(this.carsList);
    }
    private List<CarObject> createCarListByNames(List<String> carNames) {
        List<CarObject> resultList = new ArrayList<>();
        for(String carName : carNames){
            resultList.add(new CarObject(carName));
        }
        return resultList;
    }

    /**
     * CarObject 리스트를 입력받음
     * @param carsList
     */
    public void setCarsList(List<CarObject> carsList) {
        this.carsList = carsList;
        this.carsNumber = carsList.size();
        verifyDuplicateNames(carsList);
    }

    /**
     * 입력받은 carsList 에서 이름 중복 여부를 검사
     * 중복이 있을경우 Exception
     */
    public void verifyDuplicateNames(List<CarObject> carsList){;
        Set<String> setForDuplicateNames = new HashSet<>();
        for (CarObject car: carsList) {
            setForDuplicateNames.add(car.getCarName());
        }
        if(setForDuplicateNames.size() != carsList.size())
            throw new IllegalArgumentException(RacingCarExeception.DUPLICATION_ARGUMENTS);
    }
    /**
     * 전진횟수를 내림차순으로 정렬 (comparable.compareTo가 내림차순 기준)
     * @return
     */
    public List<CarObject> sortCarsList(){
        Collections.sort(this.carsList);
        return this.carsList;
    }

    public Integer getCarsNumber() {
        return carsNumber;
    }

    public List<CarObject> getCarsList() {
        return carsList;
    }


    public void setCarsNumber(Integer carsNumber) {
        this.carsNumber = carsNumber;
    }
    public void addCar(String carName){
        CarObject car = new CarObject(carName);
        this.carsList.add(car);
    }
    public void addCar(CarObject car){
        this.carsList.add(car);
    }

    /**
     * 자동차 리스트에서 Max값을 추출하여
     * 해당 값과 동일한 값의 자동차 리스트를 추출
     * (내림차순으로 정렬하므로, index가 0인 값이 Max)
     * @return
     */
    public List<CarObject> getMaxCarObjects(){
        List<CarObject> resultList = new ArrayList<>();
        sortCarsList();
        CarObject maxCar = new CarObject(this.carsList.get(0));
        for (CarObject car: this.carsList) {
            addToMaxList(resultList, car);
        }
        return resultList;
    }
    public void addToMaxList(List<CarObject> resultList, CarObject car){
        if(this.carsList.get(0).getForwardCount() == car.getForwardCount())
            resultList.add(new CarObject(car));
    }
    @Override
    public String toString() {
        return "{" +
                "carsList=" + carsList +
                ", carsNumber=" + carsNumber +
                '}';
    }
}
