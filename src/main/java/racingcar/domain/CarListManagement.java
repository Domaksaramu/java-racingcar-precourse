package racingcar.domain;

import java.util.*;


public class CarListManagement {
    private List<CarObject> carsList;
    /////////////private Set<String> setForDuplicateNames;
    private Integer carsNumber = 0;

    public CarListManagement(List<String> carNames){
        this.carsNumber = carNames.size();
        carsList = initCarList(carNames);
    }
    public CarListManagement(){
        this.carsList = new ArrayList<>();
    }

    private List<CarObject> initCarList(List<String> carNames) {
        List<CarObject> resultList = new ArrayList<>();
        for(String carName : carNames){
            resultList.add(new CarObject(carName));
        }
        return resultList;
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

    public void setCarsList(List<CarObject> carsList) {
        this.carsList = carsList;
        this.carsNumber = carsList.size();
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
            if(maxCar.getForwardCount() == car.getForwardCount()){
                resultList.add(new CarObject(car));
            }
        }
        return resultList;
    }
    public void verifyDuplicateNames(){

        return;
    }
    @Override
    public String toString() {
        return "{" +
                "carsList=" + carsList +
                ", carsNumber=" + carsNumber +
                '}';
    }
}
