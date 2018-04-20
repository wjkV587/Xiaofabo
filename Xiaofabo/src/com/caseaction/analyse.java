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
		 * ����ǰ�˱���textarea�����İ�������
		 * ʹ��solrģ��ƥ���ԭ���߳�
		 * �ؼ�����
		 * ��Ӧ�ؼ����ӵķ�������
		 */
		ActionContext actioncontext=ActionContext.getContext();
		Map<String,Object> map=actioncontext.getParameters();
		String casetext=null;
		
		if(map.get("textarea_id")!=null) {
			casetext=((String[])map.get("textarea_id"))[0];//�õ���ﴫ���İ�������
		}
		//System.out.println("Ҫ���з����İ����ǣ�\n"+casetext);
		actioncontext.put("casetext", casetext);
		/**
		 * �������߳�ȥ�������ȡ����������solr��ģ��ƥ��
		 * ���ﰸ������������׼���ã���Ҫ��solr�н�ƥ�����ݵ���
		 */
		casetext="ԭ���߳�:"+casetext;
		//����Solr������
		try {
			String solrurl="http://140.143.13.66:8080/solr/";
			SolrServer solrserver=new HttpSolrServer(solrurl);
			SolrQuery solrquery=new SolrQuery();
			//���ò�ѯ�ֶ�
			solrquery.set("q", casetext);
			solrquery.setStart(0);
			solrquery.setRows(10);//��ʾTop 10
			//���ø���
			solrquery.setHighlight(true);
			solrquery.addHighlightField("ԭ���߳�");
			solrquery.setHighlightFragsize(1000);
			solrquery.setHighlightSimplePre("<font color='red'>");
			solrquery.setHighlightSimplePost("</font>");
			//ִ�в�ѯ�õ�����ĵ���
			QueryResponse response=solrserver.query(solrquery);
			SolrDocumentList docs= response.getResults();
			//���ø�����
			Map<String ,Map<String,List<String>>> highlightresult=response.getHighlighting();
			
			
			SolrDocumentList list=new SolrDocumentList();
			SolrDocument doc=new SolrDocument();
			//�����洢�ؼ����ӵ�map
			Map<Integer,List<String>> key=new HashMap<Integer,List<String>>();
			//�����洢��Ժ���������map
			Map<Integer,String> law=new HashMap<Integer,String>();
			
			for(int i=0;i<docs.size();i++) {
				List<String> map_list=new ArrayList<String>();
				doc=docs.get(i);
				String id=doc.get("id").toString();
				String adju=doc.get("��Ժ�������").toString();
				
					//�˴���Ҫ��ȡ����ƥ��İ����Ĺؼ�����,����ƥ��
					String text=doc.get("ԭ���߳�").toString();
					
					String context="(?<=\\��)[^\\��]+";//ƥ���������ʽ
					Pattern pattern1 = Pattern.compile(context);
					Matcher m = pattern1.matcher(text);	
			        while (m.find()) {
			            //System.out.println("�ؼ����ӣ�" + m.group() );
			            map_list.add(m.group());
			            
			        }
			        law.put(i, adju);
			        key.put(i, map_list);				
				/**
				 * Top 10 ����ÿ�������Ĺؼ����Ӷ�Ҫ�ҳ���
				 */
				//ѭ������ؼ����ӽ��в���
			    /**
			        System.out.print("�ؼ������ǣ�");
			        for(String e:key.get(i)) {
			        	System.out.print(e+",");	
			        }
			        System.out.print("\n");
			      **/  
				if(highlightresult.get(id).get("ԭ���߳�")!=null) {
					doc.setField("ԭ���߳�", highlightresult.get(id).get("ԭ���߳�").get(0));
				}
				//if(i==0) {System.out.println("��"+highlightresult.get(id).get("ԭ���߳�").get(0));}
				list.add(doc);	
			}
			
			Map<Integer,List<String>> ktr=keytorules.turnrules(key);
			actioncontext.put("law", keytolaw.turnlaw(law));//��ؼ����Ӷ�Ӧ�ķ���
			actioncontext.put("rules",ktr);//��ؼ����Ӷ�Ӧ�ķ���
			actioncontext.put("key", key);//��ؼ�����
			actioncontext.put("list", list);//���ĵ���
			//д��json�ļ������ڿ��ӻ�
			writejson.echartsshow(key, ktr);
			//����ǰ��ҳ��
			return SUCCESS;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		/**
		 * ƥ�����ѽ�����õ�ԭ���߳ƣ��ؼ������Լ�ʤ�����ʣ��������÷���
		 * ���ActionContext���У���ת��test.jspҳ����
		 * Ϊ�˽����Ը�ǿ�����齫��������Ҳһ��������У�����ʵʱ�ȶ�
		 */
		
		return NONE;
	}

}
