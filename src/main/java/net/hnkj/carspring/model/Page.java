package net.hnkj.carspring.model;

public class Page {
//    private String href;
//    private String text;
//
//    public String getText() {
//        return text;
//    }
//
//    public void setText(String text) {
//        this.text = text;
//    }
//
//    public String getHref() {
//        return href;
//    }
//
//    public void setHref(String href) {
//        this.href = href;
//    }
//
//    @Override
//    public String toString() {
//        return "BaiduPageList{" +
//                "href='" + text + '\'' +
//                ", text='" + text + '\'' +
//                '}';
//    }
    private String Shop_name; //商品名
    private String Price; //价格
    private String Licence_time; //上牌时间
    private String City;//城市
    private String Brand;//品牌
    private String Fastens;//系
    private String Gear; //挡位
    private String Size;//车辆大小
    private String Color;//车身颜色
    private String Gearbox; //变速箱
    private String Displacement; //排量
    private String Transfer; //过户次数
    private String Mileage; //里程
    private String address;//网页

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getShop_name() {
        return Shop_name;
    }

    public void setShop_name(String shop_name) {
        Shop_name = shop_name;
    }

    public String getGear() {
        return Gear;
    }

    public void setGear(String gear) {
        Gear = gear;
    }

    public String getDisplacement() {
        return Displacement;
    }

    public void setDisplacement(String displacement) {
        Displacement = displacement;
    }

    public String getLicence_time() {
        return Licence_time;
    }

    public void setLicence_time(String licence_time) {
        Licence_time = licence_time;
    }

    public String getMileage() {
        return Mileage;
    }

    public void setMileage(String mileage) {
        Mileage = mileage;
    }

    public String getTransfer() {
        return Transfer;
    }

    public void setTransfer(String transfer) {
        Transfer = transfer;
    }

    public String getGearbox() {
        return Gearbox;
    }

    public void setGearbox(String gearbox) {
        Gearbox = gearbox;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String size) {
        Size = size;
    }

    public String getFastens() {
        return Fastens;
    }

    public void setFastens(String fastens) {
        Fastens = fastens;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }


    @Override
    public String toString() {
        return "Page{" +
                "Price='" + Price + '\'' +
                ", Shop_name='" + Shop_name + '\'' +
                ", Gear='" + Gear + '\'' +
                ", Displacement='" + Displacement + '\'' +
                ", Licence_time='" + Licence_time + '\'' +
                ", Mileage='" + Mileage + '\'' +
                ", Transfer='" + Transfer + '\'' +
                ", Gearbox='" + Gearbox + '\'' +
                ", Color='" + Color + '\'' +
                ", Brand='" + Brand + '\'' +
                ", Size='" + Size + '\'' +
                ", Fastens='" + Fastens + '\'' +
                ", City='" + City + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
