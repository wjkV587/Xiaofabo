package com.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class echarts extends ActionSupport {

	/**
	 * solr查询出2007-2016年每年的案件数量，前端以echarts图表可视化
	 */
	public String echartsshow() throws UnsupportedEncodingException{
		//将查到的数据存进集合，再将集合存进request域，前端echarts取出显示
		HttpServletRequest request=ServletActionContext.getRequest();
		//先连接solr服务器，循环查询每一年的案件量
		try {
			String solrurl="http://172.31.238.171:8080/solr/";
			SolrServer solrserver=new HttpSolrServer(solrurl);
			//创建查询
			SolrQuery solrquery=new SolrQuery();
			//设置for循环，循环查询每一年的案件数量
			long[] number=new long[10];
			float[] bi=new float[10];
			long ss=0;
			for(int i=2007;i<2017;i++) {
				String q="裁判日期:"+i+"*";
				solrquery.set("q",q);
				//执行查询，得到结果集
				QueryResponse response=solrserver.query(solrquery);
				SolrDocumentList docs=response.getResults();
				long num=docs.getNumFound();//得到这一年的案件发生量
				number[i-2007]=num;
				System.out.println("成功查到第"+i+"年的案件数量");
				ss+=num;
			}
			for(int i=2007;i<2017;i++) {
				//求出每年案件发生量的占比
				bi[i-2007]=(float) (number[i-2007]*1.0/ss*100);
			}
			
			request.setAttribute("number",number );//结果存进request域
			request.setAttribute("bi",bi );//结果存进request域
			return SUCCESS;//跳转到echarts.jsp页面显示
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return NONE;
	}
}
