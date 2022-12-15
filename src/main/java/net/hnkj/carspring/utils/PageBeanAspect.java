package net.hnkj.carspring.utils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * aop环绕通知，在*Biz.list*()方法前后执行，与mybatis的PageHelper插件一起完成PageBean的初始化
 *
 * @author Administrator
 */
@Component
@Aspect
public class PageBeanAspect {

    @Around(value = "execution(* *..*Service.list*(..))")
    public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
        // 取出PageBean
        Object[] args = joinPoint.getArgs();
        PageBean pageBean = null;
        for (Object obj : args) {
            if (obj instanceof PageBean) {
                pageBean = (PageBean) obj;
                break;
            }
        }

        // 如果分页，指定分页参数
        if (null != pageBean && pageBean.isPagination()) {
            PageHelper.startPage(pageBean.getPage(), pageBean.getRows());
        }

        //放行  执行目标方法
        Object returnValue = joinPoint.proceed(args);

        // 如果分页，获得总记录数
        if (null != pageBean && pageBean.isPagination() && null != returnValue &&
                returnValue instanceof List) {
            List list = (List) returnValue;
            PageInfo pageInfo = new PageInfo(list);
            Long total = pageInfo.getTotal();
            pageBean.setTotal(total.intValue());
        }

        return returnValue;
    }
}
