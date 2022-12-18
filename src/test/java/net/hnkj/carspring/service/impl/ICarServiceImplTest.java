package net.hnkj.carspring.service.impl;

import net.hnkj.carspring.model.Car;
import net.hnkj.carspring.service.ICarService;
import net.hnkj.carspring.utils.PageBean;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ICarServiceImplTest {

    @Autowired
    private ICarService carService;
    private Car car;
    private PageBean pageBean;

    @BeforeEach
    void setUp() {
        car = new Car();
        pageBean = new PageBean();
    }

    @Test
    void deleteByPrimaryKey() {
    }

    @Test
    void insert() {
    }

    @Test
    void insertSelective() {
    }

    @Test
    void selectByPrimaryKey() {
    }

    @Test
    void updateByPrimaryKeySelective() {
    }

    @Test
    void updateByPrimaryKey() {
    }

    @Test
    void listCar() {
        car.setCarname("路虎");
        List<Car> cars = carService.listCar(car,pageBean);
        for (Car car1 : cars) {
            System.out.println(car1);
        }
    }
}