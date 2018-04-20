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
	 * solr��ѯ��2007-2016��ÿ��İ���������ǰ����echartsͼ����ӻ�
	 */
	public String echartsshow() throws UnsupportedEncodingException{
		//���鵽�����ݴ�����ϣ��ٽ����ϴ��request��ǰ��echartsȡ����ʾ
		HttpServletRequest request=ServletActionContext.getRequest();
		//������solr��������ѭ����ѯÿһ��İ�����
		try {
			String solrurl="http://172.31.238.171:8080/solr/";
			SolrServer solrserver=new HttpSolrServer(solrurl);
			//������ѯ
			SolrQuery solrquery=new SolrQuery();
			//����forѭ����ѭ����ѯÿһ��İ�������
			long[] number=new long[10];
			float[] bi=new float[10];
			long ss=0;
			for(int i=2007;i<2017;i++) {
				String q="��������:"+i+"*";
				solrquery.set("q",q);
				//ִ�в�ѯ���õ������
				QueryResponse response=solrserver.query(solrquery);
				SolrDocumentList docs=response.getResults();
				long num=docs.getNumFound();//�õ���һ��İ���������
				number[i-2007]=num;
				System.out.println("�ɹ��鵽��"+i+"��İ�������");
				ss+=num;
			}
			for(int i=2007;i<2017;i++) {
				//���ÿ�갸����������ռ��
				bi[i-2007]=(float) (number[i-2007]*1.0/ss*100);
			}
			
			request.setAttribute("number",number );//������request��
			request.setAttribute("bi",bi );//������request��
			return SUCCESS;//��ת��echarts.jspҳ����ʾ
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return NONE;
	}
}
