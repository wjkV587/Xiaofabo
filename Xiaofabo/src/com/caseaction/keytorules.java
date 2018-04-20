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
	 * 根据关键因子匹配法律规则，只要一个匹配到就需添加法律规则到Map中
	 * @param args
	 */
	static Connection conn = null;
    static Statement stmt = null;  
	public static Map<Integer,List<String>>  turnrules(Map<Integer,List<String>> key) {
		//System.out.println(key);
		//载入连接数据库的信息
		//ServletContext application=this.getServletContext();
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

		/**
		 * 从数据库中逐一对key进行匹配，提取法条添加进String中
		 */
        
        Map<Integer,List<String>> list=new HashMap<Integer,List<String>>();//存放匹配的法条
        
		for(int i=0;i<key.size();i++) {
			List<String> map_list=new ArrayList<String>();
			for(String e:key.get(i)) {
	        	//System.out.print(e+",");
	        	//每个e是一个关键因子
	        	String sql="SELECT * FROM rules WHERE `key` LIKE '%"+e+"%';";
	        	//System.out.println(sql);
	        	//得到这条记录的law，与case1中的law逐一比较，如果不同则插入，如果存在相同则增加该law的time次数
				ResultSet rs;
				try {
					rs = stmt.executeQuery(sql);
					while(rs.next()) {
						//如果匹配到了
						String rule=rs.getString("rule");
						map_list.add(rule);												
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//System.out.println("成功匹配到一条案例的法规");
				    	
	        }
			list.put(i, map_list);//存进map中
			//此处是一个案例的关键因子
			//System.out.println("\n");
		}		
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
