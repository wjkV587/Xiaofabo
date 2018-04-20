package com.caseaction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class writejson {
	/**
	 * 将echarts所需数据写入json
	 * 一次写10个json文件，对应10个案例，每次写入先检查
	 * 文件是否存在，如果存在则清空，防止重复写入
	 * @param args
	 */
	static Connection conn = null;
    static Statement stmt = null;  
    static ResultSet rs=null;
    
	public static void echartsshow(Map<Integer, List<String>> key, Map<Integer, List<String>> ktr) throws IOException {
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

		
		//在json文件中写入echarts所需数据
		for(int i=0;i<key.size();i++) {
			//判断JSON文件是否存在/SolrJWeb/WebContent/js
			String path="D:\\JavaWeb\\Xiaofabo\\WebContent\\jsonfile\\"+(i+1)+".json";
			//System.out.println("文件路径为："+path);
			File jsonfile=new File(path);
			if(jsonfile.exists()) {
				//System.out.println("存在该json文件"+jsonfile.getPath());
				try {
					jsonfile.delete();
					//System.out.println("成功删除该文件");
					jsonfile.createNewFile();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			else {
				//System.out.println("不存在该json文件");
				try {			
					jsonfile.createNewFile();

				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}
			//BufferedWriter bw = new BufferedWriter(new FileWriter(jsonfile.getPath()));// 输出新的json文件  
			
			OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(jsonfile.getPath()), "UTF-8");
			BufferedWriter bw = new BufferedWriter(write);
			//设置防止关键因子重复入json文件的flag标志
			int keyflag=0,ktrflag=0;
			
			JSONObject jsob=new JSONObject();//新建一个json对象
			JSONArray ms1=new JSONArray(); //存data数组
			JSONArray ms2=new JSONArray(); //存links数组
			List<String> list1=null,list2=null;
			//rulelist存已写入json的关键因子和法则集合
			List<String> rulelist=new ArrayList<String>();
			int flag1=-1,flag2=0;
			int count1=0,count2=0;
			
			
			list1=key.get(i);//得到第i条记录的所有关键因子
			list2=ktr.get(i);//得到第i条记录的所有法律法则
			for(int j=0;j<list1.size();j++) {//遍历关键因子
				
				
				keyflag=0;ktrflag=0;//轮到下一个关键因子来匹配法则了
				
				for(int o=0;o<list2.size();o++) {//遍历法律法则
					//判断list1[j]到list2[o]有没有关联关系
					String r=list2.get(o);
					String e=list1.get(j);
					String sql="select * from rules where rule like'%"+r+"%' and `key` LIKE '%"+e+"%'";
					//System.out.println(sql);
					try {
						rs=stmt.executeQuery(sql);
						if(rs.next()) {
							//说明list1[j]到list2[o]存在关联关系
							//初始flag1=-1,flag2=0，第一次为0,1
						    
						
							//以下为2个JSON数组成员key和rule,每12个字符插入一个换行符号
							if(keyflag==0) {//说明该关键因子还未放入json
								rulelist.add(e);
								JSONObject m1=new JSONObject();  
								String regex = "(.{12})";
								e=e.replaceAll (regex, "$1\n");
								m1.put("name", e);
								m1.put("x", 200);m1.put("y", 200*count1);
								ms1.add(m1);
								flag1=rulelist.size()-1;count1++;
								keyflag=1;//设置keyflag，已加入的关键因子不再加入
							}
							else {}
							//放法律法则入json文件,每12个字符插入一个换行符号
							//先判断法律法则是否已存在于rulelist中，如果存在，不加入，增加link就OK
							if(rulelist.contains(r)) {
								//如果包含法条
								flag2=rulelist.indexOf(r);//indexOf从0开始，返回初始匹配的索引位置
								
							}
							else {
								rulelist.add(r);
								JSONObject m2=new JSONObject();  
								String regex = "(.{12})";
								r=r.replaceAll (regex, "$1\n");
								m2.put("name", r);
								m2.put("x", 800);m2.put("y", 100*count2);
								ms1.add(m2);count2++;
								flag2=rulelist.size()-1;
							}
		
							//存关联关系
							JSONObject m3=new JSONObject();  
							m3.put("source", flag1);
							m3.put("target", flag2);
							ms2.add(m3);	
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
			}
			//System.out.println("成功写入一个案例哈哈哈！！！");
			jsob.put("data", ms1);
			jsob.put("links", ms2);//link先不要写入，测试
			
			
			//将jsob写入json文件,后台响应时间过久
			bw.write(jsob.toString());  
	        bw.flush();  
	        bw.close();
		}
		
		 
        
		System.out.println("JSON文件写入成功哈哈哈!!!");
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Map<Integer, List<String>> key=null; Map<Integer, List<String>> ktr=null;
		echartsshow(key,ktr);

	}


}
