package com.action;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class poiexcel extends ActionSupport {
	
	private static  HSSFWorkbook exportData(long num,SolrDocumentList list) {
		//����num���ܵļ�¼��,list���Ѿ������õĽ���ĵ���
		// ���������ռ�  
        HSSFWorkbook wb = new HSSFWorkbook();  
        // ������  
        HSSFSheet sheet = wb.createSheet("mySheet"); 
        //���ñ�ĳ��Ϳ�
        sheet.setDefaultColumnWidth(20);  
        sheet.setDefaultRowHeightInPoints(20);  
        // ������  
        HSSFRow row = sheet.createRow((int) 0);
        // ����һ����ʽ  
        HSSFCellStyle style = wb.createCellStyle();  
        //������ʽ����
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // ��ӱ�ͷ����  
        String[] excelHeader = { "id","ԭ��","ԭ���߳�","����","��Ժ�о�"};  
        for (int i = 0; i < excelHeader.length; i++) {  
            HSSFCell cell = row.createCell(i);  //ͨ���еķ������ô�����Ԫ��
            cell.setCellValue(excelHeader[i]);  //���õ�Ԫ���ֵ
            cell.setCellStyle(style);  //���õ�Ԫ�����ʽ
        }  
        System.out.println("�ӿ�����ĵ�����С��"+list.size());
        for(int o=0;o<list.size();o++)
        {
        	SolrDocument doc=list.get(o);
        	// ��ӵ�Ԫ������  
            row = sheet.createRow(o + 1);  //������
            row.createCell(0).setCellValue(doc.get("id").toString());  
            row.createCell(1).setCellValue(doc.get("ԭ��").toString());  
            row.createCell(2).setCellValue(doc.get("ԭ���߳�").toString());
            row.createCell(3).setCellValue(doc.get("����").toString());
            row.createCell(4).setCellValue(doc.get("��Ժ�о�").toString());     
        }
        
        
        
        
        
        return wb;
	}
	
	
	public String exportExcel() throws UnsupportedEncodingException{
		//�Ȼ�ȡǰ�˷����ı����ݣ��ٲ���solr�����ѯ
				//ע��fq�����Ǻţ�fl��ָ�����
				//��ȡǰ�˱����������ݣ�request��ʽ
				HttpServletRequest request=ServletActionContext.getRequest();//�õ�����
				HttpServletResponse res=ServletActionContext.getResponse();//�õ��ظ�
				
				 res.setContentType("application/vnd.ms-excel");  
			     res.setHeader("Content-disposition", "attachment;filename=solrExcel.xls");  
			     OutputStream ouputStream = null;  
			     //HSSFWorkbook wb = exportData();  
				
				String q=request.getParameter("fq");//��ȡ�����ؼ���
				
				
				request.setAttribute("q", q);
				
				q="ԭ���߳�:*"+q+"*";
				
				System.out.println("����excelʱ������Ҫ��:"+q);
				
				//���в�ѯ
				try {
					//������Solr������
					String solrurl="http://172.31.238.171:8080/solr/";	
					SolrServer solrserver=new HttpSolrServer(solrurl);
					//������ѯ
					SolrQuery solrquery=new SolrQuery();
					//���ò�ѯ�ؼ���
					solrquery.set("q",q );
					//solrquery.setRows(100);
					
					//ִ�в�ѯ,�õ����
					QueryResponse response=solrserver.query(solrquery);		
					//�õ��ĵ������
					SolrDocumentList docs=response.getResults();
					long num=docs.getNumFound();
					/*
					//����ĵ���������ε��룬ԭ������Ϊsolr�ķ�ҳ�����������ݲ���һ���Ե���
					int numrows=50;
					int start=0;
					for(;start<=num;start+=numrows) {
						solrquery.setStart(start);
						solrquery.setRows(numrows);
						response=solrserver.query(solrquery);	
						docs=response.getResults();
						
					}
					*/	
					
					
					
					
					
					
					
					
					//����poiexcel��������excel�ļ�
					// ���������ռ�  
			        HSSFWorkbook wb = new HSSFWorkbook();  
			        // ������  
			        HSSFSheet sheet = wb.createSheet("mySheet"); 
			        //���ñ�ĳ��Ϳ�
			        sheet.setDefaultColumnWidth(20);  
			        sheet.setDefaultRowHeightInPoints(20);  
			        // ������  
			        HSSFRow row = sheet.createRow((int) 0);
			        // ����һ����ʽ  
			        HSSFCellStyle style = wb.createCellStyle();  
			        //������ʽ����
			        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			        // ��ӱ�ͷ����  
			        String[] excelHeader = { "id","ԭ��","ԭ���߳�","����","��Ժ�о�"};  
			        for (int i = 0; i < excelHeader.length; i++) {  
			            HSSFCell cell = row.createCell(i);  //ͨ���еķ������ô�����Ԫ��
			            cell.setCellValue(excelHeader[i]);  //���õ�Ԫ���ֵ
			            cell.setCellStyle(style);  //���õ�Ԫ�����ʽ
			        }  
			        int numrows=10000;
					int start=0;
			        int oo=0;
			        for(;start<=num;start+=numrows) {
			        	solrquery.setStart(start);
						solrquery.setRows(numrows);
						response=solrserver.query(solrquery);	
						docs=response.getResults();
			        System.out.println("�ӿ�����ĵ�����С��"+docs.size());
			        for(int o=0;o<docs.size();o++,oo++)
			        {
			        	SolrDocument doc=docs.get(o);
			        	// ��ӵ�Ԫ������  
			            row = sheet.createRow(oo+1);  //������
			            row.createCell(0).setCellValue(doc.get("id").toString());  
			            row.createCell(1).setCellValue(doc.get("ԭ��").toString());  
			            row.createCell(2).setCellValue(doc.get("ԭ���߳�").toString());
			            row.createCell(3).setCellValue(doc.get("����").toString());
			            //��Ϊ�˴���һЩԭ����û�з�Ժ�о���������ж�һ���Ƿ�Ϊ����д��
			            if(doc.get("��Ժ�о�")!=null) {
			                row.createCell(4).setCellValue(doc.get("��Ժ�о�").toString());
			            }
			            else {
			            	row.createCell(4).setCellValue("");
			            	}
			            
			            System.out.println("excel�����ɹ�����"+oo+"��");
			        }
			        
			        }
			        
			        
					//HSSFWorkbook wb=exportData(num,docs);
					//System.out.println("�ĵ����Ĵ�С:"+docs.getNumFound());
					
					try {  
			            ouputStream = res.getOutputStream();  
			            wb.write(ouputStream);  
			        } catch (Exception e) {  
			            throw new RuntimeException("ϵͳ�쳣");  
			        } finally {  
			            try {  
			                ouputStream.flush();  
			                ouputStream.close();  
			            } catch (Exception e) {  
			                throw new RuntimeException("ϵͳ�쳣");  
			            }  
			        }  
					
					
					
					
					
					
					
					
					
					
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
		
		
		return NONE;
	}
	

}
