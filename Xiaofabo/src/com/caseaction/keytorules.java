package com.caseaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class keytorules {
	/**
	 * ���ݹؼ�����ƥ�䷨�ɹ���ֻҪһ��ƥ�䵽������ӷ��ɹ���Map��
	 * @param args
	 */
	static Connection conn = null;
    static Statement stmt = null;  
	public static Map<Integer,List<String>>  turnrules(Map<Integer,List<String>> key) {
		//System.out.println(key);
		//�����������ݿ����Ϣ
		//ServletContext application=this.getServletContext();
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

		/**
		 * �����ݿ�����һ��key����ƥ�䣬��ȡ������ӽ�String��
		 */
        
        Map<Integer,List<String>> list=new HashMap<Integer,List<String>>();//���ƥ��ķ���
        
		for(int i=0;i<key.size();i++) {
			List<String> map_list=new ArrayList<String>();
			for(String e:key.get(i)) {
	        	//System.out.print(e+",");
	        	//ÿ��e��һ���ؼ�����
	        	String sql="SELECT * FROM rules WHERE `key` LIKE '%"+e+"%';";
	        	//System.out.println(sql);
	        	//�õ�������¼��law����case1�е�law��һ�Ƚϣ������ͬ����룬���������ͬ�����Ӹ�law��time����
				ResultSet rs;
				try {
					rs = stmt.executeQuery(sql);
					while(rs.next()) {
						//���ƥ�䵽��
						String rule=rs.getString("rule");
						map_list.add(rule);												
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//System.out.println("�ɹ�ƥ�䵽һ�������ķ���");
				    	
	        }
			list.put(i, map_list);//���map��
			//�˴���һ�������Ĺؼ�����
			//System.out.println("\n");
		}		
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
