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
	 * 根据法院审理意见匹配到法律法条
	 * @param args
	 */
	//参数为法院审理意见Map，返回为对应法条的Map
	public static Map<Integer,List<String>>  turnlaw(Map<Integer,String> key) {
		Map<Integer,List<String>> law=new HashMap<Integer,List<String>>();;
		//System.out.println(key);
		//String a="{(1, '本院认为，原被告之间的借贷关系及担保关系合法明确。两被告未能按约履行自己的义务，应承担相应的民事责任。原告要求被告丰顺明返还借款及被告王公平承担连带责任的诉请，于法有据，应予以支持。原告诉称中有关利息的计算违反我国法律法规的规定，对超出法律法规规定的部分，本院不予支持。依照《中华人民共和国民事诉讼法》第一百三十条、《中华人民共和国合同法》第二百零五条、第二百零六条、第二百零七条、《中华人民共和国担保法》第十八条、第二十一条之规定，判决如下：')} ";
		String a="本院认为，原、被告之间的借贷关系依法成立并有效。被告未按期还款，应承担相应的民事责任。被告经本院合法传唤，无正当理由未到庭，视为对原告所诉事实及诉讼请求抗辩权的放弃。据此，《中华人民共和国民法通则》第一百三十条、《中华人民共和国合同法》第二百零六条、第二百零七条的规定，判决如下：";
		String result="";
		for(int i=0;i<key.size();i++) {
			String data=key.get(i);
			List<String> fl=new ArrayList<String>();
			//System.out.println("要传到py脚本的参数为："+data);
				try {   
					   result="";
		   			   //System.out.println("start");
			           String[] args1 = new String[] { "python", "C:\\Users\\wjk\\Desktop\\实习\\腾讯云服务器资源\\solr必要配置文件\\a.py",data}; 
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
				
				
				
				
				//截取出引号中间，循环放入law.get(i)中
				String context="'([^']+)'";//匹配的正则表达式
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
	 * 将参数提取出对应的法条
	 * @param data
	 * @return
	 */
	/*
	private List<String> getlaws(String data){
		List<String> list=new ArrayList<String>();
		data="本院认为，原、被告之间的借贷关系依法成立并有效。被告未按期还款，应承担相应的民事责任。被告经本院合法传唤，无正当理由未到庭，视为对原告所诉事实及诉讼请求抗辩权的放弃。据此，《中华人民共和国民法通则》第一百三十条、《中华人民共和国合同法》第二百零六条、第二百零七条的规定，判决如下：";
		// 在字符串中查找'《'、'第'、'条'
		
		
		
		
		
		return list;
	}*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				
				
	}
}
