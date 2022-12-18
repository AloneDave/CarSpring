package net.hnkj.carspring.service;

import net.hnkj.carspring.model.Car;
import net.hnkj.carspring.utils.PageBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ICarService {

    int deleteByPrimaryKey(Integer id);

    int insert(Car record);

    //新增汽车
    int insertSelective(Car record);

    @Transactional(readOnly = true)
    Car selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Car record);

    int updateByPrimaryKey(Car record);

    //查询全部汽车信息
    @Transactional(readOnly = true)
    List<Car> listCar(Car car, PageBean pageBean);
}