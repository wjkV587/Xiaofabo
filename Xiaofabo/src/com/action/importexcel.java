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
				//����ҵõ�������¼
				String sql1="update `referlawcount-case_2007` set time=time+"+time+" where law='"+law+"'";
			    System.out.println(sql1);
			    stmt.executeUpdate(sql1);		    		
			}
			else {
				//����Ҳ�����¼
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
		//�������ݿ�
		  
			//�����������ݿ����Ϣ
			//ServletContext application=this.getServletContext();
		    String driverClass ="com.mysql.jdbc.Driver";  
	        String url="jdbc:mysql://localhost:3306/����"; 
	        String username = "root";  
	        String password = "160337"; 
	        System.out.println(username+"\n"+password);
	        //�������ݿ�MySQL��������֤
	        try {
				Class.forName(driverClass);
				conn = DriverManager.getConnection(url,username,password);//�õ�����  
				System.out.println("bbs��̳���ݿ����ӳɹ�");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        
	        //��ȡ���ݿ�xls�ļ���ȥ�ز����¼����ظ��ļ�¼
	       // SELECT * FROM case1 union SELECT * FROM case2;
	        try {
	        	System.out.println("111");
				stmt = conn.createStatement();
				//ѭ����2
				
				while(count2<count2_high) {
				
						String sql="select * from `referlawcount-case_2016` where id="+count2+"";
						System.out.println("Ҫִ�е�sql���Ϊ:"+sql);
						//�õ�������¼��law����case1�е�law��һ�Ƚϣ������ͬ����룬���������ͬ�����Ӹ�law��time����
						ResultSet rs=stmt.executeQuery(sql);
						if(rs.next()) {
							String law=rs.getString("law");
							int  time=rs.getInt("time");
							//���бȽ�
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
