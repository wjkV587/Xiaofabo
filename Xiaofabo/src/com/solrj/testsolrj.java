package com.solrj;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.SolrResponse;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.junit.Test;

/**
 * 测试solrj的服务
 * 增加
 * 删除
 * 查询
 * 修改
 * @author wjk
 *
 */
public class testsolrj {
	
	@Test
	public void testFind() throws Exception{
		//先连接Solr服务器
		String solrurl="http://172.31.238.171:8080/solr/";	
		SolrServer solrserver=new HttpSolrServer(solrurl);
		//创建查询
		SolrQuery solrquery=new SolrQuery();
		//设置查询关键词
		solrquery.set("q","*:*" );
		//设置过滤
		solrquery.set("fq", "地区:*浙江*");
		//设置起始页
		solrquery.setStart(0);
		//设置分页
		solrquery.setRows(5);
		//设置排序依据,升序or降序
		//solrquery.addSort("id",ORDER.desc);
		//执行查询,得到结果
		QueryResponse response=solrserver.query(solrquery);
		//得到文档结果集
		SolrDocumentList docs=response.getResults();
		
		//得到结果总条数
		long num=docs.getNumFound();
		System.out.println("总条数为："+num+"条");
		for(SolrDocument doc:docs)
		{	System.out.print(doc.get("id")+" ");
		    System.out.println(doc.get("原告"));
			System.out.println(doc.get("原告诉称"));	
		}
	}

	
	
	
	
	
	
	
	
	
	
}
