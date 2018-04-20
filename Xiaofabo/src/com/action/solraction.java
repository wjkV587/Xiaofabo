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
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.solrj.solrjbean;

public class solraction extends ActionSupport {
	
	/**
	 * ����Solr�򵥲�ѯģ��
	 * @throws UnsupportedEncodingException 
	 */
	public String find() throws UnsupportedEncodingException {
		//�Ȼ�ȡǰ�˷����ı����ݣ��ٲ���solr�����ѯ
		//ע��fq�����Ǻţ�fl��ָ�����
		//��ȡǰ�˱����������ݣ�request��ʽ
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String q=request.getParameter("fq");//��ȡ�����ؼ���
		String paget=request.getParameter("pagenow");//��ȡ��ǰҳ��
		System.out.println("action��ȡ����ʼҳΪ��"+paget);
		int pageNow=0;
		//�ж��Ƿ�Ϊ��,�����Ϊ�վ�����Ϊ��ǰҳ����Ϊ�վ��ǵ�һ�β�ѯ
		if(paget!=null) {pageNow=Integer.parseInt(paget);}
		//start�ǵڼ�����ʼ��¼�������Ҫ����ÿҳ��ʾ�ļ�¼��
		pageNow*=5;
		request.setAttribute("q", q);
		
		q="ԭ���߳�:*"+q+"*";
		String fl=request.getParameter("fl");
		System.out.println("����Ҫ��:\n"+q+"��ʼҳ����"+pageNow);
		
		//���в�ѯ
		try {
			//������Solr������
			String solrurl="http://172.31.238.171:8080/solr/";	
			SolrServer solrserver=new HttpSolrServer(solrurl);
			//������ѯ
			SolrQuery solrquery=new SolrQuery();
			//���ò�ѯ�ؼ���
			solrquery.set("q",q );
			//���ù���
			//solrquery.set("fq", fq);
			//������ʼҳ
			solrquery.setStart(pageNow);
			//���÷�ҳ,ÿҳ��ʾ5����¼
			solrquery.setRows(5);
			//����ָ����
			//solrquery.set("fl", "id,ԭ��,ԭ���߳�,����,��Ժ�о�");
			//������������,����or����
			
			//solrquery.addSort("id",ORDER.asc);
			//�򿪸�������
			solrquery.setHighlight(true);
			//���ø����ֶ�
			solrquery.addHighlightField("ԭ���߳�");
			//ǰ׺
			solrquery.setHighlightSimplePre("<font color='red'>");
			//��׺
			solrquery.setHighlightSimplePost("</font>");
			/**
	         * hl.snippets
	         * hl.snippets�����Ƿ��ظ���ժҪ�Ķ�������Ϊ���ǵ��ı�һ�㶼�Ƚϳ������������ؼ��ֵĵط��жദ�����hl.snippets��ֵ����1�Ļ���
	         * �᷵�ض��ժҪ��Ϣ�����ı��к��йؼ��ֵļ��λ���Ĭ��ֵΪ1�����غ��ؼ�������һ��������solr��Զ���ν�������
	         * hl.fragsize
	         * hl.fragsize������ժҪ��Ϣ�ĳ��ȡ�Ĭ��ֵ��100����������ǳ��ֹؼ��ֵ�λ����ǰ��6���ַ���������100���ַ���ȡ��һ���ı���
	         */
			//solrquery.setHighlightFragsize(100);
			//ִ�в�ѯ,�õ����
			QueryResponse response=solrserver.query(solrquery);		
			//�õ��ĵ������
			SolrDocumentList docs=response.getResults();
			//���ø�����
			Map<String, Map<String, List<String>>> highlightresult=response.getHighlighting();
			//System.out.println(highlightresult.get);
			//�õ����������
			long num=docs.getNumFound();
			System.out.println("������Ϊ��"+num+"��");
			
			
			
			
			//�����ܼ�¼��
			request.setAttribute("num",num);
			//������ҳ��
			request.setAttribute("pages", num/5);
			//���浱ǰҳ��
			request.setAttribute("pagenow", pageNow/5);
			//�治��ʾ��������
			request.setAttribute("fenzu", false);
			
			
			
			
			//�����в�ѯ���ļ�¼���һ�����ϣ��ٴ��request
			SolrDocumentList list=new SolrDocumentList();
			SolrDocument doc=new SolrDocument();
			
			for (int i = 0; i < docs.size(); i++)
			{	
				doc=docs.get(i);
				String id=doc.get("id").toString();
				System.out.println("id��ֵ��ǰ��"+id);
				if(highlightresult.get(id).get("ԭ���߳�")!=null) {
				doc.setField("ԭ���߳�", highlightresult.get(id).get("ԭ���߳�").get(0));   
				System.out.println("�������ֶ��ǣ�"+highlightresult.get(id).get("ԭ���߳�").get(0));
				}
				list.add(doc);
			}
			request.setAttribute("list",list);//�漯��list��request
			return SUCCESS;//��ת����ѯ�ɹ�ҳ��
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return NONE;
	}
	
	public String fenye() {
		
		return NONE;
	}

}
