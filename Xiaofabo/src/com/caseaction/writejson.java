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
	 * ��echarts��������д��json
	 * һ��д10��json�ļ�����Ӧ10��������ÿ��д���ȼ��
	 * �ļ��Ƿ���ڣ������������գ���ֹ�ظ�д��
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
        //�������ݿ�MySQL��������֤
        try {
			Class.forName(driverClass);
			conn = DriverManager.getConnection(url,username,password);//�õ�����  
			stmt = conn.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		//��json�ļ���д��echarts��������
		for(int i=0;i<key.size();i++) {
			//�ж�JSON�ļ��Ƿ����/SolrJWeb/WebContent/js
			String path="D:\\JavaWeb\\Xiaofabo\\WebContent\\jsonfile\\"+(i+1)+".json";
			//System.out.println("�ļ�·��Ϊ��"+path);
			File jsonfile=new File(path);
			if(jsonfile.exists()) {
				//System.out.println("���ڸ�json�ļ�"+jsonfile.getPath());
				try {
					jsonfile.delete();
					//System.out.println("�ɹ�ɾ�����ļ�");
					jsonfile.createNewFile();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			else {
				//System.out.println("�����ڸ�json�ļ�");
				try {			
					jsonfile.createNewFile();

				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}
			//BufferedWriter bw = new BufferedWriter(new FileWriter(jsonfile.getPath()));// ����µ�json�ļ�  
			
			OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(jsonfile.getPath()), "UTF-8");
			BufferedWriter bw = new BufferedWriter(write);
			//���÷�ֹ�ؼ������ظ���json�ļ���flag��־
			int keyflag=0,ktrflag=0;
			
			JSONObject jsob=new JSONObject();//�½�һ��json����
			JSONArray ms1=new JSONArray(); //��data����
			JSONArray ms2=new JSONArray(); //��links����
			List<String> list1=null,list2=null;
			//rulelist����д��json�Ĺؼ����Ӻͷ��򼯺�
			List<String> rulelist=new ArrayList<String>();
			int flag1=-1,flag2=0;
			int count1=0,count2=0;
			
			
			list1=key.get(i);//�õ���i����¼�����йؼ�����
			list2=ktr.get(i);//�õ���i����¼�����з��ɷ���
			for(int j=0;j<list1.size();j++) {//�����ؼ�����
				
				
				keyflag=0;ktrflag=0;//�ֵ���һ���ؼ�������ƥ�䷨����
				
				for(int o=0;o<list2.size();o++) {//�������ɷ���
					//�ж�list1[j]��list2[o]��û�й�����ϵ
					String r=list2.get(o);
					String e=list1.get(j);
					String sql="select * from rules where rule like'%"+r+"%' and `key` LIKE '%"+e+"%'";
					//System.out.println(sql);
					try {
						rs=stmt.executeQuery(sql);
						if(rs.next()) {
							//˵��list1[j]��list2[o]���ڹ�����ϵ
							//��ʼflag1=-1,flag2=0����һ��Ϊ0,1
						    
						
							//����Ϊ2��JSON�����Աkey��rule,ÿ12���ַ�����һ�����з���
							if(keyflag==0) {//˵���ùؼ����ӻ�δ����json
								rulelist.add(e);
								JSONObject m1=new JSONObject();  
								String regex = "(.{12})";
								e=e.replaceAll (regex, "$1\n");
								m1.put("name", e);
								m1.put("x", 200);m1.put("y", 200*count1);
								ms1.add(m1);
								flag1=rulelist.size()-1;count1++;
								keyflag=1;//����keyflag���Ѽ���Ĺؼ����Ӳ��ټ���
							}
							else {}
							//�ŷ��ɷ�����json�ļ�,ÿ12���ַ�����һ�����з���
							//���жϷ��ɷ����Ƿ��Ѵ�����rulelist�У�������ڣ������룬����link��OK
							if(rulelist.contains(r)) {
								//�����������
								flag2=rulelist.indexOf(r);//indexOf��0��ʼ�����س�ʼƥ�������λ��
								
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
		
							//�������ϵ
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
			//System.out.println("�ɹ�д��һ������������������");
			jsob.put("data", ms1);
			jsob.put("links", ms2);//link�Ȳ�Ҫд�룬����
			
			
			//��jsobд��json�ļ�,��̨��Ӧʱ�����
			bw.write(jsob.toString());  
	        bw.flush();  
	        bw.close();
		}
		
		 
        
		System.out.println("JSON�ļ�д��ɹ�������!!!");
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Map<Integer, List<String>> key=null; Map<Integer, List<String>> ktr=null;
		echartsshow(key,ktr);

	}


}
