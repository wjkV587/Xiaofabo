package com.action;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.Group;
import org.apache.solr.client.solrj.response.GroupCommand;
import org.apache.solr.client.solrj.response.GroupResponse;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.solrj.solrjbean;

public class solraction_group extends ActionSupport {
	
	/**
	 * 处理Solr分组查询模块
	 * @throws UnsupportedEncodingException 
	 */
	public String find() throws UnsupportedEncodingException {
		//先获取前端发来的表单数据，再操作solr服务查询
		//注意fq加上星号，fl需分隔出来
		//获取前端表单发来的数据，request方式
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String q=request.getParameter("fq");//获取搜索关键词
		String paget=request.getParameter("pagenow");//获取当前页数
		System.out.println("action获取的起始页为："+paget);
		int pageNow=0;
		//判断是否为空,如果不为空就设置为当前页数，为空就是第一次查询
		if(paget!=null) {pageNow=Integer.parseInt(paget);}
		//start是第几条开始记录，因此需要乘以每页显示的记录数
		pageNow*=5;
		request.setAttribute("q", q);
		
		q="原告诉称:*"+q+"*";
		String fl=request.getParameter("fl");
		System.out.println("搜索要求:\n"+q+"起始页数："+pageNow);
		
		//进行查询
		try {
			//先连接Solr服务器
			String solrurl="http://172.31.238.171:8080/solr/";	
			SolrServer solrserver=new HttpSolrServer(solrurl);
			//创建查询
			SolrQuery solrquery=new SolrQuery();
			
			//设置查询关键词
			solrquery.set("q",q );
			//设置分组
			solrquery.setParam("group", true);//是否分组
			//设置分组的域
			solrquery.setParam("group.field", "裁判日期");//按照裁判日期进行分组
			solrquery.setParam("group.limit", "1");//每组显示的个数，默认为1
			solrquery.setParam("group.ngroups", true);
			//是否计算所得分组个数；注意：当每个分组显示数目大于1个时，不能用分组数量来计算总页码
			
			
			
			//设置起始页
			solrquery.setStart(pageNow);
			//设置分页,每页显示5条记录
			//solrquery.setRows(5);
			//设置指定域
			//solrquery.set("fl", "id,原告,原告诉称,被告,法院判决");
			//设置排序依据,升序or降序
			
			//solrquery.addSort("id",ORDER.asc);
			//打开高亮开关
			solrquery.setHighlight(true);
			//设置高亮字段
			solrquery.addHighlightField("原告诉称");
			//前缀
			solrquery.setHighlightSimplePre("<font color='red'>");
			//后缀
			solrquery.setHighlightSimplePost("</font>");
			/**
	         * hl.snippets
	         * hl.snippets参数是返回高亮摘要的段数，因为我们的文本一般都比较长，含有搜索关键字的地方有多处，如果hl.snippets的值大于1的话，
	         * 会返回多个摘要信息，即文本中含有关键字的几段话，默认值为1，返回含关键字最多的一段描述。solr会对多个段进行排序。
	         * hl.fragsize
	         * hl.fragsize参数是摘要信息的长度。默认值是100，这个长度是出现关键字的位置向前移6个字符，再往后100个字符，取这一段文本。
	         */
			//solrquery.setHighlightFragsize(100);
			//执行查询,得到结果
			QueryResponse response=solrserver.query(solrquery);		
			//得到文档结果集
			//SolrDocumentList docs=response.getResults();
			GroupResponse gresp=response.getGroupResponse();
			//设置高亮域
			Map<String, Map<String, List<String>>> highlightresult=response.getHighlighting();
			//System.out.println(highlightresult.get);
			//得到结果总条数
			//存显示分组条件
			request.setAttribute("fenzu", true);//用来显示前端分组页面的条件筛选
			List<GroupCommand> commands=gresp.getValues();
			if(commands!=null) {//分组不为空
				for(GroupCommand com:commands) {
					System.out.println("总的分组个数："+com.getNGroups().longValue());
					request.setAttribute("num",com.getNGroups().longValue());
					for(Group group:com.getValues()) {//遍历循环每个组
						SolrDocumentList hits=group.getResult();
						request.setAttribute("list",hits);//存集合list进request
						
						for(SolrDocument doc:hits) {
							System.out.println(doc.get("")+","+doc.get("地区"));
						}
					}
				}
			}
			/*
			long num=docs.getNumFound();
			System.out.println("总条数为："+num+"条");
			
			
			
			
			//缓存总记录数
			request.setAttribute("num",num);
			//缓存总页数
			request.setAttribute("pages", num/5);
			//缓存当前页数
			request.setAttribute("pagenow", pageNow/5);
			
			
			
			
			//将所有查询到的记录存进一个集合，再存进request
			SolrDocumentList list=new SolrDocumentList();
			SolrDocument doc=new SolrDocument();
			
			for (int i = 0; i < docs.size(); i++)
			{	
				doc=docs.get(i);
				String id=doc.get("id").toString();
				System.out.println("id的值是前："+id);
				if(highlightresult.get(id).get("原告诉称")!=null) {
				doc.setField("原告诉称", highlightresult.get(id).get("原告诉称").get(0));   
				System.out.println("高亮的字段是："+highlightresult.get(id).get("原告诉称").get(0));
				}
				list.add(doc);
			}*/
			
			//request.setAttribute("list",list);//存集合list进request
			return SUCCESS;//跳转到查询成功页面
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return NONE;
	}
	
	public String fenye() {
		
		return NONE;
	}

}
