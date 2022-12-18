package net.hnkj.carspring.controller;

import net.hnkj.carspring.model.Car;
import net.hnkj.carspring.service.ICarService;
import net.hnkj.carspring.utils.JsonData;
import net.hnkj.carspring.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/car")
@CrossOrigin
public class CarController {

    @Autowired
    private ICarService carService;

    /**
     * 查询所有汽车
     * @param car
     * @param pageBean
     * @return
     */
    @RequestMapping("/list")
    public JsonData list(Car car, PageBean pageBean){
        JsonData jsonData = new JsonData();
        List<Car> cars = carService.listCar(car,pageBean);
        jsonData.setCode(0);
        jsonData.setMessage("查询成功");
        jsonData.setRows(cars);
        jsonData.setTotal(pageBean.getTotal());
        return jsonData;
    }

    @RequestMapping("/updataAndInsert")
    public JsonData updataAndInsert(Car car){
        JsonData jsonData = new JsonData();

        if(null==car.getId()){ //如果前端没有传入汽车id 就是汽车新增
            int i = carService.insertSelective(car);
            if(i==1){  //如果i==1 新增成功
                jsonData.setCode(1);
                jsonData.setMessage("汽车新增成功");
            }else {
                jsonData.setCode(0);
                jsonData.setMessage("汽车新增失败");
            }
        }else {//前端传过来的参数中包含id 就是汽车修改
            int i = carService.updateByPrimaryKeySelective(car);
            if(i==1){
                jsonData.setCode(1);
                jsonData.setMessage("汽车修改成功");
            }else {
                jsonData.setCode(0);
                jsonData.setMessage("汽车修改失败");
            }
        }

        return jsonData;
    }


    @RequestMapping("/del")
    public JsonData del(Car car){
        JsonData jsonData = new JsonData();

        int i = carService.deleteByPrimaryKey(car.getId());
        if(i==1){
            jsonData.setCode(1);
            jsonData.setMessage("汽车删除成功");
        }else{
            jsonData.setCode(0);
            jsonData.setMessage("汽车删除失败");
        }

        return jsonData;
    }
}
