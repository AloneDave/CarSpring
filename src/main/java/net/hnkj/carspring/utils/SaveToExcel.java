package net.hnkj.carspring.utils;


import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

public class SaveToExcel<T> {

    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    private static void setColumnWidth(HSSFSheet sheet, int colNum) {
        for (int i = 0; i < colNum; i++) {
            int v = 0;
            v = Math.round(Float.parseFloat("15.0") * 37F);
            v = Math.round(Float.parseFloat("20.0") * 267.5F);
            sheet.setColumnWidth(i, v);
        }
    }

    public void writeExcel(List<T> list, String fileAbPath) throws Exception {
        // 列数
        int columnNum;
        int rows = list.size(); // 行数
        File file;
        // 判断文件类型,如果不是以.xls结尾，那么停止执行
        file = new File(fileAbPath);
        if (!file.getName().endsWith("xls")) {
            return;
        }
        // 如果文件不存在，则重新创建
        if (!file.exists()) {
            file.createNewFile();
        }
        if (list.size() == 0 || list.equals("") || list == null) {
            return;
        }
        // 反射获得类的属性个数 ,也就得到了你要打印的列数
        Class obClass = list.get(0).getClass();
        Field[] fields = obClass.getDeclaredFields();

        columnNum = fields.length;

        // 得到该对象的属性名字，存到数组中去
        String[] titleNames = new String[columnNum];

        for (int i = 0; i < columnNum; i++) {
            titleNames[i] = fields[i].getName();
            System.out.println(titleNames[i]);
        }
        // 创建工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        setColumnWidth(sheet, titleNames.length);

        HSSFRow row = sheet.createRow(0);
        // 创建一个单元格
        HSSFCell cell = null;
        // 创建表头
        for (int i = 0; i < titleNames.length; i++) {
            cell = row.createCell(i);
            // 设置样式
            HSSFCellStyle cellStyle = workbook.createCellStyle();
            cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 设置字体居中
            // 设置字体
            HSSFFont font = workbook.createFont();
            font.setFontName("宋体");
            font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 字体加粗
            // font.setFontHeight((short)12);
            font.setFontHeightInPoints((short) 13);
            cellStyle.setFont(font);
            cell.setCellStyle(cellStyle);

            cell.setCellValue(titleNames[i]);
        }

        for (int i = 1; i < (list.size() + 1); i++) {
            // 创建第i行
            HSSFRow nextRow = sheet.createRow(i);
            for (int j = 0; j < titleNames.length; j++) {
                T eQuestion = list.get(i - 1);
                HSSFCell cell2 = nextRow.createCell(j);
                Field field = eQuestion.getClass().getDeclaredField(fields[j].getName());
                field.setAccessible(true);
                String s = (String) field.get(eQuestion);
                cell2.setCellValue(s);
            }
        }

        try {
            // 打开文件流
            FileOutputStream outputStream = FileUtils.openOutputStream(file);
            workbook.write(outputStream);
            outputStream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
