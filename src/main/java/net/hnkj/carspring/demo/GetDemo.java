package net.hnkj.carspring.demo;

import net.hnkj.carspring.model.Page;
import net.hnkj.carspring.utils.SaveToExcel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;

class GetDemo {


    public static void main(String[] args) {
//        ==============================将数据放入List======https://www.che168.com/china/a0_0ms50dgscncgpi1ltocsp1exx0/==================================================
        SaveToExcel<Page> pageSaveToExcel = new SaveToExcel<>();
        List<Page> list = new ArrayList<>();
//         =====================================================================================
        //设置驱动
        System.getProperties().setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome Dev\\Application\\chromedriver.exe");
        //实例化驱动对象
        ChromeDriver chromeDriver = new ChromeDriver();

        for (int page_m = 1; page_m <= 100; page_m++) {   //page_m控制页数
            if (page_m==1) {
                String url = "https://www.che168.com/beijing/a0_0ms50dgscncgpi1ltocspexx0/";
                chromeDriver.get(url);


                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                WebElement content_all = chromeDriver.findElement(By.cssSelector(".content.fn-clear.card-wrap"));
                List<WebElement> elements = content_all.findElements(By.xpath("//*[@class='viewlist_ul']/li"));
                List l1 = new ArrayList();
                for (WebElement page : elements) {
                    WebElement a = page.findElement(By.cssSelector("a"));
                    String url2 = a.getAttribute("href"); //获取每个商品的href
                    l1.add(url2);
                }
                System.out.println("================================================================================");

                System.out.println(l1.size());//显示href的个数

                for (int i = 0; i <= l1.size()-2; i++) {
                    String url3 = (String) l1.get(i);
                    chromeDriver.get(url3);
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //爬取商品名、挡位、排量
                    WebElement content_count = chromeDriver.findElement(By.cssSelector(".all-content.content-head.fn-clear"));
                    List<WebElement> elements2 = content_count.findElements(By.cssSelector(".car-box"));
                    for (WebElement page2 : elements2) {
                        WebElement h3 = page2.findElement(By.cssSelector("h3"));
                        String title = h3.getText(); //-----商品名
                        WebElement li3 = page2.findElement(By.cssSelector("li:nth-child(3) h4"));
                        String gear = li3.getText();//gear---挡位
                        gear = gear.substring(0, 2);
                        String Displacement = li3.getText();//Displacement-----排量
                        Displacement = Displacement.substring(5);
//                        Displacement = Displacement.replaceAll("L","");


                        //爬取车辆上牌时间、里程、变速箱、过户次数、车辆级别、颜色
                        WebElement content_count2 = chromeDriver.findElement(By.cssSelector(".all-content.all-basic.scroll-content.fn-clear"));

                        List<WebElement> elements3 = content_count2.findElements(By.cssSelector(".all-basic-content.fn-clear"));//@2
                        for (WebElement page3 : elements3) {
                            WebElement li11 = page3.findElement(By.cssSelector(".basic-item-ul:nth-of-type(1) li:nth-child(1)"));
                            WebElement li12 = page3.findElement(By.cssSelector(".basic-item-ul:nth-of-type(1) li:nth-child(2)"));
                            WebElement li13 = page3.findElement(By.cssSelector(".basic-item-ul:nth-of-type(1) li:nth-child(3)"));
                            WebElement li25 = page3.findElement(By.cssSelector(".basic-item-ul:nth-of-type(2) li:nth-child(5)"));
                            WebElement li32 = page3.findElement(By.cssSelector(".basic-item-ul:nth-of-type(3) li:nth-child(2)"));
                            WebElement li33 = page3.findElement(By.cssSelector(".basic-item-ul:nth-of-type(3) li:nth-child(3)"));
                            String licence_time = li11.getText(); //licence---牌照
                            licence_time = licence_time.substring(4);  //切片-----上牌时间
                            String mileage = li12.getText(); //mileage---里程
                            mileage = mileage.substring(4);  //切片-----表显里程
//                            mileage = mileage.replaceAll("万公里","");
                            String Gearbox = li13.getText();//Gearbox--变速箱
                            Gearbox = Gearbox.substring(7);  //切片-----变速箱
                            String transfer = li25.getText();//transfer-----转移
                            transfer = transfer.substring(4, 5);  //切片-----过户次数
                            String size = li32.getText();//size-----型号
                            size = size.substring(4);  //切片-----车辆级别
                            String color = li33.getText();//color-----颜色
                            color = color.substring(4);  //切片-----车身颜色

                            //=====================爬取城市、品牌、系======================
                            WebElement content_count3 = chromeDriver.findElement(By.cssSelector("body:nth-child(2)"));
                            List<WebElement> elements4 = content_count3.findElements(By.cssSelector(".bread-crumbs.content"));
                            // ============Selenium获取页面指定元素个数===========
                            WebElement content_count31 = chromeDriver.findElement(By.cssSelector("body:nth-child(2) .bread-crumbs.content"));
                            List<WebElement> element41 = content_count31.findElements(By.tagName("a"));
                            int number=element41.size();
//                            System.out.println(number+"=========================================================");
                            for (WebElement page4 : elements4) {
                                if (number>3 && number<7) {
                                    WebElement li02 = page4.findElement(By.cssSelector("a:nth-last-of-type(4)"));
                                    String city = li02.getText();//city------城市
                                    city = city.substring(0, 2);
                                    WebElement li03 = page4.findElement(By.cssSelector("a:nth-last-of-type(3)"));
                                    String brand = li03.getText();//brand------品牌
                                    brand = brand.substring(2);
                                    WebElement li04 = page4.findElement(By.cssSelector("a:nth-last-of-type(2)"));
                                    String fastens = li04.getText();//fastens------系
                                    fastens = fastens.substring(2);
//                                    System.out.println(city+"|"+brand+"|"+fastens);
                                    //================爬取价格=====================================
                                    WebElement content_count5 = chromeDriver.findElement(By.cssSelector("body:nth-child(2)"));
                                    List<WebElement> elements6 = content_count3.findElements(By.cssSelector("div.all-content.slogan-type-one"));
                                    WebElement span = page2.findElement(By.xpath("//*[@class='num-price']"));
                                    String price = span.getText();//----价格
//                                    price = price.replaceAll("万", "");
                                    Page page1 = new Page();
                                    page1.setShop_name(title);
                                    page1.setPrice(price);
                                    page1.setLicence_time(licence_time);
                                    page1.setCity(city);
                                    page1.setBrand(brand);
                                    page1.setFastens(fastens);
                                    page1.setGear(gear);
                                    page1.setSize(size);
                                    page1.setColor(color);
                                    page1.setGearbox(Gearbox);
                                    page1.setDisplacement(Displacement);
                                    page1.setTransfer(transfer);
                                    page1.setMileage(mileage);
                                    page1.setAddress(url3);
                                    list.add(page1);
                                    System.out.println(url3);
                                    System.out.println("========================");
                                }
                                else {
                                    String city="";
                                    String brand ="";
                                    String fastens ="";
//                                    System.out.println(city+"|"+brand+"|"+fastens);
                                    System.out.println("========================");
                                }
                            }

                        }
                    }
//            break;
                }
                System.out.println("==============结束===================第==="+page_m+"=======页========================");


                try {
                    pageSaveToExcel.writeExcel(list, "D:\\tese.xls");
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
            if (page_m>1){
                String url = "https://www.che168.com/china/a0_0ms50dgscncgpi1ltocsp"+page_m+"exx0/";
                chromeDriver.get(url);
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                WebElement content_all = chromeDriver.findElement(By.cssSelector(".content.fn-clear.card-wrap"));
                List<WebElement> elements = content_all.findElements(By.xpath("//*[@class='viewlist_ul']/li"));
                List l1 = new ArrayList();
                for (WebElement page : elements) {
                    WebElement a = page.findElement(By.cssSelector("a"));
                    String url2 = a.getAttribute("href"); //获得每个商品的href
                    l1.add(url2);
                }
                System.out.println("======================================================================================================================");

                System.out.println(l1.size());


                for (int i = 0; i <= l1.size()-2; i++) {
                    String url3 = (String) l1.get(i);
                    //                   String url3 = "https://www.che168.com/dealer/414147/45458809.html?pvareaid=100519&userpid=0&usercid=0&offertype=&offertag=0&activitycartype=0#pos=10#page=6#rtype=10#isrecom=1#filter=29#module=10#refreshid=0#recomid=29203885#queryid=1670670732$B$15231076-e826-4b2a-8e8e-251a6d672156$60670#cartype=30";
                    chromeDriver.get(url3);
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //===========================爬取商品名、挡位、排量=====================
                    WebElement content_count = chromeDriver.findElement(By.cssSelector(".all-content.content-head.fn-clear"));//@1
                    List<WebElement> elements2 = content_count.findElements(By.cssSelector(".car-box"));//@1
                    for (WebElement page2 : elements2) {
                        WebElement h3 = page2.findElement(By.cssSelector("h3"));
                        String title = h3.getText(); //-----商品名
                        WebElement li3 = page2.findElement(By.cssSelector("li:nth-child(3) h4"));
                        String gear = li3.getText();//gear---挡位
                        gear = gear.substring(0, 2);
                        String Displacement = li3.getText();//Displacement-----排量
                        Displacement = Displacement.substring(5);
//                        Displacement = Displacement.replaceAll("L","");


                        // ==================== 爬取车辆上牌时间、里程、变速箱、过户次数、车辆级别、颜色 =============
                        WebElement content_count2 = chromeDriver.findElement(By.cssSelector(".all-content.all-basic.scroll-content.fn-clear"));
                        List<WebElement> elements3 = content_count2.findElements(By.cssSelector(".all-basic-content.fn-clear"));
                        for (WebElement page3 : elements3) {
                            WebElement li11 = page3.findElement(By.cssSelector(".basic-item-ul:nth-of-type(1) li:nth-child(1)"));
                            WebElement li12 = page3.findElement(By.cssSelector(".basic-item-ul:nth-of-type(1) li:nth-child(2)"));
                            WebElement li13 = page3.findElement(By.cssSelector(".basic-item-ul:nth-of-type(1) li:nth-child(3)"));
                            WebElement li25 = page3.findElement(By.cssSelector(".basic-item-ul:nth-of-type(2) li:nth-child(5)"));
                            WebElement li32 = page3.findElement(By.cssSelector(".basic-item-ul:nth-of-type(3) li:nth-child(2)"));
                            WebElement li33 = page3.findElement(By.cssSelector(".basic-item-ul:nth-of-type(3) li:nth-child(3)"));
                            String licence_time = li11.getText(); //licence---牌照
                            licence_time = licence_time.substring(4);  //切片-----上牌时间
                            String mileage = li12.getText(); //mileage---里程
                            mileage = mileage.substring(4);  //切片-----表显里程
//                            mileage = mileage.replaceAll("万公里","");
                            String Gearbox = li13.getText();//Gearbox--变速箱
                            Gearbox = Gearbox.substring(7);  //切片-----变速箱
                            String transfer = li25.getText();//transfer-----转移
                            transfer = transfer.substring(4, 5);  //切片-----过户次数
                            String size = li32.getText();//size-----大小
                            size = size.substring(4);  //切片-----车辆级别
                            String color = li33.getText();//color-----颜色
                            color = color.substring(4);  //切片-----车身颜色

                            //===================爬取城市、品牌、系==============
                            WebElement content_count3 = chromeDriver.findElement(By.cssSelector("body:nth-child(2)"));
                            List<WebElement> elements4 = content_count3.findElements(By.cssSelector(".bread-crumbs.content"));
                            // ============Selenium获取页面指定元素个数===========
                            WebElement content_count31 = chromeDriver.findElement(By.cssSelector("body:nth-child(2) .bread-crumbs.content"));
                            List<WebElement> element41 = content_count31.findElements(By.tagName("a"));
                            int number=element41.size();
//                            System.out.println(number+"=========================================================");
                            for (WebElement page4 : elements4) {
                                if (number>3 && number<7) {
                                    WebElement li02 = page4.findElement(By.cssSelector("a:nth-last-of-type(4)"));
                                    String city = li02.getText();//city------城市
                                    city = city.substring(0, 2);
                                    WebElement li03 = page4.findElement(By.cssSelector("a:nth-last-of-type(3)"));
                                    String brand = li03.getText();//brand------品牌
                                    brand = brand.substring(2);
                                    WebElement li04 = page4.findElement(By.cssSelector("a:nth-last-of-type(2)"));
                                    String fastens = li04.getText();//fastens------系
                                    fastens = fastens.substring(2);
//                                    System.out.println(city+"|"+brand+"|"+fastens);
                                    //================爬取价格=====================================
                                    WebElement content_count5 = chromeDriver.findElement(By.cssSelector("body:nth-child(2)"));
                                    List<WebElement> elements6 = content_count3.findElements(By.cssSelector("div.all-content.slogan-type-one"));
                                    WebElement span = page2.findElement(By.xpath("//*[@class='num-price']"));
                                    String price = span.getText();//----价格
//                                    price = price.replaceAll("万", "");
                                    Page page1 = new Page();
                                    page1.setShop_name(title);
                                    page1.setPrice(price);
                                    page1.setLicence_time(licence_time);
                                    page1.setCity(city);
                                    page1.setBrand(brand);
                                    page1.setFastens(fastens);
                                    page1.setGear(gear);
                                    page1.setSize(size);
                                    page1.setColor(color);
                                    page1.setGearbox(Gearbox);
                                    page1.setDisplacement(Displacement);
                                    page1.setTransfer(transfer);
                                    page1.setMileage(mileage);
                                    page1.setAddress(url3);
                                    list.add(page1);
                                    System.out.println(url3);
                                    System.out.println("========================");
                                }
                                else {
                                    String city="";
                                    String brand ="";
                                    String fastens ="";
//                                    System.out.println(city+"|"+brand+"|"+fastens);
                                    System.out.println("========================");
                                }

                            }

                        }
                    }
//            break;
                }
                System.out.println("=============结束===================第==="+page_m+"=====页===============================");

//                SaveToExcel<Page> pageSaveToExcel = new SaveToExcel<>();
                try {
                    pageSaveToExcel.writeExcel(list, "D:\\tese.xls");
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        }
        chromeDriver.quit();
    }

}
