package com.action;



import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Statement;

public class test {
	static Connection conn=null;
	static Statement stmt = null; 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driverClass ="com.mysql.jdbc.Driver";  
        String url="jdbc:mysql://118.24.124.180:3366/case?useUnicode=true&characterEncoding=utf-8&useSSL=false"; 
        String username = "root";  
        String password = "szu_1108_qu"; 
        System.out.println(username+"\n"+password);
        //连接数据库MySQL，进行验证
        try {
			Class.forName(driverClass);
			conn = DriverManager.getConnection(url,username,password);//得到连接  
			stmt = conn.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        
        int id=0;String text="";
        for(int i=0;i<500;i++) {
        	id=i+1;
        	//从txt文件中读出文件内容
        	String filepath="C:\\Users\\wjk\\Desktop\\实习\\案件标注1-500\\"+id+".txt";
        	
        	
        	File file=new File(filepath);
        	if(file.exists()) {
        		//System.out.println(filepath);
		        	StringBuilder sb=new StringBuilder();
		        	try{
		                BufferedReader br = new BufferedReader(new FileReader(filepath));//构造一个BufferedReader类来读取文件
		                String s = null;
		                while((s = br.readLine())!=null){//使用readLine方法，一次读一行
		                    sb.append(System.lineSeparator()+s);
		                }
		                br.close();    
		            }catch(Exception e){
		                e.printStackTrace();
		            }
		            text=sb.toString();
		        	//System.out.println(id+"\n"+text);
		            String sql="insert into case_tag(id,案例) values('"+id+"','"+text+"')";
		            System.out.println(sql);
		            try {
						stmt.executeUpdate(sql);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        	} 
        }


	}

}
