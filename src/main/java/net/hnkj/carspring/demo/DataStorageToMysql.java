package net.hnkj.carspring.demo;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataStorageToMysql {
	//1、导入数据源
	private static String file="D:\\tmp2\\test.txt";
	
	//数据库资源
	private static String mysql="com.mysql.cj.jdbc.Driver";
	private static String url="jdbc:mysql://192.168.248.131:3306/db_car?useSSL=false&serverTimezone=UTC&characterEncoding=utf8";
	private static String username="root";
	private static String password="3203617";

	private static Connection conn=null;//数据库连接对象
	private static PreparedStatement stmt=null;//数据库操作对象
		
	//2、数据库连接
	public static Connection getConnection()  throws ClassNotFoundException, SQLException{
		Class.forName(mysql);
		Connection conn=DriverManager.getConnection(url,username,password);
		return conn;
			
	}
	//释放
	public static void release(PreparedStatement stmt,Connection conn) {
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt=null;
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn=null;
		}
	}
	
		
//
	public static void createTable() throws ClassNotFoundException, SQLException{
		conn=getConnection();
		String create_sql="create table if not exists vehicle("
				+"id int primary key auto_increment,"
				+ "Shop_name varchar(100) not null,"
				+ "Price varchar(10) not null,"
				+ "Licence_time varchar(20) not null,"
				+ "City varchar(10)not null,"
				+ "Brand varchar(20) not null,"
				+ "Fastens varchar(20) not null,"
				+ "Gear varchar(20) not null,"
				+ "Size varchar(20) not null,"
				+ "Color varchar(20) not null,"
				+ "Gearbox varchar(20) not null,"
				+ "Displacement varchar(20) not null,"
				+ "Transfer varchar(20) not null,"
				+ "Mileage varchar(40) not null,"
				+ "address longtext not null) DEFAULT CHARSET=utf8";
		 stmt=conn.prepareStatement("drop table if exists vehicle");
		 stmt.execute();
		 stmt=conn.prepareStatement(create_sql);
		 stmt.execute();
		 release(stmt, conn);//释放资源
	}
	//4、批量插入数据
	public static void putData(ArrayList<String []> list) throws ClassNotFoundException, SQLException{
		conn=getConnection();
		String insert_sql="insert into vehicle(Shop_name,Price,Licence_time,"
				+ "City,Brand,Fastens,Gear,Size,Color,"
				+"Gearbox,Displacement,Transfer,Mileage,address) value(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//		String insert_sql="insert into vehicle(date,level,AQI,"
//				+ "AQIRanking,pm2_5,pm10) values(?,?,?,?,?)";
		stmt=conn.prepareStatement(insert_sql);
		//遍历集合中的31行数据，每一行为一个字符串数组，数组中6个元素
		for (String[] line:list) {
			stmt.setString(1, line[0]);//日期
			stmt.setString(2, line[1]);//空气质量等级
			stmt.setString(3, line[2]);//AQI
			stmt.setString(4, line[3]);//AQI排名
			stmt.setString(5, line[4]);//pm2.5
			stmt.setString(6, line[5]);//pm10
			stmt.setString(7, line[6]);//pm10
			stmt.setString(8, line[7]);//pm10
			stmt.setString(9, line[8]);//pm10
			stmt.setString(10, line[9]);//pm10
			stmt.setString(11, line[10]);//pm10
			stmt.setString(12, line[11]);//pm10
			stmt.setString(13, line[12]);//pm10
			stmt.setString(14, line[13]);//pm10
			stmt.executeUpdate();
		}
		release(stmt, conn);
	}	
			
	//5、查询数据
	public static void scanData() throws ClassNotFoundException, SQLException{
		conn=getConnection();
		String select_sql="select * from vehicle";
		stmt=conn.prepareStatement(select_sql);
		ResultSet rs=stmt.executeQuery();//查询回的所有31行数据
		while(rs.next()) {
			String id=rs.getString(1);
			String Shop_name=rs.getString(2);
			String Licence_time=rs.getString(3);
			String Price=rs.getString(4);
			String City=rs.getString(5);
			String Brand=rs.getString(6);
			String Fastens=rs.getString(7);
			String Gear=rs.getString(8);
			String Size=rs.getString(9);
			String Color=rs.getString(10);
			String Gearbox=rs.getString(11);
			String Displacement=rs.getString(12);
			String Transfer=rs.getString(13);
			String Mileage=rs.getString(14);
			String address=rs.getString(15);
			System.out.println(id+"\t"+Shop_name+"\t"+Licence_time+"\t"+Price+"\t"+
					City+"\t"+Brand+"\t"+Fastens+"\t"+Gear+"\t"+Size+"\t"+Color+"\t"+
					Gearbox+"\t"+Displacement+"\t"+Transfer+"\t"+Mileage+"\t"+address);
		}
		release(stmt, conn);
	}

	//读取数据
	public static ArrayList<String []> readData()throws IOException {
		System.out.println("-----------------");
		ArrayList<String[]> list = new ArrayList<String[]>();
		Scanner in = new Scanner(new File(file));
		while(in.hasNext()) {
			String read = in.nextLine();
			System.out.println("==========");
			if(read!=null&&!read.equals(null)) {
				String[] line = read.split("\t");
				/*for(String str : line) {
					System.out.println(str+",");
				}*/
				list.add(line);
			}
		}
		in.close();
		return list;
	}    
        //主流程控制
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		ArrayList<String[]> list = readData();//读本地.txt文件
		createTable();//数据库建表
		putData(list);//将list中31行数据(31个字符串数组组成的集合)写入数据库表
		scanData();//查询数据库数据，在控制台展示
	}	
	
}