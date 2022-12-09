package net.hnkj.carspring.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cglib.beans.BeanMap;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 服务器返回给客户端的JSON格式的数据
 */
public class JsonData extends HashMap<String, Object> {

    /**
     * JSON转换器
     */
    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * 常量定义
     */
    private static final int SUCCESS_CODE = 0;//操作代码：0 成功
    private static final int FAILED_CODE = -1;//操作代码：非0 失败
    private static final String EMPTY_STRING = "";//空字符串

    /**
     * keys
     */
    private static final String DATASOURCE_KEY = "datasource";
    private static final String FORM_KEY = "form";
    private static final String ROW_KEY = "row";
    private static final String CODE_KEY = "code";
    private static final String MESSAGE_KEY = "message";
    private static final String ROWS_KEY = "rows";
    private static final String TOTAL_KEY = "total";


    public JsonData() {
        this.put(DATASOURCE_KEY, new HashMap<String, Object>());
        this.put(FORM_KEY, new HashMap<String, Object>());
        this.put(CODE_KEY, SUCCESS_CODE);
        this.put(MESSAGE_KEY, EMPTY_STRING);
    }

    /**
     * 向datasource中添加新的数据源
     *
     * @param key
     * @param value
     */
    public void setDatasource(String key, Object value) {
        Map<String, Object> datasource = (Map<String, Object>) this.get(DATASOURCE_KEY);
        datasource.put(key, value);
    }


    /**
     * 使用指定的对象的相关属性生成Json表单对象
     *
     * @param bean
     */
    public void initForm(Object bean) {
        if (bean != null) {
            Map<String, Object> form = (Map<String, Object>) this.get(FORM_KEY);
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                form.put(key + "", beanMap.get(key));
            }
        }
    }

    /**
     * 使用指定属性生成JSON表单对象
     *
     * @param keys
     */
    public void initForm(String... keys) {
        if (null != keys && 0 != keys.length) {
            Map<String, Object> form = (Map<String, Object>) this.get(FORM_KEY);
            for (String key : keys) {
                form.put(key, EMPTY_STRING);
            }
        }
    }

    /**
     * 向Form中添加新的元素
     *
     * @param key
     * @param value
     */
    public void setForm(String key, Object value) {
        Map<String, Object> form = (Map<String, Object>) this.get(FORM_KEY);
        form.put(key, value);
    }

    /**
     * 设置row对象
     *
     * @param row
     */
    public void setRow(Object row) {
        this.put(ROW_KEY, row);
    }


    /**
     * 设置操作消息
     *
     * @param message
     */
    public void setMessage(String message) {
        this.put(MESSAGE_KEY, message);
    }

    /**
     * 设置失败操作代码：失败 -1
     */
    public void setFailedCode() {
        this.put(CODE_KEY, FAILED_CODE);
    }

    /**
     * 设置成功操作代码：成功 0
     */
    public void setSuccessCode() {
        this.put(CODE_KEY, SUCCESS_CODE);
    }

    /**
     * 设置操作代码
     *
     * @param code
     */
    public void setCode(int code) {
        this.put(CODE_KEY, code);
    }

    /**
     * 把当前JsonData对象转成json序列，并把结果输出成字符串
     *
     * @return
     */
    public String toJSONString() {
        try {
            String json = mapper.writeValueAsString(this);
            return json;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 把当前JsonData对象转成json序列，并保存到输出流os中
     *
     * @param os
     */
    public void toJSONString(OutputStream os) {
        try {
            mapper.writeValue(os, this);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 设置查询结果
     *
     * @param rows
     */
    public void setRows(List<?> rows) {
        this.put(ROWS_KEY, rows);
    }

    /**
     * 设置总记录数
     *
     * @param total
     */
    public void setTotal(Integer total) {
        this.put(TOTAL_KEY, total);
    }
}
