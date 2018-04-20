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
 * ����solrj�ķ���
 * ����
 * ɾ��
 * ��ѯ
 * �޸�
 * @author wjk
 *
 */
public class testsolrj {
	
	@Test
	public void testFind() throws Exception{
		//������Solr������
		String solrurl="http://172.31.238.171:8080/solr/";	
		SolrServer solrserver=new HttpSolrServer(solrurl);
		//������ѯ
		SolrQuery solrquery=new SolrQuery();
		//���ò�ѯ�ؼ���
		solrquery.set("q","*:*" );
		//���ù���
		solrquery.set("fq", "����:*�㽭*");
		//������ʼҳ
		solrquery.setStart(0);
		//���÷�ҳ
		solrquery.setRows(5);
		//������������,����or����
		//solrquery.addSort("id",ORDER.desc);
		//ִ�в�ѯ,�õ����
		QueryResponse response=solrserver.query(solrquery);
		//�õ��ĵ������
		SolrDocumentList docs=response.getResults();
		
		//�õ����������
		long num=docs.getNumFound();
		System.out.println("������Ϊ��"+num+"��");
		for(SolrDocument doc:docs)
		{	System.out.print(doc.get("id")+" ");
		    System.out.println(doc.get("ԭ��"));
			System.out.println(doc.get("ԭ���߳�"));	
		}
	}

	
	
	
	
	
	
	
	
	
	
}
