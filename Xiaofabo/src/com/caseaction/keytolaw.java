package com.caseaction;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class keytolaw {
	/**
	 * ���ݷ�Ժ�������ƥ�䵽���ɷ���
	 * @param args
	 */
	//����Ϊ��Ժ�������Map������Ϊ��Ӧ������Map
	public static Map<Integer,List<String>>  turnlaw(Map<Integer,String> key) {
		Map<Integer,List<String>> law=new HashMap<Integer,List<String>>();;
		//System.out.println(key);
		//String a="{(1, '��Ժ��Ϊ��ԭ����֮��Ľ����ϵ��������ϵ�Ϸ���ȷ��������δ�ܰ�Լ�����Լ�������Ӧ�е���Ӧ���������Ρ�ԭ��Ҫ�󱻸��˳����������������ƽ�е��������ε����룬�ڷ��оݣ�Ӧ����֧�֡�ԭ���߳����й���Ϣ�ļ���Υ���ҹ����ɷ���Ĺ涨���Գ������ɷ���涨�Ĳ��֣���Ժ����֧�֡����ա��л����񹲺͹��������Ϸ�����һ����ʮ�������л����񹲺͹���ͬ�����ڶ������������ڶ������������ڶ��������������л����񹲺͹�����������ʮ�������ڶ�ʮһ��֮�涨���о����£�')} ";
		String a="��Ժ��Ϊ��ԭ������֮��Ľ����ϵ������������Ч������δ���ڻ��Ӧ�е���Ӧ���������Ρ����澭��Ժ�Ϸ�����������������δ��ͥ����Ϊ��ԭ��������ʵ���������󿹱�Ȩ�ķ������ݴˣ����л����񹲺͹���ͨ�򡷵�һ����ʮ�������л����񹲺͹���ͬ�����ڶ������������ڶ����������Ĺ涨���о����£�";
		String result="";
		for(int i=0;i<key.size();i++) {
			String data=key.get(i);
			List<String> fl=new ArrayList<String>();
			//System.out.println("Ҫ����py�ű��Ĳ���Ϊ��"+data);
				try {   
					   result="";
		   			   //System.out.println("start");
			           String[] args1 = new String[] { "python", "C:\\Users\\wjk\\Desktop\\ʵϰ\\��Ѷ�Ʒ�������Դ\\solr��Ҫ�����ļ�\\a.py",data}; 
			           //String[] args1 = new String[] { "python", "/usr/pythonTest/test_python.py",data}; 
			           
			           Process pr=Runtime.getRuntime().exec(args1);
			           BufferedReader in = new BufferedReader(new InputStreamReader(
			             pr.getInputStream()));
			           String line;
			           
			           while ((line = in.readLine()) != null) {
			            //System.out.println(line);
			                result+=line;
			           }
			           //System.out.print(result);
			           in.close();
			           pr.waitFor();
			           //System.out.println("end");
			          } 
			        catch (Exception e) {
			           e.printStackTrace();
			          }
				
				
				
				
				//��ȡ�������м䣬ѭ������law.get(i)��
				String context="'([^']+)'";//ƥ���������ʽ
				Pattern pattern1 = Pattern.compile(context);
				Matcher m = pattern1.matcher(result);	
		        while (m.find()) {
		        	
		            //System.out.println(m.group(1));
		            fl.add(m.group(1));
		        }
		        law.put(i, fl);
				
		}
		return law;
	}
	
	/**
	 * ��������ȡ����Ӧ�ķ���
	 * @param data
	 * @return
	 */
	/*
	private List<String> getlaws(String data){
		List<String> list=new ArrayList<String>();
		data="��Ժ��Ϊ��ԭ������֮��Ľ����ϵ������������Ч������δ���ڻ��Ӧ�е���Ӧ���������Ρ����澭��Ժ�Ϸ�����������������δ��ͥ����Ϊ��ԭ��������ʵ���������󿹱�Ȩ�ķ������ݴˣ����л����񹲺͹���ͨ�򡷵�һ����ʮ�������л����񹲺͹���ͬ�����ڶ������������ڶ����������Ĺ涨���о����£�";
		// ���ַ����в���'��'��'��'��'��'
		
		
		
		
		
		return list;
	}*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				
				
	}
}
