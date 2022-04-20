package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarListManagemnetTest {
    @DisplayName("입력받은 String List로 CarsListManagemsnt 생성")
    @Test
    public void generateCarsListTest(){
        List<String> carsNamesList = new ArrayList<>();
        carsNamesList.add("TEST1");
        carsNamesList.add("TEST2");
        carsNamesList.add("TEST3");
        CarListManagement carListManagement = new CarListManagement(carsNamesList);
        assertThat(carListManagement.toString()).isEqualTo("{carsList=[{carName='TEST1', forwardCount=0, currentRoundNumber=-1}, {carName='TEST2', forwardCount=0, currentRoundNumber=-1}, {carName='TEST3', forwardCount=0, currentRoundNumber=-1}], carsNumber=3}");
    }

    @DisplayName("정렬되지 않은 cartList를 내림차순으로 정렬")
    @Test
    public void carListSortTest(){
        CarListManagement carListManagement = new CarListManagement();
        List<CarObject> carList = new ArrayList<>();
        CarObject car1 = new CarObject("TEST1");
        car1.setForwardCount(1);
        carList.add(car1);
        CarObject car2 = new CarObject("TEST2");
        car2.setForwardCount(2);
        carList.add(car2);
        CarObject car3 = new CarObject("TEST3");
        car3.setForwardCount(3);
        carList.add(car3);
        carListManagement.setCarsList(carList);
        carListManagement.sortCarsList();
        assertThat(carListManagement.toString()).isEqualTo("{carsList=[{carName='TEST3', forwardCount=3, currentRoundNumber=-1}, {carName='TEST2', forwardCount=2, currentRoundNumber=-1}, {carName='TEST1', forwardCount=1, currentRoundNumber=-1}], carsNumber=3}");
    }

    @DisplayName("CarListManagement로부터 Max List 추출")
    @Test
    public void getMaxCarObjectsTest(){
        CarListManagement carListManagement = new CarListManagement();
        List<CarObject> carList = new ArrayList<>();
        CarObject car1 = new CarObject("TEST1");
        car1.setForwardCount(1);
        carList.add(car1);
        CarObject car2 = new CarObject("TEST2");
        car2.setForwardCount(2);
        carList.add(car2);
        CarObject car3 = new CarObject("TEST3");
        car3.setForwardCount(3);
        carList.add(car3);
        CarObject car4 = new CarObject("TEST4");
        car4.setForwardCount(3);
        carList.add(car4);
        carListManagement.setCarsList(carList);
        assertThat(carListManagement.getMaxCarObjects().toString()).isEqualTo("[{carName='TEST3', forwardCount=3, currentRoundNumber=-1}, {carName='TEST4', forwardCount=3, currentRoundNumber=-1}]");
    }

    @DisplayName("중복된 String List를 할당하여, 중복에 대한 Exception이 일어나는지 테스트")
    @Test
    public void duplicateStringListTest(){
        List<String> carsNamesList = new ArrayList<>();
        carsNamesList.add("TEST1");
        carsNamesList.add("TEST2");
        carsNamesList.add("TEST3");
        carsNamesList.add("TEST3");
        assertThatThrownBy(()->new CarListManagement(carsNamesList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RacingCarExeception.DUPLICATION_ARGUMENTS);
    }
}
