package net.hnkj.carspring.mapper;

import net.hnkj.carspring.model.Car;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Car record);

    int insertSelective(Car record);

    Car selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Car record);

    int updateByPrimaryKey(Car record);

    //查询全部汽车信息
    List<Car> listCar(Car car);
}