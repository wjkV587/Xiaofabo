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
        //�������ݿ�MySQL��������֤
        try {
			Class.forName(driverClass);
			conn = DriverManager.getConnection(url,username,password);//�õ�����  
			stmt = conn.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        
        int id=0;String text="";
        for(int i=0;i<500;i++) {
        	id=i+1;
        	//��txt�ļ��ж����ļ�����
        	String filepath="C:\\Users\\wjk\\Desktop\\ʵϰ\\������ע1-500\\"+id+".txt";
        	
        	
        	File file=new File(filepath);
        	if(file.exists()) {
        		//System.out.println(filepath);
		        	StringBuilder sb=new StringBuilder();
		        	try{
		                BufferedReader br = new BufferedReader(new FileReader(filepath));//����һ��BufferedReader������ȡ�ļ�
		                String s = null;
		                while((s = br.readLine())!=null){//ʹ��readLine������һ�ζ�һ��
		                    sb.append(System.lineSeparator()+s);
		                }
		                br.close();    
		            }catch(Exception e){
		                e.printStackTrace();
		            }
		            text=sb.toString();
		        	//System.out.println(id+"\n"+text);
		            String sql="insert into case_tag(id,����) values('"+id+"','"+text+"')";
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
