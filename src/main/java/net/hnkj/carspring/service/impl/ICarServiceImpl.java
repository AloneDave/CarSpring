package net.hnkj.carspring.service.impl;

import net.hnkj.carspring.mapper.CarMapper;
import net.hnkj.carspring.model.Car;
import net.hnkj.carspring.service.ICarService;
import net.hnkj.carspring.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ICarServiceImpl implements ICarService {

    @Autowired
    private CarMapper carMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return carMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Car record) {
        return 0;
    }

    @Override
    public int insertSelective(Car record) {
        return carMapper.insertSelective(record);
    }

    @Override
    public Car selectByPrimaryKey(Integer id) {
        return carMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Car record) {
        return carMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Car record) {
        return carMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Car> listBook(Car car, PageBean pageBean) {
        return carMapper.listBook(car);
    }
}
