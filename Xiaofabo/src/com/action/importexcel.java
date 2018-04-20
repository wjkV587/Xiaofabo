package com.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

public class importexcel {
	static Connection conn = null;
    static Statement stmt = null;  
    static int count1=0,count2=0,count2_high=10331,countall=14291;
    
    
    static void checkthelaw(String law,int time) {
    	try {
			stmt = conn.createStatement();
			String sql="select * from `referlawcount-case_2007` where law='"+law+"'";
			System.out.println(sql);
			count1++;
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next()) {
				//如果找得到此条记录
				String sql1="update `referlawcount-case_2007` set time=time+"+time+" where law='"+law+"'";
			    System.out.println(sql1);
			    stmt.executeUpdate(sql1);		    		
			}
			else {
				//如果找不到记录
				String sql2="insert into `referlawcount-case_2007`(id,law,time) values('"+countall+"','"+law+"','"+time+"')";
				countall++;
				System.out.println(sql2);
				stmt.executeUpdate(sql2);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	public static void main(String[] args) {	
		//连接数据库
		  
			//载入连接数据库的信息
			//ServletContext application=this.getServletContext();
		    String driverClass ="com.mysql.jdbc.Driver";  
	        String url="jdbc:mysql://localhost:3306/法条"; 
	        String username = "root";  
	        String password = "160337"; 
	        System.out.println(username+"\n"+password);
	        //连接数据库MySQL，进行验证
	        try {
				Class.forName(driverClass);
				conn = DriverManager.getConnection(url,username,password);//得到连接  
				System.out.println("bbs论坛数据库连接成功");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        
	        //读取数据库xls文件，去重并重新计数重复的记录
	       // SELECT * FROM case1 union SELECT * FROM case2;
	        try {
	        	System.out.println("111");
				stmt = conn.createStatement();
				//循环表2
				
				while(count2<count2_high) {
				
						String sql="select * from `referlawcount-case_2016` where id="+count2+"";
						System.out.println("要执行的sql语句为:"+sql);
						//得到这条记录的law，与case1中的law逐一比较，如果不同则插入，如果存在相同则增加该law的time次数
						ResultSet rs=stmt.executeQuery(sql);
						if(rs.next()) {
							String law=rs.getString("law");
							int  time=rs.getInt("time");
							//进行比较
							checkthelaw(law,time);
							
							
							//System.out.println(law+"\n"+time);
							count2++;
						}
						else {System.out.println("No");}
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	        
	        

	}

}
