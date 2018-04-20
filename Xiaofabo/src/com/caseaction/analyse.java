package com.caseaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class analyse extends ActionSupport {
	
	public String analysecase() throws Exception{
		/**
		 * 接受前端表单中textarea发来的案件程序
		 * 使用solr模糊匹配出原告诉称
		 * 关键因子
		 * 对应关键因子的法条法规
		 */
		ActionContext actioncontext=ActionContext.getContext();
		Map<String,Object> map=actioncontext.getParameters();
		String casetext=null;
		
		if(map.get("textarea_id")!=null) {
			casetext=((String[])map.get("textarea_id"))[0];//得到表达传来的案例内容
		}
		//System.out.println("要进行分析的案例是：\n"+casetext);
		actioncontext.put("casetext", casetext);
		/**
		 * 将案例诉称去掉标记提取出来，进行solr的模糊匹配
		 * 这里案例测试数据已准备好，需要在solr中将匹配数据导入
		 */
		casetext="原告诉称:"+casetext;
		//连接Solr服务器
		try {
			String solrurl="http://140.143.13.66:8080/solr/";
			SolrServer solrserver=new HttpSolrServer(solrurl);
			SolrQuery solrquery=new SolrQuery();
			//设置查询字段
			solrquery.set("q", casetext);
			solrquery.setStart(0);
			solrquery.setRows(10);//显示Top 10
			//设置高亮
			solrquery.setHighlight(true);
			solrquery.addHighlightField("原告诉称");
			solrquery.setHighlightFragsize(1000);
			solrquery.setHighlightSimplePre("<font color='red'>");
			solrquery.setHighlightSimplePost("</font>");
			//执行查询得到结果文档集
			QueryResponse response=solrserver.query(solrquery);
			SolrDocumentList docs= response.getResults();
			//设置高亮域
			Map<String ,Map<String,List<String>>> highlightresult=response.getHighlighting();
			
			
			SolrDocumentList list=new SolrDocumentList();
			SolrDocument doc=new SolrDocument();
			//创建存储关键因子的map
			Map<Integer,List<String>> key=new HashMap<Integer,List<String>>();
			//创建存储法院审理意见的map
			Map<Integer,String> law=new HashMap<Integer,String>();
			
			for(int i=0;i<docs.size();i++) {
				List<String> map_list=new ArrayList<String>();
				doc=docs.get(i);
				String id=doc.get("id").toString();
				String adju=doc.get("法院审理意见").toString();
				
					//此处需要提取所有匹配的案例的关键因子,正则匹配
					String text=doc.get("原告诉称").toString();
					
					String context="(?<=\\【)[^\\：]+";//匹配的正则表达式
					Pattern pattern1 = Pattern.compile(context);
					Matcher m = pattern1.matcher(text);	
			        while (m.find()) {
			            //System.out.println("关键因子：" + m.group() );
			            map_list.add(m.group());
			            
			        }
			        law.put(i, adju);
			        key.put(i, map_list);				
				/**
				 * Top 10 里面每个案例的关键因子都要找出来
				 */
				//循环输出关键因子进行测试
			    /**
			        System.out.print("关键因子是：");
			        for(String e:key.get(i)) {
			        	System.out.print(e+",");	
			        }
			        System.out.print("\n");
			      **/  
				if(highlightresult.get(id).get("原告诉称")!=null) {
					doc.setField("原告诉称", highlightresult.get(id).get("原告诉称").get(0));
				}
				//if(i==0) {System.out.println("后："+highlightresult.get(id).get("原告诉称").get(0));}
				list.add(doc);	
			}
			
			Map<Integer,List<String>> ktr=keytorules.turnrules(key);
			actioncontext.put("law", keytolaw.turnlaw(law));//存关键因子对应的法条
			actioncontext.put("rules",ktr);//存关键因子对应的法则
			actioncontext.put("key", key);//存关键因子
			actioncontext.put("list", list);//存文档集
			//写入json文件，用于可视化
			writejson.echartsshow(key, ktr);
			//返回前端页面
			return SUCCESS;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		/**
		 * 匹配出最佳结果，得到原告诉称，关键因子以及胜负概率，还有引用法条
		 * 存进ActionContext域中，跳转到test.jsp页面中
		 * 为了交互性更强，建议将案例内容也一并存进域中，可以实时比对
		 */
		
		return NONE;
	}

}
