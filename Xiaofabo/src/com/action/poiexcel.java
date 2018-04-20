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
		//参数num是总的记录数,list是已经搜索好的结果文档集
		// 创建工作空间  
        HSSFWorkbook wb = new HSSFWorkbook();  
        // 创建表  
        HSSFSheet sheet = wb.createSheet("mySheet"); 
        //设置表的长和宽
        sheet.setDefaultColumnWidth(20);  
        sheet.setDefaultRowHeightInPoints(20);  
        // 创建行  
        HSSFRow row = sheet.createRow((int) 0);
        // 生成一个样式  
        HSSFCellStyle style = wb.createCellStyle();  
        //设置样式居中
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 添加表头数据  
        String[] excelHeader = { "id","原告","原告诉称","被告","法院判决"};  
        for (int i = 0; i < excelHeader.length; i++) {  
            HSSFCell cell = row.createCell(i);  //通过行的方法调用创建单元格
            cell.setCellValue(excelHeader[i]);  //设置单元格的值
            cell.setCellStyle(style);  //设置单元格的样式
        }  
        System.out.println("接口里的文档集大小："+list.size());
        for(int o=0;o<list.size();o++)
        {
        	SolrDocument doc=list.get(o);
        	// 添加单元格数据  
            row = sheet.createRow(o + 1);  //创建行
            row.createCell(0).setCellValue(doc.get("id").toString());  
            row.createCell(1).setCellValue(doc.get("原告").toString());  
            row.createCell(2).setCellValue(doc.get("原告诉称").toString());
            row.createCell(3).setCellValue(doc.get("被告").toString());
            row.createCell(4).setCellValue(doc.get("法院判决").toString());     
        }
        
        
        
        
        
        return wb;
	}
	
	
	public String exportExcel() throws UnsupportedEncodingException{
		//先获取前端发来的表单数据，再操作solr服务查询
				//注意fq加上星号，fl需分隔出来
				//获取前端表单发来的数据，request方式
				HttpServletRequest request=ServletActionContext.getRequest();//得到请求
				HttpServletResponse res=ServletActionContext.getResponse();//得到回复
				
				 res.setContentType("application/vnd.ms-excel");  
			     res.setHeader("Content-disposition", "attachment;filename=solrExcel.xls");  
			     OutputStream ouputStream = null;  
			     //HSSFWorkbook wb = exportData();  
				
				String q=request.getParameter("fq");//获取搜索关键词
				
				
				request.setAttribute("q", q);
				
				q="原告诉称:*"+q+"*";
				
				System.out.println("导出excel时的搜索要求:"+q);
				
				//进行查询
				try {
					//先连接Solr服务器
					String solrurl="http://172.31.238.171:8080/solr/";	
					SolrServer solrserver=new HttpSolrServer(solrurl);
					//创建查询
					SolrQuery solrquery=new SolrQuery();
					//设置查询关键词
					solrquery.set("q",q );
					//solrquery.setRows(100);
					
					//执行查询,得到结果
					QueryResponse response=solrserver.query(solrquery);		
					//得到文档结果集
					SolrDocumentList docs=response.getResults();
					long num=docs.getNumFound();
					/*
					//这里的导入需分批次导入，原因是因为solr的分页导致所有数据不能一次性导入
					int numrows=50;
					int start=0;
					for(;start<=num;start+=numrows) {
						solrquery.setStart(start);
						solrquery.setRows(numrows);
						response=solrserver.query(solrquery);	
						docs=response.getResults();
						
					}
					*/	
					
					
					
					
					
					
					
					
					//调用poiexcel方法导出excel文件
					// 创建工作空间  
			        HSSFWorkbook wb = new HSSFWorkbook();  
			        // 创建表  
			        HSSFSheet sheet = wb.createSheet("mySheet"); 
			        //设置表的长和宽
			        sheet.setDefaultColumnWidth(20);  
			        sheet.setDefaultRowHeightInPoints(20);  
			        // 创建行  
			        HSSFRow row = sheet.createRow((int) 0);
			        // 生成一个样式  
			        HSSFCellStyle style = wb.createCellStyle();  
			        //设置样式居中
			        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			        // 添加表头数据  
			        String[] excelHeader = { "id","原告","原告诉称","被告","法院判决"};  
			        for (int i = 0; i < excelHeader.length; i++) {  
			            HSSFCell cell = row.createCell(i);  //通过行的方法调用创建单元格
			            cell.setCellValue(excelHeader[i]);  //设置单元格的值
			            cell.setCellStyle(style);  //设置单元格的样式
			        }  
			        int numrows=10000;
					int start=0;
			        int oo=0;
			        for(;start<=num;start+=numrows) {
			        	solrquery.setStart(start);
						solrquery.setRows(numrows);
						response=solrserver.query(solrquery);	
						docs=response.getResults();
			        System.out.println("接口里的文档集大小："+docs.size());
			        for(int o=0;o<docs.size();o++,oo++)
			        {
			        	SolrDocument doc=docs.get(o);
			        	// 添加单元格数据  
			            row = sheet.createRow(oo+1);  //创建行
			            row.createCell(0).setCellValue(doc.get("id").toString());  
			            row.createCell(1).setCellValue(doc.get("原告").toString());  
			            row.createCell(2).setCellValue(doc.get("原告诉称").toString());
			            row.createCell(3).setCellValue(doc.get("被告").toString());
			            //因为此处有一些原数据没有法院判决，因此需判断一下是否为空再写入
			            if(doc.get("法院判决")!=null) {
			                row.createCell(4).setCellValue(doc.get("法院判决").toString());
			            }
			            else {
			            	row.createCell(4).setCellValue("");
			            	}
			            
			            System.out.println("excel导出成功到第"+oo+"条");
			        }
			        
			        }
			        
			        
					//HSSFWorkbook wb=exportData(num,docs);
					//System.out.println("文档集的大小:"+docs.getNumFound());
					
					try {  
			            ouputStream = res.getOutputStream();  
			            wb.write(ouputStream);  
			        } catch (Exception e) {  
			            throw new RuntimeException("系统异常");  
			        } finally {  
			            try {  
			                ouputStream.flush();  
			                ouputStream.close();  
			            } catch (Exception e) {  
			                throw new RuntimeException("系统异常");  
			            }  
			        }  
					
					
					
					
					
					
					
					
					
					
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
		
		
		return NONE;
	}
	

}
